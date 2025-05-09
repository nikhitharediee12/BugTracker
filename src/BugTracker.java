import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BugTracker {
    private List<Bug> bugs;
    private int nextId;
    private final String FILE_NAME = "bugs.txt"; // File to save bugs

    // Constructor to initialize the bug tracker
    public BugTracker() {
        bugs = new ArrayList<>();
        nextId = 1;
        loadBugs();  // Load bugs when the program starts
    }

    // Add a new bug
    public Bug addBug(String description, String priority) {
        Bug bug = new Bug(nextId++, description, "Open", priority);
        bugs.add(bug);
        saveBugs();  // Save bugs after adding a new one
        return bug;
    }

    // Get all bugs
    public List<Bug> getBugs() {
        return bugs;
    }

    // Update a bug's status
    public void updateBugStatus(int id, String status) {
        for (Bug bug : bugs) {
            if (bug.getId() == id) {
                bug.setStatus(status);
                break;
            }
        }
        saveBugs();  // Save bugs after updating
    }

    // Save bugs to a file
    private void saveBugs() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Bug bug : bugs) {
                writer.write(bug.getId() + ";" + bug.getDescription() + ";" + bug.getStatus() + ";" + bug.getPriority());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving bugs: " + e.getMessage());
        }
    }

    // Load bugs from a file
    private void loadBugs() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                int id = Integer.parseInt(parts[0]);
                String description = parts[1];
                String status = parts[2];
                String priority = parts[3];
                Bug bug = new Bug(id, description, status, priority);
                bugs.add(bug);
                nextId = Math.max(nextId, id + 1);
            }
        } catch (IOException e) {
            // File not found is acceptable (no bugs saved yet)
        }
    }

    // Sort bugs by priority (Low < Medium < High)
    public void sortBugsByPriority() {
        Collections.sort(bugs, new Comparator<Bug>() {
            @Override
            public int compare(Bug bug1, Bug bug2) {
                String priority1 = bug1.getPriority();
                String priority2 = bug2.getPriority();

                if (priority1.equals(priority2)) {
                    return 0;
                } else if (priority1.equals("Low")) {
                    return -1;
                } else if (priority2.equals("Low")) {
                    return 1;
                } else if (priority1.equals("Medium")) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
    }
}
