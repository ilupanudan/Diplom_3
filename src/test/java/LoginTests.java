import io.qameta.allure.junit4.DisplayName;
import org.example.pageobjects.*;
import org.example.steps.Steps;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.example.usergenerator.UserSteps.*;
import static org.junit.Assert.assertEquals;
import static utils.PageConstants.HOME_PAGE_URL;
import static utils.PageConstants.LOGIN_PAGE_URL;

public class LoginTests extends BaseTest {

    @Before
    public void setUpLoginTest() {
        createUser();
    }

    @After
    public void tearDownLoginTest() {
        deleteUser();
    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной;")
    public void loginFromPersonalAccButtonBot() {
        MainPage objMainPage = new MainPage(driver);
        LoginPage objLoginPage = new LoginPage(driver);
        Steps steps = new Steps(driver);

        driver.get(HOME_PAGE_URL);

        steps.clickOnElement(objMainPage.EnterToPersonalAccButtonBot());

        steps.enterText(objLoginPage.emailField(), user.getEmail());

        steps.enterText(objLoginPage.passwordField(), user.getPassword());

        steps.clickOnElement(objLoginPage.enterButton());

        String buttonText = steps.getTextFromElement(objMainPage.EnterToPersonalAccButtonBot());


        assertEquals("Оформить заказ" ,buttonText );

    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»;")
    public void loginFromPersonalAccButtonTop() {
        MainPage objMainPage = new MainPage(driver);
        LoginPage objLoginPage = new LoginPage(driver);
        Steps steps = new Steps(driver);

        driver.get(HOME_PAGE_URL);

        steps.clickOnElement(objMainPage.personalAccButtonTop());

        steps.enterText(objLoginPage.emailField(), user.getEmail());

        steps.enterText(objLoginPage.passwordField(), user.getPassword());

        steps.clickOnElement(objLoginPage.enterButton());

        String buttonText = steps.getTextFromElement(objMainPage.EnterToPersonalAccButtonBot());


        assertEquals("Оформить заказ" ,buttonText );

    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации;")
    public void loginFromRegistrationButton() {
        MainPage objMainPage = new MainPage(driver);
        LoginPage objLoginPage = new LoginPage(driver);
        RegisterPage objRegisterPage = new RegisterPage(driver);
        Steps steps = new Steps(driver);

        driver.get(LOGIN_PAGE_URL);

        steps.clickOnElement(objLoginPage.registrationButton());

        steps.clickOnElement(objRegisterPage.buttonEnterInRegisterPage());

        steps.enterText(objLoginPage.emailField(), user.getEmail());

        steps.enterText(objLoginPage.passwordField(), user.getPassword());

        steps.clickOnElement(objLoginPage.enterButton());

        String buttonText = steps.getTextFromElement(objMainPage.EnterToPersonalAccButtonBot());

        assertEquals("Оформить заказ" ,buttonText );


    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля;")
    public void loginFromRecoveryPassword() {
        MainPage objMainPage = new MainPage(driver);
        LoginPage objLoginPage = new LoginPage(driver);
        ForgotPasswordPage objForgotPasswordPage = new ForgotPasswordPage(driver);
        Steps steps = new Steps(driver);

        driver.get(LOGIN_PAGE_URL);

        steps.clickOnElement(objLoginPage.recoveryPasswordButton());


        steps.clickOnElement(objForgotPasswordPage.enterButtonRecoveryPage());

        steps.waitElement(objLoginPage.enterButton());

        steps.enterText(objLoginPage.emailField(), user.getEmail());

        steps.enterText(objLoginPage.passwordField(), user.getPassword());

        steps.clickOnElement(objLoginPage.enterButton());

        String buttonText = steps.getTextFromElement(objMainPage.EnterToPersonalAccButtonBot());

        assertEquals("Оформить заказ" ,buttonText );

    }


    @Test
    @DisplayName("Выход из аккаунта по кнопке «Выйти» в личном кабинете;")
    public void logoutFromProfilePage() {
        MainPage objMainPage = new MainPage(driver);
        LoginPage objLoginPage = new LoginPage(driver);
        ProfilePage objProfilePage = new ProfilePage(driver);
        Steps steps = new Steps(driver);

        driver.get(LOGIN_PAGE_URL);

        steps.enterText(objLoginPage.emailField(), user.getEmail());

        steps.enterText(objLoginPage.passwordField(), user.getPassword());

        steps.clickOnElement(objLoginPage.enterButton());

        steps.clickOnElement(objMainPage.personalAccButtonTop());

        steps.clickOnElement(objProfilePage.exitButton());

        steps.waitElement(objLoginPage.enterButton());

        assertEquals(LOGIN_PAGE_URL ,driver.getCurrentUrl() );

    }


}
