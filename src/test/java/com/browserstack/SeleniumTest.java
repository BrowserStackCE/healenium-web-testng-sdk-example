package com.browserstack;

import com.epam.healenium.SelfHealingDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumTest {
    public WebDriver delegate;
    public SelfHealingDriver driver;

    @BeforeMethod(alwaysRun = true)
    @SuppressWarnings("unchecked")
    public void setUp() throws Exception {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        delegate = new ChromeDriver(options);
        driver = SelfHealingDriver.create(delegate);

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
       try {
           driver.quit();
       }catch(Exception e){
           System.out.println("Exception at quit   " + e.getStackTrace());

       }
    }
}
