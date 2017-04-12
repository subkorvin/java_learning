package ru.qa.rtsoft.rest.tests;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.jayway.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.qa.rtsoft.rest.model.Issue;
import ru.qa.rtsoft.rest.model.Project;

import java.io.IOException;
import java.util.Set;

import static org.testng.Assert.assertEquals;

/**
 * Created by korvin on 12.04.2017.
 */
public class RestAssuredTests extends TestBase {

  @BeforeClass
  public void init() {
    RestAssured.authentication = RestAssured.basic("LSGjeU4yP1X493ud1hNniA==", "");
  }

  public int issueId;

  @Test
  public void testCreateIssue() throws IOException {
    issueId = 5;
    skipTest();
    Set<Issue> oldIssues = app.rest().getIssues();
    Issue newIssue = new Issue().withSubject("Test issue").withDescription("Test description");
    int issueId = app.rest().createIssue(newIssue);
    Set<Issue> newIssues = app.rest().getIssues();
    oldIssues.add(newIssue.withId(issueId));
    assertEquals(newIssues, oldIssues);
  }

  @Test
  public void testGetProjects() throws IOException {
    issueId = 8;
    skipTest();
    Set<Project> projects = app.rest().getProjects();
    for (Project project : projects) {
      System.out.println("Name is " + project.getName());
    }
  }

  @Test
  public void testGetIssue() throws IOException {
    issueId = 4;
    skipTest();
    String json = RestAssured.get("http://demo.bugify.com/api/issues/" + issueId + ".json").asString();
    JsonElement parsed = new JsonParser().parse(json);
    System.out.println(parsed);
  }


  public int getIssueId(int issueId) {
    return issueId;
  }

  public void skipTest() throws IOException {
    TestBase tb = new TestBase();
    tb.skipIfNotFixed(issueId);
  }
}
