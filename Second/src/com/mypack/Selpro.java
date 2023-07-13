package com.mypack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selpro {

	public static void main(String[] args) {

		System.setProperty("Webdriver.chrome.driver",
				"D:\\Workarea\\Software\\Chrome drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://adyty-trials79.orangehrmlive.com");
		driver.manage().window().maximize();
		WebElement e1 = driver.findElement(By.id("txtUsername"));
		e1.sendKeys("Admin");
		// txtUsername
		WebElement e2 = driver.findElement(By.id("txtPassword"));
		e2.sendKeys("2XbKKa@n5M");
		WebElement e3 = driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/div/form/div[4]/button"));
		e3.click();

	}

}
