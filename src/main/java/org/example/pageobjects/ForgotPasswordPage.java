package org.example.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    private final WebDriver driver;

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }


    //Локатор ссылки "Войти"
    public By enterButtonRecoveryPage(){

        return By.xpath("//a[text()='Войти']");
    }
}
