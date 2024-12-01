
import io.qameta.allure.junit4.DisplayName;
import org.example.steps.Steps;

import org.example.pageobjects.MainPage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static utils.PageConstants.HOME_PAGE_URL;


public class SectionMoveTests extends BaseTest {

    @Before
    public void setUpRegistrationTest(){

        driver.get(HOME_PAGE_URL);
    }


    @Test
    @DisplayName("Переход к разделу \"Булки\";")
    public void moveToBunsSection() {
        Steps steps = new Steps(driver);
        MainPage objMainPage = new MainPage(driver);
        steps.clickOnElement(objMainPage.saucesButton());
        steps.clickOnElement(objMainPage.bunsButton());
        String classValueBuns = objMainPage.bunsWebElement().getAttribute("class");

        Assert.assertTrue(classValueBuns.contains("current"));
    }

    @Test
    @DisplayName("Переход к разделу \"Соусы\";")
    public void moveToSaucesSection() {
        Steps steps = new Steps(driver);
        MainPage objMainPage = new MainPage(driver);
        steps.clickOnElement(objMainPage.saucesButton());
        String classValueSauces = objMainPage.saucesWebElement().getAttribute("class");

        Assert.assertTrue(classValueSauces.contains("current"));
    }

    @Test
    @DisplayName("Переход к разделу \"Начинки\";")
    public void moveToFillingsSection() {
        Steps steps = new Steps(driver);
        MainPage objMainPage = new MainPage(driver);
        steps.clickOnElement(objMainPage.fillingsButton());
        String classValueFillings = objMainPage.fillingsWebElement().getAttribute("class");

        Assert.assertTrue(classValueFillings.contains("current"));

    }
}
