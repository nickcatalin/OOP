public class Numar {
    int numar=10;

    //returneaza suma dintre nr (membrul clasei) si a
    public int suma(int a){
        return numar+a;
    }
    //returneaza suma dintre nr, a si b
    public int suma(int a, int b){
        return numar+a+b;
    }
    //returneaza suma dintre nr, a, b si c
    public int suma(int a, int b, int c)
    {
        return numar+a+b+c;
    }
    //returneaza suma dintre nr, a, b, c si d
    public int suma(int a, int b, int c, int d){
        return numar+a+b+c+d;
    }

    public static void main(String[] args) {

        Numar a = new Numar();


        System.out.println(a.suma(1));
        System.out.println(a.suma(1,2));
        System.out.println(a.suma(1,2,3));
        System.out.println(a.suma(1,2,3,4));
    }


}
