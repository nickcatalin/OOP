public abstract class Spell {

    int damage;
    int mana;
    Spell(){}
    Spell(int damage,int mana) {
        this.damage = damage;
        this.mana =mana;
    }
    public void visit(Entity entity)
    {

    }
    public void visit(Warrior warrior)
    {

    }

    public void visit(Rogue rogue)
    {

    }

    public void visit( Mage mage)
    {

    }

    public void visit(Enemy enemy)
    {


    }
}
