package com.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonSearchTest {
    
    UtilMeth utm = new UtilMeth();

	WebDriver driver = utm.LaunchBrowser("https://www.amazon.in/");

    @Test
    public void amazonSearchTest() {
        // Navigate to Amazon.in
        driver.get("https://www.amazon.in");

        // Enter a product in the search bar
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Laptop");

        // Click on the search button
        WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
        searchButton.click();

        // Verify the title of the result page
        String pageTitle = driver.getTitle();
        Assertions.assertTrue(pageTitle.contains("Laptop"), "Title does not contain the expected keyword");
    }

//    @After
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
