public class HealthPotion implements Potion {

    int price;
    int regenVal;
    int potionweight;
    public HealthPotion()
    {

    }
    public HealthPotion(int price, int regenVal, int potionWeight)
    {
        this.price = price;
        this.regenVal = regenVal;
        this.potionweight =potionWeight;

    }

    @Override
    public void usePotion(Character character) {
        character.healthRegen(this.regenValue());
    }


    @Override
    public int potionPrice() {
        return this.price;
    }

    @Override
    public int regenValue() {
        return this.regenVal;
    }

    @Override
    public int potionWeight() {
        return this.potionweight;
    }

    @Override
    public String toString() {
        return "Health Potion";
    }
}
