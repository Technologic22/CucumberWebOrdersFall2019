package com.weborders.step_definitions;

import com.weborders.utilities.ConfigurationReader;
import com.weborders.utilities.Driver;
import io.cucumber.java.Scenario;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public void setup(Scenario scenario){
        System.out.println("--------Starting Test Automation-----------");
        System.out.println("Browser Name: "+ ConfigurationReader.getProperty("browser"));
        System.out.println("Environment: "+ConfigurationReader.getProperty("url"));
        System.out.println("Test Scenario: "+ scenario.getName());
        Driver.getDriver().manage().window().maximize();

    }

    @After
    public void tearDown(Scenario scenario){

        if (scenario.isFailed()){
            TakesScreenshot takesScreenshot=(TakesScreenshot) Driver.getDriver();
            byte[] image=takesScreenshot.getScreenshotAs(OutputType.BYTES);
            scenario.embed(image, "image/png", scenario.getName());
        }
        Driver.closeDriver();
    }

}
