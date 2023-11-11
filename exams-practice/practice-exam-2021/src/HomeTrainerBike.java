import java.util.List;
import java.util.Scanner;

public class HomeTrainerBike extends Bike {

    public HomeTrainerBike(String brand, int price, String model,
                           List<String> mouscleGroups, boolean hasDisplay) {
        super(brand, price, model, mouscleGroups, hasDisplay);
    }

    public String toWrite () {
        String s = "HomeTrainerBike ";
        s += getBrand() + "; ";
        s += getModel() + "; ";
        for (String muscle : getMuscleGroups()) {
            s += muscle + ", ";
        }
        if (!getMuscleGroups().isEmpty()) {
            s = s.substring(0, s.length() - 2);
            s += "; ";
        }
        s += hasDisplay ?  "TRUE; " : "FALSE; ";
        s += getPrice() + " euros";

        return s;
    }

    public static HomeTrainerBike read(Scanner input) {
        input.useDelimiter("; ");
        String brand = input.next();
        String model = input.next();
        List<String> muscleGroups = Bike.readMuscleGroups(
                new Scanner(input.next())
        );
        boolean hasDisplay = input.next().equals("TRUE");
        int price = Bike.readPrice(input);
        return new HomeTrainerBike(brand, price, model, muscleGroups, hasDisplay);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
