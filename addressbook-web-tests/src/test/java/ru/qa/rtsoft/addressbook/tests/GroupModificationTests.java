package ru.qa.rtsoft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.qa.rtsoft.addressbook.model.GroupData;

/**
 * Created by korvin on 21.02.2017.
 */
public class GroupModificationTests extends TestBase {

  @Test
  public void testGroupModification () {
    app.getNavigationHelper().gotoGroupPage();
    int before = app.getGroupHelper().getGroupCount();
    if (! app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("Test1", "Test2", "Test3"));
    }
    app.getGroupHelper().modifyGroup(new GroupData("Test", "Test2", "Test3"));
    int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after, before);
  }
}
