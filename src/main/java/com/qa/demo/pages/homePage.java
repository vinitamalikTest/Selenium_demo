package com.qa.demo.pages;

import com.qa.demo.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.io.IOException;

/**
 * @author Vinita
 *
 */
public class homePage extends TestBase {
    public homePage() throws IOException {
        super();
        PageFactory.initElements(driver, this);
    }


 



}
