import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WriterApplication {

    /**
     * Asks the user for input and asynchronously writes the user's input to file.
     *
     * @param args The command line arguments
     */
    public static void main(String[] args) {

        List<String> toWrite = new ArrayList<>();
        toWrite.add("The user put in:");

        Scanner scanner = new Scanner(System.in);
        System.out.println("What to write?");
        toWrite.add(scanner.nextLine());
        scanner.close();

        Thread thread = new Thread(
                () -> {
                    File file = new File("output.txt");
                    try  {
                        PrintWriter writer = new PrintWriter(
                                new BufferedWriter(new FileWriter(file)));
                        toWrite.forEach(writer::println);
                        writer.close();
                    } catch (IOException e) {
                        System.err.println("Writing failed");
                        e.printStackTrace();
                    }
                }
        );
        thread.start();
        System.out.println("Writing...");

    }

}
