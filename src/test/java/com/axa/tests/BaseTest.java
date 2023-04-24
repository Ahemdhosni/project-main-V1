package com.axa.tests;

import com.axa.utilities.DriverSetup;
import com.axa.utilities.PropertyFileSetup;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class BaseTest {
    public static ExtentHtmlReporter extentHtmlReporter;
    public static ExtentReports extentReports;
    public static ExtentTest extentTest;
    protected WebDriver driver;
    public SoftAssert softAssert;
    private String projectInitiationTimeStamp = new SimpleDateFormat("MM dd yyyy_ HH mm ss").format(Calendar.getInstance().getTime());

    @BeforeSuite
    public void setUpReport() {
        File newReportPackage = new File(System.getProperty("user.dir") + "/test-output/report "+projectInitiationTimeStamp);
        newReportPackage.mkdir();
        File newReportFolder = new File(System.getProperty("user.dir") + "/test-output/report "+projectInitiationTimeStamp+"/report");
        newReportFolder.mkdir();
        File screenShotsFolder = new File(System.getProperty("user.dir") + "/test-output/report "+projectInitiationTimeStamp+"/screenshots");
        screenShotsFolder.mkdir();
        extentHtmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/report "+projectInitiationTimeStamp+"/report/Report " + projectInitiationTimeStamp + ".html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentHtmlReporter);
        extentReports.setSystemInfo("Host Name", "Moustafa Ahmed");
        extentHtmlReporter.config().setChartVisibilityOnOpen(true);
        extentHtmlReporter.config().setDocumentTitle("Maribou Pro Testing");
        extentHtmlReporter.config().setReportName("Maribou Pro Testing Report");
        extentHtmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        extentHtmlReporter.config().setTheme(Theme.DARK);
    }

    @BeforeMethod
    public void setUpDriver() throws Exception {
        PropertyFileSetup.propertyFileSetup();
        DriverSetup.driverInitiate("Chrome");
        driver=DriverSetup.driver;
    }

    @AfterMethod
    public void getResult(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            extentTest.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " Test case FAILED due to below issues:", ExtentColor.RED));
            extentTest.fail(result.getThrowable());
            captureScreenShot();
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            extentTest.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
        } else {
            extentTest.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " Test Case SKIPPED", ExtentColor.ORANGE));
            extentTest.skip(result.getThrowable());
        }

        this.driver.quit();

    }

    @AfterSuite
    public void tearDown() {
        extentReports.flush();
    }


    public void captureScreenShot() throws IOException {
        String screenshotInitiationTimeStamp = new SimpleDateFormat("MM dd yyyy_ HH mm ss").format(Calendar.getInstance().getTime());
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String destinationFolder = System.getProperty("user.dir") + "/test-output/report "+projectInitiationTimeStamp+"/screenshots/" + screenshotInitiationTimeStamp + ".png";
        System.out.println(destinationFolder);
        File destination = new File(destinationFolder);
        FileUtils.copyFile(source, destination);
        extentTest.addScreenCaptureFromPath("../screenshots/" + screenshotInitiationTimeStamp + ".png");
    }
}
