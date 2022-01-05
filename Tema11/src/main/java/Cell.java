public class Cell {

    enum Story {
        EMPTY,
        ENEMY,
        SHOP,
        FINISH
    }
    int Ox,Oy;
    Story CellType;
    CellElement enemyORshop;
    int Visited;



}

