import com.codeborne.selenide.Selenide;
import com.google.inject.Inject;
import net.btcbit.core.BaseTest;
import net.btcbit.core.objects.pages.ContactsPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactsTest extends BaseTest {

    @Inject
    private ContactsPage contactsPage;

    private final String[] contactsTitles = {"Poland", "Estonia"};
    private final String[] contactsAddress = {"BTCBIT Sp. z o.o.\n" + "Ul. Gesia 8 - 205, 31-535\n" + "Krakow, Poland",
            "BTCBIT OÜ \nPikk tn 33-3, 10133\nTallinn, Estonia",};
    private final String[] contactsPhones = {"+48 588 813 222", "+372 8 803 222"};
    private final String[] contactsEmails = {"info@btcbit.net"};

    @BeforeEach
    void before() {
        Selenide.open("https://btcbit.net/contacts/");
    }

    @Test
    void contactsTest() {
        contactsPage.contactTitlesVisible(contactsTitles)
                .contactAddressVisible(contactsAddress)
                .contactPhoneVisible(contactsPhones)
                .contactEmailVisible(contactsEmails);
    }
}
