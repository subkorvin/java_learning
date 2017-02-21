package ru.qa.rtsoft.addressbook.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.qa.rtsoft.addressbook.appmanager.ApplicationManager;

/**
 * Created by korvin on 20.02.2017.
 */
public class TestBase {

  protected final ApplicationManager app = new ApplicationManager();

  @BeforeMethod
  public void setUp() throws Exception {
    app.init();
  }

  @AfterMethod
  public void tearDown() {
    app.stop();
  }


  public ApplicationManager getApp() {
    return app;
  }
}
