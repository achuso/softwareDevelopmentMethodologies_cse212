/***************************
 * NAME: Onat Ribar
 * STUDENT NR: 20210702099
 * CSE 212 Assignment-10
 ***************************/

import javax.swing.JFrame;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JTextArea;

public class MainFrame extends JFrame{
	
	private JPanel buttons1stRow;
	private JPanel buttons2ndRow;
	private JPanel textLabel;
	
	private JMenu menu;
	private JMenuBar menubar;	
	
	private JMenu fileMenu;
	private JMenuItem exitOption;
	
	private JMenu newMenu;
	private JMenuItem newReservation;
	private JMenuItem newServices;
	
	private JMenu helpMenu;
	private JMenuItem contents;
	private JMenuItem about;
	
	private JButton displayReservations;
	private JButton displayServices;
	private JButton displayResForCity;
	private JTextArea terminal;
	
	MainFrame() {
		super("Hotel Reservation System");

		// Menu bar
		menubar = new JMenuBar();	
		add(menubar);
		
		// Menu options
		fileMenu = new JMenu("File");
		newMenu = new JMenu("New");
		helpMenu = new JMenu("Help");
		
		// Menu sub options
		// for File:
		exitOption = new JMenuItem("Exit");
		// for New:
		newReservation = new JMenuItem("Reservation");
		newServices = new JMenuItem("Services");
		// for Help:
		contents = new JMenuItem("Contents");
		about = new JMenuItem("About");
		
		// Set menu
		fileMenu.add(exitOption);
		newMenu.add(newReservation); newMenu.add(newServices);
		helpMenu.add(contents); helpMenu.add(about);
		menubar.add(fileMenu); menubar.add(newMenu); menubar.add(helpMenu);
		this.setJMenuBar(menubar);
		
		// Initialize panels
		buttons1stRow = new JPanel();
		buttons2ndRow = new JPanel();
		textLabel = new JPanel();
		
		// Panel tweaks
		buttons1stRow.setVisible(true);
		buttons2ndRow.setVisible(true);
		textLabel.setVisible(true);	
		buttons1stRow.setBackground(new Color(0xececec));
		buttons2ndRow.setBackground(new Color(0xececec));
		
		// Buttons
		displayReservations = new JButton("Display Reservations");
		displayServices = new JButton("Display Extra Services");
		displayResForCity = new JButton("Disp. Res. For City");
		
		buttons1stRow.add(displayReservations);
		buttons1stRow.add(displayServices);
		buttons2ndRow.add(displayResForCity);
		this.add(buttons1stRow);
		this.add(buttons2ndRow);
		
		// Text Area
		terminal = new JTextArea();
		terminal.setLineWrap(true);
		terminal.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		terminal.setVisible(true);
		terminal.setEditable(false);
		terminal.setPreferredSize(new Dimension(550,275));
		this.add(terminal, BorderLayout.SOUTH);
		
		// Frame tweaks
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(new FlowLayout());
		this.setSize(600, 400);
		this.setResizable(false);
		this.setVisible(true);
		this.getContentPane().setBackground(new Color(0xececec));
	}
	
	public void setTerminalText(String output) {
		terminal.setText(output);
	}
	
	// Getters for the GUI components
	
	public JMenu getMenu() 					{ return this.menu; }
	public JButton getDisplayReservations() { return this.displayReservations; }
	public JButton getDisplayServices() 	{ return this.displayServices; }
	public JButton getDisplayResForCity() 	{ return this.displayResForCity; }
	public JTextArea getTerminal() 			{ return this.terminal; }
	
	
	public JMenuItem getExitOption() 		{ return this.exitOption; }
	public JMenuItem getReservationMenu()   { return this.newReservation; }
	public JMenuItem getServicesMenu()   	{ return this.newServices; }
	
	public JMenuItem getContentsMenu()  	{ return this.contents; }
	public JMenuItem getAboutMenu()   		{ return this.about; }

}
