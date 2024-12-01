package org.example.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //Локатор поля Email
    public By emailField(){

        return By.xpath("//fieldset[1]/div/div/input");
    }

    //Локатор поля Password
    public By passwordField(){

        return By.xpath("//fieldset[2]/div/div/input");
    }

    //Локатор кнопки "Войти"
    public By enterButton(){

        return By.xpath("//button[text()='Войти']");
    }

    //Локатор кнопки "Зарегистрироваться"
    public By registrationButton(){

        return By.xpath("//div/div/p[1]/a");
    }

    //Локатор кнопки "Восстановить пароль"
    public By recoveryPasswordButton(){

        return By.xpath("//div/div/p[2]/a");
    }

    //Локатор заголовка
    public By logoItem(){
        return By.xpath("//main/div/h2[text()='Вход']");
    }


}
