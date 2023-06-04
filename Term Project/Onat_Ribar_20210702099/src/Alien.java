import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Alien extends JPanel {

    private int height;
    private int width;
    private int hitPoints;
    private int posX;
    private int posY;
    private BufferedImage primaryImage;
    private BufferedImage secondaryImage;
    private BufferedImage currentImage;
    private int velocityModifier;
    private int velocity;
    private boolean destroyed = false;
    private int destroyedTurns = 10;
    private int moveInTurns;

    // I know it would be much more convenient to implement an abstract class, but I had some trouble and had already finished the Alien/Spaceship crafts by the time they were finished
    Alien(int velocity, int moveInTurns) throws IOException {
        this.primaryImage = ImageIO.read(new File("icons/Models/alien1of1.png"));
        //this.secondaryImage = ImageIO.read(new File("icons/Models/spaceship2.png"));

        this.currentImage = primaryImage;
        this.posX = 360;
        this.posY = -0;
        this.height = 80;
        this.width = 80;
        this.hitPoints = 3;
        this.velocity = velocity;
        this.velocityModifier = 1; // Ensures that aliens don't go out of bounds
        this.moveInTurns = moveInTurns;
    }

    public void moveAlien(int speed){
        horizontalDisplacement(speed);
        verticalDisplacement(speed);
    }

    private void horizontalDisplacement(int speed) {
        if (posX + speed * velocityModifier >= 680 || posX + speed * velocityModifier <= 20)
            velocityModifier *= -1;
        this.posX += speed * velocityModifier;
        repaint();
    }
    private void verticalDisplacement(int y) { this.posY += y; repaint(); }

    public int getHeight() {return this.height;}
    public int getWidth() {return this.width;}
    public int getHitPoints() {return this.hitPoints;}
    public boolean isDestroyed() {return destroyed;}

    public int getDestroyedTurns() {
        return destroyedTurns;
    }

    public int getMoveInTurns() {
        return moveInTurns;
    }

    public void setMoveInTurns(int moveInTurns) {
        this.moveInTurns = moveInTurns;
    }

    public void decrementMoveInTurns() {
        if (moveInTurns > 0)
            moveInTurns--;
    }

    public int getPosX() { return this.posX; }
    public int getPosY() { return this.posY; }
    public void setPosX(int posX) { this.posX = posX; }

    public BufferedImage getPrimaryImage() { return this.primaryImage; }
    public BufferedImage getSecondaryImage() { return this.secondaryImage; }
    public void setCurrentImage(BufferedImage img) { this.currentImage = img;}
    public void setDestroyed(boolean destroyed) {this.destroyed = destroyed;}

    public void setDestroyedTurns(int destroyedTurns) {
        this.destroyedTurns = destroyedTurns;
    }
}
