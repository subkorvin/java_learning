package ru.qa.rtsoft.addressbook.tests;

import org.testng.annotations.Test;
import ru.qa.rtsoft.addressbook.model.GroupData;
import ru.qa.rtsoft.addressbook.model.UserData;
import ru.qa.rtsoft.addressbook.model.Users;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

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
    if (app.user().set().size() != 0) {
      Users before = app.user().set();
      UserData modifiedUser = before.iterator().next();
      UserData user = new UserData()
              .withId(modifiedUser.getId())
              .withFirst_name("Vasya")
              .withMiddle_name("Yu")
              .withFamily_name("Pupkin")
              .withNickname("VasyaPro")
              .withCompany("NIICHAVO")
              .withAddress("Moscow, Leninsky tupik, 13")
              .withHome_phone("+7 435 1234567")
              .withCell_phone("+7 916 1234567")
              .withWork_phone("+7 495 1234567")
              .withEmail("vasya@pupkin.ru");
      app.user().modify(user);
      assertEquals(app.group().count(), before.size()); //сравнение размеров списков до и после удаления
      Users after = app.user().set();
      assertThat(after, equalTo(before.without(modifiedUser).withAdded(user)));
    } else {
      app.goTo().groupPage();
      /*
      * пользователя нет
      * проверяем наличие хотя бы одной группы
      * если группа есть - выходим из if и переходим к созданию пользователя и его модификации
      * если группы нет - создаем группу, создаем пользователя и модифицируем его
      */
      if (app.group().set().size() == 0) {
        app.group().create(new GroupData().withGroupname("Test1").withGroupheader("Test2").withGroupfooter("Test3"));
        app.user().create(new UserData()
                .withFirst_name("Vasya")
                .withMiddle_name("Yu")
                .withFamily_name("Pupkin")
                .withNickname("VasyaPro")
                .withCompany("NIICHAVO")
                .withAddress("Moscow, Leninsky tupik, 13")
                .withHome_phone("+7 435 1234567")
                .withCell_phone("+7 916 1234567")
                .withWork_phone("+7 495 1234567")
                .withEmail("vasya@pupkin.ru")
                .withGroup("Test1"));
        Users before = app.user().set();
        UserData modifiedUser = before.iterator().next();
        UserData user = new UserData()
                .withId(modifiedUser.getId())
                .withFirst_name("Vasya")
                .withMiddle_name("Yu")
                .withFamily_name("Pupkin")
                .withNickname("VasyaPro")
                .withCompany("NIICHAVO")
                .withAddress("Moscow, Leninsky tupik, 13")
                .withHome_phone("+7 435 1234567")
                .withCell_phone("+7 916 1234567")
                .withWork_phone("+7 495 1234567")
                .withEmail("vasya@pupkin.ru");
        app.user().modify(user);
        assertEquals(app.group().count(), before.size()); //сравнение размеров списков до и после удаления
        Users after = app.user().set();
        assertThat(after, equalTo(before.without(modifiedUser).withAdded(user)));
      } else {
        /*
        * пользователя нет,
        * группа есть,
        * создаем пользователя и модифицируем его
        */
        app.user().create(new UserData()
                .withFirst_name("Vasya")
                .withMiddle_name("Yu")
                .withFamily_name("Pupkin")
                .withNickname("VasyaPro")
                .withCompany("NIICHAVO")
                .withAddress("Moscow, Leninsky tupik, 13")
                .withHome_phone("+7 435 1234567")
                .withCell_phone("+7 916 1234567")
                .withWork_phone("+7 495 1234567")
                .withEmail("vasya@pupkin.ru")
                .withGroup("Test1"));
        Users before = app.user().set();
        UserData modifiedUser = before.iterator().next();
        UserData user = new UserData()
                .withId(modifiedUser.getId())
                .withFirst_name("Petya")
                .withMiddle_name("A")
                .withFamily_name("Ivanov")
                .withNickname("PIvanov")
                .withCompany("RTSoft")
                .withAddress("Tula, tup. Kommunizma, 13")
                .withHome_phone("+7 815 1234567")
                .withCell_phone("+7 812 1452365")
                .withWork_phone("+7 845 2365486")
                .withEmail("p_ivanov@microsoft.com");
        app.user().modify(user);
        assertEquals(app.group().count(), before.size()); //сравнение размеров списков до и после удаления
        Users after = app.user().set();
        assertThat(after, equalTo(before.without(modifiedUser).withAdded(user)));
      }
    }
  }
}
