import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Equipment {
    protected String requirements;


    /**
     * Constructor
     *
     * @param requirements a textual description that indicates any special requirements the
     *                     piece of equipment should meet for this particular job
     */
    public Equipment(String requirements) {
        this.requirements = requirements;
    }

    /**
     * Read the input into a list of equipment
     * @param input Scanner in the following format
     * JackHammer, A hardened chisel for reinforced floors; ConcreteMixer, None;
     * @return The list of equipment
     * @throws Exception If there is any errors in reading
     */
    public static List<Equipment> read(Scanner input) throws Exception {
        input.useDelimiter("; |;");
        List<Equipment> equipList = new ArrayList<>();
        while (input.hasNext()) {
            Scanner scanner = new Scanner(input.next());
            scanner.useDelimiter(", ");
            String name = scanner.next();
            String requirements = scanner.next();
            switch (name) {
                case "ConcreteMixer" -> equipList.add(new ConcreteMixer(requirements));
                case "JackHammer" -> equipList.add(new JackHammer(requirements));
                case "Scaffolding" -> equipList.add(new ScaffoldingTower(requirements));
                case "Torch" -> equipList.add(new Torch(requirements));
                default -> throw new Exception();
            }
        }
        return equipList;
    }

    /**
     * Getter for the requirements
     * @return the requirements
     */
    public String getRequirements() {
        return requirements;
    }

    /**
     * Equals
     *
     * @param o the object to compare with
     * @return if they are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Equipment that)) return false;
        return this.requirements.equals(that.requirements);
    }
}
