public class Problema5 {

    public static void main(String args[]) {
        double a=5,b=2,n;
        Putere obiect = new Putere();
        obiect.Power(a,b);
        n=Math.pow(a,b);
        System.out.println(n);
    }
}
class Putere{
    public void Power(double a,double b){
        double c=1;
        for(int i=1;i<=b;i++)
        {
            c=c*a;
        }
        System.out.println(c);
    }
}
