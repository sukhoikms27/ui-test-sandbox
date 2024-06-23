package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ItemPage extends BasePage {
    private static final By BACT_TO_SHOWCASE = By.xpath(".//*[@data-test='back-to-products']");
    private static final By ITEM_TITLE = By.xpath(".//*[@data-test='inventory-item-name']");

    @Step("Проверка подгрузки страницы товара")
    @Override
    void verifyPage() {
        $(BACT_TO_SHOWCASE).shouldBe(visible);
    }

    @Step("Получаем название товара на странице")
    public String getItemTitle() {
        return $(ITEM_TITLE).shouldBe(visible).getText();
    }
}
