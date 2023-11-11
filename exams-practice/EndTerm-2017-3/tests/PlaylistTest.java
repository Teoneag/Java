import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class PlaylistTest {

    Playlist playlist;

    @BeforeEach
    void setup() {
        playlist = new Playlist();
        playlist.read(new Scanner("""
                CDS
                CD U2, Songs of Innocence, 2014
                SONG 1, Every Breaking Wave, 4:12
                SONG 2, California, 4:0
                SONG 3, Song for Someone, 3:47
                CD Coldplay, Parachutes, 2000
                SONG 1, Don’t Panic, 2:17
                SONG 2, Spies, 5:19
                ADDS
                ADD ING Bank, 0:20
                ADD Bol.com, 0:15
                ADD Albert Heijn, 0:30
                ADD Specsavers, 0:15
                ADD Kruidvat, 0:10
                ADD MediaMarkt.nl, 0:20
                ADD KPN, 0:30
                ADD TU Delft, 0:15
                ADD ABN Amro, 0:30
                ADD Rabobank, 0:15
                """));
    }

    @Test
    void read() {
        assertEquals(2, playlist.getCds().size());
        assertEquals(10, playlist.getAdds().size());
        assertEquals(10, playlist.getAudios().size());
    }

    @Test
    void show() {
        assertEquals("""
                Album: U2's Songs of Innocence
                   Track Every Breaking Wave (4:12)
                Next add: ING Bank (0:20)
                Album: U2's Songs of Innocence
                   Track California (4:0)
                Next add: Bol.com (0:15)
                Album: U2's Songs of Innocence
                   Track Song for Someone (3:47)
                Next add: Albert Heijn (0:30)
                Album: Coldplay's Parachutes
                   Track Don’t Panic (2:17)
                Next add: Specsavers (0:15)
                Album: Coldplay's Parachutes
                   Track Spies (5:19)
                Next add: Kruidvat (0:10)
                """, playlist.show());
    }

    @Test
    void add() {
        int audiosSize = playlist.getAudios().size();
        int cdsSize = playlist.getCds().size();
        int addsSize = playlist.getAdds().size();

        playlist.add(new Scanner("artist\nalbum\n2020\n1\nname\n1\n2\n"));

        assertEquals(audiosSize + 2, playlist.getAudios().size());
        assertEquals(cdsSize + 1, playlist.getCds().size());
        assertEquals(addsSize, playlist.getAdds().size());
    }

    @Test
    void play() {
        assertEquals("""
                        Album: U2's Songs of Innocence
                           Track Every Breaking Wave (4:12)
                        Next add: ING Bank (0:20)
                        """,
                playlist.play("resources/spotify.txt"));
    }

    @Test
    void shuffle() {
    }

    @Test
    void write() {
        StringWriter s = new StringWriter();
        BufferedWriter bufferedWriter = new BufferedWriter(s);
        playlist.write(bufferedWriter);

        assertEquals("""
                CDS
                CD U2, Songs of Innocence, 2014
                SONG 1, Every Breaking Wave, 4:12
                SONG 2, California, 4:0
                SONG 3, Song for Someone, 3:47
                CD Coldplay, Parachutes, 2000
                SONG 1, Don’t Panic, 2:17
                SONG 2, Spies, 5:19
                ADDS
                ADD ING Bank, 0:20
                ADD Bol.com, 0:15
                ADD Albert Heijn, 0:30
                ADD Specsavers, 0:15
                ADD Kruidvat, 0:10
                ADD MediaMarkt.nl, 0:20
                ADD KPN, 0:30
                ADD TU Delft, 0:15
                ADD ABN Amro, 0:30
                ADD Rabobank, 0:15""", s.toString());
    }
}