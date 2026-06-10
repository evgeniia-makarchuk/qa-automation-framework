package base;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;

public class BaseUiTest {

    @BeforeMethod
    public void setUp() {

        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://www.saucedemo.com";

        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
    }
}