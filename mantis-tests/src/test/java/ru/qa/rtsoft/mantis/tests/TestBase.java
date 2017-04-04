package ru.qa.rtsoft.mantis.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.qa.rtsoft.mantis.appmanager.ApplicationManager;

import java.io.File;
import java.io.IOException;

/**
 * Created by korvin on 20.02.2017.
 */
public class TestBase {


  protected static ApplicationManager app;

  @BeforeSuite
  public void setUp() throws Exception {
    app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));
    app.init();
    app.ftp().upload(new File("src/test/resources/config_inc.php"), "config_inc.php", "config_inc.php.bak");
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() throws IOException {
    app.ftp().restore("config_inc.php.bak", "config_inc.php");
    app.stop();
  }


  public static ApplicationManager getApp() {
    return app;
  }

//  protected UserData refreshUserData(UserData selectedUser, int userId) {
//    Users usersAfter = app.db().users();
//    for (UserData user : usersAfter) {
//      if (user.getId() == userId) {
//        selectedUser = user;
//      }
//    }
//    return selectedUser;
//  }
}
