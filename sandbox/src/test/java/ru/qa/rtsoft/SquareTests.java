package ru.qa.rtsoft;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by korvin on 17.02.2017.
 */
public class SquareTests {

  @Test
  public void testArea(){
    Square s = new Square(7);
    Assert.assertEquals(s.area(), 49.0);
  }
}
