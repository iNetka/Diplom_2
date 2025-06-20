package site.stellarburgers.nomoreparties.steps;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import site.stellarburgers.nomoreparties.model.User;
import site.stellarburgers.nomoreparties.model.request.RegisterUserRequest;
import site.stellarburgers.nomoreparties.model.request.UpdateUserRequest;

import static io.restassured.RestAssured.given;
import static site.stellarburgers.nomoreparties.utils.Utils.*;
import static site.stellarburgers.nomoreparties.utils.Utils.AUTH_USER;

public class UserCrudSteps {

    @Step("Create user")
    public Response registerUser(User user) {

        Response response = given()
                .spec(getBaseSpec())
                .body(new RegisterUserRequest(user.getName(), user.getEmail(), user.getPassword()))
                .when()
                .post(REGISTER);

        String accessToken = response.getBody().jsonPath().getString("accessToken");
        String refreshToken = response.getBody().jsonPath().getString("refreshToken");

        user.setAccessToken(accessToken);
        user.setRefreshToken(refreshToken);
        return response;
    }

    @Step("Delete user")
    public void deleteUser(String token) {

        if (token != null) {
            given()
                    .spec(getBaseSpec())
                    .header("Authorization", token)
                    .delete(AUTH_USER)
                    .then()
                    .statusCode(202);
        }
    }

    @Step("Update user data")
    public Response updateUserData(User user) {

        return given()
                .spec(getBaseSpec())
                .header("Authorization", user.getAccessToken())
                .body(new UpdateUserRequest(user))
                .when()
                .patch(AUTH_USER);
    }

    @Step("Get user data")
    public Response getUserData(User user) {
        return given()
                .spec(getBaseSpec())
                .header("Authorization", user.getAccessToken())
                .when()
                .get(AUTH_USER);
    }
}