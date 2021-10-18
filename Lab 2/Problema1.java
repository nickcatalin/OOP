public class Problema1 {
    public static void main(String[] args) {
        String str = "sir1 si cu sir2 fac un sir3";
        String s = "si";
        int i = 0;
        int c = 0;

        while (i != -1) {

            i = str.indexOf(s, i);

            if (i != -1) {
                c++;
                i += s.length();
            }
        }
        System.out.println(c);
    }
}
