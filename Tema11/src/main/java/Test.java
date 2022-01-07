import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Test {
  public static void main(String[] args) {
    Game game = Game.getInstance();
    int index=1;
    game.run(index);
    //game.print();


  }
}
