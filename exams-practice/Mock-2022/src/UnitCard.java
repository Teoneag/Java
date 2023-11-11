import java.util.Objects;

public class UnitCard extends Card {
    private int attack;
    private int defence;

    public UnitCard(String rarity, String name, int energyCost, int attack, int defence) {
        super(rarity, name, energyCost);
        this.attack = attack;
        this.defence = defence;
    }

    public String toString() {
        return "Unit: " + super.toString() + "\n"
                + attack + " Attack - " + defence + " Defence\n";
    }

    public String toWrite() {
        return "Unit card\n" + super.toWrite() + attack + " Attack - " + defence + " Defence\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UnitCard that)) return false;
        if (!super.equals(o)) return false;
        return this.attack == that.attack && this.defence == that.defence;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), attack, defence);
    }
}


