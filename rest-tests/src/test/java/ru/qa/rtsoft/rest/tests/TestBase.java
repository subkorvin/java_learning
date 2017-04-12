package ru.qa.rtsoft.rest.tests;

import com.google.gson.JsonParser;
import com.jayway.restassured.RestAssured;
import org.openqa.selenium.remote.BrowserType;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.qa.rtsoft.rest.appmanager.ApplicationManager;

import java.io.IOException;
import java.util.Objects;

/**
 * Created by korvin on 12.04.2017.
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
    RestAssuredTests rt = new RestAssuredTests();
    int issuedId = rt.getIssueId(issueId);
    String json = RestAssured.get("http://demo.bugify.com/api/issues/" + issuedId + ".json").asString();
    JsonParser jsonParser = new JsonParser();
    String state = jsonParser.parse(json)
            .getAsJsonObject().getAsJsonArray("issues").get(0)
            .getAsJsonObject().getAsJsonPrimitive("state_name").getAsString();
    System.out.println("Issue ID is " + issuedId + ". Issue's status is " + state);
    if (Objects.equals(state, "Resolved") || Objects.equals(state, "Closed"))     {
      return false;
    } else {
      return true;
    }
  }


  public void skipIfNotFixed(int issueId) throws IOException {
    if (isIssueOpen(issueId)) {
      throw new SkipException("Ignored because of issue " + issueId);
    }
  }
}
