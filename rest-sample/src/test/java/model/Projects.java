package model;

/**
 * Created by korvin on 10.04.2017.
 */
public class Projects {

  private int id;
  private String name;


  //Getters
  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }


  //Setters

  public Projects withName(String name) {
    this.name = name;
    return this;
  }

  public Projects withId(int id) {
    this.id = id;
    return this;
  }

}
