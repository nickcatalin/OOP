package lab66;

import javax.print.attribute.standard.Media;
import java.util.Vector;

public class Student implements Persoana{

    private String name;
    private Vector<Double> medii=new Vector<Double>();

    public double calculMedieGenerala(){

        double MediaGenerala=0.0;

        for(Double i:medii)
        {
            MediaGenerala = MediaGenerala+i;
        }
        MediaGenerala=MediaGenerala/medii.size();
        return MediaGenerala;

    }
    public String getNume()
    {
        return this.name;
    }
    public void setNume(String nume)
    {
        this.name = nume;
    }
    public void addMedie(double medie)
    {
        this.medii.add(medie);
    }
    public static int stringCompare(String str1,
                                    String str2)
    {
        for (int i = 0; i < str1.length() &&
                i < str2.length(); i++) {
            if ((int)str1.charAt(i) ==
                    (int)str2.charAt(i)) {
                continue;
            }
            else {
                return (int)str1.charAt(i) -
                        (int)str2.charAt(i);
            }
        }
        if (str1.length() < str2.length()) {
            return (str1.length()-str2.length());
        }
        else if (str1.length() > str2.length()) {
            return (str1.length()-str2.length());
        }
        else {
            return 0;
        }
    }



    @Override
    public int compareTo(Object o) {
        Student student = (Student) o;
        if(stringCompare(this.name,student.name)>0)
            return 1;
        else
        if(stringCompare(this.name,student.name)<0)
            return -1;

        if(this.calculMedieGenerala()>student.calculMedieGenerala())
            return 1;
        return -1;
    }

    public String toString(){
        return this.name +" "+ this.calculMedieGenerala();
    }
}


