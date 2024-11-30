package org.example.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {
    private final WebDriver driver;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    //Локатор нопки "Выйти"
    public By exitButton(){

        return By.xpath("//ul/li[3]/button");
    }
}

