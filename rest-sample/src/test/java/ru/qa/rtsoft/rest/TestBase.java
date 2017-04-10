package ru.qa.rtsoft.rest;

import appmanager.ApplicationManager;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.jayway.restassured.RestAssured;
import model.Issue;
import org.openqa.selenium.remote.BrowserType;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Objects;
import java.util.Set;

/**
 * Created by korvin on 20.02.2017.
 */
public class TestBase {


  protected static ApplicationManager app;

  @BeforeSuite
  public void setUp() throws Exception {
    app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));
    app.init();
    //app.ftp().upload(new File("src/test/resources/config_inc.php"), "config_inc.php", "config_inc.php.bak");
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() throws IOException {
    //app.ftp().restore("config_inc.php.bak", "config_inc.php");
    app.stop();
  }


  public static ApplicationManager getApp() {
    return app;
  }

  public boolean isIssueOpen(int issueId) throws IOException {
    Set<Issue> issues = app.rest().getIssues();
    RestAssuredTests rt = new RestAssuredTests();
    int issuedId = rt.getIssueId(issueId);
    System.out.println(issuedId);
    String json = RestAssured.get("http://demo.bugify.com/api//issues/" + issuedId + ".json").asString();
    JsonElement parsed = new JsonParser().parse(json);
    System.out.println(parsed);
//    IssueData issue = mc.mc_issue_get("administrator", "root", BigInteger.valueOf(issuedId));
//    ObjectRef resolution = issue.getResolution();
//    if (!Objects.equals(resolution.getName(), "fixed")) {
//      return true;
//    } else {
//      return false;
//    }
  return true;
  }



  public void skipIfNotFixed(int issueId) throws IOException {
    if (isIssueOpen(issueId)) {
      throw new SkipException("Ignored because of issue " + issueId);
    }
  }
}
