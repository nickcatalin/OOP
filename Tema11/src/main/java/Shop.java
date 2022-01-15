import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Shop implements CellElement{

    List<Potion> shopPotionList= new ArrayList<>();

    public Shop()
    {   // 2 potiuni puse de mine ca sa fiu sigur ca shop are cate o potiune de mana si de viata
        // alte 0-2 potiuni generate random
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
    // metoda ce afiseaza lista de potiuni a magazinului si lista de potiuni ale caracterului
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
    // metoda de sterge o potiune din shop in caz de caractru a avut destui bani sa cumpere potiunea
    public void boughtPotion(int index)
{
    this.shopPotionList.remove(index-1);
}

    @Override
    public String toCharacter() {
        return "S  ";
    }
}
