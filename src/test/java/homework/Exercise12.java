package homework;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Exercise12 {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://demo.guru99.com/test/simple_context_menu.html");

		WebElement doubleClick = driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));

		Actions action = new Actions(driver);

		action.doubleClick(doubleClick).build().perform();
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();

		String text = alert.getText();
		System.out.println(text);

		if (text.contains("You double clicked")) {
			System.out.println("TESTCASE PASSED");
		} else {
			System.out.println("TESTCASE FAILED");
		}

		driver.quit();

	}
}
/**
 * <button ondblclick="myFunction()">Double-Click Me To See Alert</button>
 */