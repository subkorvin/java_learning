package ru.qa.rtsoft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.qa.rtsoft.addressbook.model.GroupData;
import ru.qa.rtsoft.addressbook.model.UserData;

import java.util.Set;


public class UserCreationTest extends TestBase {

  @Test
  public void testUserCreation() {
    app.goTo().groupPage();
    if (app.group().set().size() == 0) { // проверяем наличие хотя бы одной группы, если есть - переходим к созданию пользователя, если нет - создаем группу
      app.group().create(new GroupData().withGroupname("Test1").withGroupheader("Test2").withGroupfooter("Test3"));
    }
    app.goTo().toHomePage(); // переход требуется для корректного вычисления списка пользователей до добавления
    Set<UserData> before = app.user().set();
    UserData user = new UserData()
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
            .withGroup("Test1");
    app.user().create(user);
    Set<UserData> after = app.user().set();
    Assert.assertEquals(after.size(), before.size() + 1); //сравнение размеров списков до и после удаления


    user.withId(after.stream().mapToInt((u) -> u.getId()).max().getAsInt());
    before.add(user);
    Assert.assertEquals(before, after);
  }
}
