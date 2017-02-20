package ru.qa.rtsoft.addressbook.tests;

import org.testng.annotations.Test;
import ru.qa.rtsoft.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.gotoGroupPage();
    app.initGroupCreation();
    app.fillGroupForm(new GroupData("Test", "Test1", "Test2"));
    app.submitGroupCreation();
    app.returnToGroupPage();
  }

}
