import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Please enter the file path, like this: resources/mechs.txt");
        Scanner userInput = new Scanner(System.in);
        String fileName = userInput.nextLine();
        String outFile = "resources/out.txt";
        Scanner fileScanner;
        Scanner fileScanner2;
        BufferedWriter bufferedWriter;
        try {
             fileScanner = new Scanner(new File(fileName));
             fileScanner2 = new Scanner(new File(outFile));
             bufferedWriter = new BufferedWriter(new FileWriter(outFile));
        } catch (FileNotFoundException e) {
            System.out.println("Wrong file name");
            return;
        } catch (IOException e) {
            System.out.println("Cannot write to file.");
            return;
        }

        Game game = new Game();
        game.read(fileScanner, fileScanner2);

        int option = -1;
        while (option != 6) {
            System.out.println("""
                    Please make your choice:
                        1 – Show all mechs in the system.
                        2 – Show player stats & equipment.
                        3 – Fight a mech.
                        4 – Write current state to file.
                        5 – Restore state from file.
                        6 – Quit the application.""");
            option = userInput.nextInt();
            switch (option) {
                case 1 -> game.showMechs();
                case 2 -> game.showPlayer();
                case 3 -> game.fight();
                case 4 -> game.write(bufferedWriter);
                case 5 -> game.read(fileScanner, fileScanner2);
            }
        }
    }
}