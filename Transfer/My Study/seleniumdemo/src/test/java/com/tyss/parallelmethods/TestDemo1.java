package com.tyss.parallelmethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestDemo1 {
	static {
		System.setProperty("webdriver.chrome.driver", "D:/My Study/seleniumdemo/src/main/resources/chromedriver.exe");
	}
	
	@Test
	public static void demoFacebook() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://facebook.com");
		Reporter.log("from TestNgAnnonation: ", true);
	}
	
	@Test
	public static void demoGoogle() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://google.com");
		Reporter.log("from TestNgAnnonation: ", true);
	}
	
	@Test
	public static void demoGmail() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://mail.google.com/mail/u/0/");
		Reporter.log("from TestNgAnnonation: ", true);
	}
}
