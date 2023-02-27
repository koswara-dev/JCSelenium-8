package com.juaracoding.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestForm {
    WebDriver driver;
    String pathChromeDriver = "C:\\juaracoding\\chromedriver.exe";

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", pathChromeDriver);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(priority = 1)
    public void testUrl(){
        //step action
        String url = "https://demoqa.com/text-box";
        driver.get(url);
        System.out.println("Get URL");
        driver.manage().window().maximize();
        System.out.println("Maximize Browser");
        String titleHeader = driver.getTitle();
        System.out.println("Title Header : "+titleHeader);
        //driver.navigate().refresh();
        //step verify
        Assert.assertEquals(titleHeader, "DEMOQA");
    }

    @Test(priority = 2)
    public void testFormIdentity(){
        delay(1);
        driver.findElement(By.id("userName")).sendKeys("JuaraCoding");
        driver.findElement(By.id("userEmail")).sendKeys("info@juaracoding.com");
        driver.findElement(By.id("currentAddress")).sendKeys("Jakarta");
        driver.findElement(By.id("permanentAddress")).sendKeys("Jakarta");
        //Scroll by pixel (vertical)
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        driver.findElement(By.id("submit")).click();
        String txtName = driver.findElement(By.xpath("//p[@id='name']")).getText();
        Assert.assertTrue(txtName.contains("JuaraCoding"));
    }

    @AfterClass
    public void quitBrowser(){
        delay(3);
        driver.quit();
        System.out.println("Quit Browser");
    }

    static void delay(long detik){
        try {
            Thread.sleep(detik*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
