package site.stellarburgers.nomoreparties.steps;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import site.stellarburgers.nomoreparties.model.User;
import site.stellarburgers.nomoreparties.model.request.AuthUserRequest;

import static io.restassured.RestAssured.given;
import static site.stellarburgers.nomoreparties.utils.Utils.getBaseSpec;
import static site.stellarburgers.nomoreparties.utils.Utils.LOGIN;

public class AuthSteps {

    @Step("Login user")
    public Response login(User user) {
        return given()
                .spec(getBaseSpec())
                .body(new AuthUserRequest(user))
                .when()
                .post(LOGIN);
    }

    @Step("Login user")
    public Response login(String email, String password) {
        return given()
                .spec(getBaseSpec())
                .body(new AuthUserRequest(email, password))
                .when()
                .post(LOGIN);
    }

}