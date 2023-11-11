import java.util.List;
import java.util.Objects;

public class CoffeeItem {

    private String name;
    private double price;
    private List<String> allergies;
    private List<CoffeeVariation> variations;

    /**
     * Creates a coffee item.
     *
     * @param name The name of the coffee item
     * @param price The price of the coffee item
     * @param allergies The allergies for the coffee item
     * @param variations The variations of the coffee item
     */
    public CoffeeItem(String name, double price, List<String> allergies, List<CoffeeVariation> variations) {
        this.name = name;
        this.price = price;
        this.allergies = allergies;
        this.variations = variations;
    }

    /**
     * Gets the name of the coffee item.
     *
     * @return This coffee item's name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the price of the coffee item.
     *
     * @return This coffee item's name
     */
    public double getPrice() {
        return price;
    }

    /**
     * Gets the allergies for the coffee item.
     *
     * @return The list of allergies for this coffee item
     */
    public List<String> getAllergies() {
        return allergies;
    }

    /**
     * Gets the list of variations on the coffee item.
     *
     * @return The list of possible variations for this coffee item
     */
    public List<CoffeeVariation> getVariations() {
        return variations;
    }

    /**
     * Checks whether an object is equal to the coffee item.
     *
     * @param other The other object
     * @return True iff the other is an identical coffee item
     */
    @Override
    public boolean equals(Object other) {
        if (other == null || this.getClass() != other.getClass()) return false;
        CoffeeItem that = (CoffeeItem) other;
        return Objects.equals(this.name, that.name) && this.price == that.price
                && Objects.equals(this.allergies, that.allergies) && Objects.equals(this.variations, that.variations);
    }

}
