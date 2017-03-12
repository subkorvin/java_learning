package ru.qa.rtsoft.addressbook.model;

import com.google.common.collect.ForwardingSet;
import com.sun.jna.platform.win32.Netapi32Util;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Korvin on 12.03.2017.
 */
public class Users extends ForwardingSet<UserData> {

  private Set<UserData> delegate;

  public Users(Users users) {
    this.delegate = new HashSet<UserData>(users.delegate);
  }

  public Users() {
    this.delegate = new HashSet<UserData>();
  }

  public Users withAdded(UserData user) {
    Users users = new Users(this);
    users.add(user);
    return users;
  }

  public Users without(UserData user) {
    Users users = new Users(this);
    users.remove(user);
    return users;
  }


  @Override
  protected Set<UserData> delegate() {
    return delegate;
  }
}
