import java.util.ArrayList;
import java.util.List;

public abstract class Entity {

    List<Spell> AbilityList = new ArrayList<Spell>();
    int CurrentHealth ,MaxHealth;
    int CurrentMana ,MaxMana;
    boolean fireProtection,iceProtection,earthProtection;

    public void healthRegen(int value) {
        this.CurrentHealth=this.CurrentHealth+value;
        if(this.CurrentHealth>this.MaxHealth)
            this.CurrentHealth=this.MaxHealth;
    }
    public void manaRegen(int value) {
        this.CurrentMana=this.CurrentMana+value;
        if(this.CurrentMana>this.MaxMana)
            this.CurrentMana=this.MaxMana;
    }

    // De facut functia pentru folosirea unei abilitati
    public void accept(Spell spell)
    {
    spell.visit(this);
    }




    public abstract void receiveDamage(int value);

    public abstract int getDamage();


}
