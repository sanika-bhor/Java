package com.transflower.TFLAssessment.TFLAssessement_Testing.AdminLogin;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AdminLoginTest {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void LoginTest() {
        driver.get("http://localhost:5501/home.html");

        WebElement loginClick = driver.findElement(By.className("login-link"));
        loginClick.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/loginJWT.html"));


        WebElement email = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.id("password"));
        email.sendKeys("ravi.tambade@example.com");
        password.sendKeys("12345");
        WebElement loginButton = driver.findElement(By.cssSelector("button[type=submit]"));
        loginButton.click();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("/Admin/admin.html"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/Admin/admin.html"));

        WebElement assignTest = driver.findElement(By.id("showTestBtw"));
        assignTest.click();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println(e);
        }

        WebElement fromdate = driver.findElement(By.id("fromDate"));
        WebElement todate = driver.findElement(By.id("toDate"));
        fromdate.sendKeys("10/7/2025");
        todate.sendKeys("10/9/2025");

        WebElement getTestButton = driver.findElement(By.xpath("//button[text()='Get Tests']"));
        getTestButton.click();

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println(e);
        }

        Assert.assertNotEquals(driver.getPageSource().contains("Failed to load tests: Not Found"), true);

        WebElement updateTestButton = driver.findElement(By.xpath("//button[@onclick='updateTest(37)']"));
        updateTestButton.click();

        Assert.assertTrue(driver.getCurrentUrl().contains("/Admin/updatetest.html?id=37"));

        Select status = new Select(driver.findElement(By.id("statusDropdown")));
        status.selectByValue("scheduled");

        WebElement changeStatusButton = driver.findElement(By.id("changeStatus"));
        changeStatusButton.click();

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println(e);
        }
        Alert alert = driver.switchTo().alert(); // switch to the open alert
        alert.accept(); // click OK

        WebElement getStudentButton=driver.findElement(By.id("getStudents"));
        getStudentButton.click();

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println(e);
        }
        WebElement student1=driver.findElement(By.cssSelector("input[value='4']"));
        student1.click();

        WebElement student2=driver.findElement(By.cssSelector("input[value='6']"));
        student2.click();

       JavascriptExecutor js=(JavascriptExecutor) driver;
       js.executeScript("document.getElementById('scheduledStart').value= '2025-10-07T18:50';");
       js.executeScript("document.getElementById('scheduledEnd').value='2025-10-10T18:50';");

       WebElement remarks=driver.findElement(By.id("remarks"));
       remarks.sendKeys("Please attend test");

       WebElement addStudent=driver.findElement(By.id("addStudent"));
       addStudent.click();

       try {
           Thread.sleep(1000);
       } catch (Exception e) {
           System.out.println(e);
       }

       Alert newAlert=driver.switchTo().alert();
       newAlert.accept();
       Assert.assertTrue(driver.getCurrentUrl().contains("/Admin/admin.html"));
    }

    @AfterClass
      public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

}