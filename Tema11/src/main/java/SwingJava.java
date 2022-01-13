import java.awt.*;
import javax.swing.*;

public class SwingJava {
    public static void main(String s[]) {
        JFrame frame = new JFrame("JFrame Example");
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        JLabel label = new JLabel("JFrame By Example");
        JButton button = new JButton();
        button.setText("Button");
    ImageIcon img = new ImageIcon("src\\main\\java\\background.jpg");
        JLabel background= new JLabel("",img,JLabel.CENTER);
        background.setBounds(0,0,1280,720);
        panel.add(background);
        panel.add(label);
        panel.add(button);
        frame.add(panel);
        frame.setSize(1280, 720);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}