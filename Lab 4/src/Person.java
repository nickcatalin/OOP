import java.util.Vector;

public class Person {
String name,address;
    public Person(){
        this.name = "";
        this.address = "";
    }
    public Person(String name,String address) {
        this.name = name;
        this.address = address;
    }
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String toString(){
        return (name + " " + address);
    }
}

class Student extends Person {

    Vector<String> courses=new Vector<String>();
    Vector<Integer> grades=new Vector<Integer>();

    public Student( String name, String address)
    {
        super.name = name;
        super.address = address;

    }
    public String toString(){
        return (name + " " + address+" "+ courses+" "+grades);
    }
    public void addCourseGrade(String course,int grade)
    {
        courses.add(course);
        grades.add(grade);
    }
    public void printGrades(){
        System.out.println(grades);
    }
    public double getAverageGrade(){

        int suma=0;
        for(int i : grades)
        {
            suma=suma+i;
        }
        return suma/grades.size();
    }


}
class Teacher extends Person {
    Vector<String> courses;

    public Teacher( String name, String address)
    {
        super.name = name;
        super.address = address;

    }
    public boolean addCourse(String course)
    {   if(courses.contains(course)!=false) {
        courses.add(course);
            return true;}
        return false;
    }
    public boolean removeCourse(String course)
    {
        if(courses.contains(course)==true)
        {   courses.remove(course);
            return true;

        }
        return false;
    }



    public String toString(){
        return (name + " " + address+" "+ courses);
    }

}
class Test4 {
    public static void main(String args[]) {
        Person student, teacher, person;
        student = new Student("Popescu Ion", "Bucuresti");
        teacher = new Teacher("Ionescu Gigel", "Bucuresti");
        person = new Person("Maria", "Iasi");
        assert (person.getName().equals("Maria")) : "Metoda getName din clasa Person nu este implementata corect";
        assert (((Teacher) teacher).addCourse("Programare")) : "Metoda addCourse din clasa Teacher nu este " +
                "implementata corect";
        assert (((Teacher) teacher).addCourse("Algoritmica")) : "Metoda addCourse din clasa Teacher nu este " +
                "implementata corect";
        assert (((Teacher) teacher).addCourse("Matematica")) : "Metoda addCourse din clasa Teacher nu este " +
                "implementata corect";
        assert (!((Teacher) teacher).addCourse("Programare")) : "Metoda addCourse din clasa Teacher nu este " +
                "implementata corect";
        assert (((Teacher) teacher).removeCourse("Programare")) : "Metoda addCourse din clasa Teacher nu este " +
                "implementata corect";
        assert (!((Teacher) teacher).addCourse("Programare")) : "Metoda addCourse din clasa Teacher nu este " +
                "implementata corect";
        ((Student) student).addCourseGrade("Programare", 10);
        ((Student) student).addCourseGrade("Algoritmica", 9);
        ((Student) student).addCourseGrade("Matematica", 8);
        assert (Math.abs(((Student) student).getAverageGrade() - 9.00) <= 0.001) : "Metoda getAverageGrade din clasa " +
                "Student nu a fost implementat corect";
        ((Student) student).printGrades();
        //Ce metoda toString se va apela? Din ce clasa?
        System.out.println(student);
        System.out.println(person);
        System.out.println("Felicitari! Problema a fost rezolvata corect!");
    }
}
