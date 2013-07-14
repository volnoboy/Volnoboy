package com.volnoboy;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created with IntelliJ IDEA.
 * User: Reuven
 * Date: 7/5/13
 * Time: 12:08 AM
 * To change this template use File | Settings | File Templates.
 */

            public class WebTest {

                @Test
                public void startWebDriver(){
                WebDriver driver = new FirefoxDriver();
                    driver.navigate().to("http://comments.azurewebsites.net");
                    Assert.assertTrue("Хабр",
                            driver.getTitle().startsWith("Index"));
                    //Creating new comment. Adding text, number and category to it.
                    driver.findElement(By.xpath(".//*[@id='command-navigation']/input[1]")).click();
                    WebElement text = driver.findElement(By.xpath(".//*[@id='Text']"));
                    text.sendKeys("I love it");
                    WebElement number = driver.findElement(By.xpath(".//*[@id='Number']"));
                    number.sendKeys("248");

//                    String checkboxXPath = new String(".//*[@id='alvailablecategories']/div[1]/span");
//                    WebElement elementToClick = driver.findElement(By.xpath(checkboxXPath));
//                    elementToClick.click();
//                    driver.findElement(By.xpath(".//*[@id='categoryselector']/div[2]/input[2]")).click();

                    //Adding Category.
                    driver.findElement(By.xpath(".//*[@id='categoryselector']/div[2]/input[1]")).click();
                    //Save and return.
                    driver.findElement(By.xpath(".//*[@id='editor-navigation']/input[2]")).click();
                    //Making sure we are back to index page.
                    Assert.assertTrue("Editor",
                            driver.getTitle().startsWith("Index"));

                    driver.close();
                }
}
