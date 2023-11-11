import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Equipment {
    private String name;
    private String category;
    private int equipmentId;
    private int bonus;
    private List<String> strengths;
    private List<String> weaknesses;

    public Equipment(String name, String category, int equipmentId, int bonus, List<String> strengths, List<String> weaknesses) {
        this.name = name;
        this.category = category;
        this.equipmentId = equipmentId;
        this.bonus = bonus;
        this.strengths = strengths;
        this.weaknesses = weaknesses;
    }

    public static Equipment read(Scanner input) {
//        if (input.nextLine().contains("null")) return null;

        input.useDelimiter(" - |\\R");
        String s = input.next(); // skip EQUIPMENT
        if (s.contains("null")) return null;

        String name = input.next();
        String category = input.next();
        int id = input.nextInt();

        String next = input.next();
        int bonus = Integer.parseInt(
                next.substring(0, next.length() - 3));

        input.nextLine(); // skip /n
        Scanner lineScanner = new Scanner(input.nextLine());
        lineScanner.useDelimiter(" - ");
        List<String> strengths = new ArrayList<>();
        List<String> weaknesses = new ArrayList<>();
        while (lineScanner.hasNext()) {
            next = lineScanner.next();
            if (next.contains("strength")) {
                strengths.add(next.replace("strength: ", ""));
            } else {
                weaknesses.add(next.replace("weakness: ", ""));
            }
        }

        return new Equipment(name, category, id,
                bonus, strengths, weaknesses);
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getEquipmentId() {
        return equipmentId;
    }

    public int getBonus() {
        return bonus;
    }

    public List<String> getStrengths() {
        return strengths;
    }

    public List<String> getWeaknesses() {
        return weaknesses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipment equipment = (Equipment) o;
        return equipmentId == equipment.equipmentId && bonus == equipment.bonus && Objects.equals(name, equipment.name) && Objects.equals(category, equipment.category) && Objects.equals(strengths, equipment.strengths) && Objects.equals(weaknesses, equipment.weaknesses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, category, equipmentId, bonus, strengths, weaknesses);
    }
}
