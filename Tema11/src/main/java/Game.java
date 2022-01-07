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

        JSONObject b = (JSONObject) person.get("credentials");
        String email = (String) b.get("email");
        String password = (String) b.get("password");

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
          String prof = (String) character.get("profession");
          int exp = ((Long) character.get("experience")).intValue();

          String character_name = (String) character.get("name");
          int character_level = Integer.parseInt((String) character.get("level"));
          if(prof.equals("Warrior"))
          account.allAccountCharactes.add(new Warrior(character_name,character_level,exp)) ;
          if(prof.equals("Mage"))
            account.allAccountCharactes.add(new Mage(character_name,character_level,exp)) ;
          if(prof.equals("Rogue"))
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

  private Character printAccountCharacters(Account contCurent)
  {
    for(int i = 1;i<=contCurent.allAccountCharactes.size();i++) {
      System.out.println(i+". "+contCurent.allAccountCharactes.get(i-1));
    }
    Scanner in = new Scanner(System.in);
    int contAles=in.nextInt();
    return contCurent.allAccountCharactes.get(contAles-1);
  }
  private void showInventory(Character caracterCurent)
  {
    System.out.println(" ____________________\n" +
            "|______Inventory______|");
    for(int i=0;i<caracterCurent.Character_Inventory.potionList.size();i++)
      System.out.println((i+1)+". "+caracterCurent.Character_Inventory.potionList.get(i));
    System.out.println((caracterCurent.Character_Inventory.potionList.size()+1)+". Ca sa iesi din inventar");
    System.out.println("_____________________");
    Scanner in = new Scanner(System.in);
    int alegere=in.nextInt();
    if(alegere==caracterCurent.Character_Inventory.potionList.size()+1)
      return;

    Potion potion = caracterCurent.Character_Inventory.potionList.get(alegere-1);
    caracterCurent.Character_Inventory.potionList.remove(alegere-1);
    System.out.println(caracterCurent.CurrentHealth+"    "+ caracterCurent.CurrentMana);
    potion.usePotion(caracterCurent);
    System.out.println(caracterCurent.CurrentHealth+"    "+ caracterCurent.CurrentMana);
  }
  public void printStories(Character caracterCurent,Grid grid)
  { System.out.println();
    caracterCurent.Character_Inventory.printCoins();
    Random rand = new Random();
    Cell celula= (Cell) ((ArrayList)grid.get(caracterCurent.Current_Ox)).get(caracterCurent.Current_Oy);
    int poveste;
    if(celula.CellType== Cell.Story.EMPTY)
    {
      poveste=rand.nextInt(0,StoriesMap.get(Cell.Story.EMPTY).size());
      int sansaMoneda=rand.nextInt(101);
      if(sansaMoneda%5==0&&celula.Visited==0)
        caracterCurent.Character_Inventory.Coins=caracterCurent.Character_Inventory.Coins+rand.nextInt(15);
      System.out.println(StoriesMap.get(Cell.Story.EMPTY).get(poveste));
      grid.printMap();
    }
    if(celula.CellType== Cell.Story.ENEMY)
    {
      poveste=rand.nextInt(0,StoriesMap.get(Cell.Story.ENEMY).size());
      System.out.println(StoriesMap.get(Cell.Story.ENEMY).get(poveste));
      int sansaMoneda=rand.nextInt(101);
      if(sansaMoneda%5!=0&&celula.Visited==0)
        caracterCurent.Character_Inventory.Coins=caracterCurent.Character_Inventory.Coins+rand.nextInt(35);
      grid.printMap();
    }
    if(celula.CellType== Cell.Story.SHOP)
    {
      poveste=rand.nextInt(0,StoriesMap.get(Cell.Story.SHOP).size());
      Shop magazin= (Shop) celula.enemyORshop;
      System.out.println(StoriesMap.get(Cell.Story.SHOP).get(poveste));


      Potion potion=magazin.getPotion(caracterCurent);
      if(potion!=null)
      caracterCurent.Character_Inventory.addPotion(potion);
      grid.printMap();
    }
    if(celula.CellType== Cell.Story.FINISH)
    {
      poveste=rand.nextInt(0,StoriesMap.get(Cell.Story.FINISH).size());
      System.out.println(StoriesMap.get(Cell.Story.FINISH).get(poveste));
      grid.printMap();
      System.exit(0);
    }

  }

  public void run() {
    this.readAccounts();
    this.readStories();
    Account contCurent=this.testLogin();

    Character caracterCurent=this.printAccountCharacters(contCurent);
    System.out.println(caracterCurent);
    Grid grid=Grid.generateMap(5,5);
    grid.MyCharacter=caracterCurent;
    grid.printMap();
    this.printStories(grid.MyCharacter, grid);

    grid.goEast();
    this.printStories(grid.MyCharacter, grid);
    this.showInventory(caracterCurent);
    grid.goEast();
    this.printStories(grid.MyCharacter, grid);

    grid.goEast();
    this.printStories(grid.MyCharacter, grid);
    this.printStories(grid.MyCharacter, grid);
    this.showInventory(caracterCurent);
    this.showInventory(caracterCurent);
    grid.goEast();
    this.printStories(grid.MyCharacter, grid);

    grid.goSouth();
    this.printStories(grid.MyCharacter, grid);

    grid.goSouth();
    this.printStories(grid.MyCharacter, grid);

    grid.goSouth();
    this.printStories(grid.MyCharacter, grid);


    grid.goSouth();
    this.printStories(grid.MyCharacter, grid);


  }
  public void print() {

    for(Object i: accountsList)
    {
      Account test=(Account) i;

      System.out.println(test.allAccountCharactes);

    }

  }

  public static Game getInstance() {
    if (game == null) game = new Game();
    return game;
  }
}
