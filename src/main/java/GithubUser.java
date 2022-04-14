public class GithubUser {
  private int followers;
  private int followings;
  private int repositoryCount;
  private String name;
  private String bio;

  GithubUser(int followers,int followings,
             int repositoryCount,String name, String bio) {
    this.bio = bio;
    this.followers = followers;
    this.followings = followings;
    this.name = name;
    this.repositoryCount = repositoryCount;
  }

  @Override
  public String toString() {
    return "GithubUser{" + "followers=" + followers + ", followings=" + followings + ", repositoryCount=" + repositoryCount + ", name='" + name + '\'' + ", bio='" + bio + '\'' + '}';
  }

  public int getFollowers() {
    return followers;
  }

  public void setFollowers(int followers) {
    this.followers = followers;
  }

  public int getFollowings() {
    return followings;
  }

  public void setFollowings(int followings) {
    this.followings = followings;
  }

  public int getRepositoryCount() {
    return repositoryCount;
  }

  public void setRepositoryCount(int repositoryCount) {
    this.repositoryCount = repositoryCount;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getBio() {
    return bio;
  }

  public void setBio(String bio) {
    this.bio = bio;
  }
}
