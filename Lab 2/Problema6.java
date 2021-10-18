import java.util.Vector;

public class Problema6 {


    public static void main(String[] args) {
        Vector v = new Vector();
        Vector<Integer> d = new Vector<Integer>();
        d.add(0);//int
        d.add(0);//double
        d.add(0);//float
        d.add(0);//String
        d.add(0);//char
        d.add(0);//boolean

        v.add(7.5);
        v.add("String");
        v.add(684);
        v.add("07");
        v.add(53.135984);
        v.add(167.38426848532159745);
        v.add("2lunidreapta");
        v.add(969);
        v.add(126.197529);
        v.add(8974);
        v.add("vladbltxd$$106013mil");
        v.add(7852.128456853245897);
        v.add('t');
        v.add(true);
        v.add('4');
        v.add(false);

        for (int i = 0; i < v.size(); i++) {

            String s = v.get(i).getClass().toString();
            int intt = (s.split("int", -1).length) - 1;
            int doublee = (s.split("double", -1).length) - 1;
            int floatt = (s.split("float", -1).length) - 1;
            int charr = (s.split("char", -1).length) - 1;
            int Stringg = (s.split("String", -1).length) - 1;
            int booleann = (s.split("boolean", -1).length) - 1;


        }
        System.out.println(d.elementAt(0));

    }
}
