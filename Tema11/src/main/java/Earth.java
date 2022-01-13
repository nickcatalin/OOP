public class Earth extends Spell{
    String name ;
    Earth()
    {
        super(15,7);
        this.name="Earth";
    }
    public void visit(Entity entity)
    {

    }
    public void visit(Warrior warrior)
    {
        warrior.receiveDamage(super.damage);
    }

    public void visit(Rogue rogue)
    {

    }

    public void visit( Mage mage)
    {
        mage.receiveDamage(super.damage);
    }

    public void visit(Enemy enemy)
    {
        if(!enemy.earthProtection)
            enemy.receiveDamage(super.damage);

    }
    public String toString() {
        return name;
    }
}
