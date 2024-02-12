package com.noorteck.testnglecture;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Recap4 {

	public static void main(String[] args) {
		//Hard Assert testNG
		int a = 10;
		int b = 20;
		
		// 1. check if a equals b, if true print equals otherwise not equals
		Assert.assertEquals(a, b);

		String s1 = "Java";
		String s2 = "SQL";
		
		// 2. check if s1 equals s2, if true print equals otherwise not equals
		Assert.assertEquals(s1, s2);

		char option1 = 'A';
		char option2 = 'C';
		
		// 3. check if option1 equals option2, if true print equals otherwise not equals
		Assert.assertEquals(option1, option2);

		double price1 = 22.2;
		double price2 = 34.4;
		
		// 4. check if price1 less price2, if true print less than otherwise not not
		// less
		Assert.assertEquals(price1, price2);
		
		
	}
}
