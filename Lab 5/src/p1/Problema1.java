

/**
 *
 * @author Nan Mihai
 */
package p1;
class Animal {
    private static String nume;
    private static String culoare;

    static{
        System.out.println("Bloc 2 - Animal");
    }

     {
        System.out.println("Bloc 1 - Animal");
        nume = "Animal";
        culoare = "negru";
    }
    

    public static String getCuloare() {
         return culoare;
    }
}

class Caine extends Animal {
    private static String tipRasa;
    
     {
        tipRasa = "medie";
        System.out.println("Bloc 1 - Caine " + getCuloare());
    }
    
    static {
        System.out.println("Bloc 2 - Caine");
    }
    {
        System.out.println("Bloc 4 - Caine");
        tipRasa = "mica";
    }
     {
        System.out.println("Bloc 3 - Caine");
        tipRasa = "mare";
    }
    

}

class SharPei extends Caine {
    private static int  varsta;
    private static String taraProvenienta;


   static {
        System.out.println("Bloc 1 - SharPei");
        taraProvenienta = "China";
    }
    static{
        System.out.println("Bloc 2 - SharPei " + taraProvenienta);
    }
    {
        varsta = 5;
        System.out.println("Bloc 3 - SharPei " + varsta);
    }


}

class Problema1 {
    public static void main(String args[]) {

        SharPei cutu = new SharPei();
    }
}