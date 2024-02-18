package homework;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Exercise7 {

	public static void main(String[] args) throws Exception {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-\r\n" + "summary.html");

		Thread.sleep(2000);

		driver.findElement(By.linkText("org.openqa.selenium")).click();

		Thread.sleep(2000);

		driver.findElement(By.linkText("Alert")).click();

		Thread.sleep(2000);

		String str = driver.findElement(By.xpath("//h1[@title='Interface Alert']")).getText();
		System.out.println(str);

		if (str.equals("Interface Alert")) {
			Assert.assertTrue(true);
			System.out.println("TESTCASE PASSED");
		} else {
			throw new Exception();
		}

		Thread.sleep(2000);

		driver.findElement(By.xpath("//a[@href='../../../index.html']")).click();

		driver.findElement(By.linkText("org.openqa.selenium.chrome")).click();

		driver.findElement(By.linkText("ChromeDriver")).click();

		String str2 = driver.findElement(By.xpath("//h1[@title='Class ChromeDriver']")).getText();

		if (str2.equals("Class ChromeDriver")) {
			System.out.println("TESTCASE PASSED");
		} else {
			System.out.println("TESTCASE FAILED");
		}

		Thread.sleep(2000);
		driver.quit();

	}

}
