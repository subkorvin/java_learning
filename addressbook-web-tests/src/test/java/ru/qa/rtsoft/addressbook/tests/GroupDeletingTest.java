package ru.qa.rtsoft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.qa.rtsoft.addressbook.model.GroupData;

import java.util.List;

public class GroupDeletingTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.group().list().size() == 0) {
      app.group().create(new GroupData().withGroupname("Test1"));
    }
  }

  @Test
  public void testGroupDeleting() {
    List<GroupData> before = app.group().list();
    app.group().delete(before.size() - 1); //  второй параметр - выбор удаляемой группы, передается в метод delete и оттуда - в selectGroup
    List<GroupData> after = app.group().list();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size() - 1);
    Assert.assertEquals(before, after);
  }
}
