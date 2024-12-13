package net.btcbit.core.objects.elements;

import io.qameta.allure.Step;
import net.btcbit.core.objects.CommonPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static java.time.Duration.ofSeconds;

public class VerifyAccountElement extends CommonPage {

    private final String VERIFY_BTN = "//a[@href='/verification/'" +
            " and text()='Verify' and contains(@class, 'btn-secondary-small')]";
    private final String VERIFY_TEXT = "//div[text()='Verify your account for making transactions' " +
            "and contains(@class, 'flex-centered')]";

    @Step("(web) \"Verify\" button visible")
    public VerifyAccountElement verifyTextVisible() {
        $x(VERIFY_TEXT).shouldBe(visible, ofSeconds(10));
        return this;
    }

    @Step("(web) \"Verify\" button visible")
    public VerifyAccountElement verifyBtnVisible() {
        $x(VERIFY_BTN).shouldBe(visible);
        return this;
    }
}
