package site.stellarburgers.nomoreparties.utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import static io.restassured.http.ContentType.JSON;

public final class Utils {
    private static final String BASE_URL = "https://stellarburgers.nomoreparties.site/api/";
    public static final String INGREDIENTS = "/ingredients";
    public static final String AUTH_USER = "/auth/user";
    public static final String REGISTER =  "/auth/register";
    public static final String LOGIN = "/auth/login";

    private Utils() {
    }

    public static final String ORDERS = "/orders";



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