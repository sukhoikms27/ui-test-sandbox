package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ShowcasePage extends BasePage {
    private static final By TITLE = By.xpath(".//*[@class='title']");

    @Override
    void verifyPage() {
        $(TITLE).shouldBe(visible);
    }

    public String getPageTitle() {
        return $(TITLE).shouldBe(visible).getText();
    }
}
