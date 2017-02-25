package ru.qa.rtsoft.addressbook.tests;

import org.testng.annotations.Test;
import ru.qa.rtsoft.addressbook.model.UserData;


public class UserCreationTest extends TestBase{

  @Test
  public void testUserCreation() {
    app.getUserHelper().initNewUserCreation();
    app.getUserHelper().fillUserFormFields(new UserData("Vasya", "Yu", "Pupkin", "VasyaPro", "NIICHAVO", "Moscow, Leninsky tupik, 13", "+7 435 1234567", "+7 916 1234567", "+7 495 1234567", "vasya@pupkin.ru", "Test1"), true);
    app.getUserHelper().submitNewUserCreation();
    app.getNavigationHelper().returnToHomePage();
  }
}
