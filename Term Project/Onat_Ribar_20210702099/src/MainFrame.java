
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.InputMismatchException;

public class MainFrame extends JFrame implements ActionListener {

	// Frame-related
	ImageIcon gameIcon;
	
	// Menu bar
	private JMenuBar menubar;
		private JMenu fileMenu;
			private static JMenuItem fileMenu_register;
			private static JMenuItem fileMenu_playGame;
			private static JMenuItem fileMenu_highScore;
			private static JMenuItem fileMenu_quit;
		private JMenu helpMenu;
			private static JMenuItem helpMenu_about;

	// Panels
	private StartingPanel startingPanel;
	private JPanel loserPanel;
	private GamePanel gamePanel;


	// Sign in/up stuff
	LoginSystem loginMgr = new LoginSystem();

	MainFrame() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
		super("Space Invaders by Onat Ribar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(800, 800);
		setResizable(false);

		getContentPane().setBackground(new Color(0xF50606));
	    getContentPane().setLayout(new BorderLayout());
			
		// Frame icon
		gameIcon = new ImageIcon("icons/frameicon.png");
		setIconImage(gameIcon.getImage());
		
		// Menubar
		menubar = new JMenuBar();
		add(menubar);
		setJMenuBar(menubar);
		
			fileMenu = new JMenu("File");
			fileMenu_register = new JMenuItem("Register");
			fileMenu_playGame = new JMenuItem("Play Game");
			fileMenu_highScore = new JMenuItem("High Score");
			fileMenu_quit = new JMenuItem("Quit");
			fileMenu.add(fileMenu_register); fileMenu.add(fileMenu_playGame); fileMenu.add(fileMenu_highScore); fileMenu.add(fileMenu_quit);
			menubar.add(fileMenu);
			
			helpMenu = new JMenu("Help");
			helpMenu_about = new JMenuItem("About");
			helpMenu.add(helpMenu_about);
			menubar.add(helpMenu);
			
			fileMenu_register.addActionListener(this);
			fileMenu_playGame.addActionListener(this);
			fileMenu_highScore.addActionListener(this);
			fileMenu_quit.addActionListener(this);
			helpMenu_about.addActionListener(this);

		// Panels
		startingPanel = new StartingPanel();

		add(startingPanel);
		startingPanel.playSfxClip();
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		JMenuItem source = (JMenuItem) e.getSource();

		// Registration
		if( source == getFileMenu_register() ) {
			String registerUsername = JOptionPane.showInputDialog(this, "Enter username (at least 4 characters):", "Sign up", JOptionPane.QUESTION_MESSAGE);
			String registerPassword = JOptionPane.showInputDialog(this, "Enter password:", "Sign up", JOptionPane.QUESTION_MESSAGE);

			if( loginMgr.addUser(registerUsername, registerPassword))
				JOptionPane.showMessageDialog(this, String.format("Successfully registered for %s!", registerUsername), "Registration Successful", JOptionPane.INFORMATION_MESSAGE);
			else if (loginMgr.userExists(registerUsername))
				JOptionPane.showMessageDialog(this, String.format("Registration failed, user %s already exists!", registerUsername), "Registration Failed", JOptionPane.ERROR_MESSAGE);
			else {
				JOptionPane.showMessageDialog(this, String.format("Registration failed. Please make sure that your username is at least 4 characters long.", registerUsername), "Registration Failed", JOptionPane.ERROR_MESSAGE);
			}
		}

		// Launch game
		else if( source == getFileMenu_playGame() ) {
			int difficulty_int = 0;
			try {
				String difficulty_str = JOptionPane.showInputDialog(this, "Please enter difficulty:\n 1 for Novice, 2 for Intermediate, 3 for Advanced", "Choose Difficulty");
				difficulty_int = Integer.parseInt(difficulty_str);
				if(difficulty_int > 0 && difficulty_int < 4) {
						startingPanel.setVisible(false);
						startingPanel.stopSfxClip();
						// in case someone restarted
						if(gamePanel != null) {
							gamePanel.stopBGSfx();
							this.remove(gamePanel);
						}
						gamePanel = new GamePanel(difficulty_int);
						add(gamePanel);
						gamePanel.playSfxClip();
				}
				else JOptionPane.showMessageDialog(this, "Invalid input, please try again.");
			}
			catch(InputMismatchException | NumberFormatException | UnsupportedAudioFileException |
				  LineUnavailableException | IOException e1) {
				JOptionPane.showMessageDialog(this, "Invalid input, please try again..");
			}
		}

		else if( source == getFileMenu_highScore() ) {
			if(gamePanel != null) gamePanel.setVisible(false);
			startingPanel.setVisible(false);
			LoginPanel loginPanel = new LoginPanel(loginMgr);
			loginPanel.setVisible(false);
		}

		else if( source == getFileMenu_quit() ) {
			System.exit(0);
		}

		else if( source == getHelpMenu_about() ) {
			JOptionPane.showMessageDialog(this, "Name: Onat Ribar\nStudent ID: 20210702099\nE-mail: onat.ribar@std.yeditepe.edu.tr");
		}
		
	}
	
	
	// GETTERS FOR THE MENU ITEMS
	public JMenuItem getFileMenu_register()  { return fileMenu_register; }
	public JMenuItem getFileMenu_playGame()  { return fileMenu_playGame; }
	public JMenuItem getFileMenu_highScore() { return fileMenu_highScore; } 
	public JMenuItem getFileMenu_quit() 	 { return fileMenu_quit; }
	public JMenuItem getHelpMenu_about() 	 { return helpMenu_about; }
	
	// GETTERS FOR THE PANELS
	public StartingPanel getStartingPanel() 	{return this.startingPanel; }
	public GamePanel getGamePanel() 			{ return this.gamePanel; }
	public JPanel getLoserPanel() 				{ return this.loserPanel; }

	
}


