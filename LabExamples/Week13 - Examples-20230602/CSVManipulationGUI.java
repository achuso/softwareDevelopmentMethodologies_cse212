import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class CSVManipulationGUI extends JFrame {
    private JTextField nameTextField;
    private JTextField pointsTextField;
    private JTextArea outputTextArea;

    private static final String CSV_FILE_PATH = "data.csv";

    public CSVManipulationGUI() {
        setTitle("CSV Manipulation");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 300));

        // Create components
        JLabel nameLabel = new JLabel("Name:");
        nameTextField = new JTextField(20);
        JLabel pointsLabel = new JLabel("Points:");
        pointsTextField = new JTextField(20);
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveDataToCSV();
            }
        });

        outputTextArea = new JTextArea();
        outputTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputTextArea);

        // Create the main panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Create the input panel
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 0, 5, 10);
        inputPanel.add(nameLabel, gbc);

        gbc.gridx = 1;
        inputPanel.add(nameTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        inputPanel.add(pointsLabel, gbc);

        gbc.gridx = 1;
        inputPanel.add(pointsTextField, gbc);

        // Create the button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(saveButton);

        // Add the input panel and button panel to the main panel
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        mainPanel.add(scrollPane, BorderLayout.SOUTH);

        // Add the main panel to the content pane
        Container contentPane = getContentPane();
        contentPane.add(mainPanel);

        pack();
        setLocationRelativeTo(null); // Center the window on the screen
    }

    private void saveDataToCSV() {
        String name = nameTextField.getText();
        //ece
        String points = pointsTextField.getText();
        //80

        try {
            FileWriter writer = new FileWriter(CSV_FILE_PATH, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            bufferedWriter.write(name + "," + points);
            bufferedWriter.newLine();

            bufferedWriter.close();

            // Clear the input fields
            nameTextField.setText("");
            pointsTextField.setText("");

            readDataFromCSV(); // Update the output
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readDataFromCSV() {
        try {
            FileReader reader = new FileReader(CSV_FILE_PATH);
            BufferedReader bufferedReader = new BufferedReader(reader);

            outputTextArea.setText(""); // Clear the previous output

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length == 2) {
                    String name = fields[0];
                    String points = fields[1];
                    outputTextArea.append("Name: " + name + ", Points: " + points + "\n");
                }
            }

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    	
        SwingUtilities.invokeLater(() -> {
            CSVManipulationGUI gui = new CSVManipulationGUI();
            gui.setVisible(true);
        });
    }
}
