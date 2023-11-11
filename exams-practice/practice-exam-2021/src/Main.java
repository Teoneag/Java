import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner userInput = new Scanner(System.in);
    private static List<Product> productList = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {
        int option = -1;

        System.out.println("Welcome to the application!\n");

        read(new Scanner(new File("resources/personalfit.txt")));

        while (option != 6) {
            System.out.println("""
                    Please input your option number then press enter.
                    Please make your choice:
                        1 – Print all bikes & protein shakes
                        2 – Add a new protein shake
                        3 – Propose a random protein shake to the customer
                        4 – Show bikes that train a specific muscle group
                        5 – Write to file
                        6 – Stop the program""");


            try {
                option = Integer.parseInt(userInput.nextLine());
                switch (option) {
                    case 1 -> printAllBikesAndProteinShakes();
                    case 2 -> addNewProteinShake();
                    case 3 -> proposeRandomProteinShake();
                    case 4 -> showSpecificBikes();
                    case 5 -> write(new FileWriter(new File("resources/personalfit.txt")));
                    case 6 -> {
                    }
                    default -> System.out.println(option + " is not an available option");
                }
            } catch (Exception e) {
                System.out.println("Error reading your option number, please try again!");
            }

        }
    }

    private static void read(Scanner input) {
        while (input.hasNext()) {
            String nextInput = input.next();
            switch (nextInput) {
                case "HomeTrainerBike" -> {
                    HomeTrainerBike homeTrainerBike = HomeTrainerBike.read(
                            new Scanner(input.nextLine()));
                    productList.add(homeTrainerBike);
                }
                case "SpinningBike" -> {
                    SpinningBike spinningBike = SpinningBike.read(
                            new Scanner(input.nextLine()));
                    productList.add(spinningBike);
                }
                case "ProteinShake" -> {
                    ProteinShake proteinShake = ProteinShake.read(
                            new Scanner(input.nextLine()));
                    productList.add(proteinShake);
                }
            }
        }
    }

    private static void printAllBikesAndProteinShakes() {
        for (Product product : productList) {
            System.out.println(product + "\n");
        }
    }

    private static void addNewProteinShake() {
        productList.add(ProteinShake.add(userInput));
    }

    private static void proposeRandomProteinShake() {
        System.out.println("This is the recommender protein shake: ");
        List<ProteinShake> proteinShakes = new ArrayList<>();
        for (Product product : productList) {
            if (product instanceof ProteinShake proteinShake) {
                proteinShakes.add(proteinShake);
            }
        }
        double p = Math.random();
        int index = (int) (proteinShakes.size() * p);
        System.out.println(proteinShakes.get(index));
    }

    private static void showSpecificBikes() {
        System.out.println("Please enter the desired muscle group.");
        String muscleGroup = userInput.nextLine();
        List<Bike> bikes = new ArrayList<>();
        for (Product product : productList) {
            if (!(product instanceof Bike)) continue;
            Bike bike = (Bike) product;
            if (bike.getMuscleGroups().contains(muscleGroup)) {
                bikes.add(bike);
            }
        }
        if (bikes.isEmpty()) {
            System.out.println("There is no bike with the mouse group: " + muscleGroup);
            return;
        }
        System.out.println("These are the bikes that work the " + muscleGroup);
        for (Bike bike : bikes) {
            System.out.println(bike + "\n");
        }
    }

    private static void write(FileWriter fileWriter) {
        StringBuilder s = new StringBuilder();
        for (Product product : productList) {
            s.append(product.toWrite()).append("\n");
        }
        try {
            fileWriter.write(s.toString());
            fileWriter.close();
            System.out.println("Wrote successfully!");
        } catch (Exception e) {
            System.out.println("Error writing: " + e);
        }
    }
}