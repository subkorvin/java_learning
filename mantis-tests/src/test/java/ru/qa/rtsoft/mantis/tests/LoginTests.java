package ru.qa.rtsoft.mantis.tests;

import org.testng.annotations.Test;
import ru.qa.rtsoft.mantis.appmanager.HttpSession;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

/**
 * Created by korvin on 03.04.2017.
 */
public class LoginTests extends TestBase {

  @Test
  public void testLogin () throws IOException {
    HttpSession session = app.newSession();
    assertTrue(session.login("administrator", "root"));
    assertTrue(session.isLoggedIn("administrator"));
  }
}
