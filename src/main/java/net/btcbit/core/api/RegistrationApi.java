package net.btcbit.core.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import net.btcbit.core.api.endpoints.RegistrationEndpoints;

import java.util.Base64;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;

public class RegistrationApi {

    public static void registrationUser(String email, String password) {
        given()
                .spec(requestSpecification())
                .when()
                .formParam("account_type", "personal")
                .formParam("email", email)
                .formParam("password", encodePassword(password))
                .post(RegistrationEndpoints.SIGN_UP.getEndpoint())
                .then()
                .statusCode(SC_OK);
    }

    public static RequestSpecification requestSpecification() {
        return new RequestSpecBuilder()
                .setBaseUri("https://btcbit.net")
                .build();
    }

    private static String encodePassword(String password) {
        return Base64.getEncoder().encodeToString(password.getBytes());
    }
}
