package ru.qa.rtsoft.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.qa.rtsoft.addressbook.appmanager.ApplicationManager;

/**
 * Created by korvin on 20.02.2017.
 */
public class TestBase {

  protected static ApplicationManager app;

  @BeforeMethod
  public void setUp() throws Exception {
    app = new ApplicationManager(BrowserType.FIREFOX);
    app.init();
  }

  @AfterMethod
  public void tearDown() {
    app.stop();
  }


  public static ApplicationManager getApp() {
    return app;
  }
}
