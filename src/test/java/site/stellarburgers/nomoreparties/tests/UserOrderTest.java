package site.stellarburgers.nomoreparties.tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import site.stellarburgers.nomoreparties.steps.UserOrderSteps;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static site.stellarburgers.nomoreparties.utils.Utils.randomIndex;

public class UserOrderTest extends BaseTest {

    @Before
    public void setUp_() {
        String[] id = orderSteps.getAllIngredients().getBody().jsonPath().getString("data._id").split(",");
        List<String> ingredients = List.of(
                id[randomIndex()].trim(),
                id[randomIndex()].trim(),
                id[randomIndex()].trim());
        response = orderSteps.createOrder(ingredients, user.getAccessToken());
    }

    @Test
    @DisplayName("Данные по заказам авторизированного пользователя")
    public void testGetOrderAuthUser() {
        UserOrderSteps userOrderSteps = new UserOrderSteps(user.getAccessToken());
        response = userOrderSteps.getUserOrders();
        assertEquals(200, response.getStatusCode());
        assertNotNull(response.getBody().jsonPath().getString("orders._id"));
    }

    @Test
    @DisplayName("Данные по заказам не авторизированного пользователя")
    public void testPostOrder() {
        UserOrderSteps userOrderSteps = new UserOrderSteps("");
        response = userOrderSteps.getUserOrders();
        assertEquals(401, response.getStatusCode());
        assertEquals("You should be authorised",
                response.getBody().jsonPath().getString("message"));
    }
}