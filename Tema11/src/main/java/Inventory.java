import java.util.ArrayList;
import java.util.List;

public class Inventory {

    List<Potion> potionList=new ArrayList<Potion>();
    int maXInventory ;
    int Coins;


    public void addPotion(Potion potion)
    {
    this.potionList.add(potion);
    }
    public void removePotion(int index)
    {
    this.potionList.remove(index);
    }
    public int remainingInventorySpace()
    {
        return this.maXInventory-this.potionList.size();
    }

}
