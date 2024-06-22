package tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideConfig;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.LoginPage;
import pages.ShowcasePage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSuccessLogin {
    private static final String LOGIN = "standard_user";
    private static final String PASSWORD = "secret_sauce";
    private static final String EXPECTED_PAGE_TITLE = "Products";

    @BeforeEach
    private void setUp() {
        Selenide.open("https://www.saucedemo.com/");
    }

    @Test
    public void testSuccessLogin() {
        ShowcasePage showcasePage = new LoginPage()
                .openPage()
                .fillUsername(LOGIN)
                .fillPassword(PASSWORD)
                .clickLogin()
                .andSuccessLogin();
        assertEquals(EXPECTED_PAGE_TITLE, showcasePage.getPageTitle(), "Некорретный заголовок ожидаемой страницы");
    }

    @AfterAll
    private void tearDown() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        Selenide.closeWebDriver();
    }
}
