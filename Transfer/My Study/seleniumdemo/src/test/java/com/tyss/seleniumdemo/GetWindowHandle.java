package com.tyss.seleniumdemo;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetWindowHandle {
	static {
		System.setProperty("webdriver.chrome.driver", "D:/My Study/seleniumdemo/src/main/resources/chromedriver.exe");
	}

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://mvnrepository.com/");
		Set<String> whs= driver.getWindowHandles();
		System.out.println("number of handles: " + whs.size());
		for (String string : whs) {
			System.out.println(string);
		}
	}

}
