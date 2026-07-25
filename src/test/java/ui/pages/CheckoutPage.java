package ui.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CheckoutPage {

    private final SelenideElement firstNameInput = $("#first-name");
    private final SelenideElement lastNameInput = $("#last-name");
    private final SelenideElement postalCodeInput = $("#postal-code");
    private final SelenideElement continueButton = $("#continue");
    private final SelenideElement finishButton = $("#finish");
    private final SelenideElement completeHeader = $(".complete-header");
    private final SelenideElement errorMessage = $("[data-test='error']");

    public CheckoutPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public CheckoutPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public CheckoutPage setPostalCode(String postalCode) {
        postalCodeInput.setValue(postalCode);
        return this;
    }

    public CheckoutPage fillCustomerInfo(
            String firstName,
            String lastName,
            String postalCode
    ) {
        return setFirstName(firstName)
                .setLastName(lastName)
                .setPostalCode(postalCode);
    }

    public CheckoutPage clickContinue() {
        continueButton.click();
        return this;
    }

    public CheckoutPage finishOrder() {
        finishButton.click();
        return this;
    }

    public CheckoutPage shouldShowError(String expectedError) {
        errorMessage
                .shouldBe(visible)
                .shouldHave(text(expectedError));

        return this;
    }

    public CheckoutPage shouldShowSuccessMessage() {
        completeHeader.shouldBe(visible);
        return this;
    }
}