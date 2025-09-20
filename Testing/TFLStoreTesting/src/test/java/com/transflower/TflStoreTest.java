package com.transflower;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TflStoreTest {

    private static WebDriver driver;

    @BeforeAll
    static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://localhost:8000/index.html");
    }

    @Test
    void indexState() throws InterruptedException {
        WebElement gallery = driver.findElement(By.id("galleryLink"));
        gallery.click();

        Thread.sleep(2000); 

        String currentLink = driver.getCurrentUrl();
        assertTrue(currentLink.contains("catalog.html"));


        WebElement flower = driver.findElement(By.id("1"));
        flower.click();
        Thread.sleep(2000);
        currentLink = driver.getCurrentUrl();
        assertTrue(currentLink.contains("details.html"));


        WebElement addToCartButton = driver.findElement(By.id("click"));
        addToCartButton.click();
        Thread.sleep(2000);
        currentLink = driver.getCurrentUrl();
        assertTrue(currentLink.contains("cart.html"));

        
    }

    @AfterAll
    static void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
