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
  public void run() {
    JSONParser parser = new JSONParser();

    try {
      JSONArray a =
          (JSONArray)
              parser.parse(
                  new FileReader(
                      "src\\main\\java\\Teste\\accounts.json"));


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
        account.allGamesNumber = (int) person.get("maps_completed");

        JSONArray characters = (JSONArray) person.get("characters");
        for (Object ch : characters) {
          JSONObject character = (JSONObject) ch;
          String prof = (String) character.get("profession");
          int exp = (int) character.get("experience");
          String character_name = (String) character.get("name");
          int character_level = (int) character.get("level");
          //account.allAccountCharactes.add(new Character(character_name,prof,character_level,exp)) ;
        }
        accountsList.add(account);
      }
      List<String>  empty = new ArrayList<String>();

      List<String> enemy = new ArrayList<String>();

      List<String> shop = new ArrayList<String>();

      List<String> finish  = new ArrayList<String>();

      a =
              (JSONArray)
                      parser.parse(
                              new FileReader(
                                      "src\\main\\java\\Teste\\stories.json"));

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
