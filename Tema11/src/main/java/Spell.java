public abstract class Spell {

    int damage;
    int mana;

    Spell(int damage,int mana) {
        this.damage = damage;
        this.mana =mana;
    }
    public abstract void visit(Entity entity);

    public abstract void visit(Warrior warrior);

    public abstract void visit(Rogue rogue);

    public abstract void visit( Mage mage);


    public abstract void visit(Enemy enemy);

}
