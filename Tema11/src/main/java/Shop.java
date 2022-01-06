import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Shop implements CellElement{

    List<Potion> shopPotionList= new ArrayList<Potion>();

    public Shop()
    {
        Random rand = new Random();
        int potionNumber = rand.nextInt(2,5);
        while(potionNumber>0)
        {   int randomPotion = rand.nextInt(2);
            if(randomPotion==0)
                this.shopPotionList.add(new HealthPotion());
            if(randomPotion==1)
               shopPotionList.add(new ManaPotion());
            potionNumber--;
        }
    }

    public Potion getPotion(int index)
    {
        Potion potion = this.shopPotionList.get(index);
        this.shopPotionList.remove(index);
        return potion;

    }

    @Override
    public String toCharacter() {
        return "S  ";
    }
}
