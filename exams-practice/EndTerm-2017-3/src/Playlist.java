import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Playlist {
    private final List<Audio> audios;
    private final List<Cd> cds;
    private final List<Add> adds;

    /**
     * The constructor for the playlist
     */
    public Playlist() {
        this.audios = new ArrayList<>();
        this.cds = new ArrayList<>();
        this.adds = new ArrayList<>();
    }

    /**
     * The getter for the audios
     *
     * @return the audios
     */
    public List<Audio> getAudios() {
        return audios;
    }

    /**
     * Getter for the cds
     *
     * @return the cds
     */
    public List<Cd> getCds() {
        return cds;
    }

    /**
     * Getter for the adds
     *
     * @return the adds
     */
    public List<Add> getAdds() {
        return adds;
    }

    /**
     * Reads from the scanner the cd
     *
     * @param input the scanner
     */
    public synchronized void read(Scanner input) {
        input.useDelimiter("CDS\\R|ADDS\\R");

        Scanner cdsScanner = new Scanner(input.next());
        cdsScanner.useDelimiter("CD ");
        while (cdsScanner.hasNext()) {
            cds.add(Cd.read(new Scanner(cdsScanner.next())));
        }

        Scanner addsScanner = new Scanner(input.next());
        addsScanner.useDelimiter("ADD ");
        while (addsScanner.hasNext()) {
            adds.add(Add.read(new Scanner(addsScanner.next())));
        }

        int j = 0;
        for (Cd cd : cds) {
            for (Song song : cd.getSongs()) {
                audios.add(song);
                audios.add(adds.get(j++));
                if (j >= adds.size()) j = 0;
            }
        }
    }

    /**
     * Option 1
     *
     * @return the string
     */
    public synchronized String show() {
        StringBuilder s = new StringBuilder();
        for (Audio audio : audios) {
            s.append(audio).append("\n");
        }
        System.out.println(s);
        return s.toString();
    }

    /**
     * Option 2
     *
     * @param input the Scanner
     */
    public synchronized void add(Scanner input) {
        System.out.println("Please enter the artist, the album, the year," +
                " and the nr of songs, each on a new line");
        String artist = input.nextLine();
        String album = input.nextLine();
        int year = input.nextInt();
        int nr = input.nextInt();
        input.nextLine(); // skip /n

        List<Song> songs = new ArrayList<>();
        for (int i = 0; i < nr; i++) {
            System.out.println("Please enter the name of the song, the nr of minutes," +
                    " and the nr of seconds, each on a new line");
            String name = input.nextLine();
            int min = input.nextInt();
            int sec = input.nextInt();
            input.nextLine(); // skip /n
            songs.add(new Song(name, new Time(min, sec), year, album, artist));
        }

        Cd cd = new Cd(artist, album, year, songs);
        cds.add(cd);
        int j = 0;
        for (Song song : cd.getSongs()) {
            audios.add(song);
            audios.add(adds.get(j++));
            if (j >= adds.size()) j = 0;
        }
    }

    private void removeSong(Song song) {
        for (Cd cd : cds) {
            if (!cd.getSongs().contains(song)) continue;
            cd.remove(song);
            if (cd.getSongs().isEmpty()) {
                cds.remove(cd);
            }
        }
    }

    /**
     * Option 3
     *
     * @param fileName the filename
     * @return the string
     */
    public synchronized String play(String fileName) {
        String s = "";
        for (Audio audio : audios) {
            if (audio instanceof Add) continue;
            Song song = (Song) audio;
            removeSong(song);
            s += song + "\n";
            audios.remove(song);

            break;
        }

        for (Audio audio : audios) {
            if (audio instanceof Song) continue;

            Add add = (Add) audio;
            s += add + "\n";
            audios.remove(add);
            break;
        }
        try {
            this.write(new BufferedWriter(new FileWriter(fileName)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(s);
        return s;
    }

    /**
     * Option 4
     *
     * @param fileName the filename
     */
    public synchronized void shuffle(String fileName) {
        new Thread(() -> {
            Collections.shuffle(audios);
            play(fileName);
        }).start();
    }

    /**
     * Writes back to the file
     *
     * @param writer the writer
     */
    public synchronized void write(Writer writer) {
        StringBuilder s = new StringBuilder("CDS\n");
        for (Cd cd : cds) {
            s.append(cd.toWrite());
        }

        s.append("ADDS\n");
        for (Add add : adds) {
            s.append(add.toWrite()).append("\n");
        }

        try {
            writer.write(s.substring(0, s.length() - 1));
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}