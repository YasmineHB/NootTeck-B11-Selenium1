package com.noorteck.testnglecture;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class GroupingTest {

	@BeforeClass
	public void beforeClass() {
		System.out.println("beforeClass");
	}

	@Test(groups = { "Car", "Japan" })
	public void honda() {
		System.out.println("honda");
	}

	@Test(groups = { "Car", "USA" })
	public void tesla() {
		System.out.println("tesla");
	}

	@Test(groups = { "Car", "Germany" })
	public void benz() {
		System.out.println("benz");
	}

	@Test(groups = { "Sport", "Europe" })
	public void soccer() {
		System.out.println("soccer");
	}

	@Test(groups = { "Sport", "USA" })
	public void football() {
		System.out.println("football");
	}

	@Test(groups = { "Sport", "USA", "Spain", "Brazil" })
	public void basketball() {
		System.out.println("basketball");
	}

	@Test(groups = { "Food" })
	public void taco() {
		System.out.println("taco");
	}

	@Test(groups = { "Food" })
	public void rice() {
		System.out.println("rice");
	}

	@Test
	public void sandwich() {
		System.out.println("sandwich");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("afterClass");
	}

}
