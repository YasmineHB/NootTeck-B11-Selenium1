package com.noorteck.selenium.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.Hooks;

public class DemoRadio2 extends Hooks {

	public static void main(String[] args) throws InterruptedException {

		setUp();

		driver.get("https://www.letskodeit.com/practice");

		WebElement bmwRadio = driver.findElement(By.id("bmwradio"));
		WebElement benzRadio = driver.findElement(By.id("benzradio"));
		WebElement hondaRadio = driver.findElement(By.id("hondaradio"));

		bmwRadio.click();
		Thread.sleep(2000);

		benzRadio.click();
		Thread.sleep(2000);

		hondaRadio.click();
		Thread.sleep(2000);

		System.out.println("BMW:" + bmwRadio.isSelected());// false
		System.out.println("BENZ:" + benzRadio.isSelected());// false
		System.out.println("HONDA:" + hondaRadio.isSelected());// true

		benzRadio.click();

		System.out.println("BMW:" + bmwRadio.isSelected());// false
		System.out.println("BENZ:" + benzRadio.isSelected());// true
		System.out.println("HONDA:" + hondaRadio.isSelected());// false

		System.out.println("Show&Hide Text Field Example...");

		WebElement hideButton = driver.findElement(By.id("hide-textbox"));
		WebElement showButton = driver.findElement(By.id("show-textbox"));

		WebElement showHideTextField = driver.findElement(By.id("displayed-text"));

		System.out.println("Click the hide button");
		hideButton.click();// when we click hide button, the showHideTextFiels will not displayed

		System.out.println("Is TextField Displayed???: " + showHideTextField.isDisplayed());
		Thread.sleep(2000);

		System.out.println("Click the show button");
		showButton.click();// when we click show button, the showHideTextFiels will be displayed

		System.out.println("Is TextField Displayed???: " + showHideTextField.isDisplayed());
		Thread.sleep(2000);

		WebElement enableButton = driver.findElement(By.id("enabled-button"));
		WebElement disableButton = driver.findElement(By.id("disabled-button"));
		WebElement enableDisableTextField = driver.findElement(By.id("enabled-example-input"));

		System.out.println("Click on disabltButton");
		disableButton.click(); // when we click on disableButton, then we cannot interact with
								// enableDisableTextField

		System.out.println("Is TextField Enabled???: " + enableDisableTextField.isEnabled());

		System.out.println("*******************************");

		System.out.println("Click on enable button");
		enableButton.click();// // when we click on enableButton, then we can interact with
								// enableDisableTextField

		System.out.println("Is TextField Enabled???: " + enableDisableTextField.isEnabled());

		tearDown();
	}

}
