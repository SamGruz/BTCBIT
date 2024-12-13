package net.btcbit.core.objects.pages;

import io.qameta.allure.Step;
import net.btcbit.core.objects.CommonPage;

import static com.codeborne.selenide.Selenide.$x;

public class SignUpPage extends CommonPage {

    private final String emailField = "//input[@id='email']";
    private final String passwordField = "//input[@id='password']";
    private final String confirmPasswordField = "//input[@id='confirmPassword']";
    private final String agreementsCheckBox = "//label[@for='agreements']/span";
    private final String submitBtn = "//button[@type='submit']";

    @Step("(web) Write in \"Email\" field: {email}")
    public SignUpPage writeInEmailField(String email) {
        $x(emailField).sendKeys(email);
        return this;
    }

    @Step("(web) Write in \"Password\" field: {password}")
    public SignUpPage writeInPasswordField(String password) {
        $x(passwordField).sendKeys(password);
        return this;
    }

    @Step("(web) Write in \"Confirm password\" field: {password}")
    public SignUpPage writeInConfirmPasswordField(String password) {
        $x(confirmPasswordField).sendKeys(password);
        return this;
    }

    @Step("(web) Confirm agreements")
    public SignUpPage clickAgreementsCheckBox() {
        $x(agreementsCheckBox).click();
        return this;
    }

    @Step("(web) Click submit button")
    public void clickSubmitBtn() {
        $x(submitBtn).click();
    }
}
