package org.example.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {

    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //Локатор кнопки личного кабинета top
    public By personalAccButtonTop(){

        return By.xpath("//nav/a/p");
    }

    //Локатор кнопки личного кабинета bot
    public By EnterToPersonalAccButtonBot(){

        return By.xpath("//section[2]/div/button");
    }

    //Локатор логотипа top
    public By burgerButtonTop(){

        return By.xpath("//nav/div/a");
    }

    //Локатор кнопки "Конструктор" top
    public By constructorButtonTop(){

        return By.xpath("//ul/li[1]/a");
    }

    //Локатор кнопки булок
    public By bunsButton(){

        return By.xpath("//span[text()='Булки']");
    }
    //Элемент кнопки булок
    public WebElement bunsWebElement(){
        return driver.findElement(By.xpath("//main/section[1]/div[1]/div[1]"));
    }

    //Локатор кнопки соусов
    public By saucesButton(){

        return By.xpath("//span[text()='Соусы']");
    }

    //Элемент кнопки соусов
    public WebElement saucesWebElement(){
        return driver.findElement(By.xpath("//main/section[1]/div[1]/div[2]"));
    }

    //Локатор кнопки начинок
    public By fillingsButton(){

        return By.xpath("//span[text()='Начинки']");
    }


    //Элемент кнопки начинок
    public WebElement fillingsWebElement(){
        return driver.findElement(By.xpath("//main/section[1]/div[1]/div[3]"));
    }
    }
