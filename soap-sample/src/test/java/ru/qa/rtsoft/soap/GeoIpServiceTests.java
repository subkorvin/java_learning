package ru.qa.rtsoft.soap;

import net.webservicex.GeoIP;
import net.webservicex.GeoIPService;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by korvin on 06.04.2017.
 */
public class GeoIpServiceTests {

  @Test
  public void testMyIp() {
    GeoIP geoIP = new GeoIPService().getGeoIPServiceSoap12().getGeoIP("213.79.90.226");
    assertEquals(geoIP.getCountryCode(), "RUS");
  }

  @Test
  public void testInalidIp() {
    GeoIP geoIP = new GeoIPService().getGeoIPServiceSoap12().getGeoIP("213.79.90.300");
    assertEquals(geoIP.getCountryCode(), "RUS");
  }
}
