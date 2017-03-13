package ru.qa.rtsoft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.qa.rtsoft.addressbook.model.GroupData;
import ru.qa.rtsoft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

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
    Groups before = app.group().set();
    GroupData deletedGroup = before.iterator().next();
    app.group().delete(deletedGroup);
    Groups after = app.group().set();
    assertEquals(after.size(), before.size() - 1);

    assertThat(after, equalTo(before.without(deletedGroup)));
  }
}
