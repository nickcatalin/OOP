public class CharacterFactory {
    public  Character getCharacter(String characterType, String name, int level, int experience)
    {
        if(characterType.equals("Warrior"))
            return new Warrior(name,level,experience);
        if(characterType.equals("Rogue"))
            return new Rogue(name,level,experience);
        if(characterType.equals("Mage"))
            return new Mage(name, level, experience);

        return null;

    }

}
