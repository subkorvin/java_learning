package ru.qa.rtsoft.rest;

/**
 * Created by Korvin on 09.04.2017.
 */
public class Issue {

  private int id;
  private String subject;
  private String description;


  //Getters
  public int getId() {
    return id;
  }

  public String getSubject() {
    return subject;
  }

  public String getDescription() {
    return description;
  }


  //Setters

  public Issue withId(int id) {
    this.id = id;
    return this;
  }
  public Issue withSubject(String subject) {
    this.subject = subject;
    return this;
  }

  public Issue setDescription(String description) {
    this.description = description;
    return this;
  }
}
