import java.util.Objects;

public class Stats {
    private int attack;
    private int defence;
    private int hp;
    private int speed;

    public Stats(int attack, int defence,
                 int hp, int speed) {
        this.attack = attack;
        this.defence = defence;
        this.hp = hp;
        this.speed = speed;
    }

    public void decreaseHp(int x) {
        hp -= x;
    }

    public void setHp(int x) {
        hp = x;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefence() {
        return defence;
    }

    public int getHp() {
        return hp;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stats that = (Stats) o;
        return attack == that.attack && defence == that.defence && hp == that.hp && speed == that.speed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(attack, defence, hp, speed);
    }

    @Override
    public String toString() {
        return "It has " + attack + " attack, " + defence + " defence, "
                + hp + " health, and " + speed + " speed.";
    }
}
