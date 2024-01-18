package p15_09_2022;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class UvodUImplicitnoCekanje {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		
		driver.navigate().to("file:///C:/Users/Dell/Downloads/Zadatak4.html");
		WebElement button = driver.findElement(By.id("showInBtn"));

		driver.findElement(By.id("showInBtn")).click();

		driver.findElement(By.id("showInBtn")).click();

		driver.findElement(By.id("showInBtn")).click();
//		
//		driver.get("google.com");
//		driver.get("facebook.com");
//		
//		I NACIN PROVERE DA LI ELEMENT POSTOJI
//		List<WebElement> lista = driver.findElements(By.tagName("a"));
//		if (lista.size() == 0) {
//			System.out.println("Nije se pojavio element");
//		} else {
//			System.out.println("Pojavio se element!");
//		}
//		
		
//		II NACIN PROVERE DA LI ELEMENT POSTOJI
		boolean elementPostoji = true;
		try {
			driver.findElement(By.id("showInBtn"));
		} catch(NoSuchElementException error) {
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


