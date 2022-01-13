
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Crunchify.com
 * How to write JSON object to File in Java?
 */

 class testtt {

    private void readAccounts() throws IOException {
        JSONParser parser = new JSONParser();

        try {
            JSONArray a =
                    (JSONArray)
                            parser.parse(
                                    new FileReader(
                                            "src\\main\\java\\Teste\\test.json"));
            FileWriter file = new FileWriter("src\\main\\java\\Teste\\test.json");
            String myname="cata";
            String mypassword="cata";
            String charactername="Odysseus Prisco";
            for (Object o : a) {

                JSONObject person = (JSONObject) o;

                JSONObject credentials = (JSONObject) person.get("credentials");
                String email = (String) credentials.get("email");
                String password = (String) credentials.get("password");

                if(myname.equals(email)&&mypassword.equals(password))
                {
                    Integer mape = Integer.parseInt((String) person.get("maps_completed"));
                    System.out.println(mape);
                    mape++;

                    person.replace("maps_completed", mape.toString());
                JSONArray characters = (JSONArray) person.get("characters");
                    for (Object ch : characters) {
                      JSONObject character = (JSONObject) ch;
                        String characterName=(String) character.get("name");
                        if(charactername.equals(characterName))
                        {     int exp = ((Long) character.get("experience")).intValue();
                            int character_level = Integer.parseInt((String) character.get("level"));
                            System.out.println(character_level+"   "+exp);
                                exp=exp+40;
                                if(exp>=character_level*50)
                                {
                                    exp=exp-character_level*50;
                                    character_level++;
                                }
                                character.replace("level", Integer.toString(character_level));
                                character.replace("experience",exp);
                                break;

                        }
                     }
                    break;
                }

            }
            System.out.println(a.toJSONString());

           file.write(a.toJSONString());
            file.flush();
            file.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws IOException {
       testtt testam=new testtt();
       testam.readAccounts();
    }
}