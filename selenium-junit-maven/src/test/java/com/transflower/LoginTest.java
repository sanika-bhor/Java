package com.transflower;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.webdriver.WebDriverBrowser;
import junit.framework.Assert;


public class LoginTest {
    private static WebDriver driver;

    @BeforeAll
     static void  setup()
    {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("file://A:/TAP/GitHub/Java/webpagefortest/login.html");

    }

    @Test
    void testGoogleSearch() 
    {
        
        WebElement username=driver.findElement(By.id("username"));
        WebElement password=driver.findElement(By.id("password"));
        WebElement lgnbtn=driver.findElement(By.id("loginBtn"));
    //    WebElement message = driver.findElement(By.id("message"));
         
        

        username.sendKeys("sanika_bhor@gmail.com");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ie) {
            System.out.println(ie);
        }
        password.sendKeys("s@nika");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ie) {
            System.out.println(ie);
        }
       
        String enteredUser = username.getAttribute("value");
        String enteredPass = password.getAttribute("value");

        lgnbtn.click();
       
       
        //  Wait for message input to be updated
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement message = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.id("message"))
        );


       
        if(enteredUser.equals("sanika_bhor@gmail.com") && enteredPass.equals("s@nika"))
        {
            message.sendKeys("Login successful");
        } else {
            message.sendKeys("Invalid credentials");
        }

        try
        {
        Thread.sleep(2000);
        }
        catch(InterruptedException ie)
        {
            System.out.println(ie);
        }
        assertTrue(message.getAttribute("value").contains("Login successful"));
    }

    @AfterAll
    static void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
