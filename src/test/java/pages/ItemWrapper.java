package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.visible;

public class ItemWrapper {
    private static final By IMAGE = By.xpath(".//*[@class='inventory_item_img']");
    private static final By NAME = By.xpath(".//*[@data-test='inventory-item-name']");
    private static final By DESCRIPTION = By.xpath(".//*[@class='inventory_item_desc']");
    private static final By PRICE = By.xpath(".//*[@class='inventory_item_price']");
    private static final By ADD_TO_CART_BUTTON = By.xpath(".//button[contains(@data-test, 'add-to-cart')]");
    private static final By REMOVE_FROM_CART_BUTTON = By.xpath(".//button[contains(@data-test, 'remove')]");
    private final SelenideElement rootElement;

    public ItemWrapper(SelenideElement rootElement) {
        this.rootElement = rootElement;
    }

    public ItemPage openItem() {
        rootElement.$(NAME).shouldBe(visible).click();
        return new ItemPage();
    }

    public String getName() {
        return rootElement.$(NAME).shouldBe(visible).getText();
    }

    public String getDescription() {
        return rootElement.$(DESCRIPTION).shouldBe(visible).getText();
    }

    public String getPrice() {
        return rootElement.$(PRICE).shouldBe(visible).getText();
    }

    public void addToCart() {
        rootElement.$(ADD_TO_CART_BUTTON).shouldBe(visible).click();
        rootElement.$(REMOVE_FROM_CART_BUTTON).shouldBe(appear);
    }

    public void removeFromCart() {
        rootElement.$(REMOVE_FROM_CART_BUTTON).shouldBe(visible).click();
        rootElement.$(ADD_TO_CART_BUTTON).shouldBe(appear);
    }
}
