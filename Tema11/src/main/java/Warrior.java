import java.util.Random;

public class Warrior extends Character{

    // detine cea mai mare greudate a inventarului
    // imun la foc
    // atribut principal este puterea

    public Warrior(String name,int level,int experience)
    {
        super(name,level,experience);
        super.MaxHealth=150;
        super.MaxMana=50;
        super.CurrentHealth=150;
        super.CurrentMana=50;
        super.fireProtection=true;
        super.earthProtection=false;
        super.iceProtection=false;
        super.strength=2*level;
        super.dexterity=level;
        super.charisma=level;
        Random rand = new Random();

        int abilityNumber = rand.nextInt(2,4);
        while(abilityNumber>0)
        {   int randomAbility = rand.nextInt(3);
            if(randomAbility==0)
                super.AbilityList.add(new Fire());
            if(randomAbility==1)
                super.AbilityList.add(new Ice());
            if(randomAbility==2)
                super.AbilityList.add(new Earth());
            abilityNumber--;
        }
        super.Character_Inventory=new Inventory();
        super.Character_Inventory.Coins=rand.nextInt(50);
        int potionNumber = rand.nextInt(1,3);
        while(potionNumber>0)
        {   int randomPotion = rand.nextInt(2);
            if(randomPotion==0)
                super.Character_Inventory.addPotion(new ManaPotion());
            if(randomPotion==1)
                super.Character_Inventory.addPotion(new HealthPotion());
            potionNumber--;
        }
        Character_Inventory.maXInventory=20;

    }

    public void receiveDamage(int value)
    {   value = value - super.dexterity*super.charisma/10*2;
        if( value>0)
        super.CurrentHealth=super.CurrentHealth-value;

    }

    public int getDamage()
    {
        return 30+ super.strength/10*3;
    }

}
