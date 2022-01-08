import java.util.Random;

public class Enemy extends Entity implements CellElement{

public Enemy()
{
    Random rand = new Random();
   super.CurrentHealth =rand.nextInt(30,70);
   super.CurrentMana =rand.nextInt(30,60);
    super.MaxHealth=70;
    super.MaxMana=70;
    super.earthProtection=rand.nextBoolean();
    super.fireProtection=rand.nextBoolean();
    super.iceProtection=rand.nextBoolean();

    int abilityNumber = rand.nextInt(2,5);
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


}
    @Override
    public int getDamage() {
        Random rand = new Random();
        int sansa50 = rand.nextInt(2);
            if(sansa50==1)
                return 20;
        return 10;
    }
    @Override
    public void receiveDamage(int value) {
        Random rand = new Random();
        int sansa50 = rand.nextInt(2);
        if(sansa50==1)
        {
            super.CurrentHealth=super.CurrentHealth-value/2;
            return;
        }
    super.CurrentHealth=super.CurrentHealth-value;
    }
    @Override
    public String toCharacter() {
        return "E ";
    }
}
