import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Mech extends Fighter {
    private String name;
    private String category;
    private int lootDropId;
    private List<String> strengths;
    private List<String> weaknesses;

    public Mech(Stats stats, String name, String category, int lootDropId, List<String> strengths, List<String> weaknesses) {
        super(stats);
        this.name = name;
        this.category = category;
        this.lootDropId = lootDropId;
        this.strengths = strengths;
        this.weaknesses = weaknesses;
    }

    public static Mech read(Scanner input) {
        input.useDelimiter(" - |\\R");
        input.next(); // skip MECH

        String name = input.next();
        String category = input.next();
        int loopDropId = input.nextInt();

        int attack = Integer.parseInt(
                input.next().replace("ATK", ""));
        int defence = Integer.parseInt(
                input.next().replace("DEF", ""));
        int hp = Integer.parseInt(
                input.next().replace("HP", ""));
        int speed = Integer.parseInt(
                input.next().replace("SPD", ""));
        Stats stats = new Stats(attack, defence, hp, speed);

        input.nextLine(); // skip /n
        Scanner lineScanner = new Scanner(input.nextLine());
        lineScanner.useDelimiter(" - ");
        // TODO make this in a separate file
        List<String> strengths = new ArrayList<>();
        List<String> weaknesses = new ArrayList<>();
        while (lineScanner.hasNext()) {
            String next = lineScanner.next();
            if (next.contains("strength")) {
                strengths.add(next.replace("strength: ", ""));
            } else {
                weaknesses.add(next.replace("weakness: ", ""));
            }
        }
        return new Mech(stats, name, category, loopDropId, strengths, weaknesses);
    }

    public List<String> getStrengths() {
        return strengths;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getLootDropId() {
        return lootDropId;
    }

    public List<String> getWeaknesses() {
        return weaknesses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mech mech = (Mech) o;
        return lootDropId == mech.lootDropId && Objects.equals(name, mech.name) && Objects.equals(category, mech.category) && Objects.equals(strengths, mech.strengths) && Objects.equals(weaknesses, mech.weaknesses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, category, lootDropId, strengths, weaknesses);
    }

    @Override
    public String toString() {
        StringBuilder s1 = new StringBuilder();
//        strengths.stream().;
        // TOOD make this with a map
        for (String s : strengths) {
            s1.append(s).append(", ");
        }
        if (s1.isEmpty()) s1.append("none");
        else s1 = new StringBuilder(s1.substring(0, s1.length() - 2));

        StringBuilder s2 = new StringBuilder();
//        weaknesses.stream().map(x -> x + ", ");
        for (String s : weaknesses) {
            s2.append(s).append(", ");
        }
        if (s2.isEmpty()) s2.append("none");
        else s2 = new StringBuilder(s2.substring(0, s2.length() - 2));

        return name + " (Category " + category + ")\n"
                + super.toString() + "\n"
                + "strength(s): " + s1
                + "; weakness(es): " + s2;
    }
}
