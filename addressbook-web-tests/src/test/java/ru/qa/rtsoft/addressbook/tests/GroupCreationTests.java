package ru.qa.rtsoft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.qa.rtsoft.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().gotoGroupPage();
    int before = app.getGroupHelper().getGroupCount();
    app.getGroupHelper().createGroup(new GroupData("xrwer23", "Test4", "Test5"));
    int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after, before + 1);
  }
}
