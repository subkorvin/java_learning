package ru.qa.rtsoft.mantis.tests;

import biz.futureware.mantis.rpc.soap.client.IssueData;
import biz.futureware.mantis.rpc.soap.client.MantisConnectPortType;
import biz.futureware.mantis.rpc.soap.client.ObjectRef;
import org.testng.annotations.Test;
import ru.qa.rtsoft.mantis.model.Issue;
import ru.qa.rtsoft.mantis.model.Project;

import javax.xml.rpc.ServiceException;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.Set;

import static org.testng.Assert.assertEquals;

/**
 * Created by korvin on 06.04.2017.
 */
public class SoapTests extends TestBase{

  @Test (enabled = false)
  public void testGetProject() throws MalformedURLException, ServiceException, RemoteException {
    Set<Project> projects = app.soap().getProjects();
    System.out.println(projects.size());
    for (Project project : projects) {
      System.out.println(project.getName());
    }
  }

  @Test (enabled = false)
  public void testCreateIssue() throws RemoteException, ServiceException, MalformedURLException {
    Set<Project> projects = app.soap().getProjects();
    Issue issue = new Issue()
            .withSummary("Test issue")
            .withDescription("Test issue desription")
            .withProject(projects.iterator().next());
    Issue created = app.soap().addIssue(issue);
    assertEquals(issue.getSummary(), created.getSummary());
  }

  @Test
  public void testTemp() throws RemoteException, ServiceException, MalformedURLException {
    MantisConnectPortType mc = app.soap().getMantisConnect();
    IssueData issue = mc.mc_issue_get("administrator", "root", BigInteger.valueOf(1));
    ObjectRef resolution = issue.getResolution();
    System.out.println(resolution.getName());

//    Set<Project> projects = app.soap().getProjects();
//    Project project = projects.stream().filter((p) -> p.getName().equals("test")).findAny().get();

    //isIssueOpen(000001);
  }
}
