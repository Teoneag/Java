import java.util.Objects;
import java.util.Scanner;

public record Time(int min, int sec) {
    /**
     * Reads the time from a scanner
     * @param input the scanner
     * @return the time
     */
    public static Time read(Scanner input) {
        input.useDelimiter(":");
        int min = input.nextInt();
        int sec = input.nextInt();
        return new Time(min, sec);
    }

    /**
     * Converts the Audio to a human-readable string
     * @return the string
     */
    @Override
    public String toString() {
        return min + ":" + sec;
    }

    /**
     * Checks if 2 objects are equal
     * @param o the object to compare with
     * @return whether they are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Time time = (Time) o;
        return min == time.min && sec == time.sec;
    }

    /**
     * Calculates the hashCode of the Song
     * @return the hashCode
     */
    @Override
    public int hashCode() {
        return Objects.hash(min, sec);
    }
}
