package com.noorteck.selenium.day2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.Hooks;

public class DemoPopUp extends Hooks {

	public static void main(String[] args) throws InterruptedException {
		setUp();

		driver.get("https://www.letskodeit.com/practice");

		WebElement alertBtn = driver.findElement(By.id("alertbtn"));
		WebElement confirmBtn = driver.findElement(By.id("confirmbtn"));

		alertBtn.click();
		Thread.sleep(2000);

		/**
		 * to handle alert/pipups
		 * 
		 * 1. we need to switch control from the browser to the alert using switchTo()
		 */

		Alert alertObj = driver.switchTo().alert();

		// retrieve the text
		String text = alertObj.getText();

		System.out.println(text);
		Thread.sleep(2000);

		alertObj.accept();

		System.out.println("**********************");

		confirmBtn.click();
		Alert confirmObj = driver.switchTo().alert();

		String text2 = confirmObj.getText();
		System.out.println("Text 2 : " + text2);

		// click cancel
		confirmObj.dismiss();

		String pageTitle = driver.getTitle();
		System.out.println("Page Title: " + pageTitle);

		tearDown();
	}

}
