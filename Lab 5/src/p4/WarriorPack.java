package p4;

/**
 *
 */

import java.util.*;

public class WarriorPack extends Warrior {
    private Vector warriors;

    public WarriorPack() {
        warriors = new Vector();
    }

    public void addWarrior() {
       Warrior newWarrior;
        newWarrior=new Warrior(100,"SNAKE",10);
        warriors.add(newWarrior);
        newWarrior=new Warrior(100,"OGRE",6);
        warriors.add(newWarrior);
        newWarrior=new Warrior(100,"OGRE",6);
        warriors.add(newWarrior);
        newWarrior=new Warrior(100,"MARSHMALLOW_MAN",1);
        warriors.add(newWarrior);
    }

    public Vector getWarriors() {
        return warriors;
    }

    public int calculateDamage() {
        int damage = 0;
        for (int i = 0; i < warriors.size(); i++) {
            Warrior w = (Warrior) warriors.get(i);
            damage= damage+ w.getDamage();
            }

        return damage;
    }
    public String toString() {

        return warriors.toString();
    }

        public static void main(String[] args) {

        WarriorPack wars =new WarriorPack();
        wars.addWarrior();
        System.out.println(wars.calculateDamage());
        System.out.println(wars.toString());

        }


}
//if (warriors.get(i).type == Warrior.SNAKE_Warrior) {
//        //Snake does 10 damage
//
//        damage += 10;
//        } else if (warriors.get(i).type == Warrior.OGRE_Warrior) {
//        //Ogre does 6 damage
//        damage += 6;
//        } else if (warriors.get(i).type == Warrior.MARSHMALLOW_MAN_Warrior) {
//        //Marshmallow Man does 1 damage
//        damage += 1;}