package site.stellarburgers.nomoreparties.tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import site.stellarburgers.nomoreparties.User;

import static org.junit.Assert.assertEquals;

public class UserCrudTest extends BaseTest {

    @Test
    @DisplayName("Создание пользователя")
    public void testCreateUniqueUser() {
        response = userCrudSteps.registerUser(basicUser);
        assertEquals(200, response.getStatusCode());
        userCrudSteps.deleteUser(basicUser.getAccessToken());
    }

    @Test
    @DisplayName("Создание существующего пользователя")
    public void testCreateExistingUser() {
        response = userCrudSteps.registerUser(user);
        assertEquals(403, response.getStatusCode());
        assertEquals("User already exists",
                response.getBody().jsonPath().getString("message"));
    }

    @Test
    @DisplayName("Создание пользователя без email")
    public void testCreateUserEmptyEmail() {
        response = userCrudSteps.registerUser(new User("name","", "password"));
        assertEquals(403, response.getStatusCode());
        assertEquals("Email, password and name are required fields",
                response.getBody().jsonPath().getString("message"));
    }

    @Test
    @DisplayName("Изменение данных авторизированного пользователя")
    public void testChangedDataAuthorizedUser() {
        User userToChange = new User(user);
        userToChange.setName(updatedUserName);
        userToChange.setEmail(updatedUserEmail);
        userToChange.setPassword(updatedUserPassword);

        response = userCrudSteps.updateUserData(userToChange);

        assertEquals(200, response.getStatusCode());

        response = userCrudSteps.getUserData(user);
        assertEquals(updatedUserEmail, response.getBody().jsonPath().getString("user.email"));
        assertEquals(updatedUserName, response.getBody().jsonPath().getString("user.name"));
    }

    @Test
    @DisplayName("Изменение данных не авторизированного пользователя")
    public void testChangedDataNotAuthorizedUser() {
        User user_not_auth = new User (user);
        user_not_auth.setAccessToken("-");
        response = userCrudSteps.updateUserData(user_not_auth);

        assertEquals(401, response.getStatusCode());

        response = userCrudSteps.getUserData(user_not_auth);
        assertEquals("You should be authorised",
                response.getBody().jsonPath().getString("message"));
    }

}