package pages;

abstract public class BasePage {

    public BasePage() {
        verifyPage();
    }

    abstract void verifyPage();
}
