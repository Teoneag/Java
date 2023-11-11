import java.util.Objects;
import java.util.Scanner;

public class Song extends Audio {
    private final int nr;
    private final String artist;
    private final String album;

    /**
     * The constructor for the Song
     * @param name the name
     * @param time the time
     * @param nr the nr
     * @param artist the artist
     * @param album the album
     */
    public Song(String name, Time time, int nr, String artist, String album) {
        super(name, time);
        this.nr = nr;
        this.artist = artist;
        this.album = album;
    }

    /**
     * Reads a Song from a scanner
     * @param input the scanner
     * @param artist the artist
     * @param album the album
     * @return the song
     */
    public static Song read(Scanner input, String artist, String album) {
        input.next(); // skip SONG
        input.useDelimiter(", | ");
        int nr = input.nextInt();

        input.useDelimiter(", ");
        String name = input.next();
        Time time = Time.read(new Scanner(input.next()));
        return new Song(name, time, nr, artist, album);
    }

    /**
     * Converts the Song to a string, in the same format as the input
     * @return the string
     */
    public String toWrite() {
        return getName() + ", " + getTime();
    }

    /**
     * Getter for the nr
     * @return the nr
     */
    public int getNr() {
        return nr;
    }

    /**
     * Converts the song into a human readable string
     * @return the string
     */
    @Override
    public String toString() {
        return "Album: " + artist + "'s " + album + "\n   "
                + getName() + " (" + getTime() + ")";
    }

    /**
     * Checks if 2 obj are equal
     * @param o the object to check with
     * @return wheather they are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Song song = (Song) o;
        return nr == song.nr && Objects.equals(artist, song.artist)
                && Objects.equals(album, song.album);
    }

    /**
     * Returns the hashcode of a Song
     * @return the hashcode
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nr, artist, album);
    }
}
