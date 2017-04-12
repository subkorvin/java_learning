package ru.qa.rtsoft.github;

import com.google.common.collect.ImmutableMap;
import com.jcabi.github.*;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by korvin on 12.04.2017.
 */
public class GithubTests {

  @Test
  public void testCommits() throws IOException {
    Github github = new RtGithub("052a9f1ed24f404d1cd28a96ce2a9dbdf2b056c9");
    RepoCommits commits = github.repos().get(new Coordinates.Simple("subkorvin", "java_learning")).commits();
    for (RepoCommit commit : commits.iterate(new ImmutableMap.Builder<String, String>().build())) {
      System.out.println(new RepoCommit.Smart(commit).message());
    }
  }
}
