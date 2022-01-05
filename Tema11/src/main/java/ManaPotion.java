public class ManaPotion implements Potion{


    @Override
    public void usePotion(Character character) {
        character.CurrentMana=character.CurrentMana+this.regenValue();

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
}
