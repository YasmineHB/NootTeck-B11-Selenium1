package homework;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Exercise11 {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://demo.guru99.com/test/simple_context_menu.html");

		WebElement rightClick = driver.findElement(By.xpath("//span[text()='right click me']"));

		Actions action = new Actions(driver);

		action.contextClick(rightClick).build().perform();
		
		WebElement list = driver.findElement(By.xpath("//ul[@class='context-menu-list context-menu-root']"));
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOf(list));
		WebElement copy = driver.findElement(By.xpath("//li//span[text()='Copy']"));
		
		action.moveToElement(copy).click().build().perform();
		

		Alert alert = driver.switchTo().alert();

		String text = alert.getText();
		alert.accept();

		if (text.contains("copy")) {
			System.out.println("TESTCASE PASSED");
		} else {
			System.out.println("TESTCASE FAILED");
		}

		driver.quit();
	}

}
/**
<li class="context-menu-item context-menu-icon context-menu-icon-copy"><span>Copy</span></li>
*/