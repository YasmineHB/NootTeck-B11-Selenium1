package com.noorteck.selenium.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utils.Hooks;

public class DemoDropdown4 extends Hooks {

	public static void main(String[] args) throws InterruptedException {

		setUp();

		driver.get("https://www.letskodeit.com/practice");

		WebElement multiDropdown = driver.findElement(By.id("multiple-select-example"));

		Select selectObj = new Select(multiDropdown);

		System.out.println("Can we select multiple values: " + selectObj.isMultiple());

		selectObj.selectByVisibleText("Apple");
		Thread.sleep(2000);

		selectObj.selectByVisibleText("Peach");
		Thread.sleep(2000);

		selectObj.selectByVisibleText("Orange");
		Thread.sleep(2000);

		// Deselect

		selectObj.deselectByIndex(0);
		Thread.sleep(2000);

		selectObj.deselectByIndex(2);
		Thread.sleep(2000);

		selectObj.deselectByIndex(1);
		Thread.sleep(2000);

		tearDown();

	}

}
