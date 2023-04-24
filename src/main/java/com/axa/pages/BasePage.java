package com.axa.pages;

import com.axa.utilities.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {

    public WebDriver driver;

    /********************************* Side Menu Elements *******************************************/

    private By sideMenuButton = By.xpath("//img[@src='https://img.icons8.com/fluency/48/000000/menu-rounded.png']");

    private By sideMenuExpandedViewElement = By.xpath("//div[@class='menu-default menu-sub-hidden']");

    private By subSideMenuExpandedViewElement = By.xpath("//div[@class='menu-default menu-sub-hidden sub-show-temporary']");

    private By requestsSideMenuButton = By.xpath("//a[text()=' Requests']");

    /********************************* Requests sub side menu elements *******************************************/
    private By requestAQuotationSubSideMenuButton = By.xpath("//span[text()='Request a Quotation']");
    private By rfqListSubSideMenuButton = By.xpath("//span[text()='RFQ List']");



    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    /********************************* Side Menu Functions *******************************************/

    public void expandSideMenu() throws Exception {
        BrowserActions.waitAndClickOnWebElement(sideMenuButton, this.driver);
        BrowserActions.waitUntilWebElementIsPresent(sideMenuExpandedViewElement,driver);
    }

    public void clickOnRequestsSideMenuButton() throws Exception {
        BrowserActions.waitAndClickOnWebElement(requestsSideMenuButton, this.driver);
        BrowserActions.waitUntilWebElementIsPresent(subSideMenuExpandedViewElement, this.driver);
        BrowserActions.waitAndHoverOverElement(rfqListSubSideMenuButton,driver);
      //  Thread.sleep(2000);
    }

    public RequestAQuotationPage clickOnRequestAQuotationSubSideMenuButton() throws Exception {
        BrowserActions.waitAndClickOnWebElement(requestAQuotationSubSideMenuButton, this.driver);
        return new RequestAQuotationPage(this.driver);
    }

    public RfqListPage clickOnRfqListSubSideMenuButton() throws Exception {
        BrowserActions.waitAndClickOnWebElement(rfqListSubSideMenuButton, this.driver);
        return new RfqListPage(this.driver);
    }


}
