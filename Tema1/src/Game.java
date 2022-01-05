import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
  private static Game game;
  List<Account> accountsList = new ArrayList<Account>();
  Map<String, List<String>> myMaps = new HashMap<String, List<String>>();

  private Game(List<Account> accountsList, Map<String, List<String>> myMaps) {
    this.accountsList = accountsList;
    this.myMaps = myMaps;
  }
  public void run() {
    JSONParser jsonParser = new JSONParser();
  }
  public static Game getInstance(List<Account> accountsList, Map<String, List<String>> myMaps) {
    if (game == null) game = new Game(accountsList, myMaps);
    return game;
  }
}
