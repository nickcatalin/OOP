package lab08;


import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class Catalog extends TreeSet<Catalog.Student> {
    class Student implements Comparable {
        String name;
        double media;
        int clazz;

        public Student(String name, double media, int clazz) {
            this.name = name;
            this.media = media;
            this.clazz = clazz;
        }


        @Override
        public String toString() {
            return "Student{" +
                    "nume='" + name + '\'' +
                    ", media=" + media +
                    ", clazz=" + clazz +
                    '}';
        }



        @Override
        public int compareTo(Object o) {
            Student a=(Student)o;
            if(this.media==a.media)
                return this.name.compareTo(a.name);
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
        Student student=new Student(name,media,clazz);
        add(student);
    }
    public Student getStudent ( String name)
    {
        Iterator<Student> iterator=this.iterator();
        while(iterator.hasNext())
        {
            if(iterator.next().name.equals(name))
                return iterator.next();
        }
        return null;
    }
    public void removeStudent ( String name)
    {
        Iterator<Student> iterator=this.iterator();
        while(iterator.hasNext())
        {
            if(iterator.next().name.equals(name))
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
                return lol1.name.compareTo(lol2.name);
            }
        });
        for (Student student:this) {
            if(student.clazz==clazz)
                raspuns.add(student);
        }
        return raspuns;
    }
}