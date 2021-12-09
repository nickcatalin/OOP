package lab66;

import java.util.Collections;
import java.util.Vector;

public class Problema3 {

public static void main(String[] args) {
    Student student0 = new Student();
    student0.setNume("Alex");
    student0.addMedie(10);
    student0.addMedie(10);
    student0.addMedie(9.5);
    student0.addMedie(7.5);

    Student student1=new Student();
    student1.setNume("Trifu");
    student1.addMedie(9.2);
    student1.addMedie(6);
    student1.addMedie(9.5);
    student1.addMedie(8.5);

    Student student2=new Student();
    student2.setNume("Nicola");
    student2.addMedie(9.5);
    student2.addMedie(10);
    student2.addMedie(6.5);
    student2.addMedie(9.5);

    Student student3=new Student();
    student3.setNume("Vlad");
    student3.addMedie(7);
    student3.addMedie(8);
    student3.addMedie(9.5);
    student3.addMedie(6.5);

    Vector<Student> Students = new Vector<Student>();
    Students.add(0,student0);
    Students.add(1,student1);
    Students.add(2,student2);
    Students.add(3,student3);

    Collections.sort(Students);
    System.out.println(Students);
}

}
