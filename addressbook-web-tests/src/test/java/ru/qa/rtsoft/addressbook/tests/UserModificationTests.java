package ru.qa.rtsoft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.qa.rtsoft.addressbook.model.GroupData;
import ru.qa.rtsoft.addressbook.model.UserData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by korvin on 21.02.2017.
 */
public class UserModificationTests extends TestBase {

  @Test
  public void testUserModification() {
    /*
    * проверяем наличие хотя бы одного пользователя
    * если пользователь есть - проверяем можем ли модифицировать указанного в userNumber пользователя
    *   если номер некорректный тест завершаем, выводим ругательное сообщение в консоль
    *   если номер корректный - модифицируем пользователя
    * если нет - переходим к проверке наличия хотя бы одной группы
    */
    if (app.getUserHelper().isThereAUser()) {
      List<UserData> before = app.getUserHelper().getUsersList();
      int userNumber = 1; //номер модифицируемого пользователя в естественном виде
      userNumber = userNumber - 1; // уменьшаем номер на единицу, потому что отсчет идет с нуля
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
    } else {
      app.getNavigationHelper().gotoGroupPage();
      /*
      * пользователя нет
      * проверяем наличие хотя бы одной группы
      * если группа есть - выходим из if и переходим к созданию пользователя и его модификации
      * если группы нет - создаем группу, создаем пользователя и модифицируем его
      */
      if (!app.getGroupHelper().isThereAGroup()) {
        app.getGroupHelper().createGroup(new GroupData("Test1", "Test2", "Test3"));
        app.getUserHelper().createUser(new UserData("Vasya", "Yu", "Pupkin", "VasyaPro", "NIICHAVO", "Moscow, Leninsky tupik, 13", "+7 435 1234567", "+7 916 1234567", "+7 495 1234567", "vasya@pupkin.ru", "Test1"));
        List<UserData> before = app.getUserHelper().getUsersList();
        UserData user = new UserData(before.get(before.size() - 1).getId(), "Petya", "A", "Ivanov", "PIvanov", "RTSoft", "Tula, tup. Kommunizma, 13", "+7 815 1234567", "+7 812 1452365", "+7 845 2365486", "p_ivanov@microsoft.com", null);
        app.getUserHelper().modifyUser(user, before.size() - 1);
        List<UserData> after = app.getUserHelper().getUsersList();
        Assert.assertEquals(after.size(), before.size()); //сравнение размеров списков до и после удаления
        before.remove(before.size() - 1);
        before.add(user);
        Assert.assertEquals(before, after); // сортировка списков не выполняется, так как пользователь только один
      } else {
        /*
        * пользователя нет,
        * группа есть,
        * создаем пользователя и модифицируем его
        */
        app.getUserHelper().createUser(new UserData("Vasya", "Yu", "Pupkin", "VasyaPro", "NIICHAVO", "Moscow, Leninsky tupik, 13", "+7 435 1234567", "+7 916 1234567", "+7 495 1234567", "vasya@pupkin.ru", "Test1"));
        List<UserData> before = app.getUserHelper().getUsersList();
        UserData user = new UserData(before.get(before.size() - 1).getId(), "Petya", "A", "Ivanov", "PIvanov", "RTSoft", "Tula, tup. Kommunizma, 13", "+7 815 1234567", "+7 812 1452365", "+7 845 2365486", "p_ivanov@microsoft.com", null);
        app.getUserHelper().modifyUser(user, before.size() - 1);
        List<UserData> after = app.getUserHelper().getUsersList();
        Assert.assertEquals(after.size(), before.size()); //сравнение размеров списков до и после удаления
        before.remove(before.size() - 1);
        before.add(user);
        Assert.assertEquals(before, after); // сортировка списков не выполняется, так как пользователь только один
      }
    }
  }
}