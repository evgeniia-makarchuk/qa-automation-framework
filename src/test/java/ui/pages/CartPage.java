package ui.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CartPage {

    private final SelenideElement cartItem = $(".cart_item");
    private final SelenideElement itemName = $(".inventory_item_name");
    private final SelenideElement checkoutButton = $("#checkout");

    public CartPage shouldContainBackpack() {
        cartItem.shouldBe(visible);
        itemName.shouldHave(text("Sauce Labs Backpack"));
        return this;
    }

    public CheckoutPage clickCheckout() {
        checkoutButton.click();
        return new CheckoutPage();
    }
}