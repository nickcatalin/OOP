import java.util.Random;

public class Rogue extends Character{

    // greutate inventar medie
    // imun la pamant
    // atribut principal dexteritatea

    public Rogue(String name,int level,int experience)
    {
        super(name,level,experience);
        super.profession="Rogue";
        super.MaxHealth=100;
        super.MaxMana=75;
        super.CurrentHealth=100;
        super.CurrentMana=75;
        super.fireProtection=false;
        super.earthProtection=true;
        super.iceProtection=false;
        super.strength=level;
        super.dexterity=2*level;
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
        super.Character_Inventory.Coins=rand.nextInt(50,100);

        super.Character_Inventory.maXInventory=15;
    }


    public void receiveDamage(int value)
    {


        value = value - super.charisma*super.strength/10*3;
        if( value>0 )
            super.CurrentHealth=super.CurrentHealth-value;
    }

    public int getDamage()
    {
        return 15+super.dexterity/6*3;
    }
}
