package ru.qa.rtsoft.addressbook;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    gotoGroupPage();
    initGroupCreation();
    fillGroupForm(new GroupData("Test", "Test1", "Test2"));
    submitGroupCreation();
    returnToGroupPage();
  }

}
