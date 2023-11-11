package transport.lines;

import transport.Location;

public class train_line extends public_transport_line {

    private final String trainType;
    private final boolean isBroken;
    private final int delay;

    /**
     * Creates a train line.
     *
     * @param name The name of the train line
     * @param from The station where the train starts from
     * @param to The station the train stops at
     * @param distance The distance between the stops
     * @param trainType The type of train, either 'Sprinter' or 'Intercity'
     * @param isBroken Whether the train line is broken
     * @param delay The amount of delay in minutes
     */
    public train_line(String name, Location from, Location to, double distance, String trainType, boolean isBroken, int delay) {
        super(name, from, to, 130.0, distance);
        this.trainType = trainType;
        this.isBroken = isBroken;
        this.delay = delay;
    }

    /**
     * @inheritDoc
     */
    @Override
    public double getTime() {
        if (isBroken) return 60 * 24;
        return delay + ((trainType.equals("Sprinter")) ? super.getTime() * 1.1 : super.getTime());
    }
}
