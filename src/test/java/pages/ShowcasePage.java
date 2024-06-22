package pages;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ShowcasePage extends BasePage {
    private static final By TITLE = By.xpath(".//*[@class='title']");

    @Override
    public ShowcasePage openPage() {
        Selenide.open("/inventory.html");
        return this;
    }

    @Override
    void verifyPage() {
        $(TITLE).shouldBe(visible);
    }

    public String getPageTitle() {
        return $(TITLE).shouldBe(visible).getText();
    }
}
