import javax.swing.event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
class problema4 extends JFrame implements ChangeListener, ActionListener {


    static JFrame f;


    static JSlider red;
    static JSlider green;
    static JSlider blue;
    private static JButton Button;
    JCheckBox JCheckBox1;

    static JLabel l;


    public static void main(String[] args)
    {

        f = new JFrame("frame");


        problema4 s = new problema4();


        l = new JLabel();

        JPanel p = new JPanel();


        red = new JSlider(0, 255, 120);


        red.setPaintTrack(true);
        red.setPaintTicks(true);
        red.setPaintLabels(true);


        red.setMajorTickSpacing(50);
        red.setMinorTickSpacing(5);


        red.addChangeListener(s);

        green = new JSlider(0, 255, 120);


        green.setPaintTrack(true);
        green.setPaintTicks(true);
        green.setPaintLabels(true);


        green.setMajorTickSpacing(50);
        green.setMinorTickSpacing(5);


        green.addChangeListener(s);

        blue = new JSlider(0, 255, 120);


        blue.setPaintTrack(true);
        blue.setPaintTicks(true);
        blue.setPaintLabels(true);


        blue.setMajorTickSpacing(50);
        blue.setMinorTickSpacing(5);


        blue.addChangeListener(s);


        p.add(red);
        p.add(green);
        p.add(blue);
        p.add(l);

        f.add(p);


        l.setText("value of Slider is =" + red.getValue());


        f.setSize(600, 300);
        Button = new JButton("Verifica raspunsul");


        Button.addActionListener(s);
        p.add(Button);
        f.show();
    }
    public void actionPerformed(ActionEvent e) {




    }


    public void stateChanged(ChangeEvent e)
    {
        Button.setBackground(new java.awt.Color(red.getValue(),green.getValue(),blue.getValue()));
        l.setText("value of Slider is =" + red.getValue());
    }

}