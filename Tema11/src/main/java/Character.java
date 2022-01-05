public abstract class Character extends Entity {
  String name;
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
  // metoda pentru cumpararea

}
