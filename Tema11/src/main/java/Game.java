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
  public void run() {
    this.readAccounts();
    this.readStories();
    Account contCurent=this.testLogin();

    Character caracterCurent=this.printAccountCharacters(contCurent);
    System.out.println(caracterCurent);
    Grid grid=Grid.generateMap(5,5);
    grid.MyCharacter=caracterCurent;
    grid.printMap();
    System.out.println();
    grid.goNorth();
    grid.printMap();
    System.out.println();
    grid.goSouth();
    grid.printMap();
    System.out.println();
    grid.goEast();
    grid.printMap();
    System.out.println();
    grid.goEast();
    grid.printMap();
    System.out.println();



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
