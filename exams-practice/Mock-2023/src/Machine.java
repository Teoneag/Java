import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Machine {
    private final List<Ball> balls;
    private boolean hasLegendary;
    private final List<String> logs;

    /**
     * Constructor for the Machine:
     * initializes hasLegendary to true,
     * and the other parameters to empty Lists
     */
    public Machine() {
        hasLegendary = true;
        balls = new ArrayList<>();
        logs = new ArrayList<>();
    }

    /**
     * Read from file into Machine
     */
    public void read() {
        Scanner input;
        try {
            input = new Scanner(new File("resources/gacha.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Error reading");
            return;
        }

        while (input.hasNext()) {
            input.reset();
            String type = input.next();

            input.useDelimiter("[\\[\\]]");
            input.next();
            int nr = Integer.parseInt(input.next());
            input.nextLine(); // skip /n

            String colour = input.nextLine();

            String description = input.nextLine();

            if (type.equals("EMPTY")) {
                EmptyBall.add(balls, nr, new EmptyBall(colour, description));
                continue;
            }

            // not empty
            input.useDelimiter("[{}]");
            Scanner lineScanner = new Scanner(input.next());
            lineScanner.useDelimiter(", ");
            List<String> prizes = new ArrayList<>();
            input.nextLine();
            while (lineScanner.hasNext()) {
                prizes.add(lineScanner.next());
            }
            for (int i = 0; i < nr; i++) {
                balls.add(new FullBall(colour, description, type, prizes.get((int) (Math.random() * prizes.size()))));
            }
        }
    }

    /**
     * Prints all the balls
     * as requested in option 1
     */
    public void printAllBalls() {
        for (Ball ball : balls) {
            System.out.println(ball);
        }
    }

    /**
     * Shows the chance to get a legendary,
     * as requested in option 2
     */
    public void showChance() {
        if (!hasLegendary) {
            System.out.println("Sorry, the legendary has already been drawn, good luck next time!");
            return;
        }

        int p = (int) (1.0 / balls.size() * 100.0);
        System.out.println("The chance you get a legendary is: " + p + "%");
    }

    /**
     * Draws a ball, as requested in option 3
     */
    public void drawBall() {
        int index = (int) (Math.random() * balls.size());
        Ball ball = balls.get(index);

        System.out.println(ball.printDraw());
        logs.add(ball.toLog());
        balls.remove(index);

        if (ball instanceof FullBall fullBall) {
            if (fullBall.getType().equals("LEGENDARY")) {
                hasLegendary = false;
            }
        }
    }

    /**
     * Writes the log of all the draws into the file,
     * as requested in option 4
     */
    public void write() {
        try {
            Writer writer = new BufferedWriter(
                    new FileWriter("resources/logs.txt"));
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < logs.size(); i++) {
                s.append(i + 1).append(". ").append(logs.get(i)).append("\n");
            }
            writer.write(s.toString());
            writer.close();
        } catch (Exception e) {
            System.out.println("Error writing.");
        }

    }

    /**
     * Checks if a machine is equal to an object
     * @param o The object to compare with
     * @return Whether they are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Machine machine)) return false;
        return hasLegendary == machine.hasLegendary
                && Objects.equals(balls, machine.balls) && Objects.equals(logs, machine.logs);
    }

    /**
     * Creates the hash Code from the Machine
     * @return the hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(balls, hasLegendary, logs);
    }
}
