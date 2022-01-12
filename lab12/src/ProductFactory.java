public class ProductFactory {

    public Product factory(String type, String nameProduct, float productPrice)
    {
        if(type.equals("Book"))
            return new Book(nameProduct,productPrice);

        if(type.equals("Food"))
            return new Food(nameProduct,productPrice);
        if(type.equals("Beverage"))
            return new Beverage(nameProduct,productPrice);

        if(type.equals("Computer"))
            return new Computer(nameProduct,productPrice);

        return null;
    }
}
