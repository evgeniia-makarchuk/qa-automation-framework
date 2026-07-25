package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ui.config.SelenideConfig;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseUiTest {

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        SelenideConfig.configure();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        closeWebDriver();
    }
}