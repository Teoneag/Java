import java.util.Objects;

public class FullBall extends Ball{
    private final String type;
    private final String prize;

    /**
     * The contractor for a Ball
     * @param colour The colour String
     * @param description The description String
     * @param type The type String
     * @param prize The prize String
     */
    public FullBall(String colour, String description, String type, String prize) {
        super(colour, description);
        this.type = type;
        this.prize = prize;
    }

    /**
     * The getter for the type
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * The getter for the prize
     * @return the prize
     */
    public String getPrize() {
        return prize;
    }

    /**
     * Checks if a full ball is equal to an object
     * @param o The object to compare with
     * @return Whether they are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FullBall fullBall)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getType(), fullBall.getType())
                && Objects.equals(getPrize(), fullBall.getPrize());
    }

    /**
     * Generates the hashCode for the Full Ball
     *
     * @return The hashCode
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getType(), getPrize());
    }

    /**
     * Converts a Full Ball into a human-readable String
     * as requested by option 1
     *
     * @return The String
     */
    @Override
    public String toString() {
        return type + " Prize Ball " + super.toString() + " " + prize + ".";
    }

    /**
     * Converts a Full Ball into a human-readable String
     * as requested by option 3
     *
     * @return The String
     */
    public String printDraw() {
        return super.printDraw() + type + " Prize Ball ("
                + getColour() + "), it contains " + prize + ". Congratulations!";
    }

    /**
     * Converts a Full Ball into a human-readable String
     * as requested by option 4
     *
     * @return The String
     */
    public String toLog() {
        return "A " + type + " Prize ball " + super.toLog()
                + " containing " + prize + " was drawn.";
    }
}
