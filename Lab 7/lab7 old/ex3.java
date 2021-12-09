import java.util.Comparator;
import java.util.LinkedList;
import java.util.SortedSet;

public class ex3 extends LinkedList implements SortedSet {


    public ex3() {

    }

    public ex3(Comparator comparator) {

    }


    @Override
    public Comparator comparator() {
        return null;
    }

    @Override
    public SortedSet subSet(Object fromElement, Object toElement) {
        return null;
    }

    @Override
    public SortedSet headSet(Object toElement) {
        return null;
    }

    @Override
    public SortedSet tailSet(Object fromElement) {
        return null;
    }

    @Override
    public Object first() {
        return null;
    }

    @Override
    public Object last() {
        return null;
    }
}
