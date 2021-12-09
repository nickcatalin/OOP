package p3;

import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

class NumarNegativ extends Exception
{
    public NumarNegativ(String str)
    {
        super(str);
    }
}


public class Problema3
{  static Vector<Integer> vector = new Vector<Integer>();


    static void myRead () throws NumarNegativ {
       Scanner in = new Scanner(System.in);
       int i ;
        while (true){
            i = in.nextInt();
        if(i < 0){

            throw new NumarNegativ("Numar Negativ !");
        }
        else {
            vector.addElement(i);
        }

        }
    }


    public static void main(String args[])
    {
        try
        {
            myRead();
        }
        catch (NumarNegativ ex)
        {


            System.out.println(ex);
        }

        System.out.println(vector);
        System.out.println(Collections.max(vector));

    }
}
