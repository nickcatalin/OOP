public class Computer extends Product{


    Computer(String name,float price)
    {
        super(name,price);
    }

    public float getPriceReduced()
    {
        return (float) (this.price*10.0/100.0);
    }

}
