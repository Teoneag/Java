import java.util.List;

public class EmptyBall extends Ball{

    /**
     * The contractor for an Empty Ball
     *
     * @param colour      The colour String
     * @param description The description String
     */
    public EmptyBall(String colour, String description) {
        super(colour, description);
    }

    /**
     * Adds to a ball list the ball nr times
     * @param balls The ball list
     * @param nr The nr of times to be added
     * @param ball The ball to be added
     */
    public static void add(List<Ball> balls, int nr, Ball ball) {
        for (int i = 0; i < nr; i++) {
            balls.add(ball);
        }
    }

    /**
     * Converts an Empty Ball into a human-readable String
     * as requested by option 1
     *
     * @return The String
     */
    @Override
    public String toString() {
        return "Empty ball " + super.toString() + "... nothing.";
    }

    /**
     * Converts an Empty Ball into a human-readable String
     * as requested by option 3
     *
     * @return The String
     */
    public String printDraw() {
        return super.printDraw() + "an empty ball (" + getColour() + "). Good luck next time!";
    }

    /**
     * Converts an Empty Ball into a human-readable String
     * as requested by option 4
     *
     * @return The String
     */
    public String toLog() {
        return "An Empty Ball" + super.toLog() + " was drawn.";
    }
}
