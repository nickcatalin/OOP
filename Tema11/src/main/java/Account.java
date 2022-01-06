import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Account {

  Information playerInfo;
  List<Character> allAccountCharactes=new ArrayList<Character>() ;
  int allGamesNumber ;

  public String toString() {
    return this.allAccountCharactes+" " +this.playerInfo;
  }
}

class Information {
  public Credentials playerCredentials = new Credentials();
  public List<String> favoriteGames = new ArrayList<String>();
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
  private Credentials playerCredentials ;
  private List<String> favoriteGames ;
  private String Name;
  private String Country;

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

  public Information build() {
    return new Information(playerCredentials, favoriteGames, Name, Country);
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

  public boolean equals(String email, String password) {

    if (this.email.equals(email)&& this.password.equals(password)) return true;
    return false;
  }
}
