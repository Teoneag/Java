import java.util.Objects;

public class WeaponCard extends Card {
    private int durability;

    public WeaponCard(String rarity, String name, int energyCost, int durability) {
        super(rarity, name, energyCost);
        this.durability = durability;
    }

    public String toString() {
        return "Weapon: " + super.toString() + "\n"
                + durability + " Durability\n";
    }

    public String toWrite() {
        return "Weapon card\n" + super.toWrite() + "\n" + durability + " Durability\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WeaponCard that)) return false;
        if (!super.equals(o)) return false;
        return durability == that.durability;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), durability);
    }
}
