import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Cd {
    private String artist;
    private String name;
    private int year;
    private List<Song> songs;


    /**
     * The constructor for the CD
     * @param artist the artis
     * @param name the name
     * @param year the year
     * @param songs the songs
     */
    public Cd(String artist, String name, int year, List<Song> songs) {
        this.artist = artist;
        this.name = name;
        this.year = year;
        this.songs = songs;
    }

    /**
     * Reads a cd from a scanner
     * @param input the scanner
     * @return the cd
     */
    public static Cd read(Scanner input) {
//        input.useDelimiter(", |\n");
//
//        String artist = input.next();
//        String name = input.next();
//        String yearString = input.next();
//        System.out.println(yearString.substring(0, yearString.length() - 1));
//        int year = Integer.parseInt(yearString);
//        System.out.println(year);

        input.useDelimiter(", ");
        String artist = input.next();
        String name = input.next();
        int year = Integer.parseInt(input.nextLine().replace(", ", ""));
        List<Song> songs = new ArrayList<>();
        while (input.hasNextLine()) {
            songs.add(Song.read(new Scanner(input.nextLine()), artist, name));
        }

        return new Cd(artist, name, year, songs);
    }

    /**
     * Converts the CD into a string, same format as the input
     * @return the string
     */
    public String toWrite() {
        StringBuilder s = new StringBuilder("CD " + getArtist() + ", "
                + getName() + ", " + year + "\n");
        for (int i = 0; i < songs.size(); i++) {
            s.append("SONG ").append(i + 1).append(", ")
                    .append(songs.get(i).toWrite()).append("\n");
        }
        return s.toString();
    }

    /**
     * Removes a song from the song list
     * @param index the index of the song
     */
    public void removeSong(int index) {
        songs.remove(0);
    }

    /**
     * Getter for the artist
     * @return the artist
     */
    public String getArtist() {
        return artist;
    }

    /**
     * Getter for the name
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for the song
     * @return the song
     */
    public List<Song> getSongs() {
        return songs;
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
        Cd cd = (Cd) o;
        return year == cd.year && Objects.equals(artist, cd.artist)
                && Objects.equals(name, cd.name) && Objects.equals(songs, cd.songs);
    }

    /**
     * Returns the hash from a Cd
     * @return the hash
     */
    @Override
    public int hashCode() {
        return Objects.hash(artist, name, year, songs);
    }
}
