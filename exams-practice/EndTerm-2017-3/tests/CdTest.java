import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class CdTest {
    private Cd cd1;
    private Song song1;
    private Song song2;

    @BeforeEach
    void setup() {
        List<Song> songs = new ArrayList<>();
        song1 = new Song("song1", new Time(1, 2),
                1, "album", "artist");
        song2 = new Song("California", new Time(4, 0),
                2, "album", "artist");
        songs.add(song1);
        songs.add(song2);
        cd1 = new Cd("artist", "album", 2023, songs);
    }

    @Test
    void read() {
        Cd cd = Cd.read(new Scanner("U2, Songs of Innocence, 2014\n" +
                "SONG 1, Every Breaking Wave, 4:12\n" +
                "SONG 2, California, 4:0\n" +
                "SONG 3, Song for Someone, 3:47"));
        assertEquals(cd.getArtist(), "U2");
        assertEquals(cd.getAlbum(), "Songs of Innocence");
        assertEquals(cd.getYear(), 2014);
        List<Song> songs = new ArrayList<>();
        songs.add(new Song("Every Breaking Wave", new Time(4, 12),
                1, "Songs of Innocence", "U2"));
        songs.add(new Song("California", new Time(4, 0),
                2, "Songs of Innocence", "U2"));
        songs.add(new Song("Song for Someone", new Time(3, 47),
                3, "Songs of Innocence", "U2"));
        assertEquals(cd.getSongs(), songs);
    }

    @Test
    void toWrite() {
        assertEquals(cd1.toWrite(), "CD artist, album, 2023\n" +
                "SONG 1, song1, 1:2\n" +
                "SONG 2, California, 4:0\n");
    }

    @Test
    void remove() {
        int initialLength = cd1.getSongs().size();
        cd1.remove(song1);
        assertEquals(cd1.getSongs().size(), initialLength - 1);
        assertFalse(cd1.getSongs().contains(song1));
    }

    @Test
    void testEquals() {
        Song song3 = new Song("song1", new Time(1, 2),
                1, "album", "artist");
        Song song4 = new Song("California", new Time(4, 0),
                2, "album", "artist");
        List<Song> songs = new ArrayList<>();
        songs.add(song1);
        songs.add(song2);
        Cd cd2 = new Cd("artist", "album", 2023, songs);
        assertEquals(cd1, cd2);
        assertEquals(cd1, cd1);
        assertNotEquals(cd1, null);
        assertNotEquals(cd1, "yaes");;
        Cd cd3 = new Cd("random", "random", 1, songs);
        assertNotEquals(cd1, cd3);
    }

    @Test
    void testHashCode() {
        Song song3 = new Song("song1", new Time(1, 2),
                1, "album", "artist");
        Song song4 = new Song("California", new Time(4, 0),
                2, "album", "artist");
        List<Song> songs = new ArrayList<>();
        songs.add(song1);
        songs.add(song2);
        Cd cd2 = new Cd("artist", "album", 2023, songs);

        assertEquals(cd1.hashCode(), cd2.hashCode());
    }
}