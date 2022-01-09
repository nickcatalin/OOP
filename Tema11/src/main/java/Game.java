import java.io.*;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Game {
  private static Game game;
  List<Account> accountsList = new ArrayList<Account>();
  Map<Cell.Story, List<String>> StoriesMap = new HashMap<Cell.Story, List<String>>();

  private Game()
  {

  }
  private void readAccounts()
  {
    JSONParser parser = new JSONParser();

    try {
      JSONArray a =
              (JSONArray)
                      parser.parse(
                              new FileReader(
                                      "src\\main\\java\\Teste\\test.json"));


      for (Object o : a) {
        Account account = new Account();
        JSONObject person = (JSONObject) o;

        JSONObject credentials = (JSONObject) person.get("credentials");
        String email = (String) credentials.get("email");
        String password = (String) credentials.get("password");

        Credentials Credentials = new Credentials();
        Credentials.setEmail(email);
        Credentials.setPassword(password);

        String name = (String) person.get("name");
        String country = (String) person.get("country");

        JSONArray favourite_games = (JSONArray) person.get("favorite_games");
        List<String> favoriteGames = new ArrayList<String>();

        account.allGamesNumber = Integer.parseInt((String) person.get("maps_completed"));

        for (Object game : favourite_games) favoriteGames.add(game.toString());
        Collections.sort(favoriteGames);
        account.allGamesNumber=favoriteGames.size();
        account.playerInfo =
                new InformationBuilder()
                        .setName(name)
                        .setCountry(country)
                        .setCredentials(Credentials)
                        .setfavoriteGames(favoriteGames)
                        .build();

        JSONArray characters = (JSONArray) person.get("characters");
        for (Object ch : characters) {
          JSONObject character = (JSONObject) ch;
          String profession = (String) character.get("profession");
          int exp = ((Long) character.get("experience")).intValue();

          String character_name = (String) character.get("name");
          int character_level = Integer.parseInt((String) character.get("level"));
          if(profession.equals("Warrior"))
            account.allAccountCharactes.add(new Warrior(character_name,character_level,exp)) ;
          if(profession.equals("Mage"))
            account.allAccountCharactes.add(new Mage(character_name,character_level,exp)) ;
          if(profession.equals("Rogue"))
            account.allAccountCharactes.add(new Rogue(character_name,character_level,exp)) ;
        }
        accountsList.add(account);
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ParseException e) {
      e.printStackTrace();
    }
  }

  private void readStories()
  {
    JSONParser parser = new JSONParser();

    try {
      JSONArray a =
              (JSONArray)
                      parser.parse(
                              new FileReader(
                                      "src\\main\\java\\Teste\\stories.json"));



      List<String>  empty = new ArrayList<String>();

      List<String> enemy = new ArrayList<String>();

      List<String> shop = new ArrayList<String>();

      List<String> finish  = new ArrayList<String>();
      for (Object o : a) {

        JSONObject story = (JSONObject) o;
        String type = (String) story.get("type");
        String value = (String) story.get("value");
        if(type.equals("EMPTY"))
          empty.add(value);
        if(type.equals("ENEMY"))
          enemy.add(value);
        if(type.equals("SHOP"))
          shop.add(value);
        if(type.equals("FINISH"))
          finish.add(value);
      }

      StoriesMap.put(Cell.Story.EMPTY, empty);
      StoriesMap.put(Cell.Story.ENEMY,enemy);
      StoriesMap.put(Cell.Story.SHOP,shop);
      StoriesMap.put(Cell.Story.FINISH,finish);

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ParseException e) {
      e.printStackTrace();
    }
  }

  private Account testLogin()
  {
    Scanner in = new Scanner(System.in);
    String email;
    String password;
    int ok=1;
    while (ok == 1) {
      System.out.println("Cont:");
      email = in.nextLine();
      password = in.nextLine();
      for (Object i : accountsList) {
        Account test = (Account) i;
        if (test.playerInfo.playerCredentials.equals(email, password)) {
          return test;
        }
      }
    }

    in.close();
    return null;
  }

  private Character printAccountCharacters(Account  currentCharacter)
  {
    for(int i = 1;i<= currentCharacter.allAccountCharactes.size();i++) {
      System.out.println(i+". "+ currentCharacter.allAccountCharactes.get(i-1));
    }
    Scanner in = new Scanner(System.in);
    int chosenAccount=in.nextInt();

    return  currentCharacter.allAccountCharactes.get(chosenAccount-1);
  }

  private void showInventory(Character currentCharacter)
  {
    System.out.println(" ____________________\n" +
            "|______Inventory______|");
    for(int i=0;i<currentCharacter.Character_Inventory.potionList.size();i++)
      System.out.println((i+1)+". "+currentCharacter.Character_Inventory.potionList.get(i));
    System.out.println((currentCharacter.Character_Inventory.potionList.size()+1)+". Ca sa iesi din inventar");
    System.out.println("_____________________");
    Scanner in = new Scanner(System.in);
    int i = in.nextInt();
    if(i==currentCharacter.Character_Inventory.potionList.size()+1)
      return;

    Potion potion = currentCharacter.Character_Inventory.potionList.get(i-1);
    currentCharacter.Character_Inventory.removePotion(i-1);

    potion.usePotion(currentCharacter);


  }
  private void showInventoryHarcodat(Character currentCharacter)
  {
    System.out.println(" ____________________\n" +
            "|______Inventory______|");
    for(int i=0;i<currentCharacter.Character_Inventory.potionList.size();i++)
      System.out.println((i+1)+". "+currentCharacter.Character_Inventory.potionList.get(i));
    System.out.println((currentCharacter.Character_Inventory.potionList.size()+1)+". Ca sa iesi din inventar");
    System.out.println("_____________________");

    int alegere = 1;
    if(alegere==currentCharacter.Character_Inventory.potionList.size()+1)
      return;

    Potion potion = currentCharacter.Character_Inventory.potionList.get(alegere-1);
    currentCharacter.Character_Inventory.removePotion(alegere-1);
    potion.usePotion(currentCharacter);


  }
  public void theFightHarcodat(Character caracterCurent,Enemy enemy)
  {
    System.out.println(
            "\n" + " O       /\\___/\\\n" + "/|\\/     \\(o o)/\n" + "/ \\       \\VWV/\n");
    int tura=0,alegere=2,j=0;
    Random rand = new Random();

    while(caracterCurent.CurrentHealth>0&&enemy.CurrentHealth>0)
    {

      if(tura==0)
      { System.out.println("Character's turn");
        System.out.println("Character -> health: "+caracterCurent.CurrentHealth+"  mana: "+caracterCurent.CurrentMana+"\nEnemy -> health: "+enemy.CurrentHealth+"  mana: "+enemy.CurrentMana);
        System.out.println("1. Normal Atack\n2. Ability Atack\n3. Open Inventory");


        if(alegere==1)
        {System.out.println("1");
          enemy.CurrentHealth = enemy.CurrentHealth - caracterCurent.getDamage();

        }
        else if(alegere==2)
        {System.out.println("2");
          for(int i=0;i<caracterCurent.AbilityList.size();i++)
            System.out.println((i+1)+". "+ caracterCurent.AbilityList.get(i));
          System.out.println((caracterCurent.AbilityList.size()+1)+". Folosesti atac NORMAL");
          System.out.println("1");
            Spell spell = caracterCurent.AbilityList.get(0);
          if (caracterCurent.useAbility(spell) == 1) {
            enemy.accept(spell);
            caracterCurent.AbilityList.remove(0);
            }
          alegere=3;

        }else if(alegere==3)
        { System.out.println("3");
          this.showInventoryHarcodat(caracterCurent);
          System.out.println("1");
          alegere=2;
          j++;
          if(j==2)
            alegere=1;
        }
        tura=1;

      }
      else
      { System.out.println("Enemy's turn");
        System.out.println("Character -> health: "+caracterCurent.CurrentHealth+"  mana: "+caracterCurent.CurrentMana+"\nEnemy -> health: "+enemy.CurrentHealth+"  mana: "+enemy.CurrentMana);
        if(enemy.AbilityList.size()>0)
        {   int sansa25=rand.nextInt(100);
          if(sansa25%4==0)
          { int abilitateRandom=rand.nextInt(enemy.AbilityList.size());
            System.out.println(enemy.AbilityList);
            Spell spell=enemy.AbilityList.get(abilitateRandom);
            if (enemy.useAbility(spell) == 1) {
              enemy.AbilityList.remove(abilitateRandom);

              caracterCurent.accept(spell);
}
          }else {
            caracterCurent.CurrentHealth=caracterCurent.CurrentHealth-enemy.getDamage();
          }

        }else {
          caracterCurent.CurrentHealth=caracterCurent.CurrentHealth-enemy.getDamage();
        }

        tura=0;
      }
    }
    if(caracterCurent.CurrentHealth<=0)
      System.exit(0);

  }
  public void thefight(Character caracterCurent,Enemy enemy)
  {
    System.out.println(
            "\n" + " O       /\\___/\\\n" + "/|\\/     \\(o o)/\n" + "/ \\       \\VWV/\n");
    int tura=0,alegere;
    Random rand = new Random();
    Scanner in = new Scanner(System.in);
    while(caracterCurent.CurrentHealth>0&&enemy.CurrentHealth>0)
    {

      if(tura==0)
      { System.out.println("Character's turn");
        System.out.println("Character -> health: "+caracterCurent.CurrentHealth+"  mana: "+caracterCurent.CurrentMana+"\nEnemy -> health: "+enemy.CurrentHealth+"  mana: "+enemy.CurrentMana);
        System.out.println("1. Normal Atack\n2. Ability Atack\n3. Open Inventory");

        alegere=in.nextInt();
        if(alegere==1)
        {
          enemy.CurrentHealth = enemy.CurrentHealth - caracterCurent.getDamage();

        }
        else if(alegere==2)
        {
          for(int i=0;i<caracterCurent.AbilityList.size();i++)
            System.out.println((i+1)+". "+ caracterCurent.AbilityList.get(i));
          System.out.println((caracterCurent.AbilityList.size()+1)+". Folosesti atac NORMAL");
          alegere=in.nextInt();
          if(alegere==caracterCurent.AbilityList.size()+1)
          {
            enemy.CurrentHealth = enemy.CurrentHealth - caracterCurent.getDamage();
          } else {
            Spell spell = caracterCurent.AbilityList.get(alegere - 1);
            if(caracterCurent.useAbility(spell)==1){
            caracterCurent.AbilityList.remove(alegere - 1);

      enemy.accept(spell);
}
}
        }else if(alegere==3)
        {
          this.showInventory(caracterCurent);

        }
        tura=1;

      }
      else
      { System.out.println("Enemy's turn");
        System.out.println("Character -> health: "+caracterCurent.CurrentHealth+"  mana: "+caracterCurent.CurrentMana+"\nEnemy -> health: "+enemy.CurrentHealth+"  mana: "+enemy.CurrentMana);
        if(enemy.AbilityList.size()>0)
        {   int sansa25=rand.nextInt(100);
          if(sansa25%4==0)
          { int abilitateRandom=rand.nextInt(enemy.AbilityList.size());
            System.out.println(enemy.AbilityList);
            Spell spell=enemy.AbilityList.get(abilitateRandom);
            if (enemy.useAbility(spell) == 1) {
              enemy.AbilityList.remove(abilitateRandom);

              caracterCurent.accept(spell);
            }
          }else {
            caracterCurent.CurrentHealth=caracterCurent.CurrentHealth-enemy.getDamage();
         }

        }else {
          caracterCurent.CurrentHealth=caracterCurent.CurrentHealth-enemy.getDamage();
        }

        tura=0;
      }
    }
    if(caracterCurent.CurrentHealth<=0)
      System.exit(0);

  }
  public void printStories(Character caracterCurent,Grid grid)
  { System.out.println();

    Random rand = new Random();
    Cell celula= (Cell) ((ArrayList)grid.get(caracterCurent.Current_Ox)).get(caracterCurent.Current_Oy);
    int poveste;
    if(celula.CellType== Cell.Story.EMPTY)
    {
      poveste=rand.nextInt(0,StoriesMap.get(Cell.Story.EMPTY).size());
      System.out.println(StoriesMap.get(Cell.Story.EMPTY).get(poveste));
      int sansaMoneda=rand.nextInt(101);
      if(sansaMoneda%5==0&&celula.Visited==0){
        int banuti=rand.nextInt(1,15);
        caracterCurent.Character_Inventory.Coins =
                caracterCurent.Character_Inventory.Coins +banuti;
        System.out.println("Ai gasit "+banuti+" banuti prin nisipul argintiu!");
      }
      grid.printMap();
    }
    if(celula.CellType== Cell.Story.ENEMY)
    {
      poveste=rand.nextInt(0,StoriesMap.get(Cell.Story.ENEMY).size());
      System.out.println(StoriesMap.get(Cell.Story.ENEMY).get(poveste));
      if(celula.Visited==0)
        this.thefight(caracterCurent,(Enemy) celula.enemyORshop);
      int sansaMoneda=rand.nextInt(101);
      if (sansaMoneda % 5 != 0 && celula.Visited == 0) {
        int banuti=rand.nextInt(1,35);
        caracterCurent.Character_Inventory.Coins =
            caracterCurent.Character_Inventory.Coins +banuti;
     System.out.println("Ai castigat "+banuti+" banuti pentru invingerea inamicului!");
      }
      grid.printMap();
    }
    if(celula.CellType== Cell.Story.SHOP)
    { caracterCurent.Character_Inventory.printCoins();
      poveste=rand.nextInt(0,StoriesMap.get(Cell.Story.SHOP).size());
      Shop magazin= (Shop) celula.enemyORshop;
      System.out.println(StoriesMap.get(Cell.Story.SHOP).get(poveste));
      Scanner in = new Scanner(System.in);
      int index;

      while(true){
        magazin.printPotionList(caracterCurent);
        System.out.println((magazin.shopPotionList.size()+1)+". Ca sa iesi din Shop");
        index=in.nextInt();
        if(index==magazin.shopPotionList.size()+1)
          break;
      Potion potion=magazin.getPotion(index);
      int canBuyPotion=caracterCurent.testCoinsPotion(potion);
      if (canBuyPotion == 1) {
        magazin.boughtPotion(index);
      }
      }
      grid.printMap();
    }
    if(celula.CellType== Cell.Story.FINISH)
    {
      poveste=rand.nextInt(0,StoriesMap.get(Cell.Story.FINISH).size());
      System.out.println(StoriesMap.get(Cell.Story.FINISH).get(poveste));
      grid.printMap();
      System.out.println(
          "\n"
              + "    _    _                 _    _              _     _  _  _  _ \n"
              + "   /_\\  (_)  __  __ _  ___| |_ (_) __ _  __ _ | |_  | || || || |\n"
              + "  / _ \\ | | / _|/ _` |(_-<|  _|| |/ _` |/ _` ||  _| |_||_||_||_|\n"
              + " /_/ \\_\\|_| \\__|\\__,_|/__/ \\__||_|\\__, |\\__,_| \\__| (_)(_)(_)(_)\n"
              + "                                  |___/                         \n");
      System.exit(0);
    }

  }
  public void harcodareTastaP()
  {
    Scanner in = new Scanner(System.in);
    System.out.println("Apasati tasta P pentru a continua");
    in.nextLine();
  }
  public void testHarcodat(Grid grid, Character caracterCurent)
  {
    this.printStoriesHarcodat(grid,caracterCurent,0);
    //Se duce la dreapta de 3 ori
    grid.goEast();
    this.printStoriesHarcodat(grid,caracterCurent,0);

    grid.goEast();
    this.printStoriesHarcodat(grid,caracterCurent,0);

    grid.goEast();
   // this.printStories(grid.MyCharacter, grid);// cumpara o pot de viata si de mana
                                                // TREBUIE SA FACI O ALTA FUNCTIE PENTRU SHOP IN CARE SA TE INTREBI DACA E HARDCODAT SAU NU
    this.printStoriesHarcodat(grid,caracterCurent,0);
    grid.goEast(); // inca una la dreapta
    this.printStoriesHarcodat(grid,caracterCurent,0);

    // de 3 ori in jos
    grid.goSouth();
    this.printStoriesHarcodat(grid,caracterCurent,0);

    grid.goSouth();
    this.printStoriesHarcodat(grid,caracterCurent,0);

    grid.goSouth();
    this.printStoriesHarcodat(grid,caracterCurent,0); // da de inamic


    grid.goSouth(); // inca una in jos
    this.printStoriesHarcodat(grid,caracterCurent,0);// finish
  }
  public void testNormal(Grid grid, Character caracterCurent)
  {       Scanner in = new Scanner(System.in);
          int optiune;

    while (true)
    { this.printStories(grid.MyCharacter, grid);
      System.out.println("1. Go East   2. Go West\n3. Go North   4. Go South");
      optiune=in.nextInt();
      if(optiune==1)
      {int i=grid.goEast();
        if(i==0)
          continue;
      }
      if(optiune==2)
      {int i=grid.goWest();
        if(i==0)
          continue;
      }
      if(optiune==3)
      {int i=grid.goNorth();
        if(i==0)
          continue;
      }
      if(optiune==4)
      {int i=grid.goSouth();
        if(i==0)
          continue;
      }


    }
  }
  public void printStoriesHarcodat(Grid grid,Character caracterCurent,int comanda)
  {
    System.out.println();
   // this.harcodareTastaP();
    Random rand = new Random();
    Cell celula= (Cell) ((ArrayList)grid.get(caracterCurent.Current_Ox)).get(caracterCurent.Current_Oy);
    int poveste;
    if(celula.CellType== Cell.Story.EMPTY)
    {
      poveste=rand.nextInt(0,StoriesMap.get(Cell.Story.EMPTY).size());
      System.out.println(StoriesMap.get(Cell.Story.EMPTY).get(poveste));
      int sansaMoneda=rand.nextInt(101);
      if(sansaMoneda%5==0&&celula.Visited==0){
        int banuti=rand.nextInt(1,15);
        caracterCurent.Character_Inventory.Coins =
                caracterCurent.Character_Inventory.Coins +banuti;
        System.out.println("Ai gasit "+banuti+" banuti prin nisipul argintiu!");
      }
      grid.printMap();
    }
    if(celula.CellType== Cell.Story.ENEMY)
    {
      poveste=rand.nextInt(0,StoriesMap.get(Cell.Story.ENEMY).size());
      System.out.println(StoriesMap.get(Cell.Story.ENEMY).get(poveste));
      if(celula.Visited==0)
        this.theFightHarcodat(caracterCurent,(Enemy) celula.enemyORshop);
      int sansaMoneda=rand.nextInt(101);
      if (sansaMoneda % 5 != 0 && celula.Visited == 0) {
        int banuti=rand.nextInt(1,35);
        caracterCurent.Character_Inventory.Coins =
                caracterCurent.Character_Inventory.Coins +banuti;
        System.out.println("Ai castigat "+banuti+" banuti pentru invingerea inamicului!");
      }
      grid.printMap();
    }
    if(celula.CellType== Cell.Story.SHOP)
    {caracterCurent.Character_Inventory.printCoins();
      poveste=rand.nextInt(0,StoriesMap.get(Cell.Story.SHOP).size());
      Shop magazin= (Shop) celula.enemyORshop;
      System.out.println(StoriesMap.get(Cell.Story.SHOP).get(poveste));
      Scanner in = new Scanner(System.in);
      int index;
      int i=0;
      while(true){
        if(i==2)
        {break;}
        magazin.printPotionList(caracterCurent);
        System.out.println((magazin.shopPotionList.size()+1)+". Ca sa iesi din Shop");
        index=1;

        if(index==magazin.shopPotionList.size()+1)
          break;

        Potion potion=magazin.getPotion(index);
        int canBuyPotion=caracterCurent.testCoinsPotion(potion);
        if (canBuyPotion == 1) {
          magazin.boughtPotion(index);
        }
        i++;


        System.out.println(index);
      }
      grid.printMap();
    }
    if(celula.CellType== Cell.Story.FINISH)
    {
      poveste=rand.nextInt(0,StoriesMap.get(Cell.Story.FINISH).size());
      System.out.println(StoriesMap.get(Cell.Story.FINISH).get(poveste));
      grid.printMap();
      System.out.println(
              "\n"
                      + "    _    _                 _    _              _     _  _  _  _ \n"
                      + "   /_\\  (_)  __  __ _  ___| |_ (_) __ _  __ _ | |_  | || || || |\n"
                      + "  / _ \\ | | / _|/ _` |(_-<|  _|| |/ _` |/ _` ||  _| |_||_||_||_|\n"
                      + " /_/ \\_\\|_| \\__|\\__,_|/__/ \\__||_|\\__, |\\__,_| \\__| (_)(_)(_)(_)\n"
                      + "                                  |___/                         \n");
      System.exit(0);
    }

  }
  public void run(int index) {
    this.readAccounts();
    this.readStories();


    if(index==1)
    {  Grid grid=Grid.generateMap(5,5, index);

      grid.MyCharacter=this.accountsList.get(0).allAccountCharactes.get(0);
      this.testHarcodat(grid,this.accountsList.get(0).allAccountCharactes.get(0));

    }
    else
    { Grid grid=Grid.generateMap(7,6, index);

      Account contCurent=this.testLogin();
     Character caracterCurent=this.printAccountCharacters(contCurent);
     System.out.println(caracterCurent);
      grid.MyCharacter=caracterCurent;
      this.testNormal(grid,caracterCurent);
    }

  }


  public static Game getInstance() {
    if (game == null) game = new Game();
    return game;
  }
}