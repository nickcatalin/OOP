package p4;

/**
 *
 */
public class Warrior {
//    public static final int SNAKE_Warrior = 0;
//    public static final int OGRE_Warrior = 1;
//    public static final int MARSHMALLOW_MAN_Warrior = 2;

    //Stores one of the three above types

    //0 = dead, 100 = full strength
    public int health;
    public String name;
    public int damage;
    public  Warrior(){

    }
    public Warrior ( int health, String name,int damage) {

        this.health = health;
        this.name = name;
        this.damage = damage;
    }
    public int getDamage() {
        return this.damage;
    }

    @Override
    public String toString() {
        return Warrior.class.getTypeName() + " "+ this.name + " " + this.health + " " + this.damage;
    }
}
