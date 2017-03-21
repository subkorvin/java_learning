package ru.qa.rtsoft.addressbook.tests;

import org.testng.annotations.Test;
import ru.qa.rtsoft.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by korvin on 21.03.2017.
 */
public class Temp extends TestBase {
  @Test
  public void findGroup() {
    app.goTo().groupPage();
    List<GroupData> groups = new ArrayList<>(app.group().set());
    for (GroupData group : groups) {
      String name = group.getGroupname();

      //Iterator group = groups.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
    }
  }
}
