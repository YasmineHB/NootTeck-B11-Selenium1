package com.noorteck.testnglecture;

public class Recap2 {

	public static void main(String[] args) {

		int a = 10;
		int b = 20;
		// check if a equals to b, if true print equals otherwise not equals
		if (a == b) {
			System.out.println(a + " = " + b);
		} else {
			System.out.println(a + " not equals " + b);
		}

		String s1 = "Java";
		String s2 = "SQL";
		// check if s1 equals to s2, if true print equals otherwise not equals
		if (s1.equals(s2) == true) {
			System.out.println(s1 + " Equals " + s2);
		} else {
			System.out.println(s1 + " NOT Equals " + s2);
		}

		char option1 = 'A';
		char option2 = 'C';
		// check if option1 equals to option2, if true print equals otherwise not equals
		if (option1 == option2) {
			System.out.println(option1 + " Equals " + option2);
		} else {
			System.out.println(option1 + " NOT Equals " + option2);
		}

		double price1 = 22.2;
		double price2 = 34.4;
		// check if price less than price2, if true print less otherwise not less
		if (price1 < price2) {
			System.out.println(price1 + " < " + price2);
		} else {
			System.out.println(price1 + " > " + price2);
		}

	}

}
