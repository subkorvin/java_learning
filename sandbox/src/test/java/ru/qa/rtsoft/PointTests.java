package ru.qa.rtsoft;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by korvin on 17.02.2017.
 */
public class PointTests {

  @Test
  public void testPoint () {
    Point p1 = new Point(2, 3);
    Point p2 = new Point(-1, 5);
    Assert.assertEquals(p2.distance(p1), 3.605551275463989);
  }
}
