public class Fractie {
    int numarator,numitor;
    public Fractie()
    {
        this(2,2);
    }
        public Fractie(int val1,int val2) {

            numarator=val1;
            numitor = val2;
        }
        static int gcd(int a, int b)
              {
                 if (a == 0)
                     return b;
                 return gcd(b%a, a);
              }
        public Object suma(Object obj)
        {
            Fractie c=new Fractie();
            Fractie d= (Fractie)obj;

            c.numitor=gcd(this.numitor,d.numitor);
            c.numitor=(this.numitor*d.numitor)/c.numitor;
            c.numarator=this.numarator*(c.numitor/this.numitor)+d.numarator*(c.numitor/d.numitor);
            return c;

        }
    public boolean equals(Object obj)
    {
        Fractie c= (Fractie)obj;
        if(this.numarator==c.numarator&&this.numitor==c.numitor)
        return true;
        return false;
    }


        public String toString()
        {
            return numarator + "/" + numitor;
        }
}
