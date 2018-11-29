package com.netcompany.sdu.testing.testingdemo.ui;

import com.netcompany.sdu.testing.testingdemo.BaseUiTest;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * Created by mrr on 29/11/2018.
 */
public class UiTest extends BaseUiTest {

    @Test
    public void additionTest() throws InterruptedException {
        BasePage page = basePage;

        page.getA().click();
        page.getA().clear();
        page.getA().sendKeys("1.0");

        page.getB().click();
        page.getB().clear();
        page.getB().sendKeys("2.0");
        Thread.sleep(10*1000);

        page.getB().submit();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        assertEquals("The result of the calculation is 3.0", page.getResult().getText());
        Thread.sleep(10*1000);
    }
}
