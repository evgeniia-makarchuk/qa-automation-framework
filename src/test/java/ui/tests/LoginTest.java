package ui.tests;

import base.BaseUiTest;
import org.testng.annotations.Test;
import ui.pages.LoginPage;

import static data.users.UserType.LOCKED_OUT_USER;
import static data.users.UserType.STANDARD_USER;

public class LoginTest extends BaseUiTest {

    @Test
    void successfulLoginTest() {
        new LoginPage()
                .openPage()
                .login(STANDARD_USER.getUsername(), STANDARD_USER.getPassword())
                .shouldBeOpened();
    }

    @Test
    void lockedOutUserLoginTest() {
        new LoginPage()
                .openPage()
                .loginExpectingError(
                        LOCKED_OUT_USER.getUsername(),
                        LOCKED_OUT_USER.getPassword()
                )
                .shouldShowError("Sorry, this user has been locked out.");
    }
}