package pages;

import org.openqa.selenium.By;

public class ItemWrapper {
    private static final By IMAGE = By.xpath(".//*[@class='inventory_item_img']");
    private static final By NAME = By.xpath(".//*[@class='inventory_item_name']");
    private static final By DESCRIPTION = By.xpath(".//*[@class='inventory_item_desc']");
    private static final By PRICE = By.xpath(".//*[@class='inventory_item_price']");
    private static final By ADD_TO_CART_BUTTON = By.xpath(".//*[@class='btn btn_primary btn_small btn_inventory']");
}
