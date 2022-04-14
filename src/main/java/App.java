import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;

public class App {
  private Document document;
  private ArrayList<GithubUser> users = new ArrayList<>();

  public void getDocument(String url) throws IOException {
    this.document = Jsoup.connect(url).get();
  }

  public Document getDocument() {
    return document;
  }

  public void setDocument(Document document) {
    this.document = document;
  }

  public ArrayList<GithubUser> getUsers() {
    return users;
  }

  public void setUsers(ArrayList<GithubUser> users) {
    this.users = users;
  }

  public void makeGithubUser() {
    String follwers = this.getFollwers();
    String followings = this.getFollwings();
    String name = this.getName();
    String bio = this.getBio();
    String repoCounts = this.getRepoCount();

    GithubUser newUser = new GithubUser(this.stringToInteger(follwers),
        this.stringToInteger(followings),this.stringToInteger(repoCounts),
        name,bio);
    users.add(newUser);
  }

  public String getRepoCount() {
    String repoCount = "";
    Element repoTag = this.document
        .getElementsByClass("UnderlineNav-item js-responsive-underlinenav-item").get(0);
    repoCount = repoTag.text();
    String texts[] = repoCount.split(" ");
    repoCount = texts[1];
    return repoCount;
  }

  public String getBio() {
    Element bioTag = this.document.getElementsByClass("p-note user-profile-bio mb-3 js-user-profile-bio f4").get(0);
    return bioTag.text();
  }

  public String getFollwers() {
    String followers;
    Element spanTag = this.document.getElementsByClass("text-bold color-fg-default").get(0);
    followers = spanTag.text();
    return followers;
  }

  public String getFollwings() {
    String followings;
    Element spanTag = this.document.getElementsByClass("text-bold color-fg-default").get(1);
    followings = spanTag.text();
    return followings;
  }

  public String getName() {
    String name = "";
    Element ourTag = this.document
        .getElementsByClass("p-name vcard-fullname d-block overflow-hidden")
        .get(0);
    name = ourTag.text();
    return name;
  }

  private int stringToInteger(String str) {
    return Integer.parseInt(str);
  }
}
