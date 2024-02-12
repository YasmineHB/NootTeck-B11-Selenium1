package homework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Exercise3 {

	public static void main(String[] args) throws InterruptedException {

		// 8. Launch chrome browser **** have different version so i'm working with
		// firefox
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();

		driver.manage().window().maximize();

		// 9. Navigate to https://demo.nopcommerce.com/
		driver.get("https://demo.nopcommerce.com/");

		// 10. Click Register Link
		WebElement register = driver.findElement(By.linkText("Register"));
		register.click();

		// 11. Verify the page title is nopCommerce demo store. Register
		String str = driver.getTitle();

		if (str.equals("nopCommerce demo store. Register")) {
			// a. Gender
			WebElement gender = driver.findElement(By.id("gender-female"));
			gender.click();

			// b. First name
			WebElement fname = driver.findElement(By.id("FirstName"));
			fname.sendKeys("John");

			// c. Last name
			WebElement lname = driver.findElement(By.id("LastName"));
			lname.sendKeys("Cena");
			// d. Date of birth
			WebElement day = driver.findElement(By.name("DateOfBirthDay"));
			Select obj1 = new Select(day);

			List<WebElement> list1 = obj1.getOptions();

			for (WebElement dd : list1) {
				String str1 = dd.getText();

				if (str1.equals("12")) {
					dd.click();
				}
			}
			WebElement month = driver.findElement(By.name("DateOfBirthMonth"));
			Select obj2 = new Select(month);

			List<WebElement> list2 = obj2.getOptions();

			for (WebElement mon : list2) {
				String str2 = mon.getText();

				if (str2.equals("12")) {
					mon.click();
				}
			}

			WebElement year = driver.findElement(By.name("DateOfBirthYear"));
			Select obj3 = new Select(year);

			List<WebElement> list3 = obj3.getOptions();

			for (WebElement yr : list3) {
				String str3 = yr.getText();

				if (str3.equals("2012")) {
					yr.click();
				}
			}
			Thread.sleep(2000);
			// e. Email
			WebElement email = driver.findElement(By.id("Email"));
			email.sendKeys("abc@abc.com");

			// 13. Enter Company name
			WebElement compname = driver.findElement(By.id("Company"));
			compname.sendKeys("abcd");

			// 14. Uncheck Newsletter checkbox
			WebElement check = driver.findElement(By.id("Newsletter"));
			check.click();

			// 15. Enter password
			WebElement password = driver.findElement(By.id("Password"));
			password.sendKeys("123456");

			// 16. Confirm password
			WebElement confirmpassword = driver.findElement(By.id("ConfirmPassword"));
			confirmpassword.sendKeys("123456");

			Thread.sleep(3000);
			// 17. Click register button
			WebElement registerbtn = driver.findElement(By.id("register-button"));
			registerbtn.click();

			Thread.sleep(3000);
			// 18. Retrieve the confirmation text message and check if the confirmation text
			// message equals to
			// Your registration completed!!!
			WebElement msg = driver.findElement(By.cssSelector(".result"));

			String msgstr = msg.getText();

			if (msgstr.equals("Your registration completed!!!")) {
				System.out.println("TESTCASE PASSED");
			} else {
				System.out.println("TESTCASE FAILED because msg = " + msgstr);
			}

		} else {
			System.out.println("Title is not nopCommerce demo store. Register");
			driver.quit();
		}
		Thread.sleep(3000);
		driver.quit();
	}
}

/**
Scenario: Register new user
8. Launch chrome browser
9. Navigate to https://demo.nopcommerce.com/
10. Click Register Link
11. Verify the page title is nopCommerce demo store. Register
12. Fill out Your Personal Details Section
a. Gender
b. First name
c. Last name
d. Date of birth
e. Email
13. Enter Company name
14. Uncheck Newsletter checkbox
15. Enter password
16. Enter Username
17. Click register button
18. Retrieve the confirmation text message and check if the confirmation text message equals to
Your registration completed!!!
a. If it does then print TESTCASE PASSED
b. Otherwise print TESTCASE FAILED

*/