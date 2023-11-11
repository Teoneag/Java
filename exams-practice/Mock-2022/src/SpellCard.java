import java.util.Objects;

public class SpellCard extends Card {
    private String spellType;
    private String description;

    public SpellCard(String rarity, String name, int energyCost, String spellType, String description) {
        super(rarity, name, energyCost);
        this.spellType = spellType;
        this.description = description;
    }

    public String toString() {
        return "Spell: " + super.toString() + "\n"
                + spellType + " - " + description + "\n";
    }

    public String toWrite() {
        return "Spell card\n" + super.toWrite() + " - " + spellType
                + "\n" + description + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SpellCard that)) return false;
        if (!super.equals(o)) return false;
        return this.spellType.equals(that.spellType)
                && this.description.equals(that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), spellType, description);
    }
}
