import java.io.File;
import java.util.Scanner;

public class PlanningApplication {
    /**
     * The entry point of the application
     *
     * @param args The command line args
     */
    public static void main(String[] args) throws Exception {
        final JobCatalog jobCatalog = new JobCatalog();
        final Scanner userInput = new Scanner(System.in);
        int option = -1;

        System.out.println("Welcome to the Planning Application!\n");
        jobCatalog.read(new Scanner(new File("resources/joblist.txt")));

        while (option != 7) {
            System.out.println("""
                    Please select an option by typing it's number:
                       1 - Show all jobs in the catalog.
                       2 - Add a new job.
                       3 - Delete existing a job.
                       4 - Change date of existing job.
                       5 - Print jobs by date.
                       6 - Print required materials by date.
                       7 - Quit application.
                    """);

            option = new Scanner(userInput.nextLine()).nextInt();
            switch (option) {
                case 1 -> jobCatalog.showJobs();
                case 2 -> jobCatalog.addJob(userInput);
                case 3 -> jobCatalog.deleteJob(userInput);
                case 4 -> jobCatalog.changeDate(userInput);
                case 5 -> jobCatalog.printJobsByDate();
                case 6 -> jobCatalog.printMaterialsByDate();
                default -> System.out.println("Invalid option, please try again!");
            }
        }

        jobCatalog.write();
        System.out.println("Exiting Planning Application.");
    }
}
