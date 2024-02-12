package com.noorteck.selenium.day1;

import utils.Hooks;

public class Demo3 extends Hooks {

	public static void main(String[] args) {

		// call the setUp()

		setUp();

		driver.get("https://www.expedia.com/");

		// call the tearDown()
		tearDown();
	}

}
