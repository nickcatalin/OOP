public abstract class Product {
    String name;
    float price;

    Product()
    {

    }
    Product(String name, float price)
    {
        this.name = name;
        this.price = price;
    }

    public String toString()
    {
        return name+" "+price;
    }
}
