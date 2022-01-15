import java.io.*;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Game {
  private static Game game;
  List<Account> accountsList = new ArrayList<>();
  Map<Cell.Story, List<String>> StoriesMap = new HashMap<>();

  private Game()
  {

  }
  // metoda ce citeste conturile din json
  private void readAccounts()
  {
    JSONParser parser = new JSONParser();

    try {
      JSONArray a =
              (JSONArray)
                      parser.parse(
                              new FileReader(
                                      "src\\main\\java\\Teste\\accounts.json"));


      for (Object o : a) {
        Account account = new Account();
        JSONObject person = (JSONObject) o;

        JSONObject credentials = (JSONObject) person.get("credentials");
        String email = (String) credentials.get("email");
        String password = (String) credentials.get("password");

        Credentials Credentials = new Credentials();
        Credentials.setEmail(email);
        Credentials.setPassword(password);

        String name = (String) person.get("name");
        String country = (String) person.get("country");

        JSONArray favourite_games = (JSONArray) person.get("favorite_games");
        List<String> favoriteGames = new ArrayList<>();

        account.allGamesNumber = Integer.parseInt((String) person.get("maps_completed"));

        for (Object game : favourite_games) favoriteGames.add(game.toString());
        Collections.sort(favoriteGames);
        account.allGamesNumber=favoriteGames.size();
        account.playerInfo =
                new InformationBuilder()
                        .setName(name)
                        .setCountry(country)
                        .setCredentials(Credentials)
                        .setfavoriteGames(favoriteGames)
                        .build();
        CharacterFactory characterFactory = new CharacterFactory();
        JSONArray characters = (JSONArray) person.get("characters");
        for (Object ch : characters) {
          JSONObject character = (JSONObject) ch;
          String profession = (String) character.get("profession");
          int exp = ((Long) character.get("experience")).intValue();

          String character_name = (String) character.get("name");
          int character_level = Integer.parseInt((String) character.get("level"));

          account.allAccountCharactes.add(characterFactory.getCharacter(profession,character_name,character_level,exp));
        }
        accountsList.add(account);
      }
    } catch (IOException | ParseException e) {
      e.printStackTrace();
    }
  }
  // metoda ce salveaza progresul in json
  private void saveProgress(String Mail,String CharacterNAME)
  {
    JSONParser parser = new JSONParser();

    try {
      JSONArray a =
              (JSONArray)
                      parser.parse(
                              new FileReader(
                                      "src\\main\\java\\Teste\\accounts.json"));
      FileWriter file = new FileWriter("src\\main\\java\\Teste\\accounts.json");

      for (Object o : a) {

        JSONObject person = (JSONObject) o;

        JSONObject credentials = (JSONObject) person.get("credentials");
        String email = (String) credentials.get("email");

        if(Mail.equals(email))
        {
          int mape = Integer.parseInt((String) person.get("maps_completed"));
          System.out.println("Ai mai completat o harta, numarul de harti completate :"+mape);
          mape++;

          person.replace("maps_completed", Integer.toString(mape));
          JSONArray characters = (JSONArray) person.get("characters");
          for (Object ch : characters) {
            JSONObject character = (JSONObject) ch;
            String characterName=(String) character.get("name");
            if(CharacterNAME.equals(characterName))
            {     int exp = ((Long) character.get("experience")).intValue();
              int character_level = Integer.parseInt((String) character.get("level"));

              exp=exp+40;
              if(exp>=character_level*50)
              {
                exp=exp-character_level*50;
                character_level++;
              }
              character.replace("level", Integer.toString(character_level));
              character.replace("experience",exp);
              System.out.println("Level: "+character_level+" Experienta: "+exp);
              break;

            }
          }
          break;
        }

      }

      file.write(a.toJSONString());
      file.flush();
      file.close();
    } catch (IOException | ParseException e) {
      e.printStackTrace();
    }
  }
  // metoda ce citeste povestile
  private void readStories()
  {
    JSONParser parser = new JSONParser();

    try {
      JSONArray a =
              (JSONArray)
                      parser.parse(
                              new FileReader(
                                      "src\\main\\java\\Teste\\stories.json"));



      List<String>  empty = new ArrayList<>();

      List<String> enemy = new ArrayList<>();

      List<String> shop = new ArrayList<>();

      List<String> finish  = new ArrayList<>();
      for (Object o : a) {

        JSONObject story = (JSONObject) o;
        String type = (String) story.get("type");
        String value = (String) story.get("value");
        if(type.equals("EMPTY"))
          empty.add(value);
        if(type.equals("ENEMY"))
          enemy.add(value);
        if(type.equals("SHOP"))
          shop.add(value);
        if(type.equals("FINISH"))
          finish.add(value);
      }

      StoriesMap.put(Cell.Story.EMPTY, empty);
      StoriesMap.put(Cell.Story.ENEMY,enemy);
      StoriesMap.put(Cell.Story.SHOP,shop);
      StoriesMap.put(Cell.Story.FINISH,finish);

    } catch (IOException | ParseException e) {
      e.printStackTrace();
    }
  }

  // metoda pentru logare
  private Account testLogin()
  {
    Scanner in = new Scanner(System.in);
    String email;
    String password;

    while (true) {
      System.out.println("Cont:");
      email = in.nextLine();
      password = in.nextLine();
      for (Account i : accountsList) {

        if (i.playerInfo.playerCredentials.equals(email, password)) {

          return i;
        }
      }
    }



  }

  // metoda ce afiseaza caracterele unui cont
  private Character printAccountCharacters(Account  currentCharacter)
  {
    for(int i = 1;i<= currentCharacter.allAccountCharactes.size();i++) {
      System.out.println(i+". "+ currentCharacter.allAccountCharactes.get(i-1));
    }
    Scanner in = new Scanner(System.in);
    int chosenAccount=in.nextInt();

    return  currentCharacter.allAccountCharactes.get(chosenAccount-1);
  }
  // metoda ce afiseaza inventarul ca sa folosesti o potiune
  private void showInventory(Character currentCharacter) throws Exception {
    System.out.println(" ____________________\n" +
            "|______Inventory______|");
    for(int i=0;i<currentCharacter.Character_Inventory.potionList.size();i++)
      System.out.println((i+1)+". "+currentCharacter.Character_Inventory.potionList.get(i));
    System.out.println((currentCharacter.Character_Inventory.potionList.size()+1)+". Ca sa iesi din inventar");
    System.out.println("_____________________");
    Scanner in = new Scanner(System.in);
    int i = in.nextInt();
    if(i==currentCharacter.Character_Inventory.potionList.size()+1)
      return;
    if(i>currentCharacter.Character_Inventory.potionList.size()+1)
      InvalidCommandException.throwException();
    Potion potion = currentCharacter.Character_Inventory.potionList.get(i-1);
    currentCharacter.Character_Inventory.removePotion(i-1);

    potion.usePotion(currentCharacter);


  }
  // metoda ce afiseaza inventarul ca sa folosesti o potiune (harcodat)
  private void showInventoryHarcodat(Character currentCharacter)
  {
    System.out.println(" ____________________\n" +
            "|______Inventory______|");
    for(int i=0;i<currentCharacter.Character_Inventory.potionList.size();i++)
      System.out.println((i+1)+". "+currentCharacter.Character_Inventory.potionList.get(i));
    System.out.println((currentCharacter.Character_Inventory.potionList.size()+1)+". Ca sa iesi din inventar");
    System.out.println("_____________________");


    Potion potion = currentCharacter.Character_Inventory.potionList.get(0);
    currentCharacter.Character_Inventory.removePotion(0);
    potion.usePotion(currentCharacter);


  }
  // metoda ce se ocupa de lupta harcodata
  public void theFightHarcodat(Character currentCharacter,Enemy enemy)
  {
    System.out.println(
            """

                     O       /\\___/\\
                    /|\\/     \\(o o)/
                    / \\       \\VWV/
                    """);
    int enemyORplayer=0,choice=2,j=0;
    Random rand = new Random();

    while(currentCharacter.CurrentHealth>0&&enemy.CurrentHealth>0)
    {

      if(enemyORplayer==0)
      { System.out.println("Character's turn");
        System.out.println("Character -> health: "+currentCharacter.CurrentHealth+"  mana: "+currentCharacter.CurrentMana+"\nEnemy -> health: "+enemy.CurrentHealth+"  mana: "+enemy.CurrentMana);
        System.out.println("1. Normal Attack\n2. Ability Attack\n3. Open Inventory");


        if(choice==1)
        {System.out.println("1");
          enemy.CurrentHealth = enemy.CurrentHealth - currentCharacter.getDamage();

        }
        else if(choice==2)
        {System.out.println("2");
          for(int i=0;i<currentCharacter.AbilityList.size();i++)
            System.out.println((i+1)+". "+ currentCharacter.AbilityList.get(i));
          System.out.println((currentCharacter.AbilityList.size()+1)+". Normal Attack");
          System.out.println("1");
            Spell spell = currentCharacter.AbilityList.get(0);
          if (currentCharacter.useAbility(spell) == 1) {
            enemy.accept(spell);
            currentCharacter.AbilityList.remove(0);
            }
          choice=3;

        }else if(choice==3)
        { System.out.println("3");
          this.showInventoryHarcodat(currentCharacter);
          System.out.println("1");
          choice=2;
          j++;
          if(j==2)
            choice=1;
        }
        enemyORplayer=1;

      }
      else
      { System.out.println("Enemy's turn");
        System.out.println("Character -> health: "+currentCharacter.CurrentHealth+"  mana: "+currentCharacter.CurrentMana+"\nEnemy -> health: "+enemy.CurrentHealth+"  mana: "+enemy.CurrentMana);
        if(enemy.AbilityList.size()>0)
        {   int sansa25=rand.nextInt(100);
          if(sansa25%4==0)
          { int abilitateRandom=rand.nextInt(enemy.AbilityList.size());
            System.out.println(enemy.AbilityList);
            Spell spell=enemy.AbilityList.get(abilitateRandom);
            if (enemy.useAbility(spell) == 1) {
              enemy.AbilityList.remove(abilitateRandom);

              currentCharacter.accept(spell);
}
          }else {
            currentCharacter.CurrentHealth=currentCharacter.CurrentHealth-enemy.getDamage();
          }

        }else {
          currentCharacter.CurrentHealth=currentCharacter.CurrentHealth-enemy.getDamage();
        }

        enemyORplayer=0;
      }
    }
    if(currentCharacter.CurrentHealth<=0)
      System.exit(0);

  }
  // metoda ce se ocupa de lupta normala
  public void thefight(Character currentCharacter,Enemy enemy) throws Exception {
    System.out.println(
            """

                     O       /\\___/\\
                    /|\\/     \\(o o)/
                    / \\       \\VWV/
                    """);
    int enemyORplayer=0,choice;
    Random rand = new Random();
    Scanner in = new Scanner(System.in);
    while(currentCharacter.CurrentHealth>0&&enemy.CurrentHealth>0)
    {

      if(enemyORplayer==0)
      { System.out.println("Character's turn");
        System.out.println("Character -> health: "+currentCharacter.CurrentHealth+"  mana: "+currentCharacter.CurrentMana+"\nEnemy -> health: "+enemy.CurrentHealth+"  mana: "+enemy.CurrentMana);
        System.out.println("1. Normal Attack\n2. Ability Attack\n3. Open Inventory");

        choice=in.nextInt();
        if(choice==1)
        {
          enemy.CurrentHealth = enemy.CurrentHealth - currentCharacter.getDamage();

        }
        else if(choice==2)
        {
          for(int i=0;i<currentCharacter.AbilityList.size();i++)
            System.out.println((i+1)+". "+ currentCharacter.AbilityList.get(i));
          System.out.println((currentCharacter.AbilityList.size()+1)+". Normal Attack");
          choice=in.nextInt();
          if(choice==currentCharacter.AbilityList.size()+1)
          {
            enemy.CurrentHealth = enemy.CurrentHealth - currentCharacter.getDamage();
          } else {
            Spell spell = currentCharacter.AbilityList.get(choice - 1);
            if(currentCharacter.useAbility(spell)==1){
              currentCharacter.AbilityList.remove(choice - 1);

      enemy.accept(spell);
}
}
        }else if(choice==3)
        {
          this.showInventory(currentCharacter);

        }
        enemyORplayer=1;

      }
      else
      { System.out.println("Enemy's turn");
        System.out.println("Character -> health: "+currentCharacter.CurrentHealth+"  mana: "+currentCharacter.CurrentMana+"\nEnemy -> health: "+enemy.CurrentHealth+"  mana: "+enemy.CurrentMana);
        if(enemy.AbilityList.size()>0)
        {   int sansa25=rand.nextInt(100);
          if(sansa25%4==0)
          { int abilitateRandom=rand.nextInt(enemy.AbilityList.size());
            System.out.println(enemy.AbilityList);
            Spell spell=enemy.AbilityList.get(abilitateRandom);
            if (enemy.useAbility(spell) == 1) {
              enemy.AbilityList.remove(abilitateRandom);

              currentCharacter.accept(spell);
            }
          }else {
            currentCharacter.CurrentHealth=currentCharacter.CurrentHealth-enemy.getDamage();
         }

        }else {
          currentCharacter.CurrentHealth=currentCharacter.CurrentHealth-enemy.getDamage();
        }

        enemyORplayer=0;
      }
    }
    if(currentCharacter.CurrentHealth<=0)
      System.exit(0);

  }
  // metoda ce afiseaza cate o poveste noua la fiecare mutare si arata shop ul sau enemy ul
  public void printStories(Character currentCharacter,Grid grid,Account account) throws Exception { System.out.println();

    Random rand = new Random();
    if(currentCharacter.Current_Oy<0)
      currentCharacter.Current_Oy=0;
    if(currentCharacter.Current_Ox<0)
      currentCharacter.Current_Ox=0;
    //noinspection rawtypes
    Cell cell= (Cell) ((ArrayList)grid.get(currentCharacter.Current_Ox)).get(currentCharacter.Current_Oy);
    int story;

      if (cell.CellType == Cell.Story.EMPTY) {
        story = rand.nextInt(0, StoriesMap.get(Cell.Story.EMPTY).size());
        System.out.println(StoriesMap.get(Cell.Story.EMPTY).get(story));
        int coinChance = rand.nextInt(101);
        if (coinChance % 5 == 0 && cell.Visited == 0) {
          int banuti = rand.nextInt(1, 15);
          currentCharacter.Character_Inventory.Coins =
              currentCharacter.Character_Inventory.Coins + banuti;
          System.out.println("Ai gasit " + banuti + " banuti prin nisipul argintiu!");
        }
        grid.printMap();
      }
      if (cell.CellType == Cell.Story.ENEMY) {
        story = rand.nextInt(0, StoriesMap.get(Cell.Story.ENEMY).size());
        System.out.println(StoriesMap.get(Cell.Story.ENEMY).get(story));
        if (cell.Visited == 0) this.thefight(currentCharacter, (Enemy) cell.enemyORshop);
        int coinChance = rand.nextInt(101);
        if (coinChance % 5 != 0 && cell.Visited == 0) {
          int banuti = rand.nextInt(1, 35);
          currentCharacter.Character_Inventory.Coins =
              currentCharacter.Character_Inventory.Coins + banuti;
          System.out.println("Ai castigat " + banuti + " banuti pentru invingerea inamicului!");
        }
        grid.printMap();
      }
      if (cell.CellType == Cell.Story.SHOP) {
        currentCharacter.Character_Inventory.printCoins();
        story = rand.nextInt(0, StoriesMap.get(Cell.Story.SHOP).size());
        Shop shop = (Shop) cell.enemyORshop;
        System.out.println(StoriesMap.get(Cell.Story.SHOP).get(story));
        Scanner in = new Scanner(System.in);
        int index;

        while (true) {
          shop.printPotionList(currentCharacter);
          System.out.println((shop.shopPotionList.size() + 1) + ". Ca sa iesi din Shop");
          index = in.nextInt();
          if (index == shop.shopPotionList.size() + 1) break;
          if (index > shop.shopPotionList.size() + 1)
            InvalidCommandException.throwException();
          Potion potion = shop.getPotion(index);
          int canBuyPotion = currentCharacter.testCoinsPotion(potion);
          if (canBuyPotion == 1) {
            shop.boughtPotion(index);
          }
        }
        grid.printMap();
      }
      if (cell.CellType == Cell.Story.FINISH) {
        story = rand.nextInt(0, StoriesMap.get(Cell.Story.FINISH).size());
        System.out.println(StoriesMap.get(Cell.Story.FINISH).get(story));
        grid.printMap();
        game.saveProgress(account.playerInfo.playerCredentials.getEmail(), account.allAccountCharactes.get(0).name);
        System.out.println(
                """

                            _    _                 _    _              _     _  _  _  _\s
                           /_\\  (_)  __  __ _  ___| |_ (_) __ _  __ _ | |_  | || || || |
                          / _ \\ | | / _|/ _` |(_-<|  _|| |/ _` |/ _` ||  _| |_||_||_||_|
                         /_/ \\_\\|_| \\__|\\__,_|/__/ \\__||_|\\__, |\\__,_| \\__| (_)(_)(_)(_)
                                                          |___/                        \s
                        """);
        System.exit(0);
      }

  }

  public void harcodareTastaP()
  {
    Scanner in = new Scanner(System.in);
    System.out.println("Apasati tasta P pentru a continua");
    in.nextLine();
  }
  // metoda pentru testul harcodat
  public void testHarcodat(Grid grid, Character currentCharacter,Account account)
  {
    this.printStoriesHarcodat(grid,currentCharacter,account);

    grid.goEast();
    this.printStoriesHarcodat(grid,currentCharacter,account);

    grid.goEast();
    this.printStoriesHarcodat(grid,currentCharacter,account);

    grid.goEast();
    this.printStoriesHarcodat(grid,currentCharacter,account);

    grid.goEast();
    this.printStoriesHarcodat(grid,currentCharacter,account);


    grid.goSouth();
    this.printStoriesHarcodat(grid,currentCharacter,account);

    grid.goSouth();
    this.printStoriesHarcodat(grid,currentCharacter,account);

    grid.goSouth();
    this.printStoriesHarcodat(grid,currentCharacter,account);


    grid.goSouth();
    this.printStoriesHarcodat(grid,currentCharacter,account); // finish
  }
  // metoda pentru jocul normal
  public void testNormal(Grid grid, Character currentCharacter,Account account) throws Exception {       Scanner in = new Scanner(System.in);
          int choice,i;

    while (true)
    { this.printStories(currentCharacter, grid, account);
      System.out.println("1. Go East   2. Go West\n3. Go North   4. Go South");
      choice=in.nextInt();
      if(choice==1)
      { i=grid.goEast();
        if(i==0)
          continue;
      }
      if(choice==2)
      { i=grid.goWest();
        if(i==0)
          continue;
      }
      if(choice==3)
      { i=grid.goNorth();
        if(i==0)
          continue;
      }
      if(choice==4)
      { grid.goSouth();

      }
      if(choice>=5) {
       InvalidCommandException.throwException();
      }

    }
  }
  // metoda ce afiseaza povestea pentru fiecare mutare harcodata
  public void printStoriesHarcodat(Grid grid,Character currentCharacter,Account account)
  {
    System.out.println();
   this.harcodareTastaP();
    Random rand = new Random();
    //noinspection rawtypes
    Cell cell= (Cell) ((ArrayList)grid.get(currentCharacter.Current_Ox)).get(currentCharacter.Current_Oy);
    int story;
    if(cell.CellType== Cell.Story.EMPTY)
    {
      story=rand.nextInt(0,StoriesMap.get(Cell.Story.EMPTY).size());
      System.out.println(StoriesMap.get(Cell.Story.EMPTY).get(story));
      int coinChance=rand.nextInt(101);
      if(coinChance%5==0&&cell.Visited==0){
        int banuti=rand.nextInt(1,15);
        currentCharacter.Character_Inventory.Coins =
                currentCharacter.Character_Inventory.Coins +banuti;
        System.out.println("Ai gasit "+banuti+" banuti prin nisipul argintiu!");
      }
      grid.printMap();
    }
    if(cell.CellType== Cell.Story.ENEMY)
    {
      story=rand.nextInt(0,StoriesMap.get(Cell.Story.ENEMY).size());
      System.out.println(StoriesMap.get(Cell.Story.ENEMY).get(story));
      if(cell.Visited==0)
        this.theFightHarcodat(currentCharacter,(Enemy) cell.enemyORshop);
      int coinChance=rand.nextInt(101);
      if (coinChance % 5 != 0 && cell.Visited == 0) {
        int banuti=rand.nextInt(1,35);
        currentCharacter.Character_Inventory.Coins =
                currentCharacter.Character_Inventory.Coins +banuti;
        System.out.println("Ai castigat "+banuti+" banuti pentru invingerea inamicului!");
      }
      grid.printMap();
    }
    if(cell.CellType== Cell.Story.SHOP)
    {currentCharacter.Character_Inventory.printCoins();
      story=rand.nextInt(0,StoriesMap.get(Cell.Story.SHOP).size());
      Shop shop= (Shop) cell.enemyORshop;
      System.out.println(StoriesMap.get(Cell.Story.SHOP).get(story));
      int index;
      int i=0;
      while(true){
        if(i==2)
        {break;}
        shop.printPotionList(currentCharacter);
        System.out.println((shop.shopPotionList.size()+1)+". Ca sa iesi din Shop");
        index=1;

        if(index==shop.shopPotionList.size()+1)
          break;

        Potion potion=shop.getPotion(index);
        int canBuyPotion=currentCharacter.testCoinsPotion(potion);
        if (canBuyPotion == 1) {
          shop.boughtPotion(index);
        }
        i++;


        System.out.println(index);
      }
      grid.printMap();
    }
    if(cell.CellType== Cell.Story.FINISH)
    {
      story=rand.nextInt(0,StoriesMap.get(Cell.Story.FINISH).size());
      System.out.println(StoriesMap.get(Cell.Story.FINISH).get(story));
      grid.printMap();
      game.saveProgress(account.playerInfo.playerCredentials.getEmail(), account.allAccountCharactes.get(0).name);
      System.out.println(
              """

                          _    _                 _    _              _     _  _  _  _\s
                         /_\\  (_)  __  __ _  ___| |_ (_) __ _  __ _ | |_  | || || || |
                        / _ \\ | | / _|/ _` |(_-<|  _|| |/ _` |/ _` ||  _| |_||_||_||_|
                       /_/ \\_\\|_| \\__|\\__,_|/__/ \\__||_|\\__, |\\__,_| \\__| (_)(_)(_)(_)
                                                        |___/                        \s
                      """);
      System.exit(0);
    }

  }
  // metoda run ce porneste jocul
  public void run(int index) throws Exception {
    this.readAccounts();
    this.readStories();


    if(index==1)
    {  Grid grid=Grid.generateMap(5,5, index);

      grid.MyCharacter=this.accountsList.get(0).allAccountCharactes.get(0);
      this.testHarcodat(grid,grid.MyCharacter, this.accountsList.get(0));

    }
    else
    { Grid grid=Grid.generateMap(7,6, index);

      Account contCurent=this.testLogin();
      grid.MyCharacter=this.printAccountCharacters(contCurent);
     System.out.println(grid.MyCharacter);

      this.testNormal(grid, grid.MyCharacter,contCurent);
    }

  }


  // metoda pentru singleton pattern, sa fim siguri ca se face doar o instanta a jocului
  public static Game getInstance() {
    if (game == null) game = new Game();
    return game;
  }
}


