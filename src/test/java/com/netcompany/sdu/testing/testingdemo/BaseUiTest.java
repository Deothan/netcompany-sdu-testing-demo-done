package com.netcompany.sdu.testing.testingdemo;

import com.netcompany.sdu.testing.testingdemo.ui.BasePage;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by mrr on 29/11/2018.
 */
public abstract class BaseUiTest {
    protected WebDriver driver;
    protected BasePage basePage;

    @Before
    public void driver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOptions);
        basePage = PageFactory.initElements(driver, BasePage.class);
        basePage.setDriver(driver);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://localhost:8080/");
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}
