import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Spaceship extends JPanel {

    private int height;
    private int width;
    private int hitPoints;
    private int posX;
    private int posY;
    private int bulletCooldown = 0;
    private BufferedImage primaryImage;
    private BufferedImage secondaryImage;
    private BufferedImage currentImage;
    private boolean isDestroyed = false;


    Spaceship () throws IOException {
        this.primaryImage = ImageIO.read(new File("icons/Models/spaceship1.png"));
        this.secondaryImage = ImageIO.read(new File("icons/Models/spaceship2.png"));

        this.currentImage = primaryImage;
        this.posX = 360;
        this.posY = 600;
        this.height = 80;
        this.width = 80;
        this.hitPoints = 3;
    }
    
    public void horizontalDisplacement(int x) { this.posX += x; }
    public void verticalDisplacement(int y) { this.posY += y; }

    public int getHeight() {return this.height;}
    public int getWidth() {return this.width;}
    public int getHitPoints() {return this.hitPoints;}
    public int getBulletCooldown() {return this.bulletCooldown;}
    public void decrementBulletCooldown() {if(bulletCooldown > 0) bulletCooldown--;}
    public void resetBulletCooldown() {bulletCooldown = 30;}

    public boolean isDestroyed() {
        return isDestroyed;
    }

    public void setDestroyed(boolean destroyed) {
        isDestroyed = destroyed;
    }

    public int getPosX() { return this.posX; }
    public int getPosY() { return this.posY; }

    public BufferedImage getPrimaryImage() { return this.primaryImage; }
    public BufferedImage getSecondaryImage() { return this.secondaryImage; }
    public void setCurrentImage(BufferedImage img) throws IOException {
        this.currentImage = img;
    }

}
