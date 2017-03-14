package ru.qa.rtsoft.addressbook.tests;

import org.testng.annotations.Test;
import ru.qa.rtsoft.addressbook.model.UserData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.equalToObject;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by korvin on 13.03.2017.
 */
public class UserAdditionalInfoTests extends TestBase {

  @Test
  public void testUserPhones() {
    app.goTo().toHomePage();
    UserData user = app.user().set().iterator().next();
    UserData userInfoFromEditForm = app.user().infofromEditForm(user);

    assertThat(user.getAllPhones(), equalTo(mergePhones(userInfoFromEditForm)));
  }

  private String mergePhones(UserData user) {
    return Arrays.asList(user.getHome_phone(), user.getCell_phone(), user.getWork_phone())
            .stream().filter((s) -> ! s.equals(""))
            .map(UserAdditionalInfoTests::cleaned)
            .collect(Collectors.joining("\n"));
  }

  public static String cleaned(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }

  @Test
  public void testAddresses() {
    app.goTo().toHomePage();
    UserData user = app.user().set().iterator().next();
    UserData userInfoFromEditForm = app.user().infofromEditForm(user);

    assertThat(user.getAddress(), equalToObject(userInfoFromEditForm.getAddress()));
  }

  @Test
  public void testEmails() {
    app.goTo().toHomePage();
    UserData user = app.user().set().iterator().next();
    UserData userInfoFromEditForm = app.user().infofromEditForm(user);

    assertThat(user.getAllEmails(), equalToObject(mergeEmails(userInfoFromEditForm)));
  }

  private String mergeEmails(UserData user) {
    return Arrays.asList(user.getEmail(), user.getEmail2(), user.getEmail3())
            .stream().filter((s) -> ! s.equals(""))
            .collect(Collectors.joining("\n"));
  }
}
