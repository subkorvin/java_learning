package ru.qa.rtsoft.mantis.model;

/**
 * Created by korvin on 07.04.2017.
 */
public class Issue {

  private int id;
  private String summary;
  private String description;
  private Project project;

  //Getters

  public int getId() {
    return id;
  }

  public String getSummary() {
    return summary;
  }

  public String getDescription() {
    return description;
  }

  public Project getProject() {
    return project;
  }


  //Setters


  public Issue withId(int id) {
    this.id = id;
    return this;
  }

  public Issue withSummary(String summary) {
    this.summary = summary;
    return this;
  }

  public Issue withDescription(String description) {
    this.description = description;
    return this;
  }

  public Issue withProject(Project project) {
    this.project = project;
    return this;
  }
}
