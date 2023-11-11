import java.util.Objects;
import java.util.Scanner;

public class ProteinShake extends Product{
    private String flavour;
    private int weight;

    public ProteinShake(String brand, int price, String flavour, int weight) {
        super(brand, price);
        this.flavour = flavour;
        this.weight = weight;
    }

    public String toWrite() {
        String s = "ProteinShake ";
        s += getBrand() + "; ";
        s += getFlavour() + "; ";
        s += getWeight() + " grams; ";
        s += getPrice() + " euros";

        return s;
    }

    public static ProteinShake add(Scanner input) {
        System.out.println("Please enter the info about the protein shake, in the following format: ");
        System.out.println("QNT; Vanilla; 600 grams; 20 euros");
        ProteinShake proteinShake = null;
        while (proteinShake == null) {
            try {
                proteinShake = read(input);
                input.nextLine();
                System.out.println("You have entered this protein shake: ");
                System.out.println(proteinShake + "\n");
            } catch (Exception e) {
                System.out.println("Wrong format, please try again!");
            }
        }
        return proteinShake;
    }

    public static ProteinShake read(Scanner input) {
        input.useDelimiter("; ");
        String brand = input.next();
        String flavour = input.next();
        input.useDelimiter(" ");
        input.next(); // skip ;
        int weight = input.nextInt();
        input.next(); // skip grams;
        int price = input.nextInt();

        return new ProteinShake(brand, price, flavour, weight);
    }

    public String getFlavour() {
        return flavour;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProteinShake that)) return false;
        if (!super.equals(o)) return false;
        return getWeight() == that.getWeight() && Objects.equals(getFlavour(), that.getFlavour());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getFlavour(), getWeight());
    }

    @Override
    public String toString() {
        return "Protein Shake: " + getBrand() + "\n"
                + "   Flavour: " + flavour + "\n"
                + "   Size: " + weight + "\n"
                + "   Price: " + getPrice();
    }
}
