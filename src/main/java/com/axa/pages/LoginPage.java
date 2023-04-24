package com.axa.pages;

import com.axa.utilities.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private By userNameTextField = By.xpath("//input[@formcontrolname='username']");
    private By passwordTextField = By.xpath("//input[@formcontrolname='password']");
    private By logInButton = By.xpath("//button[text()='LOGIN']");

    public LoginPage(WebDriver driver) throws Exception {
        super(driver);
        BrowserActions.waitUntilWebElementIsPresent(logInButton, this.driver);
    }

    public void enterUserName(String userName) throws Exception {
        BrowserActions.waitAndEnterTextInWebElement(userName,userNameTextField, this.driver);
    }

    public void enterPassword(String password) throws Exception {
        BrowserActions.waitAndEnterTextInWebElement(password,passwordTextField, this.driver);
    }

    public HomePage clickOnLoginButton() throws Exception {
        BrowserActions.waitAndClickOnWebElement(logInButton, this.driver);
        return new HomePage(this.driver);
    }

}