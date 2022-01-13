import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Shop implements CellElement{

    List<Potion> shopPotionList= new ArrayList<>();

    public Shop()
    {
        Random rand = new Random();
        this.shopPotionList.add(new HealthPotion(15,50,1));
        this.shopPotionList.add(new ManaPotion(10,50,1));
        int potionNumber = rand.nextInt(3);
        while(potionNumber>0)
        {   int randomPotion = rand.nextInt(2);
            if(randomPotion==0)
                this.shopPotionList.add(new HealthPotion(15,50,1));
            if(randomPotion==1)
               this.shopPotionList.add(new ManaPotion(10,50,1));
            potionNumber--;
        }
    }
    public void printPotionList(Character character)
    {
        System.out.println(" ____________________\n" +
                "|________Shop________|");
        for(int i=0;i<this.shopPotionList.size();i++)
            System.out.println((i+1)+". "+this.shopPotionList.get(i));
        System.out.println("_____________________");
        System.out.println("Ale tale: "+ character.Character_Inventory.potionList);
    }
    public Potion getPotion(int index)
    {

        return this.shopPotionList.get(index-1);
}
public void boughtPotion(int index)
{
    this.shopPotionList.remove(index-1);
}

    @Override
    public String toCharacter() {
        return "S  ";
    }
}
