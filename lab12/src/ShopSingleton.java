import java.util.ArrayList;
import java.util.List;

public class ShopSingleton {
   static ShopSingleton shop;
    String name;
    List<Product> products;

    private ShopSingleton() {
    products=new ArrayList<Product>();
    }
    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void showProducts()
    {   System.out.println("Shop");
        for(int i=0;i<this.products.size();i++)
        {
            System.out.println((i+1)+". "+this.products.get(i));

        }
    }
    public void removeProduct(Product product) {

    products.remove(product);


    }
    public Product getCheapestProduct()
    {   Product cheapProduct = null;
        float max=100000;
        for(int i=0;i<this.products.size();i++)
        {
            if(this.products.get(i).price<max)
            {
                max=this.products.get(i).price;
                cheapProduct=this.products.get(i);
            }
        }
        if(cheapProduct!=null)
            return cheapProduct;
    return null;
    }
    public static ShopSingleton getInstance()
    {   if(shop==null) shop=new ShopSingleton();
        return shop;


    }

}

class test
{
    public static void main(String[] args)
    {
        ShopSingleton shop=ShopSingleton.getInstance();
        ProductFactory productFactory=new ProductFactory();
        Product produsDeSters=productFactory.factory("Food","mere", (float) 10);
        shop.addProduct(produsDeSters);
        shop.addProduct(productFactory.factory("Computer","gtx 1070", (float) 9));
        shop.addProduct(productFactory.factory("Food","chipsuri", (float) 3));
        shop.addProduct(productFactory.factory("Book","Atomic Habits", (float) 4.5));
        shop.addProduct(productFactory.factory("Food","banane", (float) 2.5));
        shop.addProduct(productFactory.factory("Beverage","cola", (float) 6));

        shop.showProducts();
        shop.removeProduct(produsDeSters);
        shop.showProducts();
        Product product= shop.getCheapestProduct();
        System.out.println(product);
    }
}
