import java.util.Scanner;

public class BankingApplication {

    private static Scanner userInput;
    private static Account account;

    public static void main(String[] args) {


        userInput = new Scanner(System.in);
        account = new Account();
        int option;
        do {
            printMenu();
            option = userInput.nextInt();
            executeOption(Option.values()[option - 1]);
        } while (option != 4);
    }

    private static void printMenu() {
        System.out.println("""
                Please select an option:
                  1 - Show balance
                  2 - Deposit an amount
                  3 - Withdraw an amount
                  4 - Quit""".stripIndent());
    }

    private static void executeOption(Option option) {
        int amount;
        switch (option) {
            case SHOW_BALANCE:
                System.out.println("Balance: €" + account.getBalance());
                break;
            case DEPOSIT:
                System.out.println("How much?");
                amount = userInput.nextInt();
                System.out.println("You now have €" + account.deposit(amount));
                break;
            case WITHDRAW:
                System.out.println("How much?");
                amount = userInput.nextInt();
                System.out.println("You have €" + account.withdraw(amount) + " left");
                break;
        }
    }

}
