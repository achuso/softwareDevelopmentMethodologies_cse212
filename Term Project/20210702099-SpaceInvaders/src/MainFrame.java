
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private JPanel startingPanel;
	private JPanel loadingPanel;
	private JPanel gamePanel;
	private JPanel loserPanel;
	private JPanel scoreboardPanel;

	MainFrame(JPanel startingPanel, JPanel loadingPanel, JPanel gamePanel, JPanel loserPanel, JPanel scoreboardPanel) {
		super("Space Invaders by Onat Ribar");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 800);
		this.setResizable(false);

		this.getContentPane().setBackground(new Color(0x000000));
		
		// Frame icon
		gameIcon = new ImageIcon("gameIcon.png");
		this.setIconImage(gameIcon.getImage());
		
		// Menubar
		menubar = new JMenuBar();
		this.add(menubar);
		this.setJMenuBar(menubar);
		
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
			
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		JMenuItem source = (JMenuItem) e.getSource();
		if( source == getFileMenu_register() ) {
			
		}
		else if( source == getFileMenu_playGame() ) {
			
		}
		else if( source == getFileMenu_highScore() ) {
			
		}
		else if( source == getFileMenu_quit() ) {
			System.exit(0);
		}
		else if( source == getHelpMenu_about() ) {
			
		}
		
	}
	
	
	// GETTERS FOR THE MENU ITEMS
	public JMenuItem getFileMenu_register()  { return fileMenu_register; }
	public JMenuItem getFileMenu_playGame()  { return fileMenu_playGame; }
	public JMenuItem getFileMenu_highScore() { return fileMenu_highScore; } 
	public JMenuItem getFileMenu_quit() 	 { return fileMenu_quit; }
	public JMenuItem getHelpMenu_about() 	 { return helpMenu_about; }
	
	// GETTERS FOR THE PANELS
	public JPanel getStartingPanel() 	{return this.startingPanel; }
	public JPanel getLoadingPanel() 	{ return this.loadingPanel; }
	public JPanel getGamePanel() 		{ return this.gamePanel; }
	public JPanel getLoserPanel() 		{ return this.loserPanel; }
	public JPanel scoreboardPanel() 	{ return this.scoreboardPanel; }

	
}


