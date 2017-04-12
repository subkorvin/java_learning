package ru.qa.rtsoft.rest.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by korvin on 20.02.2017.
 */
public class ApplicationManager {

  private final Properties properties;
  private WebDriver wd;

  private String browser;
  private RestHelper restHelper;


  public ApplicationManager(String browser) {
    this.browser = browser;
    properties = new Properties();
  }


  public void init() throws IOException {
    String target = System.getProperty("target", "local");
    properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
  }

  public void stop() {
    if (wd != null) {
      wd.quit();
    }
  }


  public String getProperty(String key) {
    return properties.getProperty(key);
  }


  public RestHelper rest() {
    if (restHelper == null) {
      restHelper = new RestHelper(this);
    }
    return restHelper;
  }

  public WebDriver getDriver() {
    if (wd == null) {
      if (Objects.equals(browser, BrowserType.FIREFOX)) {
        wd = new FirefoxDriver();
        wd.manage().window().maximize();
      } else if (Objects.equals(browser, BrowserType.CHROME)) {
        wd = new ChromeDriver();
        wd.manage().window().maximize();
      } else if (Objects.equals(browser, BrowserType.IE)) {
        wd = new InternetExplorerDriver();
      }
      wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  //установка тайм-аута для ожидания загрузки страницы
      wd.get(properties.getProperty("web.baseUrl"));
    }
    return wd;
  }
}
