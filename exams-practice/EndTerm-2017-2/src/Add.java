import java.util.Scanner;
public class Add extends Audio{

    /**
     * The constructor for the add
     * @param name the name
     * @param time the time
     */
    public Add(String name, Time time) {
        super(name, time);
    }

    /**
     * reads an add from the scanner
     * @param input the scanner
     * @return the add
     */
    public static Add read(Scanner input) {
        input.useDelimiter(", ");
        String name = input.next();
//        System.out.println(input.next().replace("\n", ""));
        Time time = Time.read(new Scanner(input.next().replace("\n", "")));
        return new Add(name, time);
    }

    /**
     * Converts the add into a String, in the same format as the input
     * @return the string
     */
    public String toWrite() {
        return "ADD " + getName() + ", " + getTime();
    }


    /**
     * Converts the add into a human readable string
     * @return the string
     */
    @Override
    public String toString() {
        return "Next add: " + getName() + " (" + getTime() + ")";
    }
}
