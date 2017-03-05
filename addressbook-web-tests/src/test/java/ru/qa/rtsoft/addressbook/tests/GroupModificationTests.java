package ru.qa.rtsoft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.qa.rtsoft.addressbook.model.GroupData;

import java.util.List;

/**
 * Created by korvin on 21.02.2017.
 */
public class GroupModificationTests extends TestBase {

  @Test
  public void testGroupModification () {
    app.getNavigationHelper().gotoGroupPage();
    if (! app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("Test1", "Test2", "Test3"));
    }
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().modifyGroup(new GroupData("Test2", "Test3", "Test4"), before.size() - 1);
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size());
  }
}
