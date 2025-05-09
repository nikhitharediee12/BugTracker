import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class BugTrackerGUI {
    private JFrame frame;
    private BugTracker bugTracker;
    private JTextArea textArea;
    private JTextField descriptionField, priorityField, statusField;

    public BugTrackerGUI() {
        bugTracker = new BugTracker();
        frame = new JFrame("Bug Tracker");
        frame.setLayout(new BorderLayout());

        textArea = new JTextArea(15, 30);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        panel.add(new JLabel("Description:"));
        descriptionField = new JTextField();
        panel.add(descriptionField);

        panel.add(new JLabel("Priority:"));
        priorityField = new JTextField();
        panel.add(priorityField);

        panel.add(new JLabel("Status:"));
        statusField = new JTextField();
        panel.add(statusField);

        JButton addButton = new JButton("Add Bug");
        panel.add(addButton);

        JButton viewButton = new JButton("View All Bugs");
        frame.add(viewButton, BorderLayout.SOUTH);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String description = descriptionField.getText();
                String priority = priorityField.getText();
                bugTracker.addBug(description, priority);
                descriptionField.setText("");
                priorityField.setText("");
                textArea.setText("Bug added successfully!");
            }
        });

        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Bug> bugs = bugTracker.getBugs();
                StringBuilder displayText = new StringBuilder();
                for (Bug bug : bugs) {
                    displayText.append(bug).append("\n-----------------------------\n");
                }
                textArea.setText(displayText.toString());
            }
        });

        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new BugTrackerGUI();
    }
}
