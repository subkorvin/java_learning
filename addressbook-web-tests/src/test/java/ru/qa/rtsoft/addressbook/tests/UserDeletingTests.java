package ru.qa.rtsoft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.qa.rtsoft.addressbook.model.GroupData;
import ru.qa.rtsoft.addressbook.model.UserData;

import java.util.List;

/**
 * Created by Korvin on 21.02.2017.
 */
public class UserDeletingTests extends TestBase {

  @Test
  public void testUserDeleting() {
    if (app.getUserHelper().isThereAUser()) {
      List<UserData> before = app.getUserHelper().getUsersList();
      app.getUserHelper().deleteUser();
      app.getNavigationHelper().returnToHomePage();
      List<UserData> after = app.getUserHelper().getUsersList();
      Assert.assertEquals(after.size(), before.size() - 1); //сравнение размеров списков до и после удаления

      before.remove(before.size() - 1);
      Assert.assertEquals(before, after); //сравнение списков целиком
      return;
    }
    app.getNavigationHelper().gotoGroupPage();
    if (! app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("Test1", "Test2", "Test3"));
      app.getUserHelper().createUser(new UserData("Vasya", "Yu", "Pupkin", "VasyaPro", "NIICHAVO", "Moscow, Leninsky tupik, 13", "+7 435 1234567", "+7 916 1234567", "+7 495 1234567", "vasya@pupkin.ru", "Test1"));
      app.getUserHelper().deleteUser();
//      app.getNavigationHelper().gotoGroupPage();
//      app.getGroupHelper().deleteGroup();
      app.getNavigationHelper().returnToHomePage();
    } else {
      app.getUserHelper().createUser(new UserData("Vasya", "Yu", "Pupkin", "VasyaPro", "NIICHAVO", "Moscow, Leninsky tupik, 13", "+7 435 1234567", "+7 916 1234567", "+7 495 1234567", "vasya@pupkin.ru", "Test1"));
      app.getUserHelper().deleteUser();
      app.getNavigationHelper().returnToHomePage();
    }
  }
}
