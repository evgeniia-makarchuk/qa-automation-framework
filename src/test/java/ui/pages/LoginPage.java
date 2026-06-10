package ui.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {

    private final SelenideElement username = $("#user-name");
    private final SelenideElement password = $("#password");
    private final SelenideElement loginButton = $("#login-button");
    private final SelenideElement errorMessage = $("[data-test='error']");

    public LoginPage openPage() {
        open("/");
        return this;
    }

    public LoginPage setUsername(String user) {
        username.setValue(user);
        return this;
    }

    public LoginPage setPassword(String pass) {
        password.setValue(pass);
        return this;
    }

    public InventoryPage clickLogin() {
        loginButton.click();
        return new InventoryPage();
    }

    public InventoryPage login(String user, String pass) {
        setUsername(user);
        setPassword(pass);
        return clickLogin();
    }

    public LoginPage loginExpectingError(String user, String pass) {
        setUsername(user);
        setPassword(pass);
        loginButton.click();
        return this;
    }

    public LoginPage shouldShowError(String expectedErrorText) {
        errorMessage.shouldHave(text(expectedErrorText));
        return this;
    }
}