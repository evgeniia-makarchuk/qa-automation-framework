package ui.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class InventoryPage {

    private final SelenideElement inventoryList = $(".inventory_list");
    private final SelenideElement backpackAddButton = $("#add-to-cart-sauce-labs-backpack");
    private final SelenideElement cartIcon = $(".shopping_cart_link");

    public InventoryPage shouldBeOpened() {
        inventoryList.shouldBe(visible);
        return this;
    }

    public InventoryPage addBackpackToCart() {
        backpackAddButton.click();
        return this;
    }

    public CartPage openCart() {
        cartIcon.click();
        return new CartPage();
    }
}