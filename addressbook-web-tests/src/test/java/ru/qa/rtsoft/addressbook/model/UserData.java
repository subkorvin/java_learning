package ru.qa.rtsoft.addressbook.model;

public class UserData {

  private final String first_name;
  private final String middle_name;
  private final String family_name;
  private final String nickname;
  private final String company;
  private final String address;
  private final String home_phone;
  private final String cell_phone;
  private final String work_phone;
  private final String email;
  private String group;

  public UserData(String first_name, String middle_name, String family_name, String nickname, String company, String address, String home_phone, String cell_phone, String work_phone, String email, String group) {
    this.first_name = first_name;
    this.middle_name = middle_name;
    this.family_name = family_name;
    this.nickname = nickname;
    this.company = company;
    this.address = address;
    this.home_phone = home_phone;
    this.cell_phone = cell_phone;
    this.work_phone = work_phone;
    this.email = email;
    this.group = group;
  }

  public String getFirst_name() {
    return first_name;
  }

  public String getMiddle_name() {
    return middle_name;
  }

  public String getFamily_name() {
    return family_name;
  }

  public String getNickname() {
    return nickname;
  }

  public String getCompany() {
    return company;
  }

  public String getAddress() {
    return address;
  }

  public String getHome_phone() {
    return home_phone;
  }

  public String getCell_phone() {
    return cell_phone;
  }

  public String getWork_phone() {
    return work_phone;
  }

  public String getEmail() {
    return email;
  }

  public String getGroup() {
    return group;
  }

  @Override
  public String toString() {
    return "UserData{" +
            "first_name='" + first_name + '\'' +
            ", family_name='" + family_name + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    UserData userData = (UserData) o;

    if (first_name != null ? !first_name.equals(userData.first_name) : userData.first_name != null) return false;
    return family_name != null ? family_name.equals(userData.family_name) : userData.family_name == null;
  }

  @Override
  public int hashCode() {
    int result = first_name != null ? first_name.hashCode() : 0;
    result = 31 * result + (family_name != null ? family_name.hashCode() : 0);
    return result;
  }
}
