import java.util.Objects;

public abstract class Audio {
    private final String name;
    private final Time time;

    /**
     * The constructor for the Audio
     * @param name the name
     * @param time the time
     */
    public Audio(String name, Time time) {
        this.name = name;
        this.time = time;
    }

    /**
     * The getter for the name
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * The getter for the time
     * @return the time
     */
    public Time getTime() {
        return time;
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
        Audio audio = (Audio) o;
        return Objects.equals(name, audio.name) && Objects.equals(time, audio.time);
    }

    /**
     * Creates the hashCode from the Audio
     * @return the hashCode
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, time);
    }
}
