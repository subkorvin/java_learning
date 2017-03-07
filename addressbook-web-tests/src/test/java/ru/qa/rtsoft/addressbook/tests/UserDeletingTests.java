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
//    if (app.getUserHelper().isThereAUser()) {
      List<UserData> before = app.getUserHelper().getUsersList();
      app.getUserHelper().deleteUser(before.size() - 1);
      List<UserData> after = app.getUserHelper().getUsersList();
      Assert.assertEquals(after.size(), before.size() - 1); //сравнение размеров списков до и после удаления

      before.remove(before.size() - 1);
      Assert.assertEquals(before, after); //сравнение списков целиком
//      return;
//    }
//    app.getNavigationHelper().gotoGroupPage();
//    if (! app.getGroupHelper().isThereAGroup()) {
//      app.getGroupHelper().createGroup(new GroupData("Test1", "Test2", "Test3"));
//      app.getUserHelper().createUser(new UserData("Vasya", "Yu", "Pupkin", "VasyaPro", "NIICHAVO", "Moscow, Leninsky tupik, 13", "+7 435 1234567", "+7 916 1234567", "+7 495 1234567", "vasya@pupkin.ru", "Test1"));
//      List<UserData> before = app.getUserHelper().getUsersList();
//      app.getUserHelper().deleteUser(before.size() - 1);
////      app.getNavigationHelper().gotoGroupPage();
////      app.getGroupHelper().deleteGroup();
//      List<UserData> after = app.getUserHelper().getUsersList();
//      Assert.assertEquals(after.size(), before.size() - 1); //сравнение размеров списков до и после удаления
//
//      before.remove(before.size() - 1);
//      Assert.assertEquals(before, after); //сравнение списков целиком
//    } else {
//      app.getUserHelper().createUser(new UserData("Vasya", "Yu", "Pupkin", "VasyaPro", "NIICHAVO", "Moscow, Leninsky tupik, 13", "+7 435 1234567", "+7 916 1234567", "+7 495 1234567", "vasya@pupkin.ru", "Test1"));
//      List<UserData> before = app.getUserHelper().getUsersList();
//      app.getUserHelper().deleteUser(before.size() - 1);
//      List<UserData> after = app.getUserHelper().getUsersList();
//      Assert.assertEquals(after.size(), before.size() - 1); //сравнение размеров списков до и после удаления
//
//      before.remove(before.size() - 1);
//      Assert.assertEquals(before, after); //сравнение списков целиком
//    }
  }
}
