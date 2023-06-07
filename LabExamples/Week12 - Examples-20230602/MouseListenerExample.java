import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MouseListenerExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Mouse Listener Example");
        JPanel panel = new JPanel();

        panel.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                System.out.println("Mouse Clicked");
            }

            public void mousePressed(MouseEvent e) {
                System.out.println("Mouse Pressed");
            }

            public void mouseReleased(MouseEvent e) {
                System.out.println("Mouse Released");
            }

            public void mouseEntered(MouseEvent e) {
                System.out.println("Mouse Entered");
            }

            public void mouseExited(MouseEvent e) {
                System.out.println("Mouse Exited");
            }
        });

        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}
