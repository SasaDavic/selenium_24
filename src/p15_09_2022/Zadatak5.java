package p15_09_2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Zadatak5 {

	public static void main(String[] args) throws InterruptedException {
	/*
●	Ucitati stranicu https://demoqa.com/modal-dialogs
●	Kliknuti na dugme Large modal
●	Proverite da li se prikazao dijalog i ispisite u konzoli odgovarajuce poruke

	 */		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		driver.get("https://demoqa.com/modal-dialogs");
		boolean elementPostoji = true;
		try {
			driver.findElement(By.id("showLargeModal")).click();
			//boolean displayed = 
			//driver.findElement(By.id("closeLargeModal")).isDisplayed();
		} catch (NoSuchElementException error) {
			elementPostoji = false;
		}
		
		if (elementPostoji) {
			System.out.println("Element postoji");
		} else {
			System.out.println("Element ne postoji.");
		}
		Thread.sleep(5000);
		driver.quit();

	}

}
