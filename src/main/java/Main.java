import java.io.IOException;
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) throws IOException {
    App app = new App();
    app.getDocument("https://github.com/muhammadkarbalaee");
    app.makeGithubUser();
    app.getDocument("https://github.com/idealre");
    app.makeGithubUser();

    ArrayList<GithubUser> allUsers = app.getUsers();
    for (GithubUser user: allUsers) {
      System.out.println(user.toString());
    }
  }
}
