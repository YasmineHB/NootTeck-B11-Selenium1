package com.noorteck.selenium.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.Hooks;

public class DemoLocator extends Hooks {

	public static void main(String[] args) throws InterruptedException {

		setUp();
		driver.get("https://www.amazon.com/");

		// ID locator
		WebElement searchField = driver.findElement(By.id("twotabsearchtextbox"));

		// sendKeys() --> enters a value into textFeild
		searchField.sendKeys("Selenium WebDriver");
		
		

		WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));

		searchButton.click();
		
		//Name Locator
		
		driver.get("https://ntkhr.noortecktraining.com/web/index.php/auth/login");
		Thread.sleep(2000);//use this whenever we want to see whats going on
		
		//locate the username then enter value
		WebElement usernameField = driver.findElement(By.name("username"));
		usernameField.sendKeys("ntk-admin");
		
		
		//locate the password then enter the value
		WebElement passwordField = driver.findElement(By.name("password"));
		passwordField.sendKeys("Ntk-orange!admin.123");
		
		//Xpath locator
		WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
		loginButton.click();
		
		//linktext
		driver.get("https://yahoo.com/");
		
		WebElement sportLink = driver.findElement(By.linkText("Sports"));
		sportLink.click();
		
		//partialLinkText
		driver.get("https://yahoo.com/");
		WebElement signLink = driver.findElement(By.partialLinkText("Sign"));
		signLink.click();
		
		//CSS Selector
		driver.get("https://google.com/");
		
		WebElement googleSearch = driver.findElement(By.cssSelector("#APjFqb"));
		
		googleSearch.sendKeys("Selenium is Fun...");
		
		tearDown();
	}

}
