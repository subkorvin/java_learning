package ru.qa.rtsoft.addressbook.tests;

import org.testng.annotations.Test;
import ru.qa.rtsoft.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
<<<<<<< HEAD
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupForm(new GroupData("Test", "Test1", "Test2"));
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();
=======
    app.gotoGroupPage();
    app.initGroupCreation();
    app.fillGroupForm(new GroupData("Test", "Test1", "Test2"));
    app.submitGroupCreation();
    app.returnToGroupPage();
>>>>>>> origin/master
  }

}
