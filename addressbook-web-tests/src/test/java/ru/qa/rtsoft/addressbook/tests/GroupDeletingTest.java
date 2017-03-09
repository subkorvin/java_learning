package ru.qa.rtsoft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.qa.rtsoft.addressbook.model.GroupData;

import java.util.List;

public class GroupDeletingTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.getNavigationHelper().gotoGroupPage();
    if (!app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("Test1", "Test2", "Test3"));
    }
  }

  @Test
  public void testGroupDeleting() {
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().deleteGroup(before.size() - 1); //  второй параметр - выбор удаляемой группы, передается в метод deleteGroup и оттуда - в selectGroup
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size() - 1);
    Assert.assertEquals(before, after);
  }
}
