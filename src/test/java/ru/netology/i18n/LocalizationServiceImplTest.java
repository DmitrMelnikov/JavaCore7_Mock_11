package ru.netology.i18n;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;


class LocalizationServiceImplTest {

    @BeforeAll
    public static void before() {
        System.out.println("Тест проверки локации страны стартовал!");
    }

    @AfterAll
    public static void after() {
        System.out.println("Тест проверки локации страны стоп!");
    }

    @Test
    void test_locale() {
        LocalizationServiceImpl localizationService = new LocalizationServiceImpl();
        Assertions.assertEquals(localizationService.locale(Country.RUSSIA), "Добро пожаловать");
        Assertions.assertEquals(localizationService.locale(Country.USA), "Welcome");
        Assertions.assertEquals(localizationService.locale(Country.BRAZIL), "Welcome");

    }
}
