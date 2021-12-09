package lab66;

import java.io.*;
import java.nio.file.Files;
import java.util.List;
import java.util.Vector;

public class Filtru implements FileFilter {


   public static Vector<String> extensions = new Vector<String>();
    public static  Vector<String> words = new Vector<String>();
public static void main(String[] args) throws IOException {

    RandomAccessFile file = new RandomAccessFile("/Users/cata/Desktop/lab66/src/lab66/extension.in","r");

    String str;
    while ((str = file.readLine()) != null) {
        extensions.add(str);
    }
    file.close();
    System.out.println(extensions);


    RandomAccessFile file1 = new RandomAccessFile("/Users/cata/Desktop/lab66/src/lab66/words.in","r");


    while ((str = file1.readLine()) != null) {
        words.add(str);
    }
    file1.close();
    System.out.println(words);




}

    @Override
    public boolean accept(File pathname) {
        return false;
    }
}
