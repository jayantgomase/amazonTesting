package com.test;

//import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UtilMeth {

	public WebDriver LaunchBrowser(String url) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get(url);

		driver.manage().window().maximize();

		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		return driver;
	}

	public void selectCheckBox(WebDriver driver, By locator, String value) {
		List<WebElement> chkboxes = driver.findElements(locator);
		for (WebElement ch : chkboxes) {
			if (ch.getAttribute("value").equalsIgnoreCase(value)) {
				if (!ch.isSelected()) {
					ch.click();
					break;
				} else if (ch.isSelected()) {
					ch.click();
					break;
				}
			}
		}
	}

	public void selectRadio(WebDriver driver, By locator, String value) {
		List<WebElement> radios = driver.findElements(locator);
		for (WebElement ch : radios) {
			if (ch.getAttribute("value").equalsIgnoreCase(value)) {
				if (!ch.isSelected()) {
					ch.click();
					break;
				} else if (ch.isSelected()) {
					ch.click();
					break;
				}
			}
		}
	}

	public void selectDDByValue(WebDriver driver, By locator, String value) {
		WebElement dd = driver.findElement(locator);
		Select dditems = new Select(dd);
		List<WebElement> options = dditems.getOptions();
		for (WebElement op : options) {
			if (op.getAttribute("value").equalsIgnoreCase(value)) {
				dditems.selectByVisibleText(value);
				break;
			}
		}
	}

	public void selectDDByText(WebDriver driver, By locator, String text) {
		WebElement dd = driver.findElement(locator);
		Select dditems = new Select(dd);
		List<WebElement> options = dditems.getOptions();
		for (WebElement op : options) {
			if (op.getText().equalsIgnoreCase(text)) {
				dditems.selectByVisibleText(text);
				break;
			}
		}
	}

//	public void verifyCellData(WebDriver driver, By locator, int rownum, int colnum, String text) {
//		WebElement table = driver.findElement(locator);
//		WebElement cell = table.findElement(By.xpath("//tr[" + rownum + "]/td[" + colnum + "]"));
//		assertEquals(text, cell.getText());
//	}
//
//	public void verifyRowData(WebDriver driver, By locator, int rownum, String text) {
//		WebElement table = driver.findElement(locator);
//		WebElement row = table.findElement(By.xpath("//tr[" + rownum + "]"));
//		assertTrue(row.getText().contains(text));
//	}
}
