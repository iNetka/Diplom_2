package site.stellarburgers.nomoreparties.steps;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static site.stellarburgers.nomoreparties.utils.Utils.getBaseSpec;
import static site.stellarburgers.nomoreparties.utils.Utils.getOrdersUrl;

public class UserOrderSteps {
    private final String userToken;

    public UserOrderSteps(String userToken) {
        this.userToken = userToken;
    }

    @Step("Get user orders")
    public Response getUserOrders() {
        return given()
                .spec(getBaseSpec())
                .header("Authorization", this.userToken)
                .when()
                .get(getOrdersUrl());
    }
}