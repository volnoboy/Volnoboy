package com.volnoboy;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HeaderColorTest {
    @Test
    public void startWebDriver(){
        WebDriver driver = new FirefoxDriver();
        driver.navigate().to("http://comments.azurewebsites.net")   ;
        Assert.assertTrue("Хабр",
                driver.getTitle().startsWith("Index"));

//
//        String headerColor = driver.findElement(By.xpath(".//*[@id='title']/h1")).getCssValue("color");
//
//        Assert.assertTrue("#000000", headerColor.equals("#FFFFFF"));

        // We are using  .getCssValue method to find out color of the header. And we mach it to white color.
        String headerColor = driver.findElement(By.xpath(".//*[@id='title']/h1")).getCssValue("color");
        //System.out.println("Actual value: " + headerColor);
        Assert.assertEquals("some message", "rgba(255, 255, 255, 1)", headerColor);



        driver.close();
    }
}
