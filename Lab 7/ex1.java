import java.io.*;
import java.util.*;

public class ex1 {
    public static void main(String[] args){
        ex1 ex1 = new ex1();
        TreeSet<String> t = ex1.printWords(args[0]);
        System.out.println(t + "\n");
        System.out.println(ex1.printWordsComparator(t));
    }

    public TreeSet<String> printWords (String s) {
        Scanner wordIn = new Scanner("");
        try {
            File f = new File(s);
            System.out.println(f.getAbsolutePath());
            wordIn = new Scanner(new File(s));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Vector<String> words = new Vector<>();
        while (wordIn.hasNext())
            words.add(wordIn.next());
        return new TreeSet<>(words);
    }

    public TreeSet<String> printWordsComparator(TreeSet<String> t) {
        TreeSet<String> r=new TreeSet<String>(Collections.reverseOrder());
        r.addAll(t);
        return r;}
}
