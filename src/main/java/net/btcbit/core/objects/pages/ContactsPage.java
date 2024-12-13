package net.btcbit.core.objects.pages;

import io.qameta.allure.Step;
import net.btcbit.core.objects.CommonPage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ContactsPage extends CommonPage {

    @Step("(web) Contacts titles visible")
    public ContactsPage contactTitlesVisible(String[] contactsTitles) {
        for (String title : contactsTitles) {
            var xpath = String.format("//h2[contains(@class, 'contact-info_title') and text()='%s']", title);
            var element = $(By.xpath(xpath));
            element.scrollTo();
            element.shouldBe(visible);
        }
        return this;
    }

    @Step("(web) Contacts phone visible")
    public ContactsPage contactPhoneVisible(String[] contactsPhone) {
        for (String phone : contactsPhone) {
            var xpath = String.format("//a[contains(@class, 'contact-info_link') and text()='%s']", phone);
            var element = $(By.xpath(xpath));
            element.scrollTo();
            element.shouldBe(visible).shouldHave(href("tel:" + phone.replace(" ", "")));
        }
        return this;
    }

    @Step("(web) Contacts email visible")
    public ContactsPage contactEmailVisible(String[] contactsEmail) {
        for (String email : contactsEmail) {
            var xpath = String.format("//a[contains(@class, 'contact-info_link') and text()='%s']", email);
            var element = $(By.xpath(xpath));
            element.scrollTo();
            element.shouldBe(visible).shouldHave(href("mailto:" + email));
        }
        return this;
    }

    @Step("(web) Contacts address visible")
    public ContactsPage contactAddressVisible(String[] contactsAddress) {
        var elements = $$(By.xpath("//h3[contains(@class, 'contact-info_address')]"));
        elements.shouldHave(size(contactsAddress.length));
        for (int index = 0; index < contactsAddress.length; index++) {
            var element = elements.get(index);
            element.scrollTo();
            element.shouldBe(visible).shouldHave(text(contactsAddress[index]));
        }
        return this;
    }
}
