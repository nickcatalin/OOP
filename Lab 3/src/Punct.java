import static java.lang.Math.sqrt;

public class Punct {

    private int x,y;

    public  Punct(){
        x=0;
        y=0;
    }

    int getX(){
        return x;
    }
    int getY(){
        return y;
    }
    void setX(int x){
        this.x=x;
    }
    void setY(int y){
        this.y=y;
    }
    public String toString(){
        return "("+x+", "+y+")";
    }
    double distance(int x, int y)
    {

        return sqrt((this.x-x)*(this.x-x) + (this.y-y)*(this.y-y));
    }
    double distance(Punct p1)
    {

        return sqrt((this.x-p1.x)*(this.x-p1.x) + (this.y-p1.y)*(this.y-p1.y));
    }




}
