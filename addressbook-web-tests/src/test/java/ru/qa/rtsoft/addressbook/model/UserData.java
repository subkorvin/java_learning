package ru.qa.rtsoft.addressbook.model;

public class UserData {

  private int id = Integer.MAX_VALUE;
  private String first_name;
  private String middle_name;
  private String family_name;
  private String nickname;
  private String company;
  private String address;
  private String home_phone;
  private String cell_phone;
  private String work_phone;
  private String email;
  private String email2;
  private String email3;
  private String group;
  private String allPhones;
  private String allEmails;


  //Getters
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

  public String getGroup() {
    return group;
  }

  public String getAllPhones() {
    return allPhones;
  }

  public int getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }

  public String getEmail2() {
    return email2;
  }

  public String getEmail3() {
    return email3;
  }

  public String getAllEmails() {
    return allEmails;
  }

  //Setters
  public UserData withId(int id) {
    this.id = id;
    return this;
  }

  public UserData withFirst_name(String first_name) {
    this.first_name = first_name;
    return this;
  }

  public UserData withMiddle_name(String middle_name) {
    this.middle_name = middle_name;
    return this;
  }

  public UserData withFamily_name(String family_name) {
    this.family_name = family_name;
    return this;
  }

  public UserData withNickname(String nickname) {
    this.nickname = nickname;
    return this;
  }

  public UserData withCompany(String company) {
    this.company = company;
    return this;
  }

  public UserData withAddress(String address) {
    this.address = address;
    return this;
  }

  public UserData withHome_phone(String home_phone) {
    this.home_phone = home_phone;
    return this;
  }

  public UserData withCell_phone(String cell_phone) {
    this.cell_phone = cell_phone;
    return this;
  }

  public UserData withWork_phone(String work_phone) {
    this.work_phone = work_phone;
    return this;
  }

  public UserData withEmail(String email) {
    this.email = email;
    return this;
  }

  public UserData withGroup(String group) {
    this.group = group;
    return this;
  }

  public UserData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public UserData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public UserData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }

  public UserData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }


  @Override
  public String toString() {
    return "UserData{" +
            "id='" + id + '\'' +
            ", first_name='" + first_name + '\'' +
            ", family_name='" + family_name + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    UserData userData = (UserData) o;

    if (id != userData.id) return false;
    if (first_name != null ? !first_name.equals(userData.first_name) : userData.first_name != null) return false;
    return family_name != null ? family_name.equals(userData.family_name) : userData.family_name == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (first_name != null ? first_name.hashCode() : 0);
    result = 31 * result + (family_name != null ? family_name.hashCode() : 0);
    return result;
  }
}
