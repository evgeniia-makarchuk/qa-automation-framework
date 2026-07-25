package base;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseUiTest {

    @BeforeMethod
    public void setUp() {

        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://www.saucedemo.com";

        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        closeWebDriver();
    }
}