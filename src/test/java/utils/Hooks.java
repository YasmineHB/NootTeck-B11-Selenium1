package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks {

	public static WebDriver driver;

	public static void setUp() {
		WebDriverManager.firefoxdriver().setup(); // for WINDOWS
		driver = new FirefoxDriver();

		// maximize the window in full screen
		driver.manage().window().maximize();
	}

	public static void tearDown() {

		try {
			Thread.sleep(3000);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.quit();
	}

}
