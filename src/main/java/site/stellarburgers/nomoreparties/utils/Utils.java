package site.stellarburgers.nomoreparties.utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import static io.restassured.http.ContentType.JSON;

public final class Utils {
    private static final String BASE_URL = "https://stellarburgers.nomoreparties.site/api/";

    private Utils() {
    }

    public static String getOrdersUrl() {
        return "/orders";
    }

    public static String getIngredientsUrl() {
        return "/ingredients";
    }

    public static String getAuthUserUrl() {
        return "/auth/user";
    }

    public static String getAuthRegisterUrl() {
        return "/auth/register";
    }

    public static String getLoginUserUrl() {
        return "/auth/login";
    }

    public static RequestSpecification getBaseSpec() {
        return new RequestSpecBuilder()
                .setContentType(JSON)
                .setBaseUri(BASE_URL)
                .build();
    }

    public static int randomIndex() {
        return (int) (Math.random() * 10);
    }

}