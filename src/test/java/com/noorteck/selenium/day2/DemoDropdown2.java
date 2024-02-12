package com.noorteck.selenium.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utils.Hooks;

public class DemoDropdown2 extends Hooks {

	public static void main(String[] args) throws InterruptedException {

		setUp();

		driver.get("https://demo.guru99.com/test/newtours/register.php");

		WebElement countryDropdown = driver.findElement(By.name("country"));

		Select selectObj = new Select(countryDropdown);

		// retrieve all the options from the country dropdown
		List<WebElement> countryList = selectObj.getOptions();

		// we have to loop
		for (WebElement country : countryList) {

//			country.click();
//			Thread.sleep(1000);
//		}
			/**
			 * checl if the value is SPAIN then select spain Step1: retrieve the text Step2:
			 * check if the text equals to spain Step3: if equals then click Step4: break
			 * out from the loop
			 */

			String countryStr = country.getText();
			System.out.println(countryStr);
			if (countryStr.equals("SPAIN")) {
				country.click();
				break;
			}
		}

		tearDown();

	}

}
