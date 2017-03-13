package ru.qa.rtsoft.addressbook.tests;

import org.testng.annotations.Test;
import ru.qa.rtsoft.addressbook.model.GroupData;
import ru.qa.rtsoft.addressbook.model.UserData;
import ru.qa.rtsoft.addressbook.model.Users;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

/**
 * Created by Korvin on 21.02.2017.
 */
public class UserDeletingTests extends TestBase {

  @Test
  public void testUserDeleting() {
    if (app.user().set().size() != 0) { // проверка налиичия хотя бы одного пользователя, если есть - удаляем согласно userNumber, если нет - переходим к проверке наличия группы
      Users before = app.user().set();
      UserData deletedUser = before.iterator().next();
      app.user().delete(deletedUser);
      assertEquals(app.group().count(), before.size() - 1); //сравнение размеров списков до и после удаления
      Users after = app.user().set();
      assertThat(after, equalTo(before.without(deletedUser)));
    } else {
      app.goTo().groupPage();
    /*
    * проверка наличия хотя бы одной группы
    * если есть - переходим к созданию пользователя и затем удаляем его
    * если нет - создаем сначала группу, потом создаем пользователя и удаляем его же
    */
      if (app.group().set().size() == 0) { //
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
        UserData deletedUser = before.iterator().next();
        app.user().delete(deletedUser);
        assertEquals(app.group().count(), before.size() - 1); //сравнение размеров списков до и после удаления
        Users after = app.user().set();
        assertThat(after, equalTo(before.without(deletedUser)));

      } else { // если группа есть, создаем пользователя и удаляем его же
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
        UserData deletedUser = before.iterator().next();
        app.user().delete(deletedUser);
        assertEquals(app.group().count(), before.size() - 1); //сравнение размеров списков до и после удаления
        Users after = app.user().set();
        assertThat(after, equalTo(before.without(deletedUser)));
      }
    }
  }
}
