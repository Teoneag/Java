public class Colour {

    private int red;
    private int green;
    private int blue;

    /**
     * Creates a colour.
     *
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
     * Gets the red component.
     *
     * @return The red component
     */
    public int getRed() {
        return red;
    }

    /**
     * Gets the green component.
     *
     * @return The green component
     */
    public int getGreen() {
        return green;
    }

    /**
     * Gets the blue component.
     *
     * @return The blue component
     */
    public int getBlue() {
        return blue;
    }

    /**
     * Converts the colour to a string.
     *
     * @return A string in the format <code>&quot;red, green, blue&quot;</code>
     */
    @Override
    public String toString() {
        return super.toString();
    }
}
