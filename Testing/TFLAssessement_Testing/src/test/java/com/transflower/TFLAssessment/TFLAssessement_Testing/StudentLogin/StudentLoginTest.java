package com.transflower.TFLAssessment.TFLAssessement_Testing.StudentLogin;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StudentLoginTest
{
    WebDriver driver;
    @BeforeClass
    public void setup()
    {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
    }

    @Test
    public void loginTest()
    {
        driver.get("http://localhost:5501/home.html");

        WebElement loginClick=driver.findElement(By.className("login-link"));
        loginClick.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/loginJWT.html"));

        WebElement email=driver.findElement(By.id("email"));
        email.sendKeys("sumit.bhor@example.com");

        WebElement password=driver.findElement(By.id("password"));
        password.sendKeys("12345");

        WebElement loginButton=driver.findElement(By.cssSelector("button[type=submit]"));
        loginButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("/Student/student.html"));

        Assert.assertTrue(driver.getCurrentUrl().contains("/Student/student.html"));
        
        WebElement getAllTest=driver.findElement(By.id("TestList"));
        getAllTest.click();

        Assert.assertTrue(driver.getCurrentUrl().contains("/Student/student.html#"));

        WebElement detailsButton = driver.findElement(By.xpath("//button[contains(@data-test, '\"id\":9')]"));
        detailsButton.click();
       
        Assert.assertTrue(driver.getCurrentUrl().contains("/Student/student.html#"));
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println(e);
        }
     

        WebElement startTest=driver.findElement(By.xpath("//button[contains(@data-id,'9')]"));
        startTest.click();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }

    @AfterClass
      public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}