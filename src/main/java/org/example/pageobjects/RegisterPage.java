package org.example.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    private final WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    //Локатор поля ввода Name
    public By registerNameField(){

        return By.xpath("//fieldset[1]/div/div/input");
    }

    //Локатор поля ввода Email
    public By registerEmailField(){

        return By.xpath("//fieldset[2]/div/div/input");
    }

    //Локатор поля ввода Password
    public By registerPasswordField(){

        return By.xpath("//fieldset[3]/div/div/input");
    }

    //Локатор поля кнопки "Зарегистрироваться"
    public By registerButton(){

        return By.xpath("//button[text()='Зарегистрироваться']");
    }
    //Локатор поля ошибки "Некорректный пароль"
    public By errorFieldRegistration(){

        return By.xpath("//div/p[text()='Некорректный пароль']");
    }

    //Локатор ссылки "Войти" на странице регистрации
    public By buttonEnterInRegisterPage(){

        return By.xpath("//div/div/p/a");
    }

}
