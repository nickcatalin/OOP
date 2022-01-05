import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Account {

  Information playerInfo;
  List<Character> allAccountCharactes=new ArrayList<Character>() ;
  int allGamesNumber ;
}

class Information {
  private Credentials playerCredentials = new Credentials();
  private List<String> favoriteGames = new ArrayList<String>();
  private String Name;
  private String Country;

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

    if (this.email == email && this.password == password) return true;
    return false;
  }
}
