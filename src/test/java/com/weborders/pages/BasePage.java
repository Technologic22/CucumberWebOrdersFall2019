package com.weborders.pages;

import com.weborders.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    protected WebDriver driver=Driver.getDriver();
    WebDriverWait wait=new WebDriverWait(driver, 20);

    public BasePage(){
        PageFactory.initElements(driver, this);
    }
}
