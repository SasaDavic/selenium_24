package p16_09_2022;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Zadatak2 {

	public static void main(String[] args) throws InterruptedException {
	/*
2.Zadatak 
Napisati program testira upload funkcionalnost: Koristan link https://www.guru99.com/upload-download-file-selenium-webdriver.html
●	Ucitava stranicu https://crop-circle.imageonline.co/#circlecropresult
●	Uploadujte sliku na sajt
●	Kliknite na dugme Crop Circle


	 */
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		
		driver.manage().window().maximize();
		driver.get("https://crop-circle.imageonline.co/#circlecropresult");

		Thread.sleep(5000);
		WebElement upload =
				driver.findElement(By.id("inputImage"));
		
		//upload.sendKeys("C:\\Users\\KTG\\Downloads\\brojevi tel.png");
		File slika = new File("img/majli.png");
		upload.sendKeys(slika.getAbsolutePath());
		
		
		
		 new Actions(driver)
         .scrollToElement(driver.findElement(By.xpath("//div[@class='service']")))
         .perform();
		 
		Thread.sleep(5000);
		driver.findElement(By.id("photobutton")).click();
		
		
		Thread.sleep(5000);
		driver.quit();
	}

}
