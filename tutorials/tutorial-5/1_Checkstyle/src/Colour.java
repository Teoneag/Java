public class Colour {
    private final int red;
    private final int green;
    private final int blue;

    /**
     * The constructor
     * @param red The red component
     * @param green The green component
     * @param blue The blue component
     */
    public Colour(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    /**
     * Gets the red value
     * @return the red value
     */
    public int getRed() {
        return red;
    }

    /**
     * Gets the green value
     * @return the green value
     */
    public int getGreen() {
        return green;
    }

    /**
     * Gets the blue value
     * @return the blue value
     */
    public int getBlue() {
        return blue;
    }

    /**
     * Converts the colour to a string
     * @return the string
     */
    @Override
    public String toString() {
        return super.toString();
    }
}
