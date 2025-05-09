public class Bug {
    private int id;
    private String description;
    private String status;
    private String priority;

    public Bug(int id, String description, String status, String priority) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "Bug ID: " + id + "\nDescription: " + description + "\nStatus: " + status + "\nPriority: " + priority;
    }
}
