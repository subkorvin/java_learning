package ru.qa.rtsoft.addressbook.tests;

import org.testng.annotations.Test;
import ru.qa.rtsoft.addressbook.model.GroupData;
import ru.qa.rtsoft.addressbook.model.UserData;

/**
 * Created by Korvin on 21.02.2017.
 */
public class UserDeletingTests extends TestBase {

  @Test
  public void testUserDeleting() {
    if (!app.getUserHelper().isThereAUser()) {
      app.getNavigationHelper().gotoGroupPage();
      if (!app.getGroupHelper().isThereAGroup()) {
        app.getGroupHelper().createGroup(new GroupData("Test1", "Test2", "Test3"));
        app.getUserHelper().createUser(new UserData("Vasya", "Yu", "Pupkin", "VasyaPro", "NIICHAVO", "Moscow, Leninsky tupik, 13", "+7 435 1234567", "+7 916 1234567", "+7 495 1234567", "vasya@pupkin.ru", "Test1"), true);
        app.getNavigationHelper().returnToHomePage();
        app.getUserHelper().deleteUser();
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().deleteGroup();
        app.getNavigationHelper().returnToHomePage();
      } else {
        app.getUserHelper().createUser(new UserData("Vasya", "Yu", "Pupkin", "VasyaPro", "NIICHAVO", "Moscow, Leninsky tupik, 13", "+7 435 1234567", "+7 916 1234567", "+7 495 1234567", "vasya@pupkin.ru", "Test1"), true);
        app.getNavigationHelper().returnToHomePage();
        app.getUserHelper().deleteUser();
        app.getNavigationHelper().returnToHomePage();
      }
    } else {
      app.getUserHelper().deleteUser();
      app.getNavigationHelper().returnToHomePage();
    }
  }
}
