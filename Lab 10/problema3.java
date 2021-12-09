import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class problema3 extends JFrame implements ActionListener {



    JCheckBox JCheckBox1;


    JCheckBox JCheckBox2;

    JCheckBox JCheckBox3;


    JCheckBox JCheckBox4;
    JButton Button;


 ButtonGroup G1;


 JLabel L1;

    public problema3()
    {


        this.setLayout(null);


        JCheckBox1 = new JCheckBox();


        JCheckBox2 = new JCheckBox();

        JCheckBox3 = new JCheckBox();


        JCheckBox4 = new JCheckBox();




        G1 = new ButtonGroup();


        L1 = new JLabel("");


        JCheckBox1.setText("");


        JCheckBox2.setText("");
        JCheckBox3.setText("");


        JCheckBox4.setText("");

        L1.setBounds(10, 10, 600, 10);



        JCheckBox1.setBounds(10, 30, 180, 50);


        JCheckBox2.setBounds(10, 60, 180, 50);

        JCheckBox3.setBounds(10, 90, 180, 50);


        JCheckBox4.setBounds(10, 120, 180, 50);




        this.add(L1);
        this.add(JCheckBox1);


        this.add(JCheckBox2);
        this.add(JCheckBox3);


        this.add(JCheckBox4);

//        G1.add(JCheckBox1);
//        G1.add(JCheckBox2);
//        G1.add(JCheckBox3);
//        G1.add(JCheckBox4);
        Button = new JButton("Verifica raspunsul");


        Button.addActionListener(this);
        Button.setBounds(10, 170, 80, 30);
        add(Button);
    }

    public void actionPerformed(ActionEvent e) {
        if (JCheckBox1.isSelected())
            JCheckBox1.setBackground(Color.green);

        if (JCheckBox2.isSelected())
            JCheckBox2.setBackground(Color.red);

        if (JCheckBox3.isSelected())
            JCheckBox3.setBackground(Color.green);

        if (JCheckBox4.isSelected())
            JCheckBox4.setBackground(Color.red);
    }


}

class CheckBox {

    public static void main(String args[])
    {
        problema3 f = new problema3();

        f.setBounds(100, 100, 600, 250);


        f.setTitle("RadioButtons");
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("C:\\Users\\cata\\Desktop\\lab10\\src\\Intrebare.txt"));
            String line = reader.readLine();
            f.L1.setText(line);
            line=reader.readLine();
            f.JCheckBox1.setText(line);
            line=reader.readLine();
            f.JCheckBox2.setText(line);
            line=reader.readLine();
            f.JCheckBox3.setText(line);
            line=reader.readLine();
            f.JCheckBox4.setText(line);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        f.show();

    }
}

