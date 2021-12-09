package com.POOCC.lab05;

/**
 * 
 */
public class Warrior {
    public static final int SNAKE_Warrior = 0;
    public static final int OGRE_Warrior = 1;
    public static final int MARSHMALLOW_MAN_Warrior = 2;

    //Stores one of the three above types
    public int type;
    //0 = dead, 100 = full strength
    public int health;
    public String name;

    public Warrior (int type, int health, String name) {
        this.type = type;
        this.health = health;
        this.name = name;
    }
}
