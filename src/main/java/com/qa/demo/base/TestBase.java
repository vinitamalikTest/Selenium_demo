package com.qa.demo.base;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
public class TestBase {

    public static WebDriver driver;
    public static Properties prop;

    public TestBase() {
        try {
            prop = new Properties();
            /*
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir") +
                    "/src/main/java/com/qa/demo/config/config.properties");*/
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir") +
                    "\\src\\main\\java\\com\\qa\\demo\\config\\config.properties");
            prop.load(ip);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public static void initialization() throws InterruptedException {

        String BrowserName = prop.getProperty("browser");

        if (BrowserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +
                    "/src/main/java/com/qa/demo/data/chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if(BrowserName.equals("chromeheadless")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            /*System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+
                    "/src/main/java/com/qa/demo/data/chromedriver")	;*/
           System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+
                    "\\src\\main\\java\\com\\qa\\demo\\data\\chromedriver.exe")	;
            chromeOptions.addArguments("--headless");
            chromeOptions.addArguments("--disable-gpu");
            chromeOptions.addArguments("--window-size=1920x1080");
            driver=new ChromeDriver(chromeOptions);
            // log.info("launching Chrome Broswer");
        }
        else {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") +
                    "/src/main/java/com/qa/demo/data/geckodriver.exe");
            driver = new FirefoxDriver();
        }
        driver.get(prop.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public static void failed(String testMethodName) {

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "/Screen"
                    + "shot/" + testMethodName + ".jpg"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}