import io.qameta.allure.junit4.DisplayName;
import org.example.steps.Steps;
import org.example.pageobjects.LoginPage;
import org.example.pageobjects.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.example.usergenerator.UserSteps.*;
import static org.junit.Assert.assertEquals;
import static utils.PageConstants.*;

public class MoveToPageTests extends BaseTest{



    @Before
    public void setUpLoginTest() {
        createUser();
        driver.get(LOGIN_PAGE_URL);
    }

    @After
    public void tearDownLoginTest() {
        deleteUser();
    }

    @Test
    @DisplayName("Переход в личный кабинет по клику на «Личный кабинет»;")
    public void moveToPersonalAccPage() {
        MainPage objMainPage = new MainPage(driver);
        LoginPage objLoginPage = new LoginPage(driver);
        Steps steps = new Steps(driver);

        steps.enterText(objLoginPage.emailField(), user.getEmail());

        steps.enterText(objLoginPage.passwordField(), user.getPassword());

        steps.clickOnElement(objLoginPage.enterButton());

        steps.clickOnElement(objMainPage.personalAccButtonTop());

        assertEquals(PROFILE_PAGE_URL ,driver.getCurrentUrl());

    }

    @Test
    @DisplayName("Переход в «Конструктор» по клику на логотип из личного кабинета;")
    public void moveToMainPageByLogo() {
        MainPage objMainPage = new MainPage(driver);
        LoginPage objLoginPage = new LoginPage(driver);
        Steps steps = new Steps(driver);


        steps.enterText(objLoginPage.emailField(), user.getEmail());

        steps.enterText(objLoginPage.passwordField(), user.getPassword());

        steps.clickOnElement(objLoginPage.enterButton());

        steps.clickOnElement(objMainPage.personalAccButtonTop());

        steps.clickOnElement(objMainPage.burgerButtonTop());

        assertEquals(HOME_PAGE_URL ,driver.getCurrentUrl());

    }

    @Test
    @DisplayName("Переход в «Конструктор» по клику на кнопку \"конструктор\" из личного кабинета;")
    public void moveToMainPageByConstructorButton() {
        MainPage objMainPage = new MainPage(driver);
        LoginPage objLoginPage = new LoginPage(driver);
        Steps steps = new Steps(driver);


        steps.enterText(objLoginPage.emailField(), user.getEmail());

        steps.enterText(objLoginPage.passwordField(), user.getPassword());

        steps.clickOnElement(objLoginPage.enterButton());

        steps.clickOnElement(objMainPage.personalAccButtonTop());

        steps.clickOnElement(objMainPage.constructorButtonTop());

        assertEquals(HOME_PAGE_URL ,driver.getCurrentUrl());

    }




}
