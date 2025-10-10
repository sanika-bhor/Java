package com.transflower.TFLAssessment.TFLAssessement_Testing.SMELogin;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

public class SMELoginTest {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void SMELogin() {
        driver.get("http://localhost:5501/home.html");

        WebElement loginClick = driver.findElement(By.className("login-link"));
        loginClick.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/loginJWT.html"));

        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("nirjala.naik@example.com");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("12345");

        WebElement loginButton = driver.findElement(By.cssSelector("button[type=submit]"));
        loginButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("/SME/sme.html"));

        Assert.assertTrue(driver.getCurrentUrl().contains("/SME/sme.html"));

        WebElement createTest = driver.findElement(By.id("createTestLink"));
        createTest.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/SME/sme.html"));

        WebElement testName = driver.findElement(By.id("testName"));
        testName.sendKeys("New Java Test");

        WebElement duration = driver.findElement(By.id("duration"));
        duration.sendKeys("00:30:00");

        Select subject = new Select(driver.findElement(By.id("subjectSelect")));
        subject.selectByValue("1");
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println(e);
        }

        Select smeselect = new Select(driver.findElement(By.id("smeSelect")));
        smeselect.selectByValue("1");

        // LocalDateTime dateTime = LocalDateTime.of(2025, 10, 7, 18, 1);
        // DateTimeFormatter formatter =
        // DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        // String formattedDateTime = dateTime.format(formatter);

        // WebElement scheduleTime=driver.findElement(By.id("scheduledDate"));
        // // scheduleTime.sendKeys(formattedDateTime);
        // scheduleTime.clear();
        // scheduleTime.sendKeys("2025-10-07T18:38");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('scheduledDate').value = '2025-10-07T18:50';");

        WebElement passingLevel = driver.findElement(By.id("passingLevel"));
        passingLevel.sendKeys("10");

        WebElement ques1 = driver.findElement(By.cssSelector("input[value='1']"));
        ques1.click();

        WebElement ques2 = driver.findElement(By.cssSelector("input[value='2']"));
        ques2.click();

        WebElement ques3 = driver.findElement(By.cssSelector("input[value='4']"));
        ques3.click();

        WebElement ques4 = driver.findElement(By.cssSelector("input[value='23']"));
        ques4.click();

        WebElement ques5 = driver.findElement(By.cssSelector("input[value='47']"));
        ques5.click();

        WebElement ques6 = driver.findElement(By.cssSelector("input[value='40']"));
        ques6.click();

        WebElement createTestButton = driver.findElement(By.id("submitBtn"));
        createTestButton.click();

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println(e);
        }

        Assert.assertTrue(driver.getCurrentUrl().contains("/SME/reviewtest.html"));

        WebElement confirmButton = driver.findElement(By.id("confirmBtn"));
        confirmButton.click();

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Final URL: " + driver.getCurrentUrl());

        Assert.assertTrue(driver.getCurrentUrl().contains("/SME/sme.html?msg=Test%20Created%20Successfully"));
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
