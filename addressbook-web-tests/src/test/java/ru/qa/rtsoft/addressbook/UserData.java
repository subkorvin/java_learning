package ru.qa.rtsoft.addressbook;

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

  public UserData(String first_name, String middle_name, String family_name, String nickname, String company, String address, String home_phone, String cell_phone, String work_phone, String email) {
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
}
