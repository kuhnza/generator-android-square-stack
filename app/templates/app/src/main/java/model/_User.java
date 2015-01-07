package <%=appPackage%>.model;

public class User {
  private String username;
  private String name;
  private String email;

  User() {
  }

  public User(String username, String email, String name) {
    this.username = username;
    this.name = name;
    this.email = email;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public java.lang.String toString() {
    return new org.apache.commons.lang3.builder.ToStringBuilder(this)
      .append("username", username)
      .append("name", name)
      .append("email", email)
      .toString();
  }
}
