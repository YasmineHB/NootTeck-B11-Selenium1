package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Exercise13 {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("http://dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

		WebElement oslo = driver.findElement(By.id("box1"));
		WebElement stockholm = driver.findElement(By.id("box2"));
		WebElement washington = driver.findElement(By.id("box3"));
		WebElement copenhagen = driver.findElement(By.id("box4"));
		WebElement seoul = driver.findElement(By.id("box5"));
		WebElement rome = driver.findElement(By.id("box6"));
		WebElement madrid = driver.findElement(By.id("box7"));

		WebElement italy = driver.findElement(By.id("box106"));
		WebElement spain = driver.findElement(By.id("box107"));
		WebElement norway = driver.findElement(By.id("box101"));
		WebElement denmark = driver.findElement(By.id("box104"));
		WebElement southKorea = driver.findElement(By.id("box105"));
		WebElement sweden = driver.findElement(By.id("box102"));
		WebElement unitedStates = driver.findElement(By.id("box103"));

		Actions action = new Actions(driver);

		action.clickAndHold(oslo).moveToElement(norway).release().build().perform();
		action.clickAndHold(stockholm).moveToElement(sweden).release().build().perform();
		action.clickAndHold(washington).moveToElement(unitedStates).release().build().perform();
		action.clickAndHold(copenhagen).moveToElement(denmark).release().build().perform();
		action.clickAndHold(seoul).moveToElement(southKorea).release().build().perform();
		action.clickAndHold(rome).moveToElement(italy).release().build().perform();
		action.clickAndHold(madrid).moveToElement(spain).release().build().perform();

		driver.quit();

	}
}
