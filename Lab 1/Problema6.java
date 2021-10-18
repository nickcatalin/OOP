public class Problema6 {
    public boolean isprime(int a){
        if(a==0||a==1)
            return false;
    for(int i=2;i<=a/2;i++)
    { if(a%i==0)
            return false;}
    return true;
    }
    public static void main(String args[]) {
        Problema6 obiect = new Problema6();
        for(int i=0;i<21;i++)
        if(obiect.isprime(i)==false)
            System.out.println(i+ " Nu este prim");
        else
            System.out.println(i+ " Este prim");


    }
}
