package p15_09_2022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Zadatak1 {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		/*
		 * Napisati program koji prijavljivanju na stranicu 
		 * http://cms.demo.katalon.com/my-account/, cekira Remember me checkbox.
Na kraju programa proverite da li je element cekiran. 
Izguglajte kako mozemo da proverimo da li je element cekiran.
		 */
		driver.get("http://cms.demo.katalon.com/my-account/"); 
		Thread.sleep(5000);
		driver.findElement(By.id("rememberme")).click();
		if(driver.findElement(By.id("rememberme")).isSelected() == true) {
			System.out.println("Checkbox je cekiran!");
		} else {
			System.out.println("Checkbox nije cekiran!");
		}
		Thread.sleep(5000);
		driver.quit();
	}

}
