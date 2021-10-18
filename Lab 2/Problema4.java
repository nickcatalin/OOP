import java.util.Random;
import java.util.Vector;

public class Problema4 {
    public static void main(String[] args) {
        Vector<Integer> Multimea1 = new Vector<Integer>();
        Vector<Integer> Multimea2 = new Vector<Integer>();
        Vector<Integer> Reuniune = new Vector<Integer>();
        Vector<Integer> Intersesctia = new Vector<Integer>();
        Vector<Integer> Diferenta = new Vector<Integer>();

        Random R = new Random();

        while (Multimea1.size() < 20) {
            int a = R.nextInt(100);
            if (!Multimea1.contains(a)) {
                Multimea1.add(a);
                Reuniune.add(a);
            }
        }
        while (Multimea2.size() < 20) {
            int a = R.nextInt(100);
            if (!Multimea2.contains(a))
                Multimea2.add(a);
        }


        for (int i = 0; i < Multimea2.size(); i++)
            if (!Reuniune.contains(Multimea2.elementAt(i)))
                Reuniune.add(Multimea2.elementAt(i));


        for (int i = 0; i < Multimea1.size(); i++)
            if (Multimea2.contains(Multimea1.elementAt(i)))
                Intersesctia.add(Multimea1.elementAt(i));

        for (int i = 0; i < Multimea1.size(); i++)
            Diferenta.add(Multimea1.elementAt(i).intValue() - Multimea2.elementAt(i).intValue());

        System.out.println("Multimea 1 : " + Multimea1);
        System.out.println("Multimea 1 : " + Multimea2);
        System.out.println("Reuniunea : " + Reuniune);
        System.out.println("Intersectia : " + Intersesctia);
        System.out.println("Diferenta : " + Diferenta);
    }

}