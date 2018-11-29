package com.netcompany.sdu.testing.testingdemo.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by mrr on 29/11/2018.
 */
public class BasePage {

    public static WebDriver driver;

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getA() {
        return driver.findElement(By.xpath("//input[@id='a']"));
    }

    public WebElement getB() {
        return driver.findElement(By.xpath("//input[@id='b']"));
    }

    public WebElement getResult() {
        return driver.findElement(By.xpath("//h2[@class='result']"));
    }
}