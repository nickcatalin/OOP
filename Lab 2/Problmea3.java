import java.util.Random;
import java.util.Vector;


public class Problmea3 {
    static int check(Vector v, int x) {
        Vector X = new Vector();
        X.add(x);
        int a = 0;
        for (int i = 0; i < v.size(); i++) {
            if (v.get(i) == X.get(0)) {
                v.remove(i);
                a++;
            }
        }
        return a;
    }

    public static void main(String[] args) {

        Vector<Integer> v = new Vector<Integer>();
        Random r = new Random();


        for (int i = 1; i <= 20; i++) {
            v.add(r.nextInt(10));
        }
        System.out.println(v);
        System.out.println(check(v, 1));
        System.out.println(v);

        int max = 0, min = 10, posmin = 0, suma = 0;
        for (int i = 1; i <= v.size() - 1; i++) {

            if (v.elementAt(i).intValue() > max)
                max = v.get(i);
            if (v.elementAt(i).intValue() < min) {
                min = v.get(i);
                posmin = i;
            }
            suma = suma + v.elementAt(i).intValue();
        }

        System.out.println(max);
        System.out.println(posmin);
        System.out.println(suma / v.size());

    }

}
