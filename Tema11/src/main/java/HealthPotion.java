public class HealthPotion implements Potion {

    @Override
    public void usePotion(Character character) {
        character.CurrentHealth=character.CurrentHealth+this.regenValue();
    }

    @Override
    public int potionPrice() {
        return 20;
    }

    @Override
    public int regenValue() {
        return 50;
    }

    @Override
    public int potionWeight() {
        return 1;
    }
}
