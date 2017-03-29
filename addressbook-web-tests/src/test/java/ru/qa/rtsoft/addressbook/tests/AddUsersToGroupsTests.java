package ru.qa.rtsoft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.qa.rtsoft.addressbook.model.GroupData;
import ru.qa.rtsoft.addressbook.model.Groups;
import ru.qa.rtsoft.addressbook.model.UserData;
import ru.qa.rtsoft.addressbook.model.Users;

import java.io.File;

/**
 * Created by korvin on 29.03.2017.
 */
public class AddUsersToGroupsTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().groups().size() == 0) { // проверяем наличие хотя бы одной группы, если нет - создаем группу
      app.goTo().groupPage();
      app.group().create(new GroupData().withGroupname("Test1").withGroupheader("Test2").withGroupfooter("Test3"));
      app.goTo().toHomePage();
    } else if (app.db().users().size() == 0) { //проверяем наличие хотя бы одного пользователя, если нет - создаем (в группу не присваиваем)
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
              .withPhoto(new File("src/test/resources/11698799_crop.jpg")));
    }
  }

  @Test
  public void testAddingUserToGroup() {
    Groups groups = app.db().groups();
    Users before = app.db().users();
    UserData user = before.iterator().next();
    GroupData group = groups.iterator().next();
    app.user().addToGroup(before.iterator().next(), groups.iterator().next());

  }

}
