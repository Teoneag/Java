import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Player extends Fighter {
    private Equipment offensiveEquip;
    private Equipment defensiveEquip;

    public Player() {
        super(new Stats(3, 1, 30, 3));
        this.offensiveEquip = null;
        this.defensiveEquip = null;
    }

    public int getAttackBonus() {
        return offensiveEquip == null ? 0 : offensiveEquip.getBonus();
    }

    public int getDefenceBonus() {
        return defensiveEquip == null ? 0 : defensiveEquip.getBonus();
    }

    public List<String> getStrengths() {
        List<String> strengths = defensiveEquip == null ? new ArrayList<>() : defensiveEquip.getStrengths();
        strengths.addAll(offensiveEquip == null ? new ArrayList<>() : offensiveEquip.getStrengths());
        return strengths;
    }

    public List<String> getWeaknesses() {
        List<String> weaknesses = defensiveEquip == null ? new ArrayList<>() : defensiveEquip.getWeaknesses();
        weaknesses.addAll(offensiveEquip == null ? new ArrayList<>() : offensiveEquip.getWeaknesses());
        return weaknesses;
    }

    public Equipment getOffensiveEquip() {
        return offensiveEquip;
    }

    public Equipment getDefensiveEquip() {
        return defensiveEquip;
    }

    public void setOffensiveEquip(Equipment offensiveEquip) {
        this.offensiveEquip = offensiveEquip;
    }

    public void setDefensiveEquip(Equipment defensiveEquip) {
        this.defensiveEquip = defensiveEquip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(offensiveEquip, player.offensiveEquip) && Objects.equals(defensiveEquip, player.defensiveEquip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(offensiveEquip, defensiveEquip);
    }

    @Override
    public String toString() {
        return "Player\n" + super.toString() + "\n"
                + "Offensive equipment: " + (offensiveEquip == null ? "none" : offensiveEquip.toString())
                + "; Defensive equipment: " + (defensiveEquip == null ? "none" : defensiveEquip.toString());
    }
}
