package ru.qa.rtsoft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by korvin on 20.02.2017.
 */
public class NavigationHelper extends HelperBase{

  public NavigationHelper(WebDriver wd) {

    super(wd);
  }

  public void gotoGroupPage() {
    click(By.linkText("groups"));
  }

  public void returnToHomePage() {
    click(By.linkText("home"));
  }
}
