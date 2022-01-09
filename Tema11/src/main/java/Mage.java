import java.util.Random;

public class Mage extends Character{

    // cel mai mic inventar
    // imun la ice
    // atribut pprincipal carisma

    public Mage(String name,int level,int experience)
    {
        super(name,level,experience);
        super.profession="Mage";
        super.MaxHealth=80;
        super.MaxMana=125;
        super.CurrentHealth=80;
        super.CurrentMana=125;
        super.fireProtection=false;
        super.earthProtection=false;
        super.iceProtection=true;
        super.strength=level;
        super.dexterity=level;
        super.charisma=2*level;
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

        super.Character_Inventory.maXInventory=10;
    }
    @Override
    public void accept(Spell spell)
    {
        spell.visit(this);
    }


    public void receiveDamage(int value)
    {
        value = value - super.dexterity*super.strength/9;
        if( value>0)
            super.CurrentHealth=super.CurrentHealth-value;

    }

    public int getDamage()
    {

        return 10+(super.charisma+2)/5;
    }
}
