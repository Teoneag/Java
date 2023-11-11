import java.util.Scanner;

public class Add extends Audio{
    /**
     * Constructor
     * @param name name
     * @param time time
     */
    public Add(String name, Time time) {
        super(name, time);
    }

    /**
     * Reads from scanner an Add
     * @param input the scanner
     * @return the add
     */
    public static Add read(Scanner input) {
        input.useDelimiter(", |\\R");
        String name = input.next();
        Time time = Time.read(new Scanner(input.next()));
        return new Add(name, time);
    }

    /**
     * Converts the add to a human-readable string
     * @return the string
     */
    @Override
    public String toString() {
        return "Next add: " + super.toString();
    }

    /**
     * Converts the add to a string, in the same format as the input file
     * @return the string
     */
    public String toWrite() {
        return "ADD " + super.toWrite();
    }
}
