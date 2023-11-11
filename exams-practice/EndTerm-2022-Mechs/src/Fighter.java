import java.util.ArrayList;
import java.util.List;

public abstract class Fighter {
    private Stats stats;

    public Fighter(Stats stats) {
        this.stats = stats;
    }

    public Stats getStats() {
        return stats;
    }

    public int getAttackBonus() {
        return 0;
    }

    public int getDefenceBonus() {
        return 0;
    }

    public void decreaseHp(int x) {
        stats.decreaseHp(x);
    }

    public void setHp(int x) {
        stats.setHp(x);
    }

    public List<String> getStrengths() {
        return new ArrayList<>();
    }

    public List<String> getWeaknesses() {
        return new ArrayList<>();
    }

    @Override
    public String toString() {
        return stats.toString();
    }
}
