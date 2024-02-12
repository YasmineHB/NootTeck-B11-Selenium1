package homework;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.Hooks;

public class Exercise6 extends Hooks {

	public static void main(String[] args) throws InterruptedException {

		// 1. Launch chrome browser

		// WebDriverManager.chromedriver().setup();
		// WebDriver driver = new ChromeDriver();
		// driver.manage().window().maximize();

		// have a problem with chrome version because it says only supports 114 not 121

		setUp();

		// 2. Navigate to https://demo.automationtesting.in/Alerts.html
		driver.get("https://demo.automationtesting.in/Alerts.html");

		// 3. Verify the page title is Alerts
		String str = driver.getTitle();
		System.out.println(str);

		// 4. Click Alert with Textbox
		WebElement alertbox = driver.findElement(By.linkText("Alert with Textbox"));
		alertbox.click();
		Thread.sleep(2000);

		// a. Click Click the button to demonstrate the prompt box button
		WebElement promptbox = driver.findElement(By.cssSelector(".btn-info"));
		promptbox.click();

		// b. Enter your name in the Alert Text field.
		Alert alertObj = driver.switchTo().alert();
		String text = alertObj.getText();
		System.out.println(text);
		Thread.sleep(5000);

		// c. Click Ok button
		alertObj.accept();

		// d. Verify the message displayed under Click the button to demonstrate the
		// prompt box
		// button contains following phrase: How are you today
		WebElement underclicktext = driver.findElement(By.id("demo1"));
		System.out.println(underclicktext.getText());

		// 5. Refresh the page.
		driver.get("https://demo.automationtesting.in/Alerts.html");

		// 6. Click Alert with OK & Cancel
		/**can't copy the name of the link because it comes out like "Alert with OK &amp; Cancel",
		 so I used css selectoror I need to type it "Alert with OK & Cancel"*/
		alertbox = driver.findElement(By.cssSelector("ul.nav-tabs > li:nth-child(2) > a:nth-child(1)"));
		alertbox.click();

		// a. Click Click the button to display a confirm box button
		promptbox = driver.findElement(By.cssSelector(".btn-primary"));
		promptbox.click();

		// b. Enter your name in the Alert Text field. *****has no such feild

		// c. Verify the text in alert contains Press a Button !
		Alert textObj2 = driver.switchTo().alert();
		String text2 = textObj2.getText();
		System.out.println(text2);

		if (text2.contains("Press a Button !")) {
			// i. If true, then click Cancel
			textObj2.dismiss();
		} else {
			// ii. If false, then click OK
			textObj2.accept();
		}
		// d. Verify the message displayed under Click the button to display a confirm
		// box button
		// contains following phrase: You Pressed
		underclicktext = driver.findElement(By.id("demo"));
		String text3 = underclicktext.getText();
		System.out.println(text3);
		if (text3.contains("You Pressed")) {
			System.out.println("True");
		} else {
			System.out.println("False");
		}

		// 7. Close the browser.

		Thread.sleep(5000);
		tearDown();

	}

}
/**
Scenario: Handling Alert
1. Launch chrome browser
2. Navigate to https://demo.automationtesting.in/Alerts.html
3. Verify the page title is Alerts
4. Click Alert with Textbox
a. Click Click the button to demonstrate the prompt box button
b. Enter your name in the Alert Text field.
c. Click Ok button
d. Verify the message displayed under Click the button to demonstrate the prompt box
button contains following phrase: How are you today

5. Refresh the page.
6. Click Alert with OK & Cancel
a. Click Click the button to display a confirm box button
b. Enter your name in the Alert Text field.
c. Verify the text in alert contains Press a Button !
i. If true, then click Cancel
ii. If false, then click OK
d. Verify the message displayed under Click the button to display a confirm box button
contains following phrase: You Pressed

7. Close the browser.
*/