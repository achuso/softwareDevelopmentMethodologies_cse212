import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Bullet extends JPanel {
    private int height;
    private int width;
    private int posX;
    private int posY;
    private int velocity;

    public Bullet(int height, int width, int posX, int posY, int velocity) {
        this.height = height;
        this.width = width;
        this.posX = posX;
        this.posY = posY;
        this.velocity = velocity;
    }

    public void playSfxClip() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File sfxFile = new File("sfx/blastersfx.wav"); // COLLECTED FROM ROYALTY-FREE WEBSITE https://pixabay.com/sound-effects/zap-c-07-82067/
        AudioInputStream sfxAudio = AudioSystem.getAudioInputStream(sfxFile);
        Clip sfxClip = AudioSystem.getClip();
        sfxClip.open(sfxAudio);
        sfxClip.start();
    }

    @Override
    public String toString() {
        return String.format("%d %d %d %d %d", height, width, posX, posY, velocity);
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public int getVelocity() {
        return velocity;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
}
