public class ManaPotion implements Potion{


    @Override
    public void usePotion(Character character) {
        character.manaRegen(this.regenValue());

    }

    @Override
    public int potionPrice() {
        return 10;
    }

    @Override
    public int regenValue() {
        return 30;
    }

    @Override
    public int potionWeight() {
        return 1;
    }

    @Override
    public String toString() {
        return "Mana Potion";
    }


}
