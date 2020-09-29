package com.qa.demo.testCases;

import com.qa.demo.base.TestBase;
import com.qa.demo.pages.homePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
/**
 * @author Vinita
 *
 */
public class homePageTest extends TestBase {
    static homePage home;
    static constantHomePage homeLocators;
    public homePageTest() throws IOException {
        super();
        PageFactory.initElements(driver, this);
    }
    @BeforeTest
    public static void Setup() throws IOException, InterruptedException {
        initialization();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
       
    }
  @Test
    public void clickOntext(){
	  homeLocators.clickOnNoThanks();
      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  homeLocators.clickOnhyperLinkText();
   }


	@AfterMethod
    public void teardown() {
        driver.quit();
    }
}
