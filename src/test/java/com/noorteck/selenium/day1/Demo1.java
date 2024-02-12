package com.noorteck.selenium.day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Demo1 {
	public static void main(String[] args) throws InterruptedException {

		// Step1. we need to call setProperty() from System and pass 2 param

		System.setProperty("webdriver.gecko.driver", "C:\\Users\\aaldu\\Desktop\\selenium_b11\\geckodriver.exe");

		// Step2. Create an object of webDriver

		WebDriver driver = new FirefoxDriver();

		// now we can navigate to the URL

		driver.get("https://www.expedia.com/");

		Thread.sleep(5000);
		driver.quit();
	}

}
