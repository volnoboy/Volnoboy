package com.volnoboy;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ActivateTest {

        @Test
        public void startWebDriver(){
        WebDriver driver = new FirefoxDriver();
        driver.navigate().to("http://comments.azurewebsites.net");
           Assert.assertTrue("Хабр",
                driver.getTitle().startsWith("Index"));
            //We are activating the comment, and checking text that indicates comment activation.
            driver.findElement(By.xpath(".//*[@id='main']/div/div[5]/form/table/tbody/tr[1]/td[1]/input[1]")).click();
            driver.findElement(By.xpath(".//*[@id='commandSelect']/option[2]")).click();
            Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Comments was activated successfull[\\s\\S]*$"));

        driver.close();
}
}
