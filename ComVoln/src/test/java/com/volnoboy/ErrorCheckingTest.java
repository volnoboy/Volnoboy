package com.volnoboy;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ErrorCheckingTest {
    @Test
    public void startWebDriver(){
        WebDriver driver = new FirefoxDriver();
        driver.navigate().to("http://comments.azurewebsites.net")   ;
        Assert.assertTrue("Хабр",
                driver.getTitle().startsWith("Index"));

        driver.findElement(By.xpath(".//*[@id='command-navigation']/input[1]")).click();


         //First error:    The Comment Text field is required.
        driver.findElement(By.xpath(".//*[@id='editor-navigation']/input[2]")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*$"));
        //Second error:     Comments must be assigned to at least one category.
        WebElement text = driver.findElement(By.xpath(".//*[@id='Text']"));
        text.sendKeys("I love it");
        driver.findElement(By.xpath(".//*[@id='editor-navigation']/input[2]")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*$"));
         //Third error:      The Number field should contain value from 0 to 999 and should be unique
        WebElement text2 = driver.findElement(By.xpath(".//*[@id='Text']"));
        text2.sendKeys("I love it");
        WebElement number = driver.findElement(By.xpath(".//*[@id='Number']"));
        number.sendKeys("1");
        driver.findElement(By.xpath(".//*[@id='categoryselector']/div[2]/input[1]")).click();
        driver.findElement(By.xpath(".//*[@id='editor-navigation']/input[2]")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*$"));
          // Testing to make sure we are still on the Editor page.
        Assert.assertTrue("Index",
                driver.getTitle().startsWith("Editor"));

        driver.close();
    }
}