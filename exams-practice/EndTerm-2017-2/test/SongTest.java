import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class SongTest {
    private Song song0;
    @BeforeEach
    void setup() {
        song0 = new Song("Spies", new Time(5, 19),1, "U2", "Songs of Innocence");
    }

    @Test
    void read() {
        Song song = Song.read(new Scanner("SONG 1, Spies, 5:19"), "U2", "Songs of Innocence");
        assertEquals(song, song0);
    }

    @Test
    void toWrite() {
        System.out.println(song0.toWrite());
    }

    @Test
    void getNr() {
        assertEquals(song0.getNr(), 1);
    }

    @Test
    void testToString() {
        System.out.println(song0.toString());
    }

    @Test
    void testEquals() {
        assertEquals(song0, song0);
        assertNotEquals(song0, null);
        Song song2 = new Song("Spies", new Time(5, 19),1, "U2", "Songs of Innocence");
        assertEquals(song0, song2);
        Song song3 = new Song("mama", new Time(5, 19),1, "U2", "Songs of Innocence");
        assertNotEquals(song3, song0);
    }

    @Test
    void testHashCode() {
        Song song2 = new Song("Spies", new Time(5, 19),1, "U2", "Songs of Innocence");
        assertEquals(song2.hashCode(), song0.hashCode());
    }
}