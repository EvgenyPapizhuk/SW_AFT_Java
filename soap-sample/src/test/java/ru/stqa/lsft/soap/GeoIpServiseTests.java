package ru.stqa.lsft.soap;

import com.lavasoft.GeoIPService;
import org.testng.annotations.Test;

public class GeoIpServiseTests {

    @Test
    public void myIp() {
        String location = new GeoIPService().getGeoIPServiceSoap12().getIpLocation("46.138.4.49");
        System.out.println(location);

    }
}
