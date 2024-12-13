package net.btcbit.core.objects.elements;

import io.qameta.allure.Step;
import net.btcbit.core.objects.CommonPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static java.time.Duration.ofSeconds;

public class HeaderElement extends CommonPage {

    private final String SIGN_UP_BTN = "//*[@class='header_signup__hsltv inline-block']";
    private final String SIGN_IN_BTN = "//*[@class='header_login__VSWAE inline-block']";

    @Step("(web) Click on \"Sign Up\" Button")
    public void clickSignUpBtn() {
        $x(SIGN_UP_BTN).shouldBe(visible, ofSeconds(5)).click();
    }

    @Step("(web) Click on \"Sign In\" Button")
    public void clickSignInBtn() {
        $x(SIGN_IN_BTN).shouldBe(visible, ofSeconds(5)).click();
    }
}
