package p16_09_2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UvodWait {

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		

		driver.get("file:/C:/Users/KTG/Desktop/QA%20sve/Selenijum/p15.09.2022/15.09.2022/Zadatak6a.html");
		driver.findElement(By.id("showInBtn")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("id-0")));
		driver.findElement(By.id("showInBtn")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("id-1")));
		driver.findElement(By.id("showInBtn")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("id-2")));
		driver.findElement(By.id("showInBtn")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("id-3")));
		
		wait.until(ExpectedConditions.numberOfElementsToBe(By.tagName("div"), 4));
		
		
		
		
		Thread.sleep(5000);
		driver.quit();
	}

}
