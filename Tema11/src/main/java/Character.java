public abstract class Character extends Entity {
   String name;
   String profession;
   int Current_Ox,Current_Oy;
   Inventory Character_Inventory;
   int experience;
   int level;
   int strength;
   int charisma;
   int dexterity;
   public Character()
   {

   }
  public Character(String name,int level,int experience)
  {
    this.name=name;
    this.level=level;
    this.experience=experience;
  }
  public String toString() {
       return this.profession+" "+ this.name + " "+ this.level + " "+ this.experience;
  }
  // metoda pentru cumpararea
    public int testCoinsPotion(Potion potion)
    {
        if (potion.potionPrice() < this.Character_Inventory.Coins
                && this.Character_Inventory.remainingInventorySpace() > 0) {
            this.Character_Inventory.Coins =
                    this.Character_Inventory.Coins - potion.potionPrice();
            this.Character_Inventory.addPotion(potion);
            return 1;

    }
        return 0;
    }
}
