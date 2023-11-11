import java.util.Objects;
import java.util.Scanner;

public abstract class Card {
    private String rarity;
    private String name;
    private int energyCost;

    public Card(String rarity, String name, int energyCost) {
        this.rarity = rarity;
        this.name = name;
        this.energyCost = energyCost;
    }

    public String toString() {
        return name + " (" + rarity + ") , costs " + energyCost + " Energy.";
    }

    public String toWrite() {
        return rarity + "\n" + name + " - " + energyCost + " Energy";
    }

    public String getRarity() {
        return rarity;
    }

    public String getName() {
        return name;
    }

    public int getEnergyCost() {
        return energyCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card that)) return false;
        return this.rarity.equals(that.rarity)
                && this.energyCost == that.energyCost
                && this.name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRarity(), getName(), getEnergyCost());
    }
}
