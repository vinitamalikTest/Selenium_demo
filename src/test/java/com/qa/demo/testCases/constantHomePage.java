package com.qa.demo.testCases;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.demo.base.TestBase;

public class constantHomePage extends TestBase{
	
	 public constantHomePage() throws IOException {
	 super();
     PageFactory.initElements(driver, this);
	 }
	
	

    /**
     *  This section of the Home page contains all the object/Locators of the Home screen
     *  All the Locators is static in nature, can access in entire project any where
     *  For locating elements here using @findBy for page object creation
     */

    @FindBy(xpath = "//a[@id='h_sub_menu']")
    static WebElement homePageLinkText;
    
  
    @FindBy(xpath = "//a[@class='notnow']")
    static WebElement homePageClickonNothanks;
      
    
    /**
     *  This section fo the home page contains all the possible homepage scenario's for test
     *  all the methods are public in nature and return the actual results
     */

      
    public void clickOnhyperLinkText(){
        homePageLinkText.click();
    }
    public void clickOnNoThanks(){
    	homePageClickonNothanks.click();
    }
}
