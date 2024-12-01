package org.example.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Steps {
    private final WebDriver driver;

    public Steps(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Ввод текста в элемент")
    public void enterText(By element, String text) {
        driver.findElement(element).sendKeys(text);
    }


    @Step("Проверяем доступность элемента")
    public void waitElement(By element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }


    @Step("Проверяем доступность и нажимаем на элемент")
    public void clickOnElement(By element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).click();
    }

    @Step("Получаем текст из элемента")
    public String getTextFromElement(By element) {
        return driver.findElement(element).getText();
    }



    }

