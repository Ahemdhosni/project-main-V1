package com.axa.pages;

import com.axa.utilities.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SubscribtionPage extends BasePage {
    private By firstPackageName= By.id("name-لايت");
    private By firstPackageCurr= By.id("currency-لايت");
    private By delement = By.className("country-current");
    private By countryBtn= By.id("country-btn");
    private By EGCountry = By.id("eg");
    private By lightPackPrice = By.id("currency-لايت");
    private By basicPackPrice = By.id("currency-الأساسية");
    private By PremiumPackPrice = By.id("currency-بريميوم");

    public SubscribtionPage(WebDriver driver) throws Exception {
        super(driver);

    }

    public void selectCounty(String countryName) throws Exception {
        By EGCountry = By.id(countryName);
        BrowserActions.waitAndClickOnWebElement(countryBtn,driver);
        BrowserActions.waitAndClickOnWebElement(EGCountry,driver);
        //return BrowserActions.waitAndGetWebElementText(firstPackageCurr,driver);
    }

    public String GetPackagePrice(String packageName) throws Exception {
        By pkg = By.id(packageName);

        return BrowserActions.waitAndGetWebElementText(pkg,driver);
    }

}
