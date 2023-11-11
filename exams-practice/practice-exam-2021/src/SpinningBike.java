import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class SpinningBike extends Bike {
    private int weight;
    private String mechanism;

    public SpinningBike(String brand, int price, String model,
                        List<String> muscleGroups, boolean hasDisplay,
                        int weight, String mechanism) {
        super(brand, price, model, muscleGroups, hasDisplay);
        this.weight = weight;
        this.mechanism = mechanism;
    }

    public String toWrite() {
        String s = "SpinningBike ";
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
        s += getWeight() + "KG; ";
        s += getMechanism() + "; ";
        s += getPrice() + " euros";

        return s;
    }

    public static SpinningBike read(Scanner input) {
        input.skip(" ");
        input.useDelimiter("; ");
        String brand = input.next();
        String model = input.next();
        List<String> muscleGroups = Bike.readMuscleGroups(
                new Scanner(input.next())
        );
        boolean hasDisplay = input.next().equals("TRUE");
        int weight = Integer.parseInt(input.next().replace("KG", ""));
        String mechanism = input.next();
        int price = Bike.readPrice(input);

        return new SpinningBike(brand, price, model, muscleGroups, hasDisplay, weight, mechanism);
    }

    public int getWeight() {
        return weight;
    }

    public String getMechanism() {
        return mechanism;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SpinningBike that)) return false;
        if (!super.equals(o)) return false;
        return getWeight() == that.getWeight() && Objects.equals(getMechanism(), that.getMechanism());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getWeight(), getMechanism());
    }

    @Override
    public String toString() {
        return super.toString() + "\n   The weight of the flywheel is: "
                + weight + "\n   The resistance mechanism is: " + mechanism;
    }
}
