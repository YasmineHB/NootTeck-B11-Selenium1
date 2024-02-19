package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Exercise8 {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.automationtesting.in/Frames.html");

		String mainWebID = driver.getWindowHandle();

		System.out.println("web ID: " + mainWebID);

		Thread.sleep(2000);

		WebElement frame1 = driver.findElement(By.id("singleframe"));

		driver.switchTo().frame(frame1);

		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Accessing Iframe");

		Thread.sleep(2000);

		driver.switchTo().window(mainWebID);

		driver.findElement(By.linkText("Iframe with in an Iframe")).click();
		Thread.sleep(2000);

		WebElement frame2 = driver.findElement(By.xpath("//iframe[@style='float: left;height: 300px;width:600px']"));

		driver.switchTo().frame(frame2);// switching to the first iframe

		WebElement frame3 = driver.findElement(By.xpath("//iframe[@style='float: left;height: 250px;width: 400px']"));

		driver.switchTo().frame(frame3);// switching to second iframe inside the other iframe

		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Iframe is easy");

		driver.switchTo().window(mainWebID);

		driver.findElement(By.linkText("Home")).click();

		String title = driver.getTitle();
		System.out.println(title);

		if (title.equals("Index")) {
			System.out.println("TESTCASE PASSED");
		} else {
			System.out.println("TESTCASE FAILED");
		}

		Thread.sleep(2000);

		driver.quit();
	}

}
