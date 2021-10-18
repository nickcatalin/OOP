public class Problema7 {
    public boolean isprime(int a) {
        if (a == 0)
            return false;
        for (int i = 2; i <= a / 2; i++) {
            if (a % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String args[]) {
        Problema7 obiect = new Problema7();

        int n = 10, i , a = 0;
        for(i=1;i<=n;i++){
            for (int j = 1; j <= a; j++) {
                for (int z = j ; z <= a - j; z++) {
                    if (obiect.isprime(j) && obiect.isprime(z) && a == j + z)
                        System.out.println(a + " = " + " " + j + " + " + " " + z);
                }
            }
            a=a+2;
        }


    }
}
