import java.util.List;
import java.util.Scanner;

public class BugtrackerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BugTracker bugTracker = new BugTracker();

        while (true) {
            System.out.println("Bug Tracker:");
            System.out.println("1. Add Bug");
            System.out.println("2. View All Bugs");
            System.out.println("3. Update Bug Status");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (option) {
                case 1:
                    System.out.print("Enter bug description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter bug priority (Low, Medium, High): ");
                    String priority = scanner.nextLine();
                    bugTracker.addBug(description, priority);
                    System.out.println("Bug added successfully!");
                    break;

                case 2:
                    List<Bug> bugs = bugTracker.getBugs();
                    if (bugs.isEmpty()) {
                        System.out.println("No bugs to display.");
                    } else {
                        for (Bug bug : bugs) {
                            System.out.println(bug);
                            System.out.println("-----------------------------");
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter bug ID to update: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline
                    System.out.print("Enter new status (Open, In Progress, Closed): ");
                    String status = scanner.nextLine();
                    bugTracker.updateBugStatus(id, status);
                    System.out.println("Bug status updated successfully!");
                    break;

                case 4:
                    System.out.println("Exiting Bug Tracker...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }
}
