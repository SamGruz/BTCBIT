package net.btcbit.core.objects.pages;

import io.qameta.allure.Step;
import net.btcbit.core.objects.CommonPage;

import static com.codeborne.selenide.Selenide.$x;

public class SignInPage extends CommonPage {

    private final String emailField = "//input[@id='email']";
    private final String passwordField = "//input[@id='password']";
    private final String submitBtn = "//button[@type='submit']";

    @Step("(web) Write in \"Email\" field: {email}")
    public SignInPage writeInEmailField(String email) {
        $x(emailField).sendKeys(email);
        return this;
    }

    @Step("(web) Write in \"Password\" field: {password}")
    public SignInPage writeInPasswordField(String password) {
        $x(passwordField).sendKeys(password);
        return this;
    }

    @Step("(web) Click submit button")
    public void clickSubmitBtn() {
        $x(submitBtn).click();
    }
}
