package ru.qa.rtsoft.rest;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.jayway.restassured.RestAssured;
import model.Issue;
import model.Projects;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.Set;

import static org.testng.Assert.assertEquals;

/**
 * Created by Korvin on 09.04.2017.
 */
public class RestAssuredTests extends TestBase{



  @BeforeClass
  public void init() {
    RestAssured.authentication = RestAssured.basic("LSGjeU4yP1X493ud1hNniA==", "");
  }
  public int issueId;

  @Test
  public void testCreateIssue() throws IOException {
    issueId = 1;
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
    issueId = 2;
    skipTest();
    Set<Projects> projects = app.rest().getProjects();
    for (Projects project : projects) {
      System.out.println("Name is " + project.getName());
    }
  }

  public int getIssueId(int issueId) {
    return issueId;
  }

  public void skipTest() throws IOException {
    TestBase tb = new TestBase();
    tb.skipIfNotFixed(issueId);
  }
}
