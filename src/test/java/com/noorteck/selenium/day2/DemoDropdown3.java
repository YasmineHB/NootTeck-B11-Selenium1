package com.noorteck.selenium.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utils.Hooks;

public class DemoDropdown3 extends Hooks {

	public static void main(String[] args) {

		setUp();
		driver.get("https://www.ebay.com/");

		WebElement ebaycat = driver.findElement(By.id("gh-cat"));

		Select obj = new Select(ebaycat);

		List<WebElement> list = obj.getOptions();

		for (WebElement cat : list) {

			String str = cat.getText();

			if (str.contains("&")) {
				System.out.println(str);
				cat.click();
			}

		}

		tearDown();
	}

}
