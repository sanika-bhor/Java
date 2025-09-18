package com.transflower;

import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RegisterTest {
    public static WebDriver webDriver;

    @BeforeAll
    static void setup()
    {
        WebDriverManager.chromedriver().setup();
        webDriver=new ChromeDriver();
        webDriver.get("http://127.0.0.1:5500/src/webpages/register.html");
    }

    @Test
    void testRegisterPage()
    {
        WebElement firstName=webDriver.findElement(By.id("firstName"));
        WebElement lastName=webDriver.findElement(By.id("lastName"));
        WebElement email=webDriver.findElement(By.id("email"));
        WebElement password=webDriver.findElement(By.id("password"));
        WebElement confirmPassword=webDriver.findElement(By.id("confirmPassword"));

        WebElement genderMale=webDriver.findElement(By.id("male"));
        WebElement genderFemale=webDriver.findElement(By.id("female"));

        WebElement readingCheckbox = webDriver.findElement(By.cssSelector("input[value='reading']"));
        WebElement sportsCheckbox = webDriver.findElement(By.cssSelector("input[value='sports']"));
        WebElement musicCheckbox = webDriver.findElement(By.cssSelector("input[value='music']"));
        WebElement travelCheckbox = webDriver.findElement(By.cssSelector("input[value='travel']"));

        WebElement dob=webDriver.findElement(By.id("dob"));
        Select country=new Select(webDriver.findElement(By.id("country")));
        WebElement address=webDriver.findElement(By.id("address"));
        WebElement terms=webDriver.findElement(By.name("terms"));
        WebElement btn=webDriver.findElement(By.id("btn"));

        firstName.sendKeys("sanika");
        lastName.sendKeys("bhor");
        email.sendKeys("sanika@gmail.com");
        password.sendKeys("sanika");
        confirmPassword.sendKeys("sanika");
        genderFemale.click();;
        musicCheckbox.click();
        travelCheckbox.click();
        country.selectByValue("india");

        address.sendKeys("tambademala");
        terms.click();

        dob.clear();
        dob.sendKeys("04-27-2005");

      
        btn.click();

        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        WebElement message = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("msg")));

        try{
        Thread.sleep(2000);
        }
        catch(InterruptedException ie)
        {
            System.out.println(ie);
        }
        String successMsg="Registration Successful! Welcome "+ firstName.getAttribute("value") + " " + lastName.getAttribute("value");
        assertTrue(message.getText().contains(successMsg));
    
    }
}
