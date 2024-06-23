package pages;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {
    private static final By HEADER = By.xpath(".//*[@class='login_logo']");
    private static final By USERNAME_INPUT = By.xpath(".//*[@id='user-name']");
    private static final By PASSWORD_INPUT = By.xpath(".//*[@id='password']");
    private static final By LOGIN_BUTTON = By.xpath(".//*[@id='login-button']");

    @Override
    void verifyPage() {
        $(HEADER).shouldBe(visible);
        $(USERNAME_INPUT).shouldBe(visible);
        $(PASSWORD_INPUT).shouldBe(visible);
        $(LOGIN_BUTTON).shouldBe(visible);
    }

    public LoginPage fillUsername(String name) {
        $(USERNAME_INPUT).shouldBe(visible).setValue(name);
        return this;
    }

    public LoginPage fillPassword(String password) {
        $(PASSWORD_INPUT).shouldBe(visible).setValue(password);
        return this;
    }

    public LoginPagePromise clickLogin() {
        $(LOGIN_BUTTON).shouldBe(visible).click();
        return new LoginPagePromise();
    }
}
