package ui.config;

import com.codeborne.selenide.Configuration;

public final class SelenideConfig {

    private SelenideConfig() {
    }

    public static void configure() {
        Configuration.baseUrl = System.getProperty("baseUrl", "https://www.saucedemo.com");

        Configuration.browser = System.getProperty("browser", "chrome");

        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");

        Configuration.timeout = Long.parseLong(System.getProperty("timeout", "10000"));

        Configuration.headless = Boolean.parseBoolean(System.getProperty("headless", "true"));
    }
}