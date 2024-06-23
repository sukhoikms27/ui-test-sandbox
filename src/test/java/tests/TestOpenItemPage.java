package tests;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.ItemPage;
import pages.ItemWrapper;
import pages.LoginPage;
import pages.ShowcasePage;
import utils.BaseTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TestOpenItemPage extends BaseTest {
    private static final String LOGIN = "standard_user";
    private static final String PASSWORD = "secret_sauce";

    @BeforeAll
    public static void setUp() {
        Selenide.open("");
    }

    @Test
    @Description("Тест проверяет открытие картотчки товара")
    public void testOpenItemPage() {
        ShowcasePage showcasePage = new LoginPage()
                .fillUsername(LOGIN)
                .fillPassword(PASSWORD)
                .clickLogin()
                .andSuccessLogin();

        assertThat("Список товаров пусты", showcasePage.getItems(), not(empty()));

        ItemWrapper item = showcasePage.getItems()
                .get(0);
        String expectedItemName = item.getName();

        ItemPage itemPage = item.openItem();
        assertThat(itemPage.getItemTitle(), is(expectedItemName));
    }

    @AfterAll
    public static void tearDown() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        Selenide.closeWebDriver();
    }
}
