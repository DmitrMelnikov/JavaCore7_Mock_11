package ru.netology.geo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;


class GeoServiceImplTest {

    @BeforeAll
    public static void before() {
        System.out.println("Тест определения локации по IP стартовал!");
    }

    @AfterAll
    public static void after() {
        System.out.println("Тест определения локации по IP стоп!");
    }

    @Test
    void test_geo_location_byIp_Russia() {
        GeoServiceImpl geoService = new GeoServiceImpl();
        Location location = geoService.byIp("172.0.32.13");
        Assertions.assertEquals(location.getCity().toString(), "Moscow");
        Assertions.assertEquals(location.getCountry(), Country.RUSSIA);
        Assertions.assertEquals(location.getStreet(), null);
        Assertions.assertEquals(location.getBuiling(), 0);
    }

    @Test
    void test_geo_location_byIp_USA() {
        GeoServiceImpl geoService = new GeoServiceImpl();
        Location location = geoService.byIp("96.0.183.149");
        Assertions.assertEquals(location.getCity().toString(), "New York");
        Assertions.assertEquals(location.getCountry(), Country.USA);
        Assertions.assertEquals(location.getStreet(), null);
        Assertions.assertEquals(location.getBuiling(), 0);
    }
}
