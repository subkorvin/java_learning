package ru.qa.rtsoft.addressbook.model;

public class GroupData {
  private final String groupname;
  private final String groupheader;
  private final String groupfooter;

  public GroupData(String groupname, String groupheader, String groupfooter) {
    this.groupname = groupname;
    this.groupheader = groupheader;
    this.groupfooter = groupfooter;
  }

  public String getGroupname() {
    return groupname;
  }

  public String getGroupheader() {
    return groupheader;
  }

  public String getGroupfooter() {
    return groupfooter;
  }

  @Override
  public String toString() {
    return "GroupData{" +
            "groupname='" + groupname + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    GroupData groupData = (GroupData) o;

    return groupname != null ? groupname.equals(groupData.groupname) : groupData.groupname == null;
  }

  @Override
  public int hashCode() {
    return groupname != null ? groupname.hashCode() : 0;
  }
}
