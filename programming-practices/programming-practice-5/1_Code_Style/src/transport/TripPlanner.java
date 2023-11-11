package transport;

import transport.lines.bus_line;
import transport.lines.public_transport_line;
import transport.lines.train_line;

import java.util.*;

public class TripPlanner {

    /**
     * Main method.
     *
     * @param args The command line arguments
     */
    public static void main(String[] args) {
        // Trip from Leiden Science Park to TU Delft Aula

        List<public_transport_line> AllLines = new ArrayList<>();

        Location leidenSciencePark = new Location("Leiden Science Park");
        Location leidenCentralStation = new Location("Leiden Central Station");
        Location theHagueCentralStation = new Location("The Hague Central Station");
        Location utrechtCentralStation = new Location("Utrecht Central Station");
        Location rotterdamCentralStation = new Location("Rotterdam Central Station");
        Location delftCentralStation = new Location("Delft Central Station");
        Location tuDelftAula = new Location("TU Delft Aula");

        AllLines.add(new bus_line("Bus 69",
                delftCentralStation, tuDelftAula, 2.0));
        AllLines.add(new train_line("NS Train",
                rotterdamCentralStation, delftCentralStation, 20.0, "Intercity", false, 0));
        AllLines.add(new train_line("NS Train",
                leidenCentralStation, delftCentralStation, 30.0, "Intercity", false, 0));
        AllLines.add(new train_line("NS Train",
                leidenCentralStation, theHagueCentralStation, 20.0, "Sprinter", false, 0));
        AllLines.add(new train_line("NS Train",
                theHagueCentralStation, delftCentralStation, 15.0, "Sprinter", false, 0));
        AllLines.add(new train_line("NS Train",
                leidenCentralStation, utrechtCentralStation, 40.0, "Intercity", false, 0));
        AllLines.add(new train_line("NS Train",
                utrechtCentralStation, rotterdamCentralStation, 35.0, "Intercity", false, 0));
        AllLines.add(new bus_line("Bus 90",
                leidenSciencePark, leidenCentralStation, 1.5));

        System.out.println("Quickest way from " + leidenSciencePark + " to " + tuDelftAula + ":");
        System.out.println(PlanTrip(leidenSciencePark, tuDelftAula, AllLines));
    }

    /**
     * Plans a trip between two locations.
     *
     * @param from The starting location
     * @param to The ending location
     * @param allLines The list of all transport.lines
     * @return The trip form the start to the end
     */
    private static Trip PlanTrip(Location from,Location to,List<public_transport_line>allLines){
        Distances distances;
        distances=new Distances();
        Trip trip=new Trip(from,to);
        List<Location>nextLocations=new ArrayList<>();
        Set<Location>visited=new HashSet<>();
        nextLocations.add(from);
        distances.setDistance(from, 0.0);
        while (nextLocations.isEmpty()==false){
            nextLocations.sort(new CompareDistances(distances));
            Location current = nextLocations.remove(0);
            if(visited.contains(current))continue;
            if(current.equals(to))break;
            visited.add(current);
            for(public_transport_line next:AvailableLines(current,allLines)){
                if(visited.contains(next.to))continue;
                double newDist=distances.getDistanceTo(current)+next.getTime();
                if(newDist<distances.getDistanceTo(next.to)){
                    distances.setDistance(next.to, newDist);
                    trip.setLineToTake(next.to, next);
                }
                nextLocations.add(next.to);
            }
        }
        return(trip);
    }

    /**
     * Gets all the available lines to take from a given location.
     *
     * @param from The location to check
     * @param allLines The list of all transport.lines
     * @return The lines available from the given location
     */
    private static List<public_transport_line> AvailableLines(Location from, List<public_transport_line> allLines) {
        List<public_transport_line> available = new ArrayList<>();
        for (public_transport_line line : allLines) {
            if (line.from.equals(from)) available.add(line);
        }
        return available;
    }

}
