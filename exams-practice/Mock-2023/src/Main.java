import java.util.Scanner;

public class Main {
    private static final Scanner userInput = new Scanner(System.in);
    private static final Machine machine = new Machine();

    /**
     * The Main method of the Application, it shows the interface
     *
     * @param args The command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Welcome to the Application!");

        machine.read(); // ask user for name of file
        // not abstract class


        int input = -1;

        while (input != 5) {
            System.out.println("""
                    Please make your choice:
                        1 - Show all balls currently in the machine.
                        2 - Show current chance to win the legendary prize.
                        3 - Draw a ball.
                        4 - Write debug output to file.
                        5 - Quit the application.
                    """);

            try {
                input = Integer.parseInt(userInput.nextLine());
            } catch (Exception e) {
                System.out.println("Error reading option, please try again!");
            }

            switch (input) {
                case 1 -> machine.printAllBalls();
                case 2 -> machine.showChance();
                case 3 -> machine.drawBall();
                case 4 -> machine.write();
                case 5 -> {
                }
                default -> System.out.println(
                        "This is not an available option, please try again!");
            }
        }

        System.out.println("Exiting Application!");
    }
}