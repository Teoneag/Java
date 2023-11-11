package transport.lines;

import transport.Location;

public abstract class public_transport_line {

    private final String name;
    public final Location from;
    public final Location to;
    private final double speed;
    private final double distance;

    /**
     * Creates a new public transport line.
     *
     * @param name The name of the line
     * @param from The starting location
     * @param to The ending location
     * @param speed The speed of traveled on the line (in km/h)
     * @param distance The distance from the start to the end (in km)
     */
    public public_transport_line(String name, Location from, Location to, double speed, double distance) {
        this.name = name;
        this.from = from;
        this.to = to;
        this.speed = speed;
        this.distance = distance;
    }

    /**
     * Gets the time this line takes in minutes.
     *
     * @return The time the transport.lines takes in minutes
     */
    public double getTime() {
        return distance / speed * 60.0;
    }

    /**
     * Gets a string representation fot this line.
     *
     * @return A string representation of this line
     */
    @Override
    public String toString() {
        return name;
    }
}
