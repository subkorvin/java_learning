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
    if (app.user().list().size() != 0) { // проверка налиичия хотя бы одного пользователя, если есть - удаляем согласно userNumber, если нет - переходим к проверке наличия группы
      List<UserData> before = app.user().list();
      int userNumber = 5; //номер удаляемого пользователя в естественном виде
      userNumber = userNumber - 1; // уменьшаем номер на единицу, потому что отсчет идет с нуля
      if (userNumber >= 0 && userNumber < before.size()) {
        app.user().delete(userNumber);
        List<UserData> after = app.user().list();
        Assert.assertEquals(after.size(), before.size() - 1); //сравнение размеров списков до и после удаления
        before.remove(userNumber);
        Assert.assertEquals(before, after); //сравнение списков целиком
      } else {
        System.out.println("Некорректный номер пользователя");
        return;
      }
    } else {
      app.goTo().groupPage();
    /*
    * проверка наличия хотя бы одной группы
    * если есть - переходим к созданию пользователя и затем удаляем его
    * если нет - создаем сначала группу, потом создаем пользователя и удаляем его же
    */
      if (app.group().list().size() == 0) { //
        app.group().create(new GroupData().withGroupname("Test1").withGroupheader("Test2").withGroupfooter("Test3"));
        app.user().create(new UserData("Vasya", "Yu", "Pupkin", "VasyaPro", "NIICHAVO", "Moscow, Leninsky tupik, 13", "+7 435 1234567", "+7 916 1234567", "+7 495 1234567", "vasya@pupkin.ru", "Test1"));
        List<UserData> before = app.user().list();
        app.user().delete(before.size() - 1);
//      app.goTo().groupPage();
//      app.group().delete(); // подчистка за собой, удаляем созданную группу
        List<UserData> after = app.user().list();
        Assert.assertEquals(after.size(), before.size() - 1); //сравнение размеров списков до и после удаления
        before.remove(before.size() - 1);
        Assert.assertEquals(before, after); //сравнение списков целиком

      } else { // если группа есть, создаем пользователя и удаляем его же
        app.user().create(new UserData("Vasya", "Yu", "Pupkin", "VasyaPro", "NIICHAVO", "Moscow, Leninsky tupik, 13", "+7 435 1234567", "+7 916 1234567", "+7 495 1234567", "vasya@pupkin.ru", "Test1"));
        List<UserData> before = app.user().list();
        app.user().delete(before.size() - 1);
        List<UserData> after = app.user().list();
        Assert.assertEquals(after.size(), before.size() - 1); //сравнение размеров списков до и после удаления
        before.remove(before.size() - 1);
        Assert.assertEquals(before, after); //сравнение списков целиком
      }
    }
  }
}
