import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Cd {
    private final String artist;
    private final String album;
    private final int year;
    private final List<Song> songs;

    /**
     * The constructor for the cd
     *
     * @param artist the artist
     * @param album  the album
     * @param year   the year
     * @param songs  the songs
     */
    public Cd(String artist, String album, int year, List<Song> songs) {
        this.artist = artist;
        this.album = album;
        this.year = year;
        this.songs = songs;
    }

    /**
     * Reads the cd form a scanner
     *
     * @param input scanner
     * @return the string
     */
    public static Cd read(Scanner input) {
        input.useDelimiter(", |\\R");
        String artist = input.next();
        String album = input.next();
        int year = input.nextInt();
        List<Song> songs = new ArrayList<>();
        input.nextLine(); // skip /n
        while (input.hasNextLine()) {
            songs.add(Song.read(new Scanner(input.nextLine()), album, artist));
        }
        return new Cd(artist, album, year, songs);
    }

    /**
     * Converts the cd to a string, in the same format as the input file
     *
     * @return the string
     */
    public String toWrite() {
        StringBuilder s = new StringBuilder("CD " + artist + ", " + album + ", " + year + "\n");
        for (int i = 0; i < songs.size(); i++) {
            s.append(songs.get(i).toWrite(i + 1));
        }
        return s.toString();
    }

    /**
     * Removes a song from the songs
     *
     * @param song the song
     */
    public void remove(Song song) {
        songs.remove(song);
    }

    /**
     * Getter for the artist
     *
     * @return the artist
     */
    public String getArtist() {
        return artist;
    }

    /**
     * Getter for the album
     *
     * @return the album
     */
    public String getAlbum() {
        return album;
    }

    /**
     * Getter for the year
     *
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * Getter for the songs
     *
     * @return the songs
     */
    public List<Song> getSongs() {
        return songs;
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
        Cd cd = (Cd) o;
        return year == cd.year && Objects.equals(artist, cd.artist)
                && Objects.equals(album, cd.album) && Objects.equals(songs, cd.songs);
    }

    /**
     * Calculates the hashCode of the Cd
     *
     * @return the hashCode
     */
    @Override
    public int hashCode() {
        return Objects.hash(artist, album, year, songs);
    }
}
