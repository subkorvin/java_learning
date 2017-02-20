package ru.qa.rtsoft.addressbook;

import org.testng.annotations.Test;

public class UserCreationTest extends TestBase {

  @Test
  public void testUserCreation() {
    initNewUserCreation();
    fillNewUserFormFields(new UserData("Vasya", "Yu", "Pupkin", "VasyaPro", "NIICHAVO", "Moscow, Leninsky tupik, 13", "+7 435 1234567", "+7 916 1234567", "+7 495 1234567", "vasya@pupkin.ru"));
    submitNewUserCreation();
    returnToHomePage();
  }

}
