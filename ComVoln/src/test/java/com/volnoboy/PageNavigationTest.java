package com.volnoboy;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created with IntelliJ IDEA.
 * User: Reuven
 * Date: 7/8/13
 * Time: 11:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class PageNavigationTest {
    @Test
    public void startWebDriver(){
        WebDriver driver = new FirefoxDriver();
        driver.navigate().to("http://comments.azurewebsites.net")   ;
        Assert.assertTrue("Хабр",
                driver.getTitle().startsWith("Index"));
         //First we go to page 2 and than to page 3.
        driver.findElement(By.xpath(".//*[@id='main']/div/div[5]/form/table/tfoot/tr/td/a[1]")).click();
        driver.findElement(By.xpath(".//*[@id='main']/div/div[5]/form/table/tfoot/tr/td/a[2]")).click();

        driver.close();
    }
}


