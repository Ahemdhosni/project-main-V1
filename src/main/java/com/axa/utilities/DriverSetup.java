package com.axa.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverSetup {
    public static WebDriver driver;

    public static void driverInitiate(String browser) {
        switch (browser) {
            case "Chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.get(PropertyFileSetup.properties.getProperty("Url.AxaPortal"));
                driver.manage().window().maximize();
                break;
            case "Firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.get(PropertyFileSetup.properties.getProperty("Url.AxaPortal"));
                driver.manage().window().maximize();
                break;
            case "Edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                driver.get(PropertyFileSetup.properties.getProperty("Url.AxaPortal"));
                driver.manage().window().maximize();
                break;
            default:
                System.out.println("Browser is not Supported");
        }
    }
}
