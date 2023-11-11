import java.util.Objects;

public abstract class Ball {
    private final String colour;
    private final String description;

    /**
     * The contractor for a Ball
     *
     * @param colour      The colour String
     * @param description The description String
     */
    public Ball(String colour, String description) {
        this.colour = colour;
        this.description = description;
    }

    /**
     * The getter for the colour
     *
     * @return The colour
     */
    public String getColour() {
        return colour;
    }

    /**
     * The getter for the description
     *
     * @return The description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Checks if a ball is equal to an object
     *
     * @param o The object to compare with
     * @return Whether they are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ball ball)) return false;
        return Objects.equals(getColour(), ball.getColour())
                && Objects.equals(getDescription(), ball.getDescription());
    }

    /**
     * Generates the hashCode for the Ball
     *
     * @return The hashCode
     */
    @Override
    public int hashCode() {
        return Objects.hash(getColour(), getDescription());
    }

    /**
     * Converts a Ball into a human-readable String
     * as requested by option 1
     *
     * @return The String
     */
    @Override
    public String toString() {
        return "(" + colour + "), it contains";
    }

    /**
     * Converts a Ball into a human-readable String
     * as requested by option 3
     *
     * @return The String
     */
    public String printDraw() {
        return description + "\n" + "You get ";
    }

    /**
     * Converts a Ball into a human-readable String
     * as requested by option 4
     *
     * @return The String
     */
    public String toLog() {
        return "(" + colour + ")";
    }
}
