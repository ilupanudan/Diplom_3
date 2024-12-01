import io.qameta.allure.junit4.DisplayName;
import org.example.steps.Steps;
import org.example.pageobjects.LoginPage;
import org.example.pageobjects.RegisterPage;
import org.example.usergenerator.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.example.usergenerator.UserSteps.*;
import static org.example.usergenerator.UserSteps.user;
import static org.junit.Assert.assertEquals;
import static utils.PageConstants.*;

public class RegistrationTests  extends BaseTest {

    @Before
    public void setUpRegistrationTest(){

        user = User.randomUser();
        driver.get(REGISTER_PAGE_URL);
    }

    @After
    public void tearDownRegistrationTest() {

        deleteUser();
    }

    @Test
    @DisplayName("Успешная регистрация;")
    public void registrationTest() {
        Steps steps = new Steps(driver);
        RegisterPage objRegisterPage = new RegisterPage(driver);
        LoginPage objLoginPage = new LoginPage(driver);

        steps.enterText(objRegisterPage.registerNameField(), user.getName());

        steps.enterText(objRegisterPage.registerEmailField(), user.getEmail());

        steps.enterText(objRegisterPage.registerPasswordField(), user.getPassword());


        steps.clickOnElement(objRegisterPage.registerButton());

        steps.waitElement(objLoginPage.logoItem());
        getBearerToken(user);

        assertEquals( "Вход" , steps.getTextFromElement(objLoginPage.logoItem()));

    }

    @Test
    @DisplayName("Проверка ошибки для некорректного пароля. Минимальный пароль — шесть символов;")
    public void registrationFailedShortPassword() {
        Steps steps = new Steps(driver);
        RegisterPage objRegisterPage = new RegisterPage(driver);


        steps.enterText(objRegisterPage.registerNameField(), user.getName());

        steps.enterText(objRegisterPage.registerEmailField(), user.getEmail());

        steps.enterText(objRegisterPage.registerPasswordField(), "sssss");

        steps.clickOnElement(objRegisterPage.registerButton());

        getBearerToken(user); //на всякий случай(Вдруг создастся)

        assertEquals( "Некорректный пароль" , steps.getTextFromElement(objRegisterPage.errorFieldRegistration()));

    }
}
