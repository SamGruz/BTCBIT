import com.github.javafaker.Faker;
import com.google.inject.Inject;
import net.btcbit.core.BaseTest;
import net.btcbit.core.objects.elements.HeaderElement;
import net.btcbit.core.objects.elements.InvalidCredentialsElement;
import net.btcbit.core.objects.pages.SignInPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LoginWhitWrongCredentialTest extends BaseTest {

    @Inject
    private HeaderElement headerElement;
    @Inject
    private SignInPage signInPage;
    @Inject
    private InvalidCredentialsElement invalidCredentialsElement;
    @Inject
    private Faker faker;
    private String email;
    private String password;

    @BeforeEach
    void before() {
        email = faker.internet().emailAddress("test");
        password = faker.internet().password(8, 15, true, true);
    }

    @Test
    void loginWithWrongCredentialTest() {
        headerElement.clickSignInBtn();
        signInPage.writeInEmailField(email)
                .writeInPasswordField(password)
                .clickSubmitBtn();
        invalidCredentialsElement.invalidCredentialTextVisible();
    }
}
