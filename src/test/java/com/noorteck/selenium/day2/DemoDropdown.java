package com.noorteck.selenium.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utils.Hooks;

public class DemoDropdown extends Hooks {

	public static void main(String[] args) throws InterruptedException {
		setUp();

		driver.get("https://www.letskodeit.com/practice");

		WebElement carDropdown = driver.findElement(By.id("carselect"));

		// create an object of select class
		Select selectObj = new Select(carDropdown);

		// selectByIndex

		selectObj.selectByIndex(1);// Benz
		Thread.sleep(2000);

		selectObj.selectByIndex(0);// BMW
		Thread.sleep(2000);

		selectObj.selectByIndex(2);// Honda
		Thread.sleep(2000);

		System.out.println("******************");

		// selectByVisbleText

		selectObj.selectByVisibleText("BMW");
		Thread.sleep(2000);

		selectObj.selectByVisibleText("Honda");
		Thread.sleep(2000);

		selectObj.selectByVisibleText("Benz");
		Thread.sleep(2000);

		// selectByValue

		selectObj.selectByValue("bmw");
		Thread.sleep(2000);

		selectObj.selectByValue("honda");
		Thread.sleep(2000);

		selectObj.selectByValue("benz");
		Thread.sleep(2000);

		tearDown();
	}

}
