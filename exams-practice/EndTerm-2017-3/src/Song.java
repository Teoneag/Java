import java.util.Objects;
import java.util.Scanner;

public class Song extends Audio {
    private final int nr;
    private final String album;
    private final String artist;

    /**
     * The constructor for the song
     *
     * @param name   the name
     * @param time   the time
     * @param nr     the nr
     * @param album  the album
     * @param artist the artist
     */
    public Song(String name, Time time, int nr, String album, String artist) {
        super(name, time);
        this.nr = nr;
        this.album = album;
        this.artist = artist;
    }

    /**
     * Reads the song from  a scanner
     * @param input the scanner
     * @param album the album
     * @param artist the artist
     * @return the song
     */
    public static Song read(Scanner input, String album, String artist) {
        input.next(); // skip SONG
        input.skip(" "); // skip space
        input.useDelimiter(", ");
        int nr = input.nextInt();
        String name = input.next();
        Time time = Time.read(new Scanner(input.next()));
        return new Song(name, time, nr, album, artist);
    }

    /**
     * Converts the Song to a human-readable string
     * @return the string
     */
    @Override
    public String toString() {
        return "Album: " + artist + "'s " + album
                + "\n   Track " + super.toString();
    }

    /**
     * Converts the song to a string, in the format of the input
     * @param nr the nr of the song
     * @return the string
     */
    public String toWrite(int nr) {
        return "SONG " + nr + ", " + super.toWrite() + "\n";
    }

    /**
     * Getter for the nr
     * @return the nr
     */
    public int getNr() {
        return nr;
    }

    /**
     * Getter for the album
     * @return the album
     */
    public String getAlbum() {
        return album;
    }

    /**
     * Getter for the artist
     * @return the artist
     */
    public String getArtist() {
        return artist;
    }

    /**
     * Checks if 2 objects are equal
     *
     * @param o the object to compare with
     * @return whether they are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Song song = (Song) o;
        return nr == song.nr && Objects.equals(album, song.album)
                && Objects.equals(artist, song.artist);
    }

    /**
     * Calculates the hashCode of the Song
     *
     * @return the hashCode
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nr, album, artist);
    }
}
