import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class Text extends JFrame implements ActionListener{
    private JButton button;
    private JTextField text1;
    private JTextField text2;
    private JTextField text3;
    private JLabel text4;


    public Text (String text){
        super(text);
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(300, 200));
        getContentPane().setBackground(Color.white);
        setLayout(new FlowLayout());
        button = new JButton ("Apasa");
        button.addActionListener(this);
        add(button);
        text1 = new JTextField(15);
        add(text1);
        text2 = new JTextField(15);
        add(text2);
        text3 = new JTextField(15);
        add(text3);
        text4 = new JLabel("");
        add(text4);
        show();
        pack();
    }

    public static void main (String args[]){
        Text b = new Text ("LaboratorPOO");
    }

    @Override
    public void actionPerformed(ActionEvent e){
        /*
        JButton button = (JButton)e.getSource();
        if (button.getText().equals("Apasa")) // valabil daca aveam mai multe butoane ascultate de acest ascultator
       */
        //System.out.println(text1.getText() + text2.getText());
        String s= text1.getText()+text2.getText()+text3.getText();
        text4.setText(s);
    }
}