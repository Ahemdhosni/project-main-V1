package com.axa.pages;

import com.axa.utilities.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private By homePageHeaderElement = By.xpath("//h1[text()='Home']");

    public HomePage(WebDriver driver) throws Exception {
        super(driver);
        BrowserActions.waitUntilWebElementIsPresent(homePageHeaderElement, this.driver);
    }
}
