package ru.qa.rtsoft.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by korvin on 21.02.2017.
 */
public class UserModificationTests extends TestBase {

  @Test
  public void testUserModification(){
    app.getUserHelper().selectUser();
  }
}
