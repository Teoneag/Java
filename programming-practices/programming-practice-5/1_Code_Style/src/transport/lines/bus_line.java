package transport.lines;

import transport.Location;

public class bus_line extends public_transport_line {

    /**
     * Creates a bus line.
     *
     * @param name The name of the bus line
     * @param from The station where the bus starts from
     * @param to The station the bus stops at
     * @param distance The distance between the stops
     */
    public bus_line(String name, Location from, Location to, double distance) {
        super(name, from, to, 40.0, distance);
    }

}
