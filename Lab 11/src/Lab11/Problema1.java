package Lab11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class Problema1 extends JFrame implements ActionListener{

    private JList list;

    public Problema1 (String text, Vector<Book> carti){
        super(text);
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(300, 200));
        getContentPane().setBackground(Color.white);
        setLayout(new FlowLayout());

        list=new JList(carti);
        add(new JScrollPane(list));
        show();
        pack();
    }

    public static void main (String args[]){

        Book carte1 = new Book("Carte1`","Autor1","");
        Book carte2 = new Book("Carte2`","Autor2","");
        Book carte3 = new Book("Carte3`","Autor3","");
        Book carte4 = new Book("Carte4`","Autor4","");
        Book carte5 = new Book("Carte5`","Autor5","");
        Book carte6 = new Book("Carte6`","Autor6","");
        Book carte7 = new Book("Carte7`","Autor7","");
        Book carte8 = new Book("Carte8`","Autor8","");

        Vector<Book> carti =new Vector<Book>();
        
        carti.add(carte1);
        carti.add(carte2);
        carti.add(carte3);
        carti.add(carte4);
        carti.add(carte5);
        carti.add(carte6);
        carti.add(carte7);
        carti.add(carte8);
        carti.add(carte1);
        carti.add(carte2);
        carti.add(carte3);
        carti.add(carte4);
        carti.add(carte5);
        carti.add(carte6);
        carti.add(carte7);
        carti.add(carte8);

        Problema1 b = new Problema1 ("LaboratorPOO",carti);
    }

    @Override
    public void actionPerformed(ActionEvent e){



    }
}