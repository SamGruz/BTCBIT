import com.github.javafaker.Faker;
import com.google.inject.Inject;
import net.btcbit.core.BaseTest;
import net.btcbit.core.objects.elements.HeaderElement;
import net.btcbit.core.objects.elements.VerifyAccountElement;
import net.btcbit.core.objects.pages.SignInPage;
import net.btcbit.core.objects.pages.SignUpPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.lang.Thread.sleep;
import static net.btcbit.core.api.RegistrationApi.registrationUser;

class LoginTest extends BaseTest {

    @Inject
    private HeaderElement headerElement;
    @Inject
    private SignInPage signInPage;
    @Inject
    private SignUpPage signUpPage;
    @Inject
    private VerifyAccountElement verifyAccountElement;
    @Inject
    private Faker faker;
    private String email;
    private String password;


    @BeforeEach
    void before() {
        email = faker.name().firstName().toLowerCase() + ".test" + "@gmail.com";
        password = faker.internet().password(9, 15, true, true) + "!" + "Q";
        registrationUser(email, password);
    }

    @Test
    void loginTest() throws InterruptedException {
        headerElement.clickSignInBtn();
        signInPage.writeInEmailField(email)
                .writeInPasswordField(password)
                .clickSubmitBtn();
        sleep(30000);
        verifyAccountElement.verifyTextVisible()
                .verifyBtnVisible();
    }
}
