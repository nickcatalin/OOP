public class Problema5 {

    public String cenzurare(String text, String cuvinte[]) {

        int ok = 0, j = 0;
        while (ok == 0 && j < cuvinte.length) {
            if (text.contains(cuvinte[j]))
                ok++;
            j++;
        }
        if (ok == 0) {
            System.out.println("Nimic suspect");
            return text;
        } else
            System.out.println("Text suspect");


        String cuvintecenzurate[] = new String[2];
        cuvintecenzurate[0] = "t******t";
        cuvintecenzurate[1] = "b***a";
        for (int i = 0; i < cuvinte.length; i++)
            text = text.replaceAll(cuvinte[i], cuvintecenzurate[i]);

        return text;
    }

    public static void main(String[] args) {
        String text = "Un terorist avea o bomba";
        String cuvinte[] = new String[2];
        cuvinte[0] = "terorist";
        cuvinte[1] = "bomba";
        Problema5 prb5 = new Problema5();
        String rezultat;
        rezultat = prb5.cenzurare(text, cuvinte);
        System.out.println("Textul rezultat este : " + rezultat);

    }
}
