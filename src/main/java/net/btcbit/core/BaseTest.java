package net.btcbit.core;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;

import static io.qameta.allure.selenide.LogType.BROWSER;
import static java.util.logging.Level.WARNING;

@Slf4j
public class BaseTest {
    static {
        Configuration.baseUrl = "https://btcbit.net";
        Configuration.browser = "chrome";
    }

    @BeforeEach
    void addAllureListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true)
                .savePageSource(true)
                .enableLogs(BROWSER, WARNING));
    }

    @BeforeEach
    void prepare() {
        log.info("Test started...");
        Selenide.open("/");
    }
}
