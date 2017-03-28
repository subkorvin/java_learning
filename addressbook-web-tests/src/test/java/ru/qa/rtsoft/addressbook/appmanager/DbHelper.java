package ru.qa.rtsoft.addressbook.appmanager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.qa.rtsoft.addressbook.model.GroupData;
import ru.qa.rtsoft.addressbook.model.Groups;
import ru.qa.rtsoft.addressbook.model.UserData;
import ru.qa.rtsoft.addressbook.model.Users;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Korvin on 25.03.2017.
 */
public class DbHelper {

  private final SessionFactory sessionFactory;

  public DbHelper() {
    // A SessionFactory is set up once for an application!
    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure() // configures settings from hibernate.cfg.xml
            .build();
      sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
  }

  public Groups groups () {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<GroupData> result = session.createQuery( "from GroupData").list();
    session.getTransaction().commit();
    session.close();
    for ( GroupData group : result ) {
      group.withGroupheader(group.getGroupheader().replaceAll("\r\n", "\n")).withGroupfooter(group.getGroupfooter().replaceAll("\r\n", "\n"));
    }
    return new Groups(result);
  }


  public Users users () {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<UserData> result = session.createQuery("from UserData where deprecated = '0000-00-00'").list();
    session.getTransaction().commit();
    session.close();
    return new Users(result);
  }
}
