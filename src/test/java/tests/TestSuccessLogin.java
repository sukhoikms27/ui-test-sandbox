package tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import pages.LoginPage;
import pages.ShowcasePage;
import utils.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSuccessLogin extends BaseTest {
    private static final String LOGIN = "standard_user";
    private static final String PASSWORD = "secret_sauce";
    private static final String EXPECTED_PAGE_TITLE = "Products";

    @BeforeEach
    public void setUp() {
        Selenide.open("/");
    }

    @Test
    public void testSuccessLogin() {
        ShowcasePage showcasePage = new LoginPage()
                .fillUsername(LOGIN)
                .fillPassword(PASSWORD)
                .clickLogin()
                .andSuccessLogin();
        assertEquals(EXPECTED_PAGE_TITLE, showcasePage.getPageTitle(), "Некорретный заголовок ожидаемой страницы");
    }

    @AfterAll
    public static void tearDown() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        Selenide.closeWebDriver();
    }
}
