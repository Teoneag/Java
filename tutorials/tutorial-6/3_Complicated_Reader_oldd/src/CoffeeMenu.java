import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class CoffeeMenu {

    /**
     * Reads a coffee menu from the given input.
     *
     * @param input The scanner to read from
     * @return The coffee menu read from the input
     */
    public static CoffeeMenu read(Scanner input) {
        try {
            List<CoffeeItem> coffees = readCoffees(input);
            List<Addition> additions = readAdditions(input);
            return new CoffeeMenu(coffees, additions);
        } catch (Exception e) {
            System.out.println("Wrong output format");
            return null;
        } finally {
            System.out.println("Error while reading.");
        }
    }

    private static List<CoffeeItem> readCoffees(Scanner input) throws Exception {
        List<CoffeeItem> coffees = new ArrayList<>();

        String line = input.nextLine();
        if (!line.equals("COFFEES")) throw new Exception();

        while (input.hasNext()) {
            line = input.nextLine();
            if (line.equals("ADDITIONS")) break;

            Scanner lineScanner = new Scanner(line);
            lineScanner.useDelimiter(",");
            if (!lineScanner.next().equals("COFFEE")) throw new Exception();

            String name = lineScanner.next();
            double price = lineScanner.nextDouble();
            List<String> allergies = new ArrayList<>();
            while (lineScanner.hasNext()) {
                allergies.add(lineScanner.next());
            }
            List<CoffeeVariation> coffeeVariations = readVariations(input);

            CoffeeItem coffeeItem = new CoffeeItem(name, price, allergies, coffeeVariations);
            coffees.add(coffeeItem);
        }
        return coffees;
    }

    private static List<CoffeeVariation> readVariations(Scanner input) {
        List<CoffeeVariation> coffeeVariations = new ArrayList<>();
        while (input.hasNext()) {
            String line = input.nextLine();
            if (line.contains("COFFEE")) break;

            Scanner lineScanner = new Scanner(line);
            lineScanner.useDelimiter(",");
            if (!lineScanner.next().equals("VARIATION")) break;
            String varName = lineScanner.next();
            double varPrice = lineScanner.nextDouble();
            List<String> allergies = new ArrayList<>();
            while (lineScanner.hasNext()) allergies.add(lineScanner.next());
            CoffeeVariation coffeeVariation = new CoffeeVariation(varName, varPrice, allergies);
            coffeeVariations.add(coffeeVariation);
        }
        return coffeeVariations;
    }

    private static List<Addition> readAdditions(Scanner input) throws Exception {
        List<Addition> additions = new ArrayList<>();

        while (input.hasNext()) {
            String line = input.nextLine();
            Scanner lineScanner = new Scanner(line);
            lineScanner.useDelimiter(",");
            if (!lineScanner.next().equals("ADDITION")) throw new Exception();

            String name = lineScanner.next();
            double price = lineScanner.nextDouble();
            List<String> allergies = new ArrayList<>();
            while (lineScanner.hasNext()) {
                allergies.add(lineScanner.next());
            }
            Addition addition = new Addition(name, price, allergies);
            additions.add(addition);
        }
        return additions;
    }

    private final List<CoffeeItem> coffees;
    private final List<Addition> additions;

    /**
     * Creates a coffee menu.
     *
     * @param coffees   The list of coffees on the menu
     * @param additions The list of additions on the menu
     */
    public CoffeeMenu(List<CoffeeItem> coffees, List<Addition> additions) {
        this.coffees = coffees;
        this.additions = additions;
    }

    /**
     * Gets the coffees on the menu.
     *
     * @return The list of coffees on this menu
     */
    public List<CoffeeItem> getCoffees() {
        return coffees;
    }

    /**
     * Gets the additions on the menu.
     *
     * @return The list of coffees on this menu
     */
    public List<Addition> getAdditions() {
        return additions;
    }

    /**
     * Checks whether an object is equal to the coffee menu.
     *
     * @param other The other object
     * @return True iff the other is an identical coffee menu
     */
    @Override
    public boolean equals(Object other) {
        if (other == null || this.getClass() != other.getClass()) return false;
        CoffeeMenu that = (CoffeeMenu) other;
        return Objects.equals(this.coffees, that.coffees)
                && Objects.equals(this.additions, that.additions);
    }

}
