import javax.swing.*;
import java.awt.*;

public class LoginPanel extends JPanel {

    JLabel loginHeader;

    LoginPanel(LoginSystem loginMgr) {
        this.setBackground(new Color(0x1d0b38));

        loginHeader = new JLabel("Login");
        JTextField usernameField = new JTextField("Enter username:");
        JTextField passwordField = new JTextField("Enter username:");

        this.add(loginHeader);
        this.add(usernameField);
        this.add(passwordField);
    }
}
