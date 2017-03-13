package ru.qa.rtsoft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.qa.rtsoft.addressbook.model.UserData;
import ru.qa.rtsoft.addressbook.model.Users;
import ru.qa.rtsoft.addressbook.tests.TestBase;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Created by korvin on 20.02.2017.
 */
public class UserHelper extends HelperBase {

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
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void initNewUserCreation() {
    click(By.linkText("add new"));
  }

  private void selectUserById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }

  public void initUserModificationById(int index) {
    wd.findElement(By.xpath("//a[@href='edit.php?id=" + index + "']/img[@title='Edit']")).click();
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

  public void create(UserData user) {
    initNewUserCreation();
    fillUserFormFields(user, true);
    submitNewUserCreation();
    userCache = null;
    TestBase.getApp().goTo().toHomePage();
  }

  public boolean isThereAUser() {
    return isElementPresent(By.xpath("//div/div[4]/form[2]/table/tbody/tr[2]/td[1]/input"));
  }

  public void delete(UserData user) {
    selectUserById(user.getId());
    initUserDeleting();
    confirmationUserDeleting();
    userCache = null;
    TestBase.getApp().goTo().toHomePage();
  }

  public void modify(UserData user) {
    int index = user.getId();
    initUserModificationById(index);
    fillUserFormFields(user, false);
    submitUserModification();
    userCache = null;
    TestBase.getApp().goTo().toHomePage();
  }

  private Users userCache = null;

  public Users set() {
    if (userCache != null) {
      return new Users(userCache);
    }
    userCache = new Users();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      String first_name = element.findElement(By.xpath(".//td[3]")).getText();
      String last_name = element.findElement(By.xpath(".//td[2]")).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      String allPhones = element.findElement(By.xpath(".//td[6]")).getText();
      UserData user = new UserData()
              .withId(id)
              .withFirst_name(first_name)
              .withFamily_name(last_name)
              .withAllPhones(allPhones);
      userCache.add(user);
    }
    return new Users(userCache);
  }


  public UserData infofromEditForm(UserData user) {
    initUserModificationById(user.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    wd.navigate().back();
    return new UserData().withId(user.getId()).withFirst_name(firstname).withFamily_name(lastname).withHome_phone(home).withCell_phone(mobile).withWork_phone(work);
  }
}
