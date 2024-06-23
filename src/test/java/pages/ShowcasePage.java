package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ShowcasePage extends BasePage {
    private static final By TITLE = By.xpath(".//*[@class='title']");
    private static final By ITEM = By.xpath(".//*[@data-test='inventory-item']");
    private static final By SORT = By.xpath(".//*[@class='product_sort_container']");

    @Step("Проверка загрузки страницы витрины")
    @Override
    void verifyPage() {
        $(TITLE).shouldBe(visible);
    }

    @Step("Получаем заголовок")
    public String getPageTitle() {
        return $(TITLE).shouldBe(visible).getText();
    }

    @Step("Получаем список товаров")
    public List<ItemWrapper> getItems() {
        return $$(ITEM).asFixedIterable()
                .stream()
                .map(item -> new ItemWrapper(item))
                .collect(Collectors.toList());
    }

    public ShowcasePage selectSortType(SortType type) {
        $(SORT).shouldBe(visible)
                .selectOptionByValue(type.getValue());
        return this;
    }
}
