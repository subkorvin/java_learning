package ru.qa.rtsoft.rest;

import appmanager.ApplicationManager;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.jayway.restassured.RestAssured;
import org.testng.SkipException;

import java.io.IOException;

/**
 * Created by korvin on 20.02.2017.
 */
public class TestBase {


  protected static ApplicationManager app;

  public static ApplicationManager getApp() {
    return app;
  }

  public boolean isIssueOpen(int issueId) throws IOException {
    RestAssuredTests rt = new RestAssuredTests();
    int issuedId = rt.getIssueId(issueId);
    System.out.println(issuedId);
    String json = RestAssured.get("http:/demo.bugify.com/api/issues/" + issuedId + ".json").asString();
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
