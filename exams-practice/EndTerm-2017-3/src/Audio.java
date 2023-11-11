import java.util.Objects;

public abstract class Audio {
    final private String name;
    final private Time time;

    /**
     * Constructor
     * @param name the name
     * @param time the time
     */
    public Audio(String name, Time time) {
        this.name = name;
        this.time = time;
    }

    /**
     * Converts the Audio to a human readable stirng
     * @return the string
     */
    @Override
    public String toString() {
        return name + " (" + time + ")";
    }

    /**
     * Converts the add to a string, in the same format as the input file
     * @return the string
     */
    public String toWrite() {
        return name + ", " + time;
    }

    /**
     * Getter for the name
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for the time
     * @return the time
     */
    public Time getTime() {
        return time;
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
        Audio audio = (Audio) o;
        return Objects.equals(name, audio.name) && Objects.equals(time, audio.time);
    }

    /**
     * Calculates the hashCode of the Audio
     * @return the hashCode
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, time);
    }
}
