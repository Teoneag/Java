import java.io.*;
import java.util.*;

public class Main {
    private static Scanner userInput = new Scanner(System.in);
    private static String fileName;
    private static List<Cd> cds = new ArrayList<>();
    private static List<Add> adds = new ArrayList<>();

    private static List<Object> playlist = new ArrayList<>();

    /**
     * The main method of the application
     * @param args The command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Please enter the file name.");
//        try {  // spotify.txt
        fileName = userInput.nextLine();
//            fileInput = new Scanner(new File("resources/" + userInput.nextLine()));
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }

        try {
            read(new Scanner(new File("resources/" + fileName)));
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

            input = Integer.parseInt(userInput.nextLine());

            switch (input) {
                case 1 -> show();
                case 2 -> add();
                case 3 -> play();
                case 4 -> shuffle();
            }
        }
    }

    private static void show() {
        for (Object o : playlist) {
            System.out.println(o);
        }
    }

    private static void add() {
        System.out.println("Please enter the name of the Artist, " +
                "the album(CD) and the year, separated by a comma");
        Scanner scanner = new Scanner(userInput.nextLine());
        scanner.useDelimiter(", ");
        String artist = scanner.next();
        String album = scanner.next();
        int year = scanner.nextInt();

        System.out.println("Please enter the nr of songs in the CD");
        int nr = Integer.parseInt(userInput.nextLine());

        List<Song> songs = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < nr; i++) {
            System.out.println("Please enter the song name and the length, " +
                    "separated by a comma, like this: The Miracle, 4:15");
            scanner = new Scanner(userInput.nextLine());
            scanner.useDelimiter(", ");
            String name = scanner.next();
            Time time = Time.read(new Scanner(scanner.next()));
            Song song = new Song(name, time, i + 1, artist, album);
            songs.add(song);
            playlist.add(song);
            playlist.add(adds.get(i++));
            if (i >= adds.size()) i = 0;
        }
    }

    private static void play() {
        Cd cd = cds.get(0);
        Song song = cd.getSongs().get(0);
        System.out.println(song);
        System.out.println(adds.get(0));
        cd.removeSong(0);
        if (cd.getSongs().isEmpty()) {
            cds.remove(0);
        }
        playlist.remove(0); // song
        for (int i = 0; i < playlist.size(); i++) {
            if (playlist.get(i) instanceof Add) {
                playlist.remove(i);
                break;
            }
        }

        write();
    }

    private static synchronized void shuffle() {
        // TODO make a separate class
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                Collections.shuffle(playlist);
//                play();
//                System.out.println("""
//                        Please make your choice:
//                            1 - Show the current playlist
//                            2 – Add a new CD including songs
//                            3 – Play
//                            4 – Shuffle
//                            5 – Stop the program""");
//            }
//        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
//                fa
            }
        }).start();

    }

    private static void write() {
        try {
            BufferedWriter bufferedWriter =
                    new BufferedWriter(
                            new FileWriter("resources/" + fileName));
            String s = "CDS\n";
            for (Cd cd : cds) {
                s += cd.toWrite();
            }

            s += "ADDS\n";
            for (Add add : adds) {
                s += add.toWrite() + "\n";
            }

//            System.out.println(s);
            bufferedWriter.write(s);
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void read(Scanner input) {
        input.useDelimiter("CDS|ADDS");
        // TODO: /n not working

        Scanner cdsScanner = new Scanner(input.next());
        cdsScanner.nextLine(); // skip /n
        cdsScanner.useDelimiter("CD ");
        while (cdsScanner.hasNext()) {
            cds.add(Cd.read(new Scanner(cdsScanner.next())));
        }

        Scanner addsScanner = new Scanner(input.next());
        addsScanner.nextLine(); // skip /n
        addsScanner.useDelimiter("ADD ");
        while (addsScanner.hasNext()) {
            adds.add(Add.read(new Scanner(addsScanner.next())));
        }

        int j = 0;
        for (Cd cd : cds) {
            for (Song song : cd.getSongs()) {
                playlist.add(song);
                playlist.add(adds.get(j++));
                if (j >= adds.size()) j = 0;
            }
        }
    }
}