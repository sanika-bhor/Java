package com.tap.example.RestAPITesting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProductUITest {
    WebDriver driver;

    @BeforeClass
    public void setup()
    {
        // WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
    }
    

    @Test
    public void testProductCatalogPage()
    {
        driver.get("http://localhost:9090/index.html");
      
        List<WebElement> products=driver.findElements(By.tagName("li"));
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println(e);
        }
        // WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(5));
      
        Assert.assertTrue(products.size()>0,"product should be listed");
    }

    @AfterClass
    public void teardown()
    {
         driver.quit();
    }
}
