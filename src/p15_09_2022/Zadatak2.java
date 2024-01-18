package p15_09_2022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Zadatak2 {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		/*
		 * Zadatak (dok ne stignemo do ovog zadatka izguglajte kako da selektujete vrednost 
		 * u select elementu) 
	Napisati program koji ucitava stranicu https://www.ebay.com/ i bira kategoriju “Crafts”

		 */
		driver.get("https://www.ebay.com/");
		Select drop = new Select(driver.findElement(By.id("gh-cat")));
		//drop.selectByIndex(13);
		//drop.selectByValue("14339");
		drop.selectByVisibleText("Crafts");
		
		Thread.sleep(5000);
		driver.quit();
	}

}
