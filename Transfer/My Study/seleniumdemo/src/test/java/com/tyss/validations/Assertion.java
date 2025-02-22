package com.tyss.validations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertion {
	static {
		System.setProperty("webdriver.chrome.driver", "D:/My Study/seleniumdemo/src/main/resources/chromedriver.exe");
	}
	
	@Test
	public void test1() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.actitime.com/login.do");
		String actualTitle = driver.getTitle();
		String expectedTitle = "actiTIME - Login";
		Assert.assertEquals(actualTitle, expectedTitle);
		driver.close();
	}

	@Test
	public void test2() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.actitime.com/login.do");
		String actualTitle = driver.getTitle();
		String expectedTitle = "actiTIME - Login";
		
		//Softassert closes the browser as well
		SoftAssert s = new SoftAssert();
		s.assertEquals(actualTitle, expectedTitle);
		driver.close();
		s.assertAll();
	}

}
