package utils;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {
    @BeforeAll
    public static void configureTests() {
        Configuration.baseUrl = "https://www.saucedemo.com/";
    }

    @AfterAll
    public static void closeDriver() {
        WebDriverRunner.closeWebDriver();
    }
}
