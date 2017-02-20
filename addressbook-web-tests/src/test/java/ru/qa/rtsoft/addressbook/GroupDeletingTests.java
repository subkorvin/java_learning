package ru.qa.rtsoft.addressbook;

import org.testng.annotations.Test;

public class GroupDeletingTests extends TestBase {

  @Test
  public void testGroupDeleting() {
    gotoGroupPage();
    selectGroup();
    deleteSelectedGroups();
    returnToGroupPage();
  }

}
