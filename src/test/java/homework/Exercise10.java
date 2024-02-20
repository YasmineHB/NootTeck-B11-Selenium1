package homework;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Exercise10 {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://testautomationpractice.blogspot.com/");

		String mainWebPageID = driver.getWindowHandle();
		System.out.println(mainWebPageID);

		// search field
		WebElement searchField = driver.findElement(By.id("Wikipedia1_wikipedia-search-input"));

		// search btn
		WebElement searchbtn = driver.findElement(By.xpath("//input[@class='wikipedia-search-button']"));

		searchField.sendKeys("selenium (software)");
		searchbtn.click();

		Thread.sleep(2000);

		// open windows
		driver.findElement(By.linkText("Selenium (software)")).click();
		// String seleniumPageID = driver.getWindowHandle();//we dont need to write this
		// System.out.println(seleniumPageID);

		driver.switchTo().window(mainWebPageID);// go to main webpage so I can search more for another webpage

		searchField.clear();
		searchField.sendKeys("eBay");
		searchbtn.click();
		Thread.sleep(2000);

		driver.findElement(By.linkText("EBay")).click();
		// String ebay = driver.getWindowHandle();
		// System.out.println(ebay);

		driver.switchTo().window(mainWebPageID);// swtch to main so I can search more

		searchField.clear();
		searchField.sendKeys("Target Corporation");
		searchbtn.click();
		Thread.sleep(2000);

		driver.findElement(By.linkText("Target Corporation")).click();
		// String target = driver.getWindowHandle();
		// System.out.println(target);

		driver.switchTo().window(mainWebPageID);// swtch to main so I can search more

		searchField.clear();
		searchField.sendKeys("Google Chrome");// we need to click google chrome
		searchbtn.click();
		Thread.sleep(2000);

		driver.findElement(By.linkText("Google Chrome")).click();
		// String google = driver.getWindowHandle();
		// System.out.println(google);

		driver.switchTo().window(mainWebPageID);// swtch to main so I can search more

		searchField.clear();
		searchField.sendKeys("Yahoo!");
		searchbtn.click();
		Thread.sleep(2000);

		driver.findElement(By.linkText("Yahoo!")).click();
		// String yahoo = driver.getWindowHandle();
		// System.out.println(yahoo);

		Set<String> windowsID = driver.getWindowHandles();

		for (String windowID : windowsID) {
			System.out.println("*************************************************");
			System.out.println("windowID: " + windowID);

			// switch the control to the window
			driver.switchTo().window(windowID);
			String title = driver.getTitle();

			// Selenium
			if (title.equals("Selenium (software) - Wikipedia")) {

				Thread.sleep(2000);
				System.out.println(title);
				driver.findElement(By.xpath("//td//a[@href='https://selenium.dev/']")).click();
				String title1 = driver.getTitle();
				if (title1.equals("Selenium")) {
					System.out.println(title1);
				} else {
					System.out.println("title is not Selenium it is: " + title1);
				}
				driver.findElement(By.linkText("Documentation")).click();
				String seleniumDocText = driver.findElement(By.xpath("//h1")).getText();
				if (seleniumDocText.equals("The Selenium Browser Automation Project")) {
					System.out.println("Wooow, once I am done here I will read all the\r\n" + "available documents.");
				} else {
					System.out.println("I am still going to read all the available documents.");
				}
				driver.close();
				Thread.sleep(2000);

				// ebay
			} else if (title.equals("eBay - Wikipedia")) {

				System.out.println(title);
				Thread.sleep(2000);
				driver.findElement(By.xpath("//td//a[@href='https://www.ebay.com']")).click();
				String title2 = driver.getTitle();
				System.out.println(title2);

				if (title2.equals("Electronics, Cars, Fashion, Collectibles & More | eBay")) {
					WebElement allCat = driver.findElement(By.id("gh-cat"));
					Select obj = new Select(allCat);
					List<WebElement> listAllCat = obj.getOptions();
					int count = 0;

					for (WebElement list : listAllCat) {
						String str = list.getText();

						if (str.contains("&")) {
							count++;
							System.out.println(str);
						}
					}
					System.out.println("count of & appeared in the text = " + count);
					if (count > 6) {
						System.out.println("TESTCASE PASSED");
					} else {
						System.out.println("TESTCASE FAILED");
					}
				} else {
					System.out.println("Invalid Title");
				}
				Thread.sleep(2000);
				driver.close();

				// target
			} else if (title.equals("Target Corporation - Wikipedia")) {

				System.out.println(title);
				Thread.sleep(2000);
				driver.findElement(By.linkText("target.com")).click();
				String title3 = driver.getTitle();
				if (title3.equals("Target : Expect More. Pay Less.")) {

					List<WebElement> links = driver.findElements(By.tagName("a"));
					int countStatic = 0;
					for (WebElement list : links) {
						String text = list.getText();
						System.out.println(text);

						String url = list.getAttribute("href");
						System.out.println(url);

						if (url.contains("static")) {
							countStatic++;
						}
					}
					if (countStatic > 50) {
						System.out.println("TESTCASE PASSED");
					} else {
						System.out.println("TESTCASE FAILED");
					}
				}
				Thread.sleep(2000);
				driver.close();

				// Google
			} else if (title.equals("Google Chrome - Wikipedia")) {// we need to change to google Chrome in order to get
																	// to the website
				System.out.println(title);
				Thread.sleep(2000);
				driver.findElement(By.xpath("//td//a[@href='https://www.google.com/']")).click();
				String title4 = driver.getTitle();
				System.out.println(title4);

				if (title4.equals("Google")) {
					String text = driver.findElement(By.xpath("//span[@class='ktLKi']")).getText();
					System.out.println(text);
				}
				Thread.sleep(2000);
				driver.close();

				// Yahoo!
			} else if (title.equals("Yahoo! - Wikipedia")) {

				System.out.println(title);
				Thread.sleep(2000);
				driver.findElement(By.xpath("//td//a[@href='https://www.yahoo.com/']")).click();
				String title5 = driver.getTitle();
				System.out.println(title5);
				if (title5.equals("Yahoo | Mail, Weather, Search, Politics, News, Finance, Sports & Videos")) {

					List<WebElement> header = driver.findElements(By.cssSelector("ul._yb_1rhuy"));
					for (WebElement list : header) {
						String text = list.getText();
						System.out.println(text);
					}
				}
				Thread.sleep(2000);
				driver.close();
			}
		}

		driver.switchTo().window(mainWebPageID);
		String mainPageTitle = driver.getTitle();

		if (mainPageTitle.equals("Automation Testing Practice")) {
			System.out.println("TESTCASE PASSED");
		} else {
			System.out.println("TESTCASE FAILED");
		}
		driver.quit();
	}

}
