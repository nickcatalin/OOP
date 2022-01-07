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
    public void setVisited()
    {
        this.Visited=1;
    }
    public Cell(Story Type,int Ox,int Oy){


        this.CellType=Type;
        this.Visited=0;
        this.Ox=Ox;
        this.Oy=Oy;

    }
    public Cell(Story Type,int Ox,int Oy,CellElement enemyORShop){

        this.CellType=Type;
        this.Visited=0;
        this.Ox=Ox;
        this.Oy=Oy;
        this.enemyORshop=enemyORShop;


    }


}

