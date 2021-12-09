package lab66;

public class Problema2 {
    public static void main(String[] args) {


//        Circle c1 = new Circle();
//        Square sq = (Square) c1;
////Conversie 2
//        Rectangle r = new Rectangle(5.0, 5.0);
//        sq = (Square) r;
////Conversie 3
//        sq = new Square(7.0);
//        r = sq;               Nu se poate da cast de la circle la square

      //  Rectangle r = new Shape(5.0, 5.0);  'Shape' is abstract; cannot be instantiated
        Rectangle r = new Square(); // merge

        Square S = new Square();
        Rectangle rec=(Rectangle) S;
        Shape sh=(Shape) S;
    //  Circle c = (Circle) S;

        System.out.println(rec instanceof Square);
        System.out.println(sh instanceof Square);
        //System.out.println(c instanceof Square);

    }
}
