package ru.qa.rtsoft.addressbook.tests;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.qa.rtsoft.addressbook.model.GroupData;
import ru.qa.rtsoft.addressbook.model.UserData;
import ru.qa.rtsoft.addressbook.model.Users;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class UserCreationTest extends TestBase {

  @DataProvider
  public Iterator<Object[]> validUsersFromXml () throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/users1.xml")));
    String xml = "";
    String line = reader.readLine();
    while (line != null) {
      xml += line;
      line = reader.readLine();
    }
    XStream xstream = new XStream();
    xstream.processAnnotations(UserData.class);
    List<UserData> users = (List<UserData>) xstream.fromXML(xml);
    return users.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
  }

  @DataProvider
  public Iterator<Object[]> validUsersFromJson () throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/users_p.json")));
    String json = "";
    String line = reader.readLine();
    while (line != null) {
      json += line;
      line = reader.readLine();
    }
    Gson gson = new Gson();
    List<UserData> users = gson.fromJson(json, new TypeToken<List<UserData>>(){}.getType());
    return users.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
  }



  @Test (dataProvider = "validUsersFromJson")
  public void testUserCreation(UserData user) {
    app.goTo().groupPage();
    if (app.group().set().size() == 0) { // проверяем наличие хотя бы одной группы, если есть - переходим к созданию пользователя, если нет - создаем группу
      app.group().create(new GroupData().withGroupname("Test1").withGroupheader("Test2").withGroupfooter("Test3"));
    }
    app.goTo().toHomePage(); // переход требуется для корректного вычисления списка пользователей до добавления
    Users before = app.user().set();
    app.user().create(user);
    assertThat(app.user().count(), equalTo(before.size() + 1)); //сравнение размеров списков до и после удаления
    Users after = app.user().set();
    assertThat(after, equalTo(before.withAdded(user.withId(after.stream().mapToInt((u) -> u.getId()).max().getAsInt()))));
  }
}
