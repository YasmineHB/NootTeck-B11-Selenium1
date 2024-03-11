package homework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.Hooks;

public class Exercise4 {

	public static void main(String[] args) throws InterruptedException {

		// 19. Launch chrome browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// 20. Navigate to https://www.dummyticket.com/
		driver.get("https://www.dummyticket.com/");
		Thread.sleep(2000);

		// 21. Click BUY TICKET link
		driver.findElement(By.linkText("Buy Ticket")).click();

		Thread.sleep(2000);

		// 22. Verify the page title is Dummy ticket for applying visa - Verifiable
		// flight reservation for embassy
		String title = driver.getTitle();

		if (title.equals("Dummy ticket for applying visa - Verifiable flight reservation for embassy")) {
			System.out.println("Title: " + title);
		} else {
			System.out.println("TITLE IS NOT RIGHT");
		}
		// 23. Select Dummy ticket and hotel – USD $35.00
		driver.findElement(By.id("product_3186")).click();
		Thread.sleep(3000);

		// 24. Verify the message displayed under Choose the Correct option contains:
		// Dummy ticket and hotel
		String text = driver.findElement(By.xpath("//div[@class='woocommerce-message']")).getText();

		System.out.println(text);

		Thread.sleep(1000);
		// 25. For Passenger Detail Section
		driver.findElement(By.id("travname")).sendKeys("John");
		driver.findElement(By.id("travlastname")).sendKeys("Cena");
		driver.findElement(By.id("dob")).click();
		WebElement month = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
		Select monthObj = new Select(month);
		monthObj.selectByVisibleText("Sep");
		Thread.sleep(2000);
		WebElement year = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		Select yearObj = new Select(year);
		yearObj.selectByVisibleText("1970");
		Thread.sleep(2000);
		driver.findElement(By.linkText("9")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("sex_1")).click();

		// 26. For Travel Details Section
		driver.findElement(By.id("traveltype_2")).click();
		driver.findElement(By.id("fromcity")).sendKeys("Maryland");
		driver.findElement(By.id("tocity")).sendKeys("California");
		driver.findElement(By.id("departon")).click();
		Thread.sleep(2000);
		WebElement travelMonth = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
		Select travelMonthObj = new Select(travelMonth);
		travelMonthObj.selectByVisibleText("Mar");
		WebElement travelYear = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		Select travelYearObj = new Select(travelYear);
		travelYearObj.selectByVisibleText("2024");
		driver.findElement(By.cssSelector("a[data-date='20']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("returndate")).click();
		Thread.sleep(2000);
		WebElement returnMonth = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
		Select returnMonthObj = new Select(returnMonth);
		returnMonthObj.selectByVisibleText("Aug");
		WebElement returnYear = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		Select returnYearObj = new Select(returnYear);
		returnYearObj.selectByVisibleText("2024");
		driver.findElement(By.cssSelector("a[data-date='25']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("notes")).sendKeys("N/A");

		// 27. For Delivery Option Section
		WebElement purpose = driver.findElement(By.id("reasondummy"));
		Select purposeObj = new Select(purpose);
		purposeObj.selectByVisibleText("Prank a friend");
		Thread.sleep(2000);
		driver.findElement(By.id("deliverymethod_1")).click();

		// 28. For Billing Details Section
		driver.findElement(By.id("billname")).sendKeys("John Cena");
		driver.findElement(By.id("billing_phone")).sendKeys("1234567890");
		driver.findElement(By.id("billing_email")).sendKeys("jc@jc.com");
		WebElement billingCountry = driver.findElement(By.id("billing_country"));
		Select billingCountryObj = new Select(billingCountry);
		// billingCountryObj.selectByVisibleText("Costa Rica");
		billingCountryObj.selectByVisibleText("United States (US)");
		Thread.sleep(2000);
		driver.findElement(By.id("billing_address_1")).sendKeys("123 way drive");
		driver.findElement(By.id("billing_address_2")).sendKeys("Apt 303");
		driver.findElement(By.id("billing_city")).sendKeys("Reston");
		WebElement billingState = driver.findElement(By.id("billing_state"));
		Select billingStateObj = new Select(billingState);
		billingStateObj.selectByVisibleText("Virginia");
		Thread.sleep(2000);
		driver.findElement(By.id("billing_postcode")).sendKeys("12345");
		Thread.sleep(2000);

		// 29. Click Proceed to Paypal
		driver.findElement(By.id("place_order")).click();
		Thread.sleep(2000);

		// 30. Click Cancel and return to KTINI
		driver.findElement(By.id("cancelLink")).click();
		Thread.sleep(2000);

		// 31. Verify the page title is Basket - Dummy ticket
		String title2 = driver.getTitle();
		System.out.println(title2);
		if (title2.equals("Basket - Dummy ticket")) {
			System.out.println("YES");
		} else {
			System.out.println("Title is not Basket - Dummy ticket");
		}
		String cancelText = driver.findElement(By.xpath("//section//div[@class='woocommerce-info']")).getText();
		System.out.println(cancelText);
		if (cancelText.equals("Your order was cancelled.")) {
			System.out.println("TESTCASE PASSED");
		} else {
			System.out.println("TESTCASE FAILED");
		}

		driver.quit();
	}

}
