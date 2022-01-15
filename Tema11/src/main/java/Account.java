import java.util.ArrayList;
import java.util.List;

public class Account {

  Information playerInfo;
  List<Character> allAccountCharactes= new ArrayList<>() ;
  int allGamesNumber ;

  public String toString() {
    return this.allAccountCharactes+" " +this.playerInfo;
  }
}

class Information {
  public Credentials playerCredentials;
  public List<String> favoriteGames ;
  public String Name;
  public String Country;

  public Information(
      Credentials playerCredentials, List<String> favoriteGames, String Name, String Country) {
    this.playerCredentials = playerCredentials;
    this.favoriteGames = favoriteGames;
    this.Name = Name;
    this.Country = Country;
  }

  public Credentials getCredentials() {
    return this.playerCredentials;
  }

  public List<String> getFavoriteGames() {
    return this.favoriteGames;
  }

  public String getName() {
    return this.Name;
  }

  public String getCountry() {
    return this.Country;
  }

  public String toString() {
    return  this.Name + " " + this.Country ;
  }
}

class InformationBuilder {
  private Credentials playerCredentials =null;
  private List<String> favoriteGames=null ;
  private String Name=null;
  private String Country=null;

  public InformationBuilder setCredentials(Credentials playerCredentials) {
    this.playerCredentials = playerCredentials;
    return this;
  }

  public InformationBuilder setfavoriteGames(List<String> favoriteGames) {
    this.favoriteGames = favoriteGames;
    return this;
  }

  public InformationBuilder setName(String Name) {
    this.Name = Name;
    return this;
  }

  public InformationBuilder setCountry(String Country) {
    this.Country = Country;
    return this;
  }

  public Information build()  {
   try {
    if(playerCredentials==null||favoriteGames==null||Name==null||Country==null)
      throw new Exception(" InformationIncompleteException");
    return new Information(playerCredentials, favoriteGames, Name, Country);
  }catch (Exception e) {
     e.printStackTrace();
   }
  return null;
   }
}

class Credentials {
  private String email, password;

  public void setEmail(String email) {
    this.email = email;
  }

  public void setPassword(String password) {
    this.password = password;
  }
  public String getEmail() {
    return this.email;
  }
  public boolean equals(String email, String password) {

    return this.email.equals(email) && this.password.equals(password);
  }
}
