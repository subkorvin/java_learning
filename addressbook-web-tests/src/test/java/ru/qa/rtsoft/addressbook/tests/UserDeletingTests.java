package ru.qa.rtsoft.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by Korvin on 21.02.2017.
 */
public class UserDeletingTests extends TestBase {

  @Test
  public void testUserDeleting() {
    app.getUserHelper().selectUser();
    app.getUserHelper().initUserDeleting();
    app.getUserHelper().confirmationUserDeleting();
    app.getNavigationHelper().returnToHomePage();
  }
}
