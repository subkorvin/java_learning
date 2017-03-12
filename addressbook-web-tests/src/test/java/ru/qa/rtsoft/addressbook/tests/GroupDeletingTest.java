package ru.qa.rtsoft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.qa.rtsoft.addressbook.model.GroupData;

import java.util.Set;

public class GroupDeletingTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.group().set().size() == 0) {
      app.group().create(new GroupData().withGroupname("Test1"));
    }
  }

  @Test
  public void testGroupDeleting() {
    Set<GroupData> before = app.group().set();
    GroupData deletedGroup = before.iterator().next();
    app.group().delete(deletedGroup); //  второй параметр - выбор удаляемой группы, передается в метод delete и оттуда - в selectGroup
    Set<GroupData> after = app.group().set();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(deletedGroup);
    Assert.assertEquals(before, after);
  }
}
