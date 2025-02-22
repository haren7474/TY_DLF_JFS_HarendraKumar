package com.tyss.seleniumdemo;

import java.awt.Desktop.Action;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Slider {
	static {
		System.setProperty("webdriver.chrome.driver", "D:/My Study/seleniumdemo/src/main/resources/chromedriver.exe");
	}

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/");

		driver.findElement(By.xpath("//a[text()='Slider']")).click();
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		WebElement slider = driver
				.findElement(By.className("ui-slider-handle ui-corner-all ui-state-default"));
		System.out.println(slider);
		Actions action= new Actions(driver);
		action.moveToElement(driver.findElement(By.tagName("style")));

	}
}
