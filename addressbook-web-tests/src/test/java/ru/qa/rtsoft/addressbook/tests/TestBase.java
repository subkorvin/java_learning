package ru.qa.rtsoft.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.qa.rtsoft.addressbook.appmanager.ApplicationManager;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by korvin on 20.02.2017.
 */
public class TestBase {

  Logger logger = LoggerFactory.getLogger(TestBase.class);


  protected static ApplicationManager app;

  @BeforeSuite
  public void setUp() throws Exception {
    app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));
    app.init();
  }

  @AfterSuite (alwaysRun = true)
  public void tearDown() {
    app.stop();
  }


  public static ApplicationManager getApp() {
    return app;
  }

  @BeforeMethod
  public void logTestStart(Method m, Object[] p) {
    logger.info("Start test " + m.getName() + " with parameters " + Arrays.asList(p));
  }

  @AfterMethod(alwaysRun = true)
  public void logTestStop(Method m, Object[] p) {
    logger.info("Stop test " + m.getName() + " with parameters " + Arrays.asList(p));
  }
}
