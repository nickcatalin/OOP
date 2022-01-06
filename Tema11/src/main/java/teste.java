



// Java program to demonstrate working of Scanner in Java
import java.util.Scanner;

class GetInputFromUser {
    public static void main(String args[])
    {
        // Using Scanner for Getting Input from User
        Scanner in = new Scanner(System.in);
    while (true) {
      String s = in.nextLine();
      System.out.println("You entered string " + s);

    if(s.equals("Ana"))
         break;
    }


        // closing scanner
        in.close();
    }
}















//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//
//class GetInputFromUser {
//
//    public static void main(String args[]) throws IOException, ParseException {
//        // Using Scanner for Getting Input from User
//        Map<Cell.Story, List<String>> StoriesMap = new HashMap<Cell.Story, List<String>>();
//        List<String> empty = new ArrayList<String>();
//
//        List<String> enemy = new ArrayList<String>();
//
//        List<String> shop = new ArrayList<String>();
//
//        List<String> finish  = new ArrayList<String>();
//        JSONParser parser = new JSONParser();
//
//        JSONArray  a =
//                (JSONArray)
//                        parser.parse(
//                                new FileReader(
//                                        "src\\main\\java\\Teste\\stories.json"));
//
//        for (Object o : a) {
//
//            JSONObject story = (JSONObject) o;
//            String type = (String) story.get("type");
//            String value = (String) story.get("value");
//            if(type.equals("EMPTY"))
//                empty.add(value);
//            if(type.equals("ENEMY"))
//                enemy.add(value);
//            if(type.equals("SHOP"))
//                shop.add(value);
//            if(type.equals("FINISH"))
//                finish.add(value);
//
//
//        }
//
//        StoriesMap.put(Cell.Story.EMPTY, empty);
//        StoriesMap.put(Cell.Story.ENEMY,enemy);
//        StoriesMap.put(Cell.Story.SHOP,shop);
//        StoriesMap.put(Cell.Story.FINISH,finish);
//
//        for(Map.Entry m:StoriesMap.entrySet()){
//            System.out.println(m.getKey()+" "+m.getValue());
//        }
//       Random r = new Random();
//        System.out.println(r.nextInt(22,28));
//    }}