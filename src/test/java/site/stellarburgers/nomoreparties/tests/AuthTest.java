package site.stellarburgers.nomoreparties.tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AuthTest extends BaseTest {

    private final static String INCORRECT_EMAIL = "INCORRECT_EMAIL";
    private final static String INCORRECT_PASSWORD = "INCORRECT_PASSWORD";

    @Test
    @DisplayName("Авторизация пользователя")
    public void testLoginUser() {
        response = authSteps.login(user);
        assertEquals(200, response.getStatusCode());
    }

    @Test
    @DisplayName("Авторизация пользователя с неверным логином и паролем")
    public void testLoginIncorrectUser() {
        response = authSteps.login(INCORRECT_EMAIL, INCORRECT_PASSWORD);
        assertEquals(401, response.getStatusCode());
        assertEquals("email or password are incorrect",
                response.getBody().jsonPath().getString("message"));
    }

}