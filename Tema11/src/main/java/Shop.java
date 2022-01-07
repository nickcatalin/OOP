import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Shop implements CellElement{

    List<Potion> shopPotionList= new ArrayList<Potion>();

    public Shop()
    {
        Random rand = new Random();
        this.shopPotionList.add(new HealthPotion());
        this.shopPotionList.add(new ManaPotion());
        int potionNumber = rand.nextInt(3);
        while(potionNumber>0)
        {   int randomPotion = rand.nextInt(2);
            if(randomPotion==0)
                this.shopPotionList.add(new HealthPotion());
            if(randomPotion==1)
               this.shopPotionList.add(new ManaPotion());
            potionNumber--;
        }
    }

    public Potion getPotion(Character character)
    {   Scanner in = new Scanner(System.in);
        int index;
        System.out.println(" ____________________\n" +
                "|________Shop________|");
        for(int i=0;i<this.shopPotionList.size();i++)
            System.out.println((i+1)+". "+this.shopPotionList.get(i));
        System.out.println("_____________________");
        System.out.println("Ale tale: "+ character.Character_Inventory.potionList);
        index=in.nextInt();
        Potion potion = this.shopPotionList.get(index-1);

    if (potion.potionPrice() < character.Character_Inventory.Coins
        && character.Character_Inventory.remainingInventorySpace() > 0) {
      character.Character_Inventory.Coins =
          character.Character_Inventory.Coins - potion.potionPrice();
      this.shopPotionList.remove(index - 1);
      return potion;
}
    return null;
    }

    @Override
    public String toCharacter() {
        return "S  ";
    }
}
