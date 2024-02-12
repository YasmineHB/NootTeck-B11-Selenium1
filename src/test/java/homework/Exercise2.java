package homework;

import org.openqa.selenium.WebDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Exercise2 {

	public static void main(String[] args) throws InterruptedException {
		// 1. Launch chrome browser
		WebDriverManager.firefoxdriver().setup();

		WebDriver driver = new FirefoxDriver();

		driver.manage().window().maximize();

		// 2. Navigate to https://demo.guru99.com/test/newtours/
		driver.get("https://demo.guru99.com/test/newtours/");

		// 3. Click REGISTER link
		WebElement register = driver.findElement(By.linkText("REGISTER"));
		register.click();

		// 4. Verify the page title is Mercury Tours
		String text = driver.getTitle();

		if (text.equals("Mercury Tours")) {
			System.out.println(text);
		} else {
			System.out.println("page title is not Mercury Tours - it is " + text);
		}

		System.out.println(driver.getTitle());

		// 5. Enter first name
		WebElement fname = driver.findElement(By.name("firstName"));
		fname.sendKeys("John");

		// 6. Enter last name
		WebElement lname = driver.findElement(By.name("lastName"));
		lname.sendKeys("Cena");

		// 7. Enter phone number
		WebElement phone = driver.findElement(By.name("phone"));
		phone.sendKeys("1234567890");

		Thread.sleep(1000);

		// 8. Enter email ***** I think there is a mistake username intead of email
		WebElement email = driver.findElement(By.name("userName"));
		email.sendKeys("abcd@abcd.com");

		// 9. Enter address
		WebElement address = driver.findElement(By.name("address1"));
		address.sendKeys("123 bells");

		// 10. Enter city
		WebElement city = driver.findElement(By.name("city"));
		city.sendKeys("Reston");

		// 11. Enter state
		WebElement state = driver.findElement(By.name("state"));
		state.sendKeys("VA");

		Thread.sleep(1000);

		// 12. Enter zip code
		WebElement zip = driver.findElement(By.name("postalCode"));
		zip.sendKeys("20854");

		WebElement country = driver.findElement(By.name("country"));
		Select obj = new Select(country);

		List<WebElement> list = obj.getOptions();

		for (WebElement con : list) {
			String str = con.getText();

			if (str.equals("UNITED STATES")) {
				con.click();
			}
		}
		Thread.sleep(1000);

		// 13. Enter username *** and here we have email instead of username
		WebElement username = driver.findElement(By.name("email"));
		username.sendKeys("John");

		// 14. Enter password
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("123456");

		// 15. Re-Enter password in confirm password field
		WebElement confirmpass = driver.findElement(By.name("confirmPassword"));
		confirmpass.sendKeys("123456");

		Thread.sleep(5000);

		// 16. Click Submit
		WebElement submit = driver.findElement(By.name("submit"));
		submit.click();

		// 17. Retrieve the confirmation text message and check if the confirmation text
		// message contains
		// following phrase: Thank you for registering.
		WebElement text1 = driver.findElement(By.cssSelector(
				"body > div:nth-child(5) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(4) > td:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(3) > td:nth-child(1) > p:nth-child(2) > font:nth-child(1)"));
		String str = text1.getText();

		if (str.contains("Thank you for registering.")) {
			// a. If it does then print TESTCASE PASSED
			System.out.println("TESTCASE PASSED");
		} else {
			// b. Otherwise print TESTCASE FAILED
			System.out.println("TESTCASE FAILED");
		}

		// 18. Close the browser
		Thread.sleep(5000);
		driver.quit();

	}

}

/**

Scenario: Register new user in Mercury Tours Page
1. Launch chrome browser
2. Navigate to https://demo.guru99.com/test/newtours/
3. Click REGISTER link
4. Verify the page title is Mercury Tours
5. Enter first name
6. Enter last name
7. Enter phone number
8. Enter email
9. Enter address
10. Enter city
11. Enter state
12. Enter zip code
13. Enter username
14. Enter password
15. Re-Enter password in confirm password field
16. Click Submit
17. Retrieve the confirmation text message and check if the confirmation text message contains
following phrase: Thank you for registering.
a. If it does then print TESTCASE PASSED
b. Otherwise print TESTCASE FAILED
18. Close the browser


*/