import com.github.javafaker.Faker;
import com.google.inject.Inject;
import net.btcbit.core.BaseTest;
import net.btcbit.core.objects.elements.HeaderElement;
import net.btcbit.core.objects.elements.VerifyAccountElement;
import net.btcbit.core.objects.pages.SignUpPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RegistrationTest extends BaseTest {

    @Inject
    private HeaderElement headerElement;
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
        email = faker.name().firstName().toLowerCase() + "@gmail.com";
        password = faker.internet().password(8, 15, true, true);
    }

    @Test
    void registrationTest() {
        headerElement.clickSignUpBtn();
        signUpPage.writeInEmailField(email)
                .writeInPasswordField(password)
                .writeInConfirmPasswordField(password)
                .clickAgreementsCheckBox()
                .clickSubmitBtn();
        verifyAccountElement.verifyTextVisible()
                .verifyBtnVisible();
    }
}
