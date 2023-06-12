package ru.netology.sender;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.i18n.LocalizationServiceImpl;
import ru.netology.sender.MessageSender;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;


class MessageSenderImplMock {
    @BeforeAll
    public static void before() {
        System.out.println("Тесты стартовали!");
    }

    @AfterAll
    public static void after() {
        System.out.println("Тесты закончены!");
    }

    @Test
    void test_get_send_massage_only_Russia() {

        LocalizationServiceImpl localizationService = Mockito.mock(LocalizationServiceImpl.class);
        when(localizationService.locale(Country.RUSSIA)).thenReturn("Добро пожаловать");

        GeoService geoService = Mockito.mock(GeoService.class);
        when(geoService.byIp("172.0.32.11")).thenReturn(new Location("Moscow", Country.RUSSIA, "Lenina", 15));

        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);

        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.0.32.11");

        Assertions.assertEquals(messageSender.send(headers), "Добро пожаловать");
        System.out.println("");
    }

    @Test
    void test_get_send_massage_only_USA() {

        LocalizationServiceImpl localizationService = Mockito.mock(LocalizationServiceImpl.class);
        when(localizationService.locale(Country.USA)).thenReturn("Welcome");

        GeoService geoService = Mockito.mock(GeoService.class);
        when(geoService.byIp("96.44.183.149")).thenReturn(new Location("New York", Country.USA, " 10th Avenue", 32));

        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);

        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.44.183.149");

        Assertions.assertEquals(messageSender.send(headers), "Welcome");
        System.out.println("");
    }


}
