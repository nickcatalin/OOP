import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@SuppressWarnings("ALL")
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
    // metoda ce genereaza o harta cu toate celulele goale
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

    // metoda ce adauga shop, enemy si finish pe harta de trebuie harcodata
    private  void generateTestMap()
    {   this.HelperGrid();
     ((ArrayList) this.get(0)).set(3, new Cell(Cell.Story.SHOP, 0, 3, new Shop()));
     ((ArrayList) this.get(1)).set(3, new Cell(Cell.Story.SHOP, 1, 3, new Shop()));
     ((ArrayList) this.get(2)).set(0, new Cell(Cell.Story.SHOP, 2, 0, new Shop()));
     ((ArrayList) this.get(3)).set(4, new Cell(Cell.Story.ENEMY, 3, 4, new Enemy()));
     ((ArrayList) this.get(4)).set(4, new Cell(Cell.Story.FINISH, 4, 4));


    }
    // metoda ce pune random numarul de shopuri si de inamici pe harta goala
    private void generateRandomMap()
    {
        Random rand = new Random();
        this.HelperGrid();
        Cell celula;
        int i,j;
        i=rand.nextInt(this.lenght);
        j=rand.nextInt(this.width);
        ((ArrayList) this.get(i)).set(j, new Cell(Cell.Story.SHOP, i, j, new Shop()));
        i=rand.nextInt(this.lenght);
        j=rand.nextInt(this.width);
        celula= (Cell) ((ArrayList)this.get(i)).get(j);
        while(celula.CellType!= Cell.Story.EMPTY)
        {
            i=rand.nextInt(this.lenght);
            j=rand.nextInt(this.width);
            celula= (Cell) ((ArrayList)this.get(i)).get(j);
        }
        ((ArrayList) this.get(i)).set(j, new Cell(Cell.Story.FINISH, i, j));
        i=rand.nextInt(this.lenght);
        j=rand.nextInt(this.width);
        celula= (Cell) ((ArrayList)this.get(i)).get(j);
        while(celula.CellType!= Cell.Story.EMPTY)
        {
            i=rand.nextInt(this.lenght);
            j=rand.nextInt(this.width);
           celula= (Cell) ((ArrayList)this.get(i)).get(j);
        }
        ((ArrayList) this.get(i)).set(j, new Cell(Cell.Story.SHOP, i, j, new Shop()));
        i=rand.nextInt(this.lenght);
        j=rand.nextInt(this.width);
        celula= (Cell) ((ArrayList)this.get(i)).get(j);
        while(celula.CellType!= Cell.Story.EMPTY)
        {
            i=rand.nextInt(this.lenght);
            j=rand.nextInt(this.width);
            celula= (Cell) ((ArrayList)this.get(i)).get(j);
        }
        ((ArrayList) this.get(i)).set(j, new Cell(Cell.Story.ENEMY, i, j, new Enemy()));
        i=rand.nextInt(this.lenght);
        j=rand.nextInt(this.width);
        celula= (Cell) ((ArrayList)this.get(i)).get(j);
        while(celula.CellType!= Cell.Story.EMPTY)
        {
            i=rand.nextInt(this.lenght);
            j=rand.nextInt(this.width);
            celula= (Cell) ((ArrayList)this.get(i)).get(j);
        }
        ((ArrayList) this.get(i)).set(j, new Cell(Cell.Story.ENEMY, i, j, new Enemy()));
        i=rand.nextInt(this.lenght);
        j=rand.nextInt(this.width);
        celula= (Cell) ((ArrayList)this.get(i)).get(j);
        while(celula.CellType!= Cell.Story.EMPTY)
        {
            i=rand.nextInt(this.lenght);
            j=rand.nextInt(this.width);
            celula= (Cell) ((ArrayList)this.get(i)).get(j);
        }
        ((ArrayList) this.get(i)).set(j, new Cell(Cell.Story.ENEMY, i, j, new Enemy()));
        i=rand.nextInt(this.lenght);
        j=rand.nextInt(this.width);
        celula= (Cell) ((ArrayList)this.get(i)).get(j);
        while(celula.CellType!= Cell.Story.EMPTY)
        {
            i=rand.nextInt(this.lenght);
            j=rand.nextInt(this.width);
            celula= (Cell) ((ArrayList)this.get(i)).get(j);
        }
        ((ArrayList) this.get(i)).set(j, new Cell(Cell.Story.ENEMY, i, j, new Enemy()));


    }
    // metoda ce printeaza harta
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

    public static Grid generateMap(int Lenght,int Width,int gameType) {
        if (grid == null) grid = new Grid(Lenght,Width);
       if(gameType==1)
        grid.generateTestMap();
       else
           grid.generateRandomMap();
        return grid;
    }
    // metodele de miscare
    public int goSouth()
    {
    if (this.MyCharacter.Current_Ox == this.lenght - 1) {
      System.out.println("Cazi de pe harta\n");
            return 0;}
    this.MyCharacter.Current_Ox++;
        return 1;
    }
    public int goNorth()
    {
        if (this.MyCharacter.Current_Ox <= 0) {
            System.out.println("Cazi de pe harta\n");
            return 0;}
        this.MyCharacter.Current_Ox--;
        return 1;
    }
    public int goEast()
    {
        if (this.MyCharacter.Current_Oy == this.width - 1) {
            System.out.println("Cazi de pe harta\n");
            return 0;}
        this.MyCharacter.Current_Oy++;
        return 1;
    }
    public int goWest()
    {
        if (this.MyCharacter.Current_Ox <= 0) {
            System.out.println("Cazi de pe harta\n");
            return 0;}
        this.MyCharacter.Current_Oy--;
        return 1;
    }

}
