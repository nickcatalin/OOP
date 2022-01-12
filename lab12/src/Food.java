public class Food extends Product{



    Food(String name,float price)
    {
        super(name,price);
    }

    public float getPriceReduced()
    {
        return (float) (this.price*20.0/100.0);
    }

}
