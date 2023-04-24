package com.axa.pages;

import com.axa.utilities.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RfqListPage extends BasePage {
    private By rfqListHeaderElement= By.xpath("//h1[text()='RFQ List']");
    public RfqListPage(WebDriver driver) throws Exception {
        super(driver);
        BrowserActions.waitUntilWebElementIsPresent(rfqListHeaderElement, this.driver);
    }

    public String getRFQStatus(String rfqNumber) throws Exception {
        By status=By.xpath("(//td[text()='"+rfqNumber+"']//following-sibling::td)[2]");
        return BrowserActions.waitAndGetWebElementText(status,driver);
    }

}
