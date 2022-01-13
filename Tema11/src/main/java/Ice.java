public class Ice extends Spell {
    String name ;
    Ice(){
        super(10,5);
        this.name="Ice";
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
        rogue.receiveDamage(super.damage);
    }

    public void visit( Mage mage)
    {

    }

    public void visit(Enemy enemy)
    {
        if(!enemy.iceProtection)
            enemy.receiveDamage(super.damage);

    }
    public String toString() {
        return name;
    }
}
