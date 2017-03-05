package ru.qa.rtsoft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.qa.rtsoft.addressbook.model.GroupData;

import java.util.List;

public class GroupDeletingTest extends TestBase {

  @Test
  public void testGroupDeleting() {
    app.getNavigationHelper().gotoGroupPage();
    if (!app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("Test1", "Test2", "Test3"));
    }
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().deleteGroup(before.size() - 1);
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() - 1);
  }
}
