package net.btcbit.core.objects.elements;

import io.qameta.allure.Step;
import net.btcbit.core.objects.CommonPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static java.time.Duration.ofSeconds;

public class InvalidCredentialsElement extends CommonPage {

    private final String INVALID_CREDENTIAL_TEXT = "//div[contains(@class, 'bg-error')]";

    @Step("(web) Invalid credential text visible")
    public InvalidCredentialsElement invalidCredentialTextVisible() {
        $x(INVALID_CREDENTIAL_TEXT).shouldBe(visible, ofSeconds(10));
        return this;
    }
}
