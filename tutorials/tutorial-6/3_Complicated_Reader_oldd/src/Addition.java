import java.util.List;
import java.util.Objects;

public class Addition {

    private String name;
    private double price;
    private List<String> allergies;

    /**
     * Creates an addition.
     *
     * @param name The name of the addition
     * @param price The price of the addition
     * @param allergies The list of allergies for the addition
     */
    public Addition(String name, double price, List<String> allergies) {
        this.name = name;
        this.price = price;
        this.allergies = allergies;
    }

    /**
     * Gets the name of the addition.
     *
     * @return This addition's name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the price of the addition.
     *
     * @return This addition's price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Gets the list of allergies.
     *
     * @return The list of allergies for this addition.
     */
    public List<String> getAllergies() {
        return allergies;
    }

    /**
     * Checks whether an object is equal to the addition.
     *
     * @param other The other object
     * @return True iff the other is an identical addition
     */
    @Override
    public boolean equals(Object other) {
        if (other == null || this.getClass() != other.getClass()) return false;
        Addition that = (Addition) other;
        return Objects.equals(this.name, that.name) && this.price == that.price && Objects.equals(this.allergies, that.allergies);
    }

}
