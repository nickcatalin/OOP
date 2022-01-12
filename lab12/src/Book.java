public class Book extends Product {

    Book(String name,float price)
    {
        super(name,price);
    }

    public float getPriceReduced()
    {
        return (float) (this.price*15.0/100.0);
    }

}
