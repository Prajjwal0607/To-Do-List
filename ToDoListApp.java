import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ToDoListApp extends JFrame {

    private DefaultListModel<String> taskModel;
    private JList<String> taskList;
    private JTextField taskInput;
    private JButton addButton, deleteButton;

    public ToDoListApp() {
        setTitle("To-Do List");
        setSize(400, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center window

        // Initialize components
        taskModel = new DefaultListModel<>();
        taskList = new JList<>(taskModel);
        taskInput = new JTextField();
        addButton = new JButton("Add Task");
        deleteButton = new JButton("Delete Selected");

        // Layout setup
        setLayout(new BorderLayout());

        // Top panel with text field and add button
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        topPanel.add(taskInput, BorderLayout.CENTER);
        topPanel.add(addButton, BorderLayout.EAST);

        // Bottom panel with delete button
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.add(deleteButton);

        // Add components to main window
        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(taskList), BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        // Add Button Listener
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String task = taskInput.getText().trim();
                if (!task.isEmpty()) {
                    taskModel.addElement(task);
                    taskInput.setText("");
                }
            }
        });

        // Delete Button Listener
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = taskList.getSelectedIndex();
                if (selectedIndex != -1) {
                    taskModel.remove(selectedIndex);
                }
            }
        });
    }

    public static void main(String[] args) {
        // Launch the app
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ToDoListApp().setVisible(true);
            }
        });
    }
}
