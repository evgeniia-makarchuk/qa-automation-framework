package ui.tests;

import base.BaseUiTest;
import org.testng.annotations.Test;
import ui.pages.LoginPage;
import ui.pages.CheckoutPage;

import static data.CheckoutData.FIRST_NAME;
import static data.CheckoutData.LAST_NAME;
import static data.CheckoutData.POSTAL_CODE;
import static data.CheckoutErrorMessages.*;
import static data.users.UserType.STANDARD_USER;

public class CheckoutTest extends BaseUiTest {

    private CheckoutPage openCheckoutPage() {
        return new LoginPage()
                .openPage()
                .login(STANDARD_USER.getUsername(), STANDARD_USER.getPassword())
                .shouldBeOpened()
                .addBackpackToCart()
                .openCart()
                .shouldContainBackpack()
                .clickCheckout();
    }

    @Test
    public void successfulCheckoutTest() {
        openCheckoutPage()
                .fillCustomerInfo(FIRST_NAME, LAST_NAME, POSTAL_CODE)
                .clickContinue()
                .finishOrder()
                .shouldShowSuccessMessage();
    }

    @Test
    public void checkoutWithoutFirstNameTest() {
        openCheckoutPage()
                .setLastName(LAST_NAME)
                .setPostalCode(POSTAL_CODE)
                .clickContinue()
                .shouldShowError(FIRST_NAME_REQUIRED);
    }

    @Test
    public void checkoutWithoutLastNameTest() {
        openCheckoutPage()
                .setFirstName(FIRST_NAME)
                .setPostalCode(POSTAL_CODE)
                .clickContinue()
                .shouldShowError(LAST_NAME_REQUIRED);
    }

    @Test
    public void checkoutWithoutPostalCodeTest() {
        openCheckoutPage()
                .setFirstName(FIRST_NAME)
                .setLastName(LAST_NAME)
                .clickContinue()
                .shouldShowError(POSTAL_CODE_REQUIRED);
    }
}