package com.noorteck.testnglecture;

import org.testng.Assert;

public class Recap5 {

	
	public static void main(String[] args) {
		// 4. check if price1 less price2, if true print less than otherwise not not
				// less
		
		double price1 = 22.2;
		double price2 = 34.4;
		
		Assert.assertTrue(price1 < price2);
		
		System.out.println("DONE...");
		
		//if it is true it will continue checking but 
		//if it is false it will give exception and stop checking
	}
}
