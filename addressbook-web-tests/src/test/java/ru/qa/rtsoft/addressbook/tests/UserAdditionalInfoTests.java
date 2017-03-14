package ru.qa.rtsoft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.qa.rtsoft.addressbook.appmanager.HelperBase;
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
            .stream().filter((s) -> !s.equals(""))
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
            .stream().filter((s) -> !s.equals(""))
            .collect(Collectors.joining("\n"));
  }

  @Test
  public void testDetailInfo() {
    app.user().openDetails();
    String details = app.user().userDetails();
    app.goTo().toHomePage();
    UserData user = app.user().set().iterator().next();
    UserData userInfoFromEditForm = app.user().infofromEditForm(user);

//    System.out.print("DETAILS \n" + cleanedDetais(details) + "\n");
//    System.out.print("2 blocks \n" + mergeTwoBlocks(userInfoFromEditForm));
    System.out.println(mergePhonesSuffix(userInfoFromEditForm));

    //assertThat(cleanedDetais(details), equalToObject(mergeTwoBlocks(userInfoFromEditForm)));
  }

  private String mergeNames(UserData user) {
    return Arrays.asList(user.getFirst_name(), user.getMiddle_name(), user.getFamily_name())
            .stream().collect(Collectors.joining(" "));
  }

  private String mergeFirstBlock(UserData user) {
    return Arrays.asList(mergeNames(user), user.getNickname(), user.getCompany(), user.getAddress())
            .stream().collect(Collectors.joining("\n"));
  }

  private String mergePhonesSuffix (UserData user) {
    return Arrays.asList(user.getWork_phone(), user.getCell_phone())
            .stream()
            .filter((s) -> s.equals(user.getWork_phone()))
            .collect(Collectors.joining("W: "));
  }

  private String mergeTwoBlocks(UserData user) {
    return Arrays.asList(mergeFirstBlock(user), mergePhones(user), mergeEmails(user))
            .stream()
            .map(UserAdditionalInfoTests::cleanedDetais)
            .collect(Collectors.joining("\n\n"));
  }

  public static String cleanedDetais(String details) {
    return details.replaceAll("Member of: Test1", "").replaceAll("\n\n\n", "");
  }
}

