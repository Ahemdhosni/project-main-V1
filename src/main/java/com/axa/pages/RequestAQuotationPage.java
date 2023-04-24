package com.axa.pages;

import com.axa.utilities.BrowserActions;
import org.openqa.selenium.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class RequestAQuotationPage extends BasePage {
    /********************************* Request a Quotation Main View Elements *******************************************/

    private By requestPageHeaderElement = By.xpath("//h1[text()='Request a Quotation']");
    private By policyTypeDropDownMenuElement = By.xpath("(//*[@formcontrolname='policyTypeId']//div)[2]");
    private By coverTypeDropDownMenuElement = By.xpath("(//*[@formcontrolname='coverType']//div)[2]");
    private By openCoverCurrencyDropDownMenuElement = By.xpath("(//*[@formcontrolname='openCoverCurrency']//div)[2]");
    private By minimumAndDepositTextField = By.xpath("//input[@formcontrolname='minimumAndDeposit']");
    private By maximumPerCertificateTextField = By.xpath("//input[@formcontrolname='maximumPerCertificate']");
    private By customerDropDownMenuElementTextField = By.xpath("//*[@formcontrolname='customerId']//input");
    private By brokerDropDownMenuElementTextField = By.xpath("//*[@formcontrolname='brokerId']//input");
    private By effectiveDateTextField = By.xpath("//input[@formcontrolname='effectiveDate']");
    private By durationDropDownMenuElementTextField = By.xpath("//*[@formcontrolname='duration']//input");
    private By customNumberOfDaysTextField = By.xpath("//input[@formcontrolname='numberOfDays']");
    private By productsDropDownMenuElementTextField = By.xpath("//*[@formcontrolname='selectedProducts']//input");
    private By productsDropDownMenuArrow = By.xpath("//*[@formcontrolname='selectedProducts']//span[@class='ng-arrow-wrapper']");
    private By deadlineDateTextField = By.xpath("//input[@formcontrolname='deadlineDate']");
    private By addNewCustomerButton = By.xpath("(//div[@class='col-1 pl-0 ng-star-inserted'])[1]//button");
    private By addNewBrokerButton = By.xpath("(//div[@class='col-1 pl-0 ng-star-inserted'])[2]//button");
    private By saveButton = By.xpath("//button[text()='Save']");

    /********************************* Add New Customer View Elements *******************************************/

    private By addNewCustomerViewHeaderElement = By.xpath("//h6[text()='Add New Customer']");
    private By englishCustomerNameTextFieldInAddNewCustomerView = By.xpath("//input[@formcontrolname='nameEn']");
    private By arabicCustomerNameTextFieldInAddNewCustomerView = By.xpath("//input[@formcontrolname='nameAr']");
    private By taxNumberTextFieldInAddNewCustomerView = By.xpath("//input[@formcontrolname='taxNumber']");
    private By contactNumberTextFieldInAddNewCustomerView = By.xpath("(//span[text()='Contact Number']//parent::label)//input");
    private By addButtonInAddNewCustomerView = By.xpath("//button[text()='Add']");
    private By closeButtonInAddNewCustomerView = By.xpath("//button[text()='Close']");

    /********************************* Add New Broker View Elements *******************************************/

    private By addNewBrokerViewHeaderElement = By.xpath("//h6[text()='Add New Broker']");
    private By brokerTypeDropDownInAddNewBrokerView = By.xpath("//select[@formcontrolname='brokerType']");
    private By brokerNameTextFieldInAddNewBrokerView = By.xpath("//input[@formcontrolname='nameEn']");
    private By fRANumberTextFieldInAddNewBrokerView = By.xpath("//input[@formcontrolname='fraCode']");
    private By contactNumberTextFieldInAddNewBrokerView = By.xpath("//input[@formcontrolname='contactDial']");
    private By addButtonInAddNewBrokerView = By.xpath("//button[text()='Add']");
    private By closeButtonInAddNewBrokerView = By.xpath("//button[text()='Close']");




    /********************************* Main Info View Elements *******************************************/

    private By nextButton = By.xpath("//button[text()='Next']");
    private By rfqHeaderElement = By.xpath("//*[contains(text(),'RFQ No.')]");
    private By finalTabHeaderElement = By.xpath("//div[text()='Final']");



    public RequestAQuotationPage(WebDriver driver) throws Exception {
        super(driver);
        BrowserActions.isWebElementPresent(requestPageHeaderElement, this.driver);
    }

    /********************************* Request a Quotation Main View Functions *******************************************/

    public void clickOnPolicyTypeDropDown() throws Exception {
        BrowserActions.waitAndClickOnWebElement(policyTypeDropDownMenuElement, this.driver);
    }

    public void clickOnOptionFromPolicyTypeDropDown(String option) throws Exception {
        clickOnPolicyTypeDropDown();
        By dropDownOptionElement=By.xpath("//span[text()='"+option+"']");
        BrowserActions.isWebElementPresent(dropDownOptionElement, this.driver);
        List<WebElement> options = driver.findElements(dropDownOptionElement);
        if(options.size()>1){
            dropDownOptionElement=By.xpath("(//span[text()='"+option+"'])[2]");
        }
        BrowserActions.waitAndClickOnWebElement(dropDownOptionElement, this.driver);
    }

    public void clickOnCoverTypeDropDown() throws Exception {
        BrowserActions.waitAndClickOnWebElement(coverTypeDropDownMenuElement, this.driver);
    }

    public void clickOnOptionFromCoverTypeDropDown(String option) throws Exception {
        clickOnCoverTypeDropDown();
        By dropDownOptionElement=By.xpath("//span[text()='"+option+"']");
        BrowserActions.isWebElementPresent(dropDownOptionElement, this.driver);
        List<WebElement> options = driver.findElements(dropDownOptionElement);
        if(options.size()>1){
            dropDownOptionElement=By.xpath("(//span[text()='"+option+"'])[2]");
        }
        BrowserActions.waitAndClickOnWebElement(dropDownOptionElement, this.driver);
    }

    public void clickOnAddNewCustomerButton() throws Exception {
        BrowserActions.waitAndClickOnWebElement(addNewCustomerButton, this.driver);
        BrowserActions.waitUntilWebElementIsPresent(addNewCustomerViewHeaderElement,driver);
    }

    public void clickOnAddNewBrokerButton() throws Exception {
        BrowserActions.waitAndClickOnWebElement(addNewBrokerButton, this.driver);
        BrowserActions.waitUntilWebElementIsPresent(addNewBrokerViewHeaderElement,driver);

    }

    public void clickOnOpenCoverCurrencyDropDown() throws Exception {
        BrowserActions.waitAndClickOnWebElement(openCoverCurrencyDropDownMenuElement, this.driver);
    }

    public void clickOnOptionFromOpenCoverCurrencyDropDown(String option) throws Exception {
        clickOnOpenCoverCurrencyDropDown();
        By dropDownOptionElement=By.xpath("//span[text()='"+option+"']");
        BrowserActions.isWebElementPresent(dropDownOptionElement, this.driver);
        List<WebElement> options = driver.findElements(dropDownOptionElement);
        if(options.size()>1){
            dropDownOptionElement=By.xpath("(//span[text()='"+option+"'])[2]");
        }
        BrowserActions.waitAndClickOnWebElement(dropDownOptionElement, this.driver);
    }

    public void clickOnSaveButton() throws Exception {
        BrowserActions.waitAndClickOnWebElement(saveButton, this.driver);
    }



    public void enterMinimumAndDeposit(String text) throws Exception {
        BrowserActions.waitAndEnterTextInWebElement(text,minimumAndDepositTextField, this.driver);
    }

    public void enterMaximumPerCertificate(String text) throws Exception {
        BrowserActions.waitAndEnterTextInWebElement(text,maximumPerCertificateTextField, this.driver);
    }

    public void enterTextInCustomerDropDown(String text) throws Exception {
        BrowserActions.waitAndEnterTextInWebElementAndThenPressEnter(text,customerDropDownMenuElementTextField, this.driver);
    }

    public void enterTextInBrokerDropDown(String text) throws Exception {
        BrowserActions.waitAndEnterTextInWebElementAndThenPressEnter(text,brokerDropDownMenuElementTextField, this.driver);
    }

    public void enterEffectiveDate(String dateOffset) throws Exception {
        String date = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(date));
        c.add(Calendar.DATE, Integer.parseInt(dateOffset));
        date = sdf.format(c.getTime());
        BrowserActions.waitAndEnterTextInWebElementAndThenPressEnter(date,effectiveDateTextField, this.driver);
    }

    public void enterTextInDurationDropDown(String text) throws Exception {
        BrowserActions.waitAndEnterTextInWebElementAndThenPressEnter(text,durationDropDownMenuElementTextField, this.driver);
    }

    public void enterCustomNumberOfDays(String text) throws Exception {
        BrowserActions.waitAndEnterTextInWebElementAndThenPressEnter(text,customNumberOfDaysTextField, this.driver);
    }

    public void enterTextInProductsDropDownMenu(String text) throws Exception {
        BrowserActions.waitAndEnterTextInWebElementAndThenPressEnter(text,productsDropDownMenuElementTextField, this.driver);
        BrowserActions.waitAndClickOnWebElement(productsDropDownMenuArrow,driver);

    }

    public void enterDeadlineDate(String dateOffset) throws Exception {
        String date = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(date));
        c.add(Calendar.DATE, Integer.parseInt(dateOffset));
        date = sdf.format(c.getTime());
        BrowserActions.waitAndEnterTextInWebElementAndThenPressEnter(date,deadlineDateTextField, this.driver);
    }

    /********************************* Add New Customer View Functions *******************************************/

    public void clickOnAddButtonInAddNewCustomerView() throws Exception {
//        for(int i=0;i<10;i++){
//            if(BrowserActions.isWebElementPresent(addButtonInAddNewCustomerView,driver)){
//                BrowserActions.waitAndClickOnWebElement(addButtonInAddNewCustomerView, this.driver);
//            }else{
//                break;
//            }
//        }
        BrowserActions.waitAndClickOnWebElement(addButtonInAddNewCustomerView, this.driver);
        BrowserActions.waitUntilWebElementIsNotPresent(addButtonInAddNewCustomerView,driver);
    }

    public void clickOnCloseButtonInAddNewCustomerView() throws Exception {
            BrowserActions.waitAndClickOnWebElement(closeButtonInAddNewCustomerView, this.driver);
    }

    public void enterEngCustomerNameInAddNewCustomerView(String text) throws Exception {
        BrowserActions.waitAndEnterTextInWebElement(text,englishCustomerNameTextFieldInAddNewCustomerView, this.driver);
     }

    public void enterArCustomerNameInAddNewCustomerView(String text) throws Exception {
        BrowserActions.waitAndEnterTextInWebElement(text,arabicCustomerNameTextFieldInAddNewCustomerView, this.driver);
    }

    public void enterTaxNumberInAddNewCustomerView(String text) throws Exception {
        BrowserActions.waitAndEnterTextInWebElement(text,taxNumberTextFieldInAddNewCustomerView, this.driver);
    }

    public void enterContactNumberInAddNewCustomerView(String text) throws Exception {
        BrowserActions.waitAndEnterTextInWebElement(text,contactNumberTextFieldInAddNewCustomerView, this.driver);
    }

    /********************************* Add New Broker View Functions *******************************************/

    public void chooseBrokerTypeFromAddNewBrokerView(String type) throws Exception {
        BrowserActions.waitAndSelectFromDropdown(type,brokerTypeDropDownInAddNewBrokerView,driver);
    }

    public void enterBrokerNameInAddNewBrokerView(String name) throws Exception {
        BrowserActions.waitAndEnterTextInWebElement(name,brokerNameTextFieldInAddNewBrokerView,driver);
    }

    public void enterFRANumberInAddNewBrokerView(String number) throws Exception {
        BrowserActions.waitAndEnterTextInWebElement(number,fRANumberTextFieldInAddNewBrokerView,driver);
    }

    public void enterContactNumberInAddNewBrokerView(String number) throws Exception {
        BrowserActions.waitAndEnterTextInWebElement(number,contactNumberTextFieldInAddNewBrokerView,driver);
    }

    public void clickOnAddButtonInAddNewBrokerView() throws Exception {
        BrowserActions.waitAndClickOnWebElement(addButtonInAddNewBrokerView, this.driver);
        BrowserActions.waitUntilWebElementIsNotPresent(addButtonInAddNewBrokerView,driver);
    }

    public void clickOnCloseButtonInAddNewBrokerView() throws Exception {
        BrowserActions.waitAndClickOnWebElement(closeButtonInAddNewBrokerView, this.driver);
    }


    /********************************* Main Info View Functions *******************************************/

    public void clickOnNextButtonInMainInfoView() throws Exception {
        BrowserActions.waitAndClickOnWebElement(nextButton, this.driver);
    }

    public String getRFQNumber() throws Exception {
        String rfq=BrowserActions.waitAndGetWebElementText(rfqHeaderElement, this.driver);
        return rfq.substring(rfq.indexOf(".")+1);
    }

    public boolean isRFQDisplayed() throws Exception {
        String rfq=getRFQNumber();
        System.out.println(rfq);
        if(rfq.length()>3){
            return true;
        }else{
            return false;
        }
    }

    public boolean isNextButtonDisplayed() throws Exception {
        return BrowserActions.isWebElementPresent(nextButton,driver);
    }

    public boolean isFinalTabDisplayed() throws Exception {
        return BrowserActions.isWebElementPresent(finalTabHeaderElement,driver);
    }
    public RfqListPage navigateToRfqListPage() throws Exception {
        clickOnRequestsSideMenuButton();
        return clickOnRfqListSubSideMenuButton();
    }
}
