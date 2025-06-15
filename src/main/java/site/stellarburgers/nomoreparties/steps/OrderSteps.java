package site.stellarburgers.nomoreparties.steps;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.JSONObject;

import java.util.List;

import static io.restassured.RestAssured.given;
import static site.stellarburgers.nomoreparties.utils.Utils.*;

public class OrderSteps {


    @Step("Create order")
    public Response createOrder(List<String> ingredients, String userToken) {

        return given()
                .spec(getBaseSpec())
                .header("Authorization", userToken)
                .body(new JSONObject().put("ingredients", ingredients).toString())
                .when()
                .post(getOrdersUrl());
    }

    @Step("Get ingredients")
    public Response getAllIngredients() {
        return given()
                .spec(getBaseSpec())
                .when()
                .get(getIngredientsUrl());
    }
}