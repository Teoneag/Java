import java.util.*;

public class CoffeeVariation {

    private String name;
    private double extraCost;
    private List<String> allergies;

    /**
     * Creates a coffee variation.
     *
     * @param name The name of the variation
     * @param extraCost The extra cost of the variation
     * @param allergies The list of allergies
     */
    public CoffeeVariation(String name, double extraCost, List<String> allergies) {
        this.name = name;
        this.extraCost = extraCost;
        this.allergies = allergies;
    }

    /**
     * Gets the name of the variation.
     *
     * @return This variation's name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the extra cost of the variation.
     *
     * @return This variation's extra cost.
     */
    public double getExtraCost() {
        return extraCost;
    }

    /**
     * Checks whether an object is equal to the coffee variation.
     *
     * @param other The other object
     * @return True iff the other is an identical coffee variation
     */
    @Override
    public boolean equals(Object other) {
        if (other == null || this.getClass() != other.getClass()) return false;
        CoffeeVariation that = (CoffeeVariation) other;
        return Objects.equals(this.name, that.name) && this.extraCost == that.extraCost;
    }

}
