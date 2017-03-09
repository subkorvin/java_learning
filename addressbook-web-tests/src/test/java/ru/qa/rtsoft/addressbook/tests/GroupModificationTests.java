package ru.qa.rtsoft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.qa.rtsoft.addressbook.model.GroupData;

import java.util.*;

/**
 * Created by korvin on 21.02.2017.
 */
public class GroupModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.getNavigationHelper().gotoGroupPage();
    if (!app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("Test1", "Test2", "Test3"));
    }
  }

  @Test
  public void testGroupModification () {
    List<GroupData> before = app.getGroupHelper().getGroupList();
    int groupNumber = 1; // выбор номера группы в естественном виде (groupNumber == before.size() - 1)
    groupNumber = groupNumber - 1; // уменьшаем номер на единицу потому что отсчет идет с нуля
    GroupData group = new GroupData(before.get(groupNumber).getId(), "Test2", "Test3", "Test4");
    app.getGroupHelper().modifyGroup(group, groupNumber); // второй параметр - выбор модифицируемой группы, передается в метод modifyGroup и оттуда - в selectGroup
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(groupNumber);
    before.add(group);
    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
