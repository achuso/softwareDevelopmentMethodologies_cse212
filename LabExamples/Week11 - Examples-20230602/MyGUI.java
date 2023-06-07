import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class MyGUI extends JPanel {
	
    private JButton displayButton;
    private JButton clickButton;
    private JMenuBar menuBar;
    private JTextArea textArea;


    public MyGUI() {
    	
        //construct preComponents
        JMenu fileMenu = new JMenu ("File");
        
        JMenuItem exitItem = new JMenuItem ("Exit");
        fileMenu.add (exitItem);
        
        JMenu newMenu = new JMenu ("New");
        JMenuItem createItem = new JMenuItem ("Create object");
        newMenu.add (createItem);
        
        JMenu helpMenu = new JMenu ("Help");
        JMenuItem contentsItem = new JMenuItem ("Contents");
        helpMenu.add (contentsItem);
        JMenuItem aboutItem = new JMenuItem ("About");
        helpMenu.add (aboutItem);

        //construct components
        displayButton = new JButton ("Display Info");
        clickButton = new JButton ("Click");

        menuBar = new JMenuBar();
        menuBar.add (fileMenu);
        menuBar.add (newMenu);
        menuBar.add (helpMenu);
        textArea = new JTextArea (5, 5);
        
        
        //adjust size and set layout
        setPreferredSize (new Dimension (535, 396));
        setLayout (null);

        //add components
        add (displayButton);
        add (clickButton);
        add (menuBar);
        add (textArea);


        //set component bounds (only needed by Absolute Positioning)
        displayButton.setBounds (180, 35, 185, 20);
        clickButton.setBounds (180, 60, 185, 20);
        menuBar.setBounds (0, 0, 635, 25);
        textArea.setBounds (15, 90, 505, 295);
        
        //textArea.setAlignmentX(BOTTOM_ALIGNMENT);

        ArrayList<String> stringInputs = new ArrayList<String>();

        // New -> Create object
        createItem.addActionListener(new java.awt.event.ActionListener() {
            
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	String s = JOptionPane.showInputDialog("Enter a string: ", "Placeholder");
                
            	stringInputs.add(s);
            }
        });
        
        
		// Display Info Button
        displayButton.addActionListener(new java.awt.event.ActionListener() {

            String print = "";
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	
            	for (int i=0; i<stringInputs.size(); i++) {
            		print += stringInputs.get(i);
            		print += "\n";
            		
            	}
            	
                textArea.setText(print);
                print = ""; // clear the print string for non repeating
            }
        });
        
      
        
        // Click Button
        clickButton.addActionListener(new java.awt.event.ActionListener() {
        	
        	public void actionPerformed(java.awt.event.ActionEvent evt) {
                
        		JOptionPane.showMessageDialog(null, "Button clicked!", "PopUp Window", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        
        
        // File -> Exit
        exitItem.addActionListener(new java.awt.event.ActionListener() {
        	
        	public void actionPerformed(java.awt.event.ActionEvent evt) {
               System.exit(0);
            }
        });
        
        
        // Help -> Contents
        contentsItem.addActionListener(new java.awt.event.ActionListener() {
        	
        	public void actionPerformed(java.awt.event.ActionEvent evt) {
            	
            	JOptionPane.showMessageDialog(null, "Contents", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        // Help -> About
        aboutItem.addActionListener(new java.awt.event.ActionListener() {
        	
        	public void actionPerformed(java.awt.event.ActionEvent evt) {
            	
            	JOptionPane.showMessageDialog(null, "About", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        
        
        
    }

    public static void main(String[] args) {
    	
    	JFrame frame = new JFrame ("My GUI");
    	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new MyGUI());
		
		
		frame.setMaximumSize(new Dimension(1000, 600));
		frame.setMinimumSize(new Dimension(535, 500));
		
		// align window to center of the screen
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
    	
    }

}