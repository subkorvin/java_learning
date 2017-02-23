package ru.qa.rtsoft.addressbook.tests;

import org.testng.annotations.Test;
import ru.qa.rtsoft.addressbook.model.UserData;

/**
 * Created by korvin on 21.02.2017.
 */
public class UserModificationTests extends TestBase {

  @Test
  public void testUserModification(){
    app.getUserHelper().initUserModification();
    app.getUserHelper().fillNewUserFormFields(new UserData("Petya", "A", "Ivanov", "PIvanov", "RTSoft", "Tula, tup. Kommunizma, 13", "+7 815 1234567", "+7 812 1452365", "+7 845 2365486", "p_ivanov@microsoft.com"));
    app.getUserHelper().submitUserModification();
    app.getNavigationHelper().returnToHomePage();
  }
}
