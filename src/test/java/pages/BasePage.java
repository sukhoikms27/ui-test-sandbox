package pages;

abstract public class BasePage {

    abstract <T> T openPage();

    abstract void verifyPage();
}
