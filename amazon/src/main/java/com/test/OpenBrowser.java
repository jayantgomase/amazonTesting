package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenBrowser {

	public static void main(String[] args) {
		// launchChrome();
		locateById();
	}

	public static void launchChrome() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");

		driver.manage().window().maximize();

		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());

		driver.close();

	}

	@SuppressWarnings("deprecation")
	public static void locateById() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");

		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("lacoste");

		searchBox.sendKeys(Keys.ENTER);

		// Locate the link by partial text
		WebElement shoppingLink = driver.findElement(By.partialLinkText("Shopping"));
		shoppingLink.click();
		WebElement mapsLink = driver.findElement(By.partialLinkText("Maps"));
		mapsLink.click();

		driver.navigate().back();
		WebElement imagesLink = driver.findElement(By.partialLinkText("Images"));
		imagesLink.click();

//		WebElement searchButton = driver.findElement(By.name("btnK"));
//		searchButton.click();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.close();
	}
}
