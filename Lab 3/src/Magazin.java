import java.util.Vector;

public class Magazin {
    String nume;

    Produs prod1=new Produs();
    Produs prod2=new Produs();
    Produs prod3=new Produs();


    public  Magazin(){
        this.nume = "Profi";
        this.prod1.pret=2.50;
        this.prod2.pret=1.50;
        this.prod3.pret=4.20;
        this.prod1.nume="Lays";
        this.prod2.nume="Chio";
        this.prod3.nume="Pepsi";
        this. prod1.cantitate=254;
        this. prod2.cantitate=231;
        this. prod3.cantitate=226;
    }

    public String toString()
    {
        return prod1.toString()+"\n"+prod2.toString()+"\n"+prod3.toString();
    }

    public double getTotalMagazin(){
        return (prod1.getTotalProdus()+prod2.getTotalProdus()+prod3.getTotalProdus());
    }



}
