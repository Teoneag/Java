import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Stream;

public class JobCatalog {
    private final List<Job> jobs;

    /**
     * The constructor: initializes the jobs with an empty list
     */
    public JobCatalog() {
        this.jobs = new ArrayList<>();
    }

    public void read(Scanner input) {
        while (input.hasNextLine()) {
            Address location = Address.read(new Scanner(input.nextLine()));

            String description = input.nextLine();


            List<Equipment> equipment = null;
            try {
                equipment = Equipment.read(new Scanner(input.nextLine()));
            } catch (Exception e) {
                System.out.println("Error reading file " + e);
            }

            Date date = Date.read(new Scanner(input.nextLine()));

            jobs.add(new Job(location, description, equipment, date));
        }
    }

    public void showJobs() {
        System.out.println(toPrint());
    }

    public void addJob(Scanner userInput) {
        System.out.println("You are now adding a new job!");
        System.out.println("Enter all the required values, then press enter.");

        Address location = null;
        while (location == null) {
            try {
                System.out.println("Please enter the address, using this format:");
                System.out.println("Street name; street number; zip code; city name");
                location = Address.read(new Scanner(userInput.nextLine()));
            } catch (Exception e) {
                System.out.println("Invalid address format. Please try again.");
            }
        }

        String description = null;
        while (description == null) {
            try {
                System.out.println("Please enter the description.");
                description = userInput.nextLine();
            } catch (Exception e) {
                System.out.println("Invalid description format. Please try again.");
            }
        }

        List<Equipment> equipment = null;
        while (equipment == null) {
            try {
                System.out.println("Please enter the equipment, using this format:");
                System.out.println("JackHammer, A hardened chisel for reinforced floors; " + "ConcreteMixer, None;");
                equipment = Equipment.read(new Scanner(userInput.nextLine()));
            } catch (Exception e) {
                System.out.println("Invalid equipment format. Please try again.");
            }
        }

        Date date = null;
        while (date == null) {
            try {
                System.out.println("Please enter the date, using this format:");
                System.out.println("23-10-2021");
                date = Date.read(new Scanner(userInput.nextLine()));
            } catch (Exception e) {
                System.out.println("Invalid date format. Please try again.");
            }
        }

        jobs.add(new Job(location, description, equipment, date));
    }

    public void deleteJob(Scanner userInput) {
        System.out.println("Which job would you like to delete from the printed list? ");

        Job job = readJobNumber(userInput);

        System.out.println("Are you sure you wanna delete this job? (yes/no)\n" + job);
        String answer = areYouSure(userInput);

        if ("no".equals(answer)) {
            System.out.println("Would you like to delete other job? (yes/no)");
            answer = userInput.nextLine();

            while (!answer.equals("yes") && !answer.equals("no")) {
                System.out.println("Not a valid option, please try again!");
                answer = userInput.nextLine();
            }

            if (answer.equals("yes")) deleteJob(userInput);
            return;
        }

        // answer == yes
        jobs.remove(job);
        System.out.println("Job removed successfully!");
    }

    public void changeDate(Scanner userInput) {
        System.out.println("Which job's date would you like to change?");

        Job job = readJobNumber(userInput);

        System.out.println("Are you sure you wanna delete this job? (yes/no)\n" + job);
        String answer = areYouSure(userInput);

        if ("no".equals(answer)) {
            System.out.println("Would you like to change the date of other job? (yes/no)");
            answer = userInput.nextLine();

            while (!answer.equals("yes") && !answer.equals("no")) {
                System.out.println("Not a valid option, please try again!");
                answer = userInput.nextLine();
            }

            if (answer.equals("yes")) changeDate(userInput);
            return;
        }

        Date date = null;
        while (date == null) {
            try {
                System.out.println("Please enter the desired date in this format: 23-10-2021");
                date = Date.read(new Scanner(userInput.nextLine()));
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again!");
            }
        }

        // answer == yes
        jobs.remove(job);
        jobs.add(new Job(job.getLocation(), job.getDescription(), job.getRequireEquipment(), date));
        System.out.println("Job date changed successfully!");
    }

    public void printJobsByDate() {
        jobs.stream()
                .sorted((o1, o2) -> o1.getPlannedDate().compareTo(o2.getPlannedDate()))
                .map(job -> job.toString() + "\n")
                .forEach(System.out::println);
    }

    public void printMaterialsByDate() {
        jobs.stream()
                .flatMap(job -> job.getRequireEquipment().stream()
                        .flatMap(e -> Stream.of(
                                e.getClass().getSimpleName(),
                                (e instanceof PowerSupply p) ? p.getPowerSupply() : e
                        ))
                )
                .distinct()
                .forEach(System.out::println);
    }

    public void write() {
        System.out.println("Saving the job catalogue...");

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("resources/joblist.txt"));
            bufferedWriter.write(this.toString());
            bufferedWriter.close();
            System.out.println("Save successful!");

        } catch (Exception e) {
            System.out.println("Could not write to files");
        }
    }

    private String areYouSure(Scanner userInput) {
        String answer = userInput.nextLine();
        while (!answer.equals("yes") && !answer.equals("no")) {
            System.out.println("Not a valid option, please try again!");
            answer = userInput.nextLine();
        }
        return answer;
    }

    private Job readJobNumber(Scanner userInput) {
        System.out.println(toPrint());
        System.out.println("Please enter the job number and then press enter.");

        int input = Integer.parseInt(userInput.nextLine());
        while (input < 1 || input > jobs.size()) {
            try {
                System.out.println("Not a valid option, please try again!");
                input = Integer.parseInt(userInput.nextLine());
            } catch (Exception e) {
                System.out.print("Invalid input!");
            }
        }
        return jobs.get(input - 1);
    }

    /**
     * Converts the JobCatalog to a string
     *
     * @return The string
     */
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (Job job : jobs) {
            res.append(job.toString());
        }
        return res.toString();
    }

    public String toPrint() {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < jobs.size(); i++) {
            res.append(i + 1).append("\n").append(jobs.get(i).toString()).append("\n");
        }
        return res.toString();
    }

    /**
     * The equals method
     *
     * @param o the object to compare with
     * @return whether they are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JobCatalog that)) return false;
        return Objects.equals(jobs, that.jobs);
    }

    /**
     * The hashcode method
     *
     * @return the hashcode
     */
    @Override
    public int hashCode() {
        return Objects.hash(jobs);
    }
}
