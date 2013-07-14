package com.volnoboy;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NumberSortTest {
    @Test
    public void startWebDriver(){
        WebDriver driver = new FirefoxDriver();
        driver.navigate().to("http://comments.azurewebsites.net");
        Assert.assertTrue("Хабр",
                driver.getTitle().startsWith("Index"));
          //Clicking number to change sorting of the list.
        driver.findElement(By.xpath(".//*[@id='main']/div/div[5]/form/table/thead/tr/th[2]/a")).click();
        driver.close();
}
}
