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
    if (app.getUserHelper().isThereAUser()) { // проверка налиичия хотя бы одного пользователя, если есть - удаляем согласно userNumber, если нет - переходим к проверке наличия группы
      List<UserData> before = app.getUserHelper().getUsersList();
      int userNumber = 1; //номер модифицируемого пользователя в естественном виде
      userNumber = userNumber - 1; // уменьшаем номер на единицу, потому что отсчет идет с нуля
      if (userNumber >= 0 && userNumber < before.size()) {
        app.getUserHelper().deleteUser(userNumber);
        List<UserData> after = app.getUserHelper().getUsersList();
        Assert.assertEquals(after.size(), before.size() - 1); //сравнение размеров списков до и после удаления
        before.remove(userNumber);
        Assert.assertEquals(before, after); //сравнение списков целиком
      } else {
        System.out.println("Некорректный номер пользователя");
        return;
      }
    } else {
      app.getNavigationHelper().gotoGroupPage();
    /*
    * проверка наличия хотя бы одной группы
    * если есть - переходим к созданию пользователя и затем удаляем его
    * если нет - создаем сначала группу, потом создаем пользователя и удаляем его же
    */
      if (!app.getGroupHelper().isThereAGroup()) { //
        app.getGroupHelper().createGroup(new GroupData("Test1", "Test2", "Test3"));
        app.getUserHelper().createUser(new UserData("Vasya", "Yu", "Pupkin", "VasyaPro", "NIICHAVO", "Moscow, Leninsky tupik, 13", "+7 435 1234567", "+7 916 1234567", "+7 495 1234567", "vasya@pupkin.ru", "Test1"));
        List<UserData> before = app.getUserHelper().getUsersList();
        app.getUserHelper().deleteUser(before.size() - 1);
//      app.getNavigationHelper().gotoGroupPage();
//      app.getGroupHelper().deleteGroup(); // подчистка за собой, удаляем созданную группу
        List<UserData> after = app.getUserHelper().getUsersList();
        Assert.assertEquals(after.size(), before.size() - 1); //сравнение размеров списков до и после удаления
        before.remove(before.size() - 1);
        Assert.assertEquals(before, after); //сравнение списков целиком
      } else { // если группа есть, создаем пользователя и удаляем его же
        app.getUserHelper().createUser(new UserData("Vasya", "Yu", "Pupkin", "VasyaPro", "NIICHAVO", "Moscow, Leninsky tupik, 13", "+7 435 1234567", "+7 916 1234567", "+7 495 1234567", "vasya@pupkin.ru", "Test1"));
        List<UserData> before = app.getUserHelper().getUsersList();
        app.getUserHelper().deleteUser(before.size() - 1);
        List<UserData> after = app.getUserHelper().getUsersList();
        Assert.assertEquals(after.size(), before.size() - 1); //сравнение размеров списков до и после удаления
        before.remove(before.size() - 1);
        Assert.assertEquals(before, after); //сравнение списков целиком
      }
    }
  }
}
