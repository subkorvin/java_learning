package ru.qa.rtsoft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.qa.rtsoft.addressbook.model.UserData;

/**
 * Created by korvin on 20.02.2017.
 */
public class UserHelper extends HelperBase{

  public UserHelper(WebDriver wd) {

    super(wd);
  }

  public void submitNewUserCreation() {
    click(By.name("submit"));
  }

  public void fillUserFormFields(UserData userData, boolean creation) {
    type((By.name("firstname")), userData.getFirst_name());
    type((By.name("middlename")), userData.getMiddle_name());
    type((By.name("lastname")), userData.getFamily_name());
    type((By.name("nickname")), userData.getNickname());
    type((By.name("company")), userData.getCompany());
    type((By.name("address")), userData.getAddress());
    type((By.name("home")), userData.getHome_phone());
    type((By.name("mobile")), userData.getCell_phone());
    type((By.name("work")), userData.getWork_phone());
    type((By.name("email")), userData.getEmail());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(userData.getGroup());
    } else {
      Assert.assertFalse (isElementPresent (By.name("new_group")));
    }
  }

  public void initNewUserCreation() {
    click(By.linkText("add new"));
  }

  public void selectUser() {
    click(By.xpath("//div/div[4]/form[2]/table/tbody/tr[2]/td[1]/input"));
  }

  public void initUserModification() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
  }

  public void submitUserModification() {
    click(By.name("update"));
  }

  public void initUserDeleting() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void confirmationUserDeleting() {
    confirm();
  }

  public void createUser(UserData user, boolean b) {
    initNewUserCreation();
    fillUserFormFields(user, b);
    submitNewUserCreation();
  }

  public boolean isThereAUser() {
    return isElementPresent(By.xpath("//div/div[4]/form[2]/table/tbody/tr[2]/td[1]/input"));
  }

  public void deleteUser() {
    selectUser();
    initUserDeleting();
    confirmationUserDeleting();
  }

  public void modifyUser(UserData user, boolean b) {
    initUserModification();
    fillUserFormFields(user, b);
    submitUserModification();
    }
}
