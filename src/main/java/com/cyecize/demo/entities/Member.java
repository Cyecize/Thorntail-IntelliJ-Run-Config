package com.cyecize.demo.entities;

public class Member {

  private int id;

  private String username;

  private String direction;

  public Member() {

  }

  public Member(int id, String username, String direction) {
    this.setId(id);
    this.setUsername(username);
    this.setDirection(direction);
  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getDirection() {
    return this.direction;
  }

  public void setDirection(String direction) {
    this.direction = direction;
  }
}
