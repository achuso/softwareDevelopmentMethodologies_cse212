import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CharacterMovementGUI extends JPanel implements KeyListener {
    private int characterX = 250;  // Initial X position of the character
    private int characterY = 400;  // Initial Y position of the character

    public CharacterMovementGUI() {
        setPreferredSize(new Dimension(500, 500));
        setBackground(Color.LIGHT_GRAY);
        setFocusable(true);
        addKeyListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.PINK);
        //g.fillRect(characterX, characterY, 50, 50);  // Draw the character
        g.fill3DRect(characterX, characterY, 50, 50, true);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        // Move the character based on the arrow keys
        if (key == KeyEvent.VK_UP) {
            characterY -= 10;  // Move character up
        } else if (key == KeyEvent.VK_DOWN) {
            characterY += 10;  // Move character down
        } else if (key == KeyEvent.VK_LEFT) {
            characterX -= 10;  // Move character left
        } else if (key == KeyEvent.VK_RIGHT) {
            characterX += 10;  // Move character right
        }

        repaint();  // Redraw the panel to update the character's position
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Not used in this example
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Not used in this example
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Character Movement");
        CharacterMovementGUI panel = new CharacterMovementGUI();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
