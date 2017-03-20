package ru.qa.rtsoft.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.qa.rtsoft.addressbook.appmanager.ApplicationManager;

/**
 * Created by korvin on 20.02.2017.
 */
public class TestBase {

  protected static ApplicationManager app;

  @BeforeSuite
  public void setUp() throws Exception {
    app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));
    app.init();
  }

  @AfterSuite
  public void tearDown() {
    app.stop();
  }


  public static ApplicationManager getApp() {
    return app;
  }
}
