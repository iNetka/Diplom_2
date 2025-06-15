package site.stellarburgers.nomoreparties.tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class OrderTest extends BaseTest {

    private List<String> ingredients;
    private String[] allIngredients;

    @Before
    public void setUp_() {
        allIngredients = orderSteps.getAllIngredients().getBody().jsonPath().getString("data._id").split(",");
    }

    @Test
    @DisplayName("Создание заказа с авторизацией и валидными ингредиентами")
    public void testCreateOrderValidIngredientsAuthUser() {
        ingredients = List.of(allIngredients[4].trim(), allIngredients[3].trim(), allIngredients[2].trim());
        response = orderSteps.createOrder(ingredients, user.getAccessToken());
        assertEquals(200, response.getStatusCode());
    }

    @Test
    @DisplayName("Создание заказа с авторизацией и не валидными ингредиентами")
    public void testCreateOrderNotValidIngredientsAuthUser() {
        ingredients = List.of(allIngredients[4], allIngredients[3], allIngredients[2]);
        response = orderSteps.createOrder(ingredients, user.getAccessToken());
        assertEquals(500, response.getStatusCode());
    }

    @Test
    @DisplayName("Создание заказа с авторизацией и без ингредиентов")
    public void testCreateOrderEmptyIngredientsAuthUser() {
        response = orderSteps.createOrder(ingredients, user.getAccessToken());
        assertEquals(400, response.getStatusCode());
        assertEquals("Ingredient ids must be provided",
                response.getBody().jsonPath().getString("message"));
    }

    @Test
    @DisplayName("Создание заказа без авторизации и валидными ингредиентами")
    public void testCreateOrderValidIngredientsNotAuthUser() {
        ingredients = List.of(allIngredients[4].trim(), allIngredients[3].trim(), allIngredients[2].trim());
        response = orderSteps.createOrder(ingredients, "");
        assertEquals(200, response.getStatusCode());
    }

    @Test
    @DisplayName("Создание заказа с авторизацией и неверным хешем ингредиентов")
    public void testCreateOrderInvalidIngredientHashAuthUser() {
        String fakeIngredient1 = "invalidHash1";
        String fakeIngredient2 = "invalidHash2";

        ingredients = List.of(fakeIngredient1, fakeIngredient2);
        response = orderSteps.createOrder(ingredients, user.getAccessToken());

        assertEquals(400, response.getStatusCode());
    }
}