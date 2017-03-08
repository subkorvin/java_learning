package ru.qa.rtsoft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.qa.rtsoft.addressbook.model.UserData;

import java.util.Comparator;
import java.util.List;


public class UserCreationTest extends TestBase {

  @Test
  public void testUserCreation() {
//    app.getNavigationHelper().gotoGroupPage();
//    if (!app.getGroupHelper().isThereAGroup()) {
//      app.getGroupHelper().createGroup(new GroupData("Test1", "Test2", "Test3"));
//    }
    List<UserData> before = app.getUserHelper().getUsersList();
    UserData user = new UserData("Serioga", "Yu", "Pupkin", "VasyaPro", "NIICHAVO", "Moscow, Leninsky tupik, 13", "+7 435 1234567", "+7 916 1234567", "+7 495 1234567", "vasya@pupkin.ru", "Test1");
    app.getUserHelper().createUser(user);
    List<UserData> after = app.getUserHelper().getUsersList();
    Assert.assertEquals(after.size(), before.size() + 1); //сравнение размеров списков до и после удаления

    before.add(user);
    Comparator<? super UserData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId()); //вычисление наибольшего id
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
