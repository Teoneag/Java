package transport;

import transport.lines.public_transport_line;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Trip {

    private final Location from;
    private final Location to;
    private final List locations;
    private final List linesToTake;

    /**
     * Creates a new trip.
     *
     * @param from The starting location
     * @param to The ending location
     */
    public Trip(Location from, Location to) {
        this.from = from;
        this.to = to;
        this.locations = new ArrayList();
        this.linesToTake = new ArrayList();
    }

    /**
     * Gets the line to take to get to a location.
     *
     * @param to The location to check
     * @return The line to take or null if no line is set
     */
    public public_transport_line getLineToTake(Location to) {
        for (int i = 0; i < locations.size(); i++) {
            if (locations.get(i).equals(to))
            return (public_transport_line) linesToTake.get(i);
        }
        return null;
    }

    /**
     * Sets the line to take to get to a location.
     *
     * @param to The location to check
     * @param line The line to take
     */
    public void setLineToTake(Location to, public_transport_line line) {
        locations.add(0, to);
        linesToTake.add(0, line);
    }

    /**
     * Gets a string representation for this trip.
     *
     * @return The string representation for this trip
     */
    @Override
    public String toString() {
        if (!locations.contains(to)) return "No route";

        String result = "";
        Location current = to;
        while (current != from) {
            public_transport_line line = getLineToTake(current);
            result = " --(" + line + ")-> " + line.to + result;
                current = line.from;
        }
        result = from + result;
        return result;
    }

}
