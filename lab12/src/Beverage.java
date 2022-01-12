public class Beverage extends Product{



    Beverage(String name,float price)
    {
        super(name,price);
    }


    public float getPriceReduced()
    {
        return (float) (this.price*5.0/100.0);
    }

}
