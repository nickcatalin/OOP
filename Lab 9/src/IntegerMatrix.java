import java.util.*;

public class IntegerMatrix extends AMatrix<Integer>{
    AMatrix<Integer> matrix;

    //afisare
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (ArrayList<Integer> linie : matrix) {
            for (Integer element : linie)
                result.append(element).append(" ");
            result.append("\n");
        }
        return result.toString();
    }

    //sum
    public Integer sum(Integer obj1, Integer obj2) {
        return obj1 + obj2;
    }

    //adunare
    public AMatrix<Integer> addition(AMatrix<Integer> m) {
        AMatrix<Integer> result = new IntegerMatrix();
        Iterator<ArrayList<Integer>> i1 = m.iterator();
        Iterator<ArrayList<Integer>> i2 = matrix.iterator();
        while (i1.hasNext() && i2.hasNext()) {
            ArrayList<Integer> resultLinie = new ArrayList<>();
            Iterator<Integer> j1 = i1.next().iterator();
            Iterator<Integer> j2 = i2.next().iterator();
            while (j1.hasNext() && j2.hasNext())
                resultLinie.add(result.sum(j1.next(), j2.next()));
            result.add(resultLinie);
        }
        return result;
    }
}
