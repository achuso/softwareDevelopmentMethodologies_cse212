import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Graphics;

public class LoserScreen extends JPanel {

    private BufferedImage loserScreen;

    LoserScreen() throws IOException {
        setPreferredSize(new Dimension(800, 800));
        loserScreen = ImageIO.read(new File("icons/Scenes/gameover.png"));
        setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (loserScreen != null)
            g.drawImage(loserScreen, 0, 0, this);
    }

}
