package ui.tests;

import base.BaseUiTest;
import org.testng.annotations.Test;
import ui.pages.LoginPage;

import static data.CheckoutData.FIRST_NAME;
import static data.CheckoutData.LAST_NAME;
import static data.CheckoutData.POSTAL_CODE;
import static data.CheckoutErrorMessages.*;
import static data.users.UserType.STANDARD_USER;

public class CheckoutTest extends BaseUiTest {

    @Test
    public void successfulCheckoutTest() {
        new LoginPage()
                .openPage()
                .login(STANDARD_USER.getUsername(), STANDARD_USER.getPassword())
                .shouldBeOpened()
                .addBackpackToCart()
                .openCart()
                .shouldContainBackpack()
                .clickCheckout()
                .fillCustomerInfo(FIRST_NAME, LAST_NAME, POSTAL_CODE)
                .clickContinue()
                .finishOrder()
                .shouldShowSuccessMessage();
    }

    @Test
    public void checkoutWithoutFirstNameTest() {
        new LoginPage()
                .openPage()
                .login(STANDARD_USER.getUsername(), STANDARD_USER.getPassword())
                .shouldBeOpened()
                .addBackpackToCart()
                .openCart()
                .shouldContainBackpack()
                .clickCheckout()
                .setLastName(LAST_NAME)
                .setPostalCode(POSTAL_CODE)
                .clickContinue()
                .shouldShowError(FIRST_NAME_REQUIRED);
    }

    @Test
    public void checkoutWithoutLastNameTest() {
        new LoginPage()
                .openPage()
                .login(STANDARD_USER.getUsername(), STANDARD_USER.getPassword())
                .shouldBeOpened()
                .addBackpackToCart()
                .openCart()
                .shouldContainBackpack()
                .clickCheckout()
                .setFirstName(FIRST_NAME)
                .setPostalCode(POSTAL_CODE)
                .clickContinue()
                .shouldShowError(LAST_NAME_REQUIRED);
    }

    @Test
    public void checkoutWithoutPostalCodeTest() {
        new LoginPage()
                .openPage()
                .login(STANDARD_USER.getUsername(), STANDARD_USER.getPassword())
                .shouldBeOpened()
                .addBackpackToCart()
                .openCart()
                .shouldContainBackpack()
                .clickCheckout()
                .setFirstName(FIRST_NAME)
                .setLastName(LAST_NAME)
                .clickContinue()
                .shouldShowError(POSTAL_CODE_REQUIRED);
    }
}