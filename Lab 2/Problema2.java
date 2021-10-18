import java.util.StringTokenizer;

public class Problema2 {
    public static void main(String[] args) {

        int i, j = 0;
        String str = "sir1 si cu sir2 fac un sir3";

        i = (str.split("si ", -1).length) - 1;

        System.out.println(i);

        StringTokenizer st = new StringTokenizer("Marius, de ce nu l-ai ajutat pe George? Era de datoria ta sa vezi ce poti face.", " -,?.:");
        while (st.hasMoreTokens()) {
            if (st.nextToken().equals("Marius"))
                j++;
        }
        System.out.println(j);
    }
}
