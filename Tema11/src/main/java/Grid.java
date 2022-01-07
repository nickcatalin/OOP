import java.util.ArrayList;
import java.util.List;

public class Grid extends ArrayList {
List<Cell> Map;
int lenght,width;
Character MyCharacter;
private static Grid grid;

    private Grid()
    {


    }

    private Grid(int Lenght,int Width)
    {
        this.lenght =Lenght;
        this.width = Width;
    }
    private void HelperGrid()
    {

        for (int i = 0; i <this.lenght ; i++) {
            this.Map = new ArrayList<>();
            for (int j = 0; j <this.width ; j++) {
                Cell Celula = new Cell(Cell.Story.EMPTY, i, j);

                //Cell celula= (Cell) ((ArrayList)this.get(i)).get(j);
                this.Map.add(Celula);
            }
           this.add(this.Map);

        }
    }
    private  void generateTestMap()
    {   this.HelperGrid();
     ((ArrayList) this.get(0)).set(3, new Cell(Cell.Story.SHOP, 0, 3, new Shop()));
     ((ArrayList) this.get(1)).set(3, new Cell(Cell.Story.SHOP, 1, 3, new Shop()));
     ((ArrayList) this.get(2)).set(0, new Cell(Cell.Story.SHOP, 2, 0, new Shop()));
     ((ArrayList) this.get(3)).set(4, new Cell(Cell.Story.ENEMY, 3, 4, new Enemy()));
     ((ArrayList) this.get(4)).set(4, new Cell(Cell.Story.FINISH, 4, 4));


    }
    public void printMap()
    {
        for (int i = 0; i <this.lenght ; i++) {

            for (int j = 0; j <this.width ; j++) {
                Cell celula= (Cell) ((ArrayList)this.get(i)).get(j);

                if(grid.MyCharacter.Current_Ox==i&&grid.MyCharacter.Current_Oy==j){
                    System.out.print("P  ");
                    ((Cell) ((ArrayList)this.get(i)).get(j)).setVisited();
                continue;}

                if(celula.CellType== Cell.Story.FINISH)
                    if(celula.Visited==0)
                        System.out.print("?  ");
                    else
                        System.out.print("F  ");


                if(celula.CellType== Cell.Story.EMPTY)
                    if(celula.Visited==0)
                        System.out.print("?  ");
                    else
                        System.out.print("N  ");

                if(celula.CellType== Cell.Story.SHOP||celula.CellType== Cell.Story.ENEMY)
                    if(celula.Visited==0)
                        System.out.print("?  ");
                    else
                        System.out.print(celula.enemyORshop.toCharacter());

            }
            System.out.println();

        }
    }

    public static Grid generateMap(int Lenght,int Width) {
        if (grid == null) grid = new Grid(Lenght,Width);
        grid.generateTestMap();

        return grid;
    }
    public void goSouth()
    {
    if (this.MyCharacter.Current_Ox == this.lenght - 1) {
      System.out.println("Cazi de pe harta\n");
            return;}
    this.MyCharacter.Current_Ox++;
    }
    public void goNorth()
    {
        if (this.MyCharacter.Current_Ox == 0) {
            System.out.println("Cazi de pe harta\n");
            return;}
        this.MyCharacter.Current_Ox--;
    }
    public void goEast()
    {
        if (this.MyCharacter.Current_Oy == this.width - 1) {
            System.out.println("Cazi de pe harta\n");
            return;}
        this.MyCharacter.Current_Oy++;
    }
    public void goWest()
    {
        if (this.MyCharacter.Current_Ox == 0) {
            System.out.println("Cazi de pe harta\n");
            return;}
        this.MyCharacter.Current_Oy--;
    }
}