

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;


public class StartingPanel extends JPanel {

	private BufferedImage bg_login;
	private Clip sfxClip;
	
	StartingPanel() {
		try {
			bg_login = ImageIO.read(new File("icons/Scenes/startscreen.png"));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (bg_login != null) {
			g.drawImage(bg_login, 0, 0, this);
		}
	}

	public Clip getSfxClip() {
		return sfxClip;
	}

	public void playSfxClip() throws LineUnavailableException, UnsupportedAudioFileException, IOException {
		File sfxFile = new File("sfx/intromusic.wav");
		AudioInputStream sfxAudio = AudioSystem.getAudioInputStream(sfxFile);
		sfxClip = AudioSystem.getClip();
		sfxClip.open(sfxAudio);
		sfxClip.start();
		sfxClip.loop(Clip.LOOP_CONTINUOUSLY);
	}

	public void stopSfxClip() {
		sfxClip.stop();
	}
}

