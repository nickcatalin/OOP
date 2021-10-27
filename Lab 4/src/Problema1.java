class Patrulater {
    public int latura1, latura2, latura3, latura4;
    public double unghi1, unghi2, unghi3, unghi4;

    public Patrulater() {
        this(0, 0, 0, 0);
    }

    public Patrulater(int latura1, int latura2, int latura3, int latura4) {
        this.latura1 = latura1;
        this.latura2 = latura2;
        this.latura3 = latura3;
        this.latura4 = latura4;
    }

    public Patrulater(double unghi1, double unghi2, double unghi3, double unghi4) {
        this(0, 0, 0, 0, unghi1, unghi2, unghi3, unghi4);
    }

    public Patrulater(int latura1, int latura2, int latura3, int latura4,
                      double unghi1, double unghi2, double unghi3, double unghi4) {
        this(latura1, latura2, latura3, latura4);
        this.unghi1 = unghi1;
        this.unghi2 = unghi2;
        this.unghi3 = unghi3;
        this.unghi4 = unghi4;
    }

    public int perimetru() {
        int result;
        result = latura1 + latura2 + latura3 + latura4;
        return result;
    }

}
class Paralelogram extends Patrulater
{

    public Paralelogram(int lungime,int latime,double unghi1,double unghi2) {

        super(lungime,latime,lungime,latime,unghi1,unghi2,unghi1,unghi2);

    }

    public double ariePralelogram(){

        double AriePralelogram;
        AriePralelogram=this.latura1*this.latura2*Math.sin(unghi1);
        return AriePralelogram;

    }

}
class Romb extends Paralelogram{

    public double diag1,diag2;
    public Romb(int latura,double unghi1,double unghi2,double diag1,double diag2)
    {
        super(latura,latura,unghi1,unghi2);
        this.diag1=diag1;
        this.diag2=diag2;

    }
    public double arieRomb(){
        double ArieRomb;
        ArieRomb=(this.diag1*this.diag2)/2;
        return ArieRomb;
    }
}
class Dreptunghi extends Paralelogram{
    public Dreptunghi(int latura1,int latura2) {
        super(latura1,latura2,90,90);


    }
    public int arieDreptunghi()
    {
        return this.latura1*this.latura2;
    }
}

class Patrat extends Dreptunghi{
    public Patrat(int latura)
    {
        super(latura,latura);

    }
    public int ariePatrat(){

        return this.latura1*this.latura1;
    }
}
public class Problema1{
    public static void main(String[] args) {
        Paralelogram p1 = new Paralelogram(3,2,120,60);
        Romb r1 = new Romb(2,90,90,2.5,2.5);
        Dreptunghi d1=new Dreptunghi(3,4);
        Patrat pt1=new Patrat(3);

        System.out.println("Perimetru!!");
        System.out.println(p1.perimetru());
        System.out.println(r1.perimetru());
        System.out.println(d1.perimetru());
        System.out.println(pt1.perimetru());

        System.out.println("Arie!!");
        System.out.println(p1.ariePralelogram());
        System.out.println(r1.arieRomb());
        System.out.println(d1.arieDreptunghi());
        System.out.println(pt1.ariePatrat());

    }
}