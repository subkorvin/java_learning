package ru.qa.rtsoft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.qa.rtsoft.addressbook.model.GroupData;
import ru.qa.rtsoft.addressbook.model.UserData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

/**
 * Created by korvin on 21.02.2017.
 */
public class UserModificationTests extends TestBase {

  @Test
  public void testUserModification() {
    if (app.getUserHelper().isThereAUser()) {
      List<UserData> before = app.getUserHelper().getUsersList();
      int userNumber = 1; //номер модифицируемого пользователя
      if (userNumber >= 0 && userNumber < before.size()) {
        UserData user = new UserData(before.get(userNumber).getId(), "Petya", "A", "Ivanov", "PIvanov", "RTSoft", "Tula, tup. Kommunizma, 13", "+7 815 1234567", "+7 812 1452365", "+7 845 2365486", "p_ivanov@microsoft.com", null);
        app.getUserHelper().modifyUser(user, userNumber);
        List<UserData> after = app.getUserHelper().getUsersList();
        Assert.assertEquals(after.size(), before.size()); //сравнение размеров списков до и после удаления

        before.remove(userNumber);
        before.add(user);
        Comparator<? super UserData> byId = (u1, u2) -> Integer.compare(u1.getId(), u2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
      } else {
        System.out.println("Некорректный номер пользователя");
        return;
      }
    }else {
      app.getNavigationHelper().gotoGroupPage();
      if (!app.getGroupHelper().isThereAGroup()) {
        app.getGroupHelper().createGroup(new GroupData("Test1", "Test2", "Test3"));
        app.getUserHelper().createUser(new UserData("Vasya", "Yu", "Pupkin", "VasyaPro", "NIICHAVO", "Moscow, Leninsky tupik, 13", "+7 435 1234567", "+7 916 1234567", "+7 495 1234567", "vasya@pupkin.ru", "Test1"));
        app.getUserHelper().modifyUser(new UserData("Petya", "A", "Ivanov", "PIvanov", "RTSoft", "Tula, tup. Kommunizma, 13", "+7 815 1234567", "+7 812 1452365", "+7 845 2365486", "p_ivanov@microsoft.com", null));
      } else {
        app.getUserHelper().createUser(new UserData("Vasya", "Yu", "Pupkin", "VasyaPro", "NIICHAVO", "Moscow, Leninsky tupik, 13", "+7 435 1234567", "+7 916 1234567", "+7 495 1234567", "vasya@pupkin.ru", "Test1"));
        app.getUserHelper().modifyUser(new UserData("Petya", "A", "Ivanov", "PIvanov", "RTSoft", "Tula, tup. Kommunizma, 13", "+7 815 1234567", "+7 812 1452365", "+7 845 2365486", "p_ivanov@microsoft.com", null));
      }
    }
  }

}