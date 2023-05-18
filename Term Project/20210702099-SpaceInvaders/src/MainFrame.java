import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MainFrame extends JFrame {

	
	
	MainFrame() {
		
		super("Space Invaders by Onat Ribar");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 800);
		this.setResizable(false);
		
		this.getContentPane().setBackground(new Color(0xFFFFFF));
		
		ImageIcon gameIcon = new ImageIcon("gameIcon.png");
		this.setIconImage(gameIcon.getImage());
		
		
		this.setVisible(true);
	}

}
