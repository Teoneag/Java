import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class CityReader {

    public static Stream<City> readCitiesFunctional(BufferedReader reader) {
        Stream<String> lines = reader.lines();

        return lines.filter(x -> !x.isBlank()).map(x -> {
            Scanner s = new Scanner(x).useDelimiter(",");
            return new City(s.next(), s.nextInt(), s.next(), s.nextDouble());
        });
    }

    public static List<City> readCitiesImperative(BufferedReader reader) throws IOException {
        // Read all lines
        List<String> lines = new ArrayList<>();
        String line = reader.readLine();
        while (line != null) {
            lines.add(line);
            line = reader.readLine();
        }
        ;

        // Remove all empty lines
        List<String> notEmpty = new ArrayList<>();
        for (String s : lines) {
            if (!s.isBlank()) {
                notEmpty.add(s);
            }
        }

        // Split all lines on comma
        List<String[]> linesSplit = new ArrayList<>();
        for (String s : notEmpty) {
            linesSplit.add(s.split(","));
        }

        // Convert the String arrays to cities
        List<City> cities = new ArrayList<>();
        for (String[] parts : linesSplit) {
            cities.add(new City(parts[0], Integer.parseInt(parts[1]), parts[2], Double.parseDouble(parts[3])));
        }

        return cities;
    }

}
