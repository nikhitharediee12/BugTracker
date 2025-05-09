import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BugOperations {

    public static void addBug(String description, String priority, String status) {
        String query = "INSERT INTO project_issue (description, priority, status) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, description);
            stmt.setString(2, priority);
            stmt.setString(3, status);
            stmt.executeUpdate();
            System.out.println("Bug added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Bug> getAllBugs() {
        List<Bug> bugs = new ArrayList<>();
        String query = "SELECT * FROM project_issue";  // Correct table name
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                bugs.add(new Bug(rs.getInt("id"), rs.getString("description"),
                        rs.getString("status"), rs.getString("priority")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bugs;
    }

    public static void updateBugStatus(int id, String status) {
        String query = "UPDATE project_issue SET status = ? WHERE id = ?";  // Correct table name
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, status);
            stmt.setInt(2, id);
            stmt.executeUpdate();
            System.out.println("Bug status updated successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
