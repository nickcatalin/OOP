import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class problema2 extends JFrame implements ActionListener {



    JRadioButton jRadioButton1;


    JRadioButton jRadioButton2;

    JRadioButton jRadioButton3;


    JRadioButton jRadioButton4;


    JButton Button;


 ButtonGroup G1;


 JLabel L1;

    public problema2()
    {
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

        this.setLayout(null);


        jRadioButton1 = new JRadioButton();


        jRadioButton2 = new JRadioButton();

        jRadioButton3 = new JRadioButton();


        jRadioButton4 = new JRadioButton();




        G1 = new ButtonGroup();


        L1 = new JLabel("");


        jRadioButton1.setText("");


        jRadioButton2.setText("");
        jRadioButton3.setText("");


        jRadioButton4.setText("");

        L1.setBounds(10, 10, 600, 10);



        jRadioButton1.setBounds(10, 30, 180, 50);


        jRadioButton2.setBounds(10, 60, 180, 50);

        jRadioButton3.setBounds(10, 90, 180, 50);


        jRadioButton4.setBounds(10, 120, 180, 50);




        this.add(L1);
        this.add(jRadioButton1);


        this.add(jRadioButton2);
        this.add(jRadioButton3);


        this.add(jRadioButton4);

        G1.add(jRadioButton1);
        G1.add(jRadioButton2);
        G1.add(jRadioButton3);
        G1.add(jRadioButton4);
        Button = new JButton("Verifica raspunsul");


        Button.addActionListener(this);
        Button.setBounds(10, 170, 80, 30);
        add(Button);
    }
    public void actionPerformed(ActionEvent e) {
        if (jRadioButton1.isSelected())
            jRadioButton1.setBackground(Color.green);

        if (jRadioButton2.isSelected())
            jRadioButton2.setBackground(Color.red);

        if (jRadioButton3.isSelected())
            jRadioButton3.setBackground(Color.red);

        if (jRadioButton4.isSelected())
            jRadioButton4.setBackground(Color.red);
    }


}

class RadioButton {

    public static void main(String args[])
    {
        problema2 f = new problema2();

        f.setBounds(100, 100, 600, 250);


        f.setTitle("RadioButtons");
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("C:\\Users\\cata\\Desktop\\lab10\\src\\Intrebare.txt"));
            String line = reader.readLine();
            f.L1.setText(line);
            line=reader.readLine();
            f.jRadioButton1.setText(line);
            line=reader.readLine();
            f.jRadioButton2.setText(line);
            line=reader.readLine();
            f.jRadioButton3.setText(line);
            line=reader.readLine();
            f.jRadioButton4.setText(line);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        f.show();

    }
}

