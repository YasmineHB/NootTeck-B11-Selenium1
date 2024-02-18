package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import utils.Hooks;

public class Exercise1 extends Hooks {

	public static void main(String[] args) throws Exception {

		// 1. Launch chrome browser
		setUp();

		// 2. Navigate to https://ntkhr.noortecktraining.com/web/index.php/auth/login
		driver.get("https://ntkhr.noortecktraining.com/web/index.php/auth/login");

		// 3. Enter ntk-admin in the username field
		WebElement username = driver.findElement(By.name("username"));
		username.sendKeys("ntk-admin");

		// 4. Enter Ntk-orange!admin.123 in the password field
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("Ntk-orange!admin.123");

		// 5. Click Login Button
		WebElement login = driver.findElement(By.cssSelector(
				"#app > div.orangehrm-login-layout > div > div.orangehrm-login-container > div > div.orangehrm-login-slot > div.orangehrm-login-form > form > div.oxd-form-actions.orangehrm-login-action > button"));
		login.click();
		Thread.sleep(2000);

		// 6. Retrieve the Header Text and Verify the header is Dashboard
		System.out.println(driver.getTitle());

		WebElement header = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6"));

		String head = header.getText();

		if (head.equals("Dashboard")) {
			System.out.println("Header name = " + head);
		} else {
			System.out.println("Header name is not Dashboard");
		}

		Assert.assertTrue(head.contains("Dashboard"));

		if (head.contains("Dashboard")) {
			throw new Exception("Message not valid");
		}

		// 7. Close the browser
		tearDown();

	}
}
/**
 * Scenario: Login to OrangeHRM application 1. Launch chrome browser 2. Navigate
 * to https://ntkhr.noortecktraining.com/web/index.php/auth/login 3. Enter
 * ntk-admin in the username field 4. Enter Ntk-orange!admin.123 in the password
 * field 5. Click Login Button 6. Retrieve the Header Text and Verify the header
 * is Dashboard 7. Close the browser
 */