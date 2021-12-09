package com.company;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class Catalog extends TreeSet<Catalog.Student> {
    class Student implements Comparable {
        String nume;
        double media;
        int clazz;

        public Student(String nume, double media, int clazz) {
            this.nume = nume;
            this.media = media;
            this.clazz = clazz;
        }

//        @Override
//        public int compare(Object o1, Object o2) {
//            Student lol1=(Student)o1;
//            Student lol2=(Student)o2;
//            if(lol1.media==lol2.media)
//                return lol1.nume.compareTo(lol2.nume);
//            return Double.compare(lol1.media,lol2.media);
//        }
        @Override
        public String toString() {
            return "Student{" +
                    "nume='" + nume + '\'' +
                    ", media=" + media +
                    ", clazz=" + clazz +
                    '}';
        }



        @Override
        public int compareTo(Object o) {
            Student a=(Student)o;
                if(this.media==a.media)
                    return this.nume.compareTo(a.nume);
                return Double.compare(this.media,a.media);
            }
        }

    public Catalog() {
    }

    public Catalog(Comparator<? super Student> comparator) {
        super(comparator);
    }
    public void addStudent(String name,double media,int clazz)
    {
        Student Ovidiu=new Student(name,media,clazz);
            add(Ovidiu);
    }
    public Student getStudent ( String name)
    {
        Iterator<Student> iterator=this.iterator();
        while(iterator.hasNext())
        {
            if(iterator.next().nume.equals(name))
                return iterator.next();
        }
        return null;
    }
    public void removeStudent ( String name)
    {
        Iterator<Student> iterator=this.iterator();
        while(iterator.hasNext())
        {
            if(iterator.next().nume.equals(name))
                iterator.remove();
        }
    }
    public Catalog byClass (int clazz )
    {
        Catalog raspuns=new Catalog(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                Student lol1=(Student)o1;
                Student lol2=(Student)o2;
                return lol1.nume.compareTo(lol2.nume);
            }
        });
        for (Student student:this) {
            if(student.clazz==clazz)
                raspuns.add(student);
        }
        return raspuns;
    }
}
