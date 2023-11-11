import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner userInput = new Scanner(System.in);
    private static Scanner fileInput;
    private static List<Cd> cds = new ArrayList<>();
    private static List<Add> adds = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Please enter the file name.");
        fileInput = new Scanner(userInput.nextLine());


    }

    private static void read(Scanner input) {
        input.useDelimiter("CDS\n|ADDS\n");
        System.out.println(input.next());
    }
}