package com.juaracoding.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SeleniumLocator {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\juaracoding\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String url = "https://demoqa.com/text-box";
        driver.get(url);
        System.out.println("Get URL");
        driver.manage().window().maximize();
        System.out.println("Maximize Browser");

        String titleHeader = driver.getTitle();
        System.out.println("Title Header : "+titleHeader);
        //Locator
        String title = driver.findElement(By.className("main-header")).getText();
        System.out.println("Title Page : "+title);
        driver.findElement(By.id("userName")).sendKeys("JuaraCoding");
        driver.findElement(By.id("userEmail")).sendKeys("info@juaracoding.com");
        driver.findElement(By.id("currentAddress")).sendKeys("Jakarta");
        driver.findElement(By.id("permanentAddress")).sendKeys("Jakarta");
        //Scroll by pixel (vertical)
        js.executeScript("window.scrollBy(0,500)");
        driver.findElement(By.id("submit")).click();
        System.out.println("Data berhasil disimpan");

        //verify
        System.out.println("Test Case Result :");
        if(title.equals("Text Box")){
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }

        //Checkbox
//        driver.get("https://demoqa.com/checkbox");
//        driver.findElement(By.xpath("//*[@id='tree-node']/ol/li/span/button")).click();
//        driver.findElement(By.xpath("//*[@id='tree-node']/ol/li/ol/li[3]/span/label/span[3]")).click();
//        String txtDownlaoads = driver.findElement(By.xpath("//*[@id='result']/span[2]")).getText();
//        System.out.println(txtDownlaoads);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
        System.out.println("Button Login Clicked");

        driver.get("https://www.google.com/");
        driver.findElement(By.linkText("Gmail")).click();

        System.out.println("Delay 3 seconds");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
        System.out.println("Quit Browser");
    }
}
