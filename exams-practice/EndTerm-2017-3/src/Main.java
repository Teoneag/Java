import java.io.*;
import java.util.Scanner;

public class Main {
    /**
     * The entry point of the application
     *
     * @param args The command line arguments
     */
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.println("Please enter the file name");
        String fileName = userInput.nextLine();
//        String fileName = "resources/spotify.txt";

        Playlist playlist = new Playlist();

        try {
            playlist.read(new Scanner(new File(fileName)));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        int input = -1;
        while (input != 5) {
            System.out.println("""
                    Please make your choice:
                        1 - Show the current playlist
                        2 – Add a new CD including songs
                        3 – Play
                        4 – Shuffle
                        5 – Stop the program""");
            input = -1;
            while (input == -1) {
                input = Integer.parseInt(userInput.nextLine());
                switch (input) {
                    case 1 -> playlist.show();
                    case 2 -> playlist.add(userInput);
                    case 3 -> playlist.play(fileName);
                    case 4 -> playlist.shuffle(fileName);
                }
            }
        }
    }
}