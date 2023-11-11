import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public abstract class Bike extends Product {
    String model;
    List<String> muscleGroups;
    boolean hasDisplay;

    public Bike(String brand, int price, String model,
                List<String> mouscleGroups, boolean hasDisplay) {
        super(brand, price);
        this.model = model;
        this.muscleGroups = mouscleGroups;
        this.hasDisplay = hasDisplay;
    }

    public static List<String> readMuscleGroups(Scanner input) {
        List<String> muscleGroups = new ArrayList<>();
        input.useDelimiter(", ");
        while (input.hasNext()) {
            muscleGroups.add(input.next());
        }
        return muscleGroups;
    }

    public static int readPrice(Scanner input) {
        input.useDelimiter(" ");
        input.next(); // skip ;
        return input.nextInt();
    }

    public String getModel() {
        return model;
    }

    public List<String> getMuscleGroups() {
        return muscleGroups;
    }

    public boolean isHasDisplay() {
        return hasDisplay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bike bike)) return false;
        if (!super.equals(o)) return false;
        return isHasDisplay() == bike.isHasDisplay() && Objects.equals(getModel(), bike.getModel()) && Objects.equals(getMuscleGroups(), bike.getMuscleGroups());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getModel(), getMuscleGroups(), isHasDisplay());
    }

    @Override
    public String toString() {
        String s = "Bike: " + getBrand() + " " + model + "\n";
        if (!muscleGroups.isEmpty()) {
            s += "   Muscle groups: ";
        }
        for (String muscle : muscleGroups) {
            s += muscle + " & ";
        }
        if (!muscleGroups.isEmpty()) {
            s = s.substring(0, s.length() - 3);
        }
        s += "\n";
        if (hasDisplay) {
            s += "   An electronic display that visualizes speed is present.\n";
        }
        s += "   The price is: " + getPrice() + " euros.";
        return s;
    }
}
