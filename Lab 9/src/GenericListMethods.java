import java.util.*;

public class GenericListMethods implements GenericInterface{
    @Override
    public <E extends Comparable<E>> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        LinkedHashSet<E> set = new LinkedHashSet<E>(list);
        return new ArrayList<E>(set);
    }

    @Override
    public <E extends Comparable<E>> E max(ArrayList<E> list) {
        return Collections.max(list);
    }

    @Override
    public <E extends Comparable<E>> int binarySearch(ArrayList<E> list, E key, int start, int end) {
            //conditia de oprire (x nu se afla in v)
            if (start > end)
                return -1;
            //etapa divide
            int mid = (start + end) / 2;
            //etapa stapaneste
            if (list.get(mid).equals(key))
                return mid;
            if (list.get(mid).compareTo(key) > 0)
                return binarySearch(list, key, start, mid - 1);
            return binarySearch(list, key, mid + 1, end);
    }
}
