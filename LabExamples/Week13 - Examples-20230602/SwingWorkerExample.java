import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingWorkerExample extends JFrame {
    private JButton startButton;
    private JTextArea textArea;

    public SwingWorkerExample() {
        setTitle("SwingWorker Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create components
        startButton = new JButton("Start");
        textArea = new JTextArea();
        textArea.setEditable(false);

        // Add components to the content pane
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(startButton, BorderLayout.NORTH);
        contentPane.add(new JScrollPane(textArea), BorderLayout.CENTER);

        // Add action listener to the start button
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startBackgroundTask();
            }
        });

        pack();
        setLocationRelativeTo(null); // Center the window on the screen
    }

    private void startBackgroundTask() {
        // Create and execute the SwingWorker
        SwingWorker<String, Integer> worker = new SwingWorker<String, Integer>() {
            @Override
            protected String doInBackground() throws Exception {
                // Perform the time-consuming task here
                for (int i = 1; i <= 10; i++) {
                    Thread.sleep(1000); // Simulate a long operation
                    publish(i); // Publish intermediate results
                }
                return "Task completed!";
            }

            @Override
            protected void process(java.util.List<Integer> chunks) {
                // Update the UI with intermediate results
            	
            	// chunks - intermediate results to process
                for (Integer chunk : chunks) {
                    textArea.append("Processing: " + chunk + "\n");
                }
            }

            @Override
            protected void done() {
                // Executed when the background task is finished
                try {
                    String result = get(); // Retrieve the task result
                    textArea.append(result + "\n");
                    startButton.setEnabled(true); // Enable the start button
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        // Disable the start button and execute the SwingWorker
        startButton.setEnabled(false);
        worker.execute();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SwingWorkerExample example = new SwingWorkerExample();
            example.setVisible(true);
        });
    }
}
