package ru.qa.rtsoft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.qa.rtsoft.addressbook.model.GroupData;
import ru.qa.rtsoft.addressbook.model.UserData;

import java.util.Comparator;
import java.util.List;


public class UserCreationTest extends TestBase {

  @Test
  public void testUserCreation() {
    app.getNavigationHelper().gotoGroupPage();
    if (!app.getGroupHelper().isThereAGroup()) { // проверяем наличие хотя бы одной группы, если есть - переходим к созданию пользователя, если нет - создаем группу
      app.getGroupHelper().createGroup(new GroupData("Test1", "Test2", "Test3"));
    }
    app.getNavigationHelper().returnToHomePage(); // переход требуется для корректного вычисления списка пользователей до добавления
    List<UserData> before = app.getUserHelper().getUsersList();
    UserData user = new UserData("1", "Yu", "Pupkin", "VasyaPro", "NIICHAVO", "Moscow, Leninsky tupik, 13", "+7 435 1234567", "+7 916 1234567", "+7 495 1234567", "vasya@pupkin.ru", "Test1");
    app.getUserHelper().createUser(user);
    List<UserData> after = app.getUserHelper().getUsersList();
    Assert.assertEquals(after.size(), before.size() + 1); //сравнение размеров списков до и после удаления
    before.add(user);
    Comparator<? super UserData> byId = (u1, u2) -> Integer.compare(u1.getId(), u2.getId()); //вычисление наибольшего id
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
