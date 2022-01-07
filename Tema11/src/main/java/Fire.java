public class Fire extends Spell{
    String name = "Fire";
    Fire(){
        super(30,10);
    }
    public void visit(Entity entity)
    {

    }
    public void visit(Warrior warrior)
    {

    }

    public void visit(Rogue rogue)
    {
    rogue.receiveDamage(super.damage);
    }

    public void visit( Mage mage)
    {
    mage.receiveDamage(super.damage);
    }

    public void visit(Enemy enemy)
    {
    if(enemy.fireProtection==false)
        enemy.receiveDamage(super.damage);

    }
}
