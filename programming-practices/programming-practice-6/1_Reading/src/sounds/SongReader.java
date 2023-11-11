package sounds;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SongReader {

    public static Song readSong(Reader reader) {
        int channels = 0;
        List<PlayNote> notes = new ArrayList<>();

        Scanner scanner = new Scanner(reader);

        scanner.next(); // skip CHANNELS
        channels = scanner.nextInt();

        scanner.useDelimiter("NOTE ");
        scanner.next();

        while (scanner.hasNext()) {
            notes.add(PlayNote.read(new Scanner(scanner.next())));
        }

//        String line = scanner.nextLine();
//        Scanner lineScanner = new Scanner(line);
//        lineScanner.next();


        return new Song(channels, notes);
    }

}
