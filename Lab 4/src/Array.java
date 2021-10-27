import java.util.Collections;
import java.util.Stack;
import java.util.Vector;

public class Array {
    //Vectorul in care se vor retine elementele
    private Vector vector;

    //Constructor clasei
    public Array() {
        //Instantierea vectorului cu elemente
        vector = new Vector();
    }

    //Metoda care adauga un element in vector, folosind pozitia curenta
    public void addElement(Integer x) {
        vector.add(x);
    }

    //Metoda care adauga un element in vector, tinand cont de pozitia indicata
    public void addElement(Integer x, int poz) {
        if(poz >= 0 && poz <= vector.size()) {
            vector.add(poz, x);
        }
    }

    //Metoda care returneaza elementul aflat in vector la pozitia indicata
    public int get(int poz) {
        int result;
        if(poz >= 0 && poz < vector.size()) {
            result = (int) vector.get(poz);
            return result;
        } else {
            return Integer.MIN_VALUE;
        }
    }

    //Metoda ce intoarce numarul de elemente din vector
    public int getSize() {
        return vector.size();
    }

    //Metoda pentru stergerea unui element din vector
    public boolean remove(Integer x) {
        return vector.remove(x);
    }

    //Metoda pentru stergerea elementului de pe pozitia pos din vector
    public Integer remove(int pos) {
        return (Integer) vector.remove(pos);
    }

    //Metoda uzitata pentru afisarea unui obiect de tip Array
    public String toString() {
        String result = "{";
        for(int i = 0; i < vector.size(); i++) {
            result += get(i) + ", ";
        }
        result += "}";
        return result;
    }

    public void sort() {
        Collections.sort(vector);
    }
}

class MyStack extends Array {



    public void push(int x)
    {
        super.addElement(x,0);
    }
    public int pop()
    {
        int x=super.get(0);
        super.remove(0);
        return x;

    }

}

class Main{

    public static void main(String[] args) {
            SortedArray sortedArray=new SortedArray();
            MyStack myStack=new MyStack();

            sortedArray.addElement(1);
            sortedArray.addElement(3);
            sortedArray.addElement(2);
            sortedArray.addElement(4);

            myStack.push(1);
            myStack.push(2);
            myStack.push(3);
            myStack.push(1);
            myStack.push(2);
            myStack.push(3);
            myStack.push(1);
            myStack.push(2);
            myStack.push(3);

            int x= myStack.pop();
            x= myStack.pop();
             x= myStack.pop();


            System.out.println(sortedArray);
            System.out.println(myStack);

    }
}