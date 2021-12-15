package Lab11;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class Problema2 extends JFrame implements ActionListener{

    private JList list;
    private JButton button;
    private JTextField nume;
    private JTextField carte;
    private DefaultListModel list1;

    public Problema2 (String text){
        super(text);
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(300, 200));
        getContentPane().setBackground(Color.white);
        setLayout(new GridLayout());
        button = new JButton ("Apasa");
        button.addActionListener(this);
        add(button);
        nume = new JTextField(25);
        add(nume);
        carte = new JTextField(15);
        add(carte);

        list1=new DefaultListModel();

        lis

        list=new JList(list1);
        add(new JScrollPane(list));
        show();
        pack();
    }

    public static void main (String args[]){




        Problema2 b = new Problema2 ("LaboratorPOO");
    }
    int i=0;
    @Override
    public void actionPerformed(ActionEvent e){

        String s= nume.getText()+" "+carte.getText();
        nume.setText("");
        carte.setText("");
        list1.add(i,s);
        i++;
    }
}