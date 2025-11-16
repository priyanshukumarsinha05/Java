import javax.swing.*;
import java.awt.*;

public class j5 {

    public static void main(String[] args) {

        // Create frame
        JFrame frame = new JFrame("Alpha Beta App");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // Components
        JButton alpha = new JButton("Alpha");
        JButton beta = new JButton("Beta");
        JLabel msg = new JLabel("Click a button...");

        // Event handling
        alpha.addActionListener(e -> msg.setText("Alpha pressed"));
        beta.addActionListener(e -> msg.setText("Beta pressed"));

        // Add components to frame
        frame.add(alpha);
        frame.add(beta);
        frame.add(msg);

        // Show frame
        frame.setVisible(true);
    }
}
