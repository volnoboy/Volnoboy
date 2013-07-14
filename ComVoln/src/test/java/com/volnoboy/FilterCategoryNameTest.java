package com.volnoboy;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FilterCategoryNameTest {
    @Test
    public void startWebDriver(){
        WebDriver driver = new FirefoxDriver();
        driver.navigate().to("http://comments.azurewebsites.net")   ;
        Assert.assertTrue("Хабр",
                driver.getTitle().startsWith("Index"));
         //Choosing category and applying filter.
        driver.findElement(By.xpath(".//*[@id='SelectedCateg']/option[4]")).click();
        driver.findElement(By.xpath(".//*[@id='applybutton']")).click();
        driver.close();
    }
}
