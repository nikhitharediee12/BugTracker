import java.util.List;
import java.util.Scanner;

public class BugTrackerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Bug Tracker:");
            System.out.println("1. Add Bug");
            System.out.println("2. View All Bugs");
            System.out.println("3. Update Bug Status");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter bug description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter bug priority (Low, Medium, High): ");
                    String priority = scanner.nextLine();
                    BugOperations.addBug(description, priority, "Open");
                    System.out.println("Bug added successfully!");
                    break;
                case 2:
                    List<Bug> bugs = BugOperations.getAllBugs();
                    if (bugs.isEmpty()) {
                        System.out.println("No bugs found.");
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
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter new status (Open, In Progress, Closed): ");
                    String status = scanner.nextLine();
                    BugOperations.updateBugStatus(id, status);
                    System.out.println("Bug status updated successfully!");
                    break;
                case 4:
                    System.out.println("Exiting Bug Tracker...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option, try again.");
            }
        }
    }
}
