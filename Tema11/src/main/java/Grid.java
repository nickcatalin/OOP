import java.util.ArrayList;
import java.util.List;

public class Grid extends ArrayList {
List<List<Cell>> Map;
int lenght,width;
Character MyCharacter;
private static Grid grid;

    private Grid()
    {

    }



    public void generateMap()
    {

    }

    public static Grid getInstance() {
        if (grid == null) grid = new Grid();
        return grid;
    }
}
