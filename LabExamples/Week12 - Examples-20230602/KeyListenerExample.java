import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class KeyListenerExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Key Listener Example");
        JPanel panel = new JPanel();

        panel.setFocusable(true); // Ensure the panel has focus to receive keyboard events

        panel.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
                System.out.println("Key Typed: " + e.getKeyChar());
            }

            public void keyPressed(KeyEvent e) {
                System.out.println("Key Pressed: " + KeyEvent.getKeyText(e.getKeyCode()));
            }

            public void keyReleased(KeyEvent e) {
                System.out.println("Key Released: " + KeyEvent.getKeyText(e.getKeyCode()));
            }
        });

        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}
