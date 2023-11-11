import java.util.Objects;
import java.util.Scanner;

public record Time(int min, int sec) {
    /**
     * Reads from a scanner the time
     * @param input the scanner
     * @return the time
     */
    public static Time read(Scanner input) {
        input.useDelimiter(":");
        int min = input.nextInt();
//        System.out.println("s" + input.nextLine() + "e");
        int sec = Integer.parseInt(input.nextLine().replace(":", ""));
        return new Time(min, sec);
    }

    /**
     * Converts the time to a human-readable string
     * @return the string
     */
    @Override
    public String toString() {
        return min + ":" + sec;
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
        Time time = (Time) o;
        return min == time.min && sec == time.sec;
    }

    /**
     * Converts the time to a hashcode
     * @return the hashcode
     */
    @Override
    public int hashCode() {
        return Objects.hash(min, sec);
    }
}
