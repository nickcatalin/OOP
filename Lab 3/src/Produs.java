public class Produs {

    String nume;
    double pret;
    int cantitate;
    public String toString()
    {
        return "Produs "+nume+" "+pret+" "+cantitate;
    }
    public double getTotalProdus() {
        double cantitatedouble = (double) cantitate;

        return cantitatedouble*pret;
    }
}
