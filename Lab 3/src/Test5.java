public class Test5 {

    public static void main(String[] args) {

        Punct A =new Punct();
        Punct B =new Punct();
        A.setX(1);
        A.setY(2);
        B.setX(-1);
        B.setY(3);


        System.out.println( A);
        System.out.println( B);
        System.out.println(A.distance(-1,3));
        System.out.println(A.distance(B));

    }
}
