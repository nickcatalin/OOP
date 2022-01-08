public class Ice extends Spell {
    String name = "Ice";
    Ice(){
        super(10,5);
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
        if(enemy.iceProtection==false)
            enemy.receiveDamage(super.damage);

    }
}
