import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.*;

class problema5 extends JFrame implements  ActionListener {


    static JFrame f;

    static Vector<Color> colors= new Vector<Color>(); ;
    private static JButton Button;
    static JLabel l;
    int i=0;

    public static void main(String[] args)
    {   colors.add(Color.BLACK);
        colors.add(Color.red);
        colors.add(Color.blue);
        colors.add(Color.cyan);
        colors.add(Color.yellow);
        colors.add(Color.white);
        colors.add(Color.green);
        f = new JFrame("frame");

        solve s = new solve();


        f.setSize(600, 300);
        Button = new JButton("Verifica raspunsul");


        Button.addActionListener(s);
        f.add(Button);
        f.show();
    }

    public void actionPerformed(ActionEvent e) {

        Button.setForeground(colors.get(i));
        i++;if(i==6)
        {
            i=0;
        }
        Button.setBackground(colors.get(i));


    }




}