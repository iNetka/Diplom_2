package site.stellarburgers.nomoreparties.tests;

import com.github.javafaker.Faker;
import io.qameta.allure.Allure;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import site.stellarburgers.nomoreparties.model.User;
import site.stellarburgers.nomoreparties.steps.AuthSteps;
import site.stellarburgers.nomoreparties.steps.OrderSteps;
import site.stellarburgers.nomoreparties.steps.UserCrudSteps;

public abstract class BaseTest {
    protected Response response;
    protected String updatedUserName;
    protected String updatedUserEmail;
    protected String updatedUserPassword;
    protected User user;
    protected User basicUser;

    protected AuthSteps authSteps;
    protected OrderSteps orderSteps;
    protected UserCrudSteps userCrudSteps;

    private Faker faker;

    @Before
    public void setUp() {
        faker = new Faker();
        user = generateTestUser();
        basicUser = generateTestUser();
        generateUpdatedTestData();
        authSteps = new AuthSteps();
        orderSteps = new OrderSteps();
        userCrudSteps = new UserCrudSteps();
        userCrudSteps.registerUser(user);
    }

    @After
    public void tearDown() {
        attachResponseDetails();
        cleanupTestUser();
    }


    private User generateTestUser() {
        String name = faker.name().firstName();
        String password = faker.internet().password(8, 16, true, true, true);
        String email = faker.internet().emailAddress();

        return new User(name, email, password);
    }

    private void generateUpdatedTestData() {
        updatedUserName = "updated_" + user.getName();
        updatedUserEmail = "updated_" + user.getEmail();
        updatedUserPassword = "Updated@123" + user.getPassword();
    }

    private void attachResponseDetails() {
        Allure.addAttachment("Response Status Code", String.valueOf(response.getStatusCode()));
        Allure.addAttachment("Response Body", response.getBody().prettyPrint());
    }

    private void cleanupTestUser() {
        if (user.getAccessToken() != null) {
            userCrudSteps.deleteUser(user.getAccessToken());
        }
    }
}