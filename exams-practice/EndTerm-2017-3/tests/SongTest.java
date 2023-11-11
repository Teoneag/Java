import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class SongTest {
    private Song song1;
    @BeforeEach
    void setup() {
        song1 = new Song("name", new Time(10, 20),
                1, "album", "artist");
    }

    @Test
    void read() {
        Song song = Song.read(new Scanner("SONG 1, Every Breaking Wave, 4:12"),
                "Songs of Innocence", "U2");
        assertEquals(song.getNr(), 1);
        assertEquals(song.getAlbum(), "Songs of Innocence");
        assertEquals(song.getArtist(), "U2");
        assertEquals(song.getName(), "Every Breaking Wave");
        assertEquals(song.getTime(), new Time(4, 12));
    }

    @Test
    void testToString() {
        assertEquals(song1.toString(), "Album: artist's album\n" +
                "   Track name (10:20)");
    }

    @Test
    void toWrite() {
        assertEquals(song1.toWrite(1), "SONG 1, name, 10:20\n");
    }

    @Test
    void testEquals() {
        assertEquals(song1, song1);
        Song song2 = new Song("name", new Time(10, 20),
                1, "album", "artist");
        assertEquals(song1, song2);

        assertNotEquals(song1, null);
        assertNotEquals(song1, "yes");
        Song song3 = new Song("x", new Time(10, 20),
                1, "album", "artist");
        Song song4 = new Song("name", new Time(11, 20),
                1, "album", "artist");
        Song song5 = new Song("name", new Time(10, 20),
                1, "x", "artist");
        Song song6 = new Song("name", new Time(10, 20),
                1, "album", "x");
        assertNotEquals(song1, song3);
        assertNotEquals(song1, song4);
        assertNotEquals(song1, song5);
        assertNotEquals(song1, song6);
    }

    @Test
    void testHashCode() {
        Song song2 = new Song("name", new Time(10, 20),
                1, "album", "artist");
        assertEquals(song1.hashCode(), song2.hashCode());
    }
}