package com.transflower;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testLoginPageTitle() {
        driver.get("http://127.0.0.1:5500/login.html");
        String title = driver.getTitle();
        System.out.println("Page title: " + title);
        Assert.assertEquals(title, "Login");
    }

    @Test
    public void testLoginButtonExists() {
        driver.get("http://127.0.0.1:5500/login.html");
        WebElement username=driver.findElement(By.id("username"));
        WebElement password=driver.findElement(By.id("password"));
        username.sendKeys("admin");
        password.sendKeys("admin");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginbtn")));
        loginButton.click();

        WebElement msg=driver.findElement(By.id("message"));  
        if(msg.getText().equals("Login successful"))
        {
            // Wait for the exact URL to change to the expected one
            wait.until(ExpectedConditions.urlToBe("http://127.0.0.1:5500/index.html"));

        }
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "http://127.0.0.1:5500/index.html", "Page did not redirect to the expected URL.");
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
