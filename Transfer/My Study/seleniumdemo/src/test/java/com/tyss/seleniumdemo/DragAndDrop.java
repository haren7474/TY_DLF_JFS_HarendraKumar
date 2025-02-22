package com.tyss.seleniumdemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {
	static {
		System.setProperty("webdriver.chrome.driver", "D:/My Study/seleniumdemo/src/main/resources/chromedriver.exe");
	}

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/");
		
		//Drag and drop
		driver.findElement(By.xpath("//a[text()='Droppable']")).click();
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		Actions action = new Actions(driver);
		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement drop = driver.findElement(By.id("droppable"));
		action.dragAndDrop(drag, drop).perform();

		// Clicking on select item
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//a[text()='Selectable']")).click();
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		WebElement target = driver.findElement(By.xpath("//li[text()='Item 4']"));
		action.click(target).build().perform();

		// Slider
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//a[text()='Slider']")).click();
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		WebElement slider = driver.findElement(By.className("ui-slider-handle ui-corner-all ui-state-default ui-state-hover"));
		System.out.println(slider);
		//action.moveToElement(driver.findElement(By.tagName("style")));

	}
}
