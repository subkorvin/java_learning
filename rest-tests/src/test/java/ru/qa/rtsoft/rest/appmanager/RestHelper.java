package ru.qa.rtsoft.rest.appmanager;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.jayway.restassured.RestAssured;
import ru.qa.rtsoft.rest.model.Issue;
import ru.qa.rtsoft.rest.model.Project;

import java.io.IOException;
import java.util.Set;

/**
 * Created by korvin on 12.04.2017.
 */
public class RestHelper {

  private ApplicationManager app;

  public RestHelper(ApplicationManager app) {
    this.app = app;
  }

  public Set<Project> getProjects() {
    String json = RestAssured.get("http://demo.bugify.com/api/projects.json").asString();
    JsonElement parsed = new JsonParser().parse(json);
    JsonElement projects = parsed.getAsJsonObject().get("projects");
    return new Gson().fromJson(projects, new TypeToken<Set<Project>>() {
    }.getType());
  }

  public Set<Issue> getIssues() throws IOException {
    String json = RestAssured.get("http://demo.bugify.com/api/issues.json").asString();
    JsonElement parsed = new JsonParser().parse(json);
    JsonElement issues = parsed.getAsJsonObject().get("issues");
    return new Gson().fromJson(issues, new TypeToken<Set<Issue>>(){}.getType());
  }

  public int createIssue(Issue newIssue) throws IOException {
    String json = RestAssured.given()
            .parameter("subject", newIssue.getSubject())
            .parameter("description", newIssue.getDescription())
            .post("http://demo.bugify.com/api/issues.json").asString();
    JsonElement parsed = new JsonParser().parse(json);
    return parsed.getAsJsonObject().get("issue_id").getAsInt();
  }
}
