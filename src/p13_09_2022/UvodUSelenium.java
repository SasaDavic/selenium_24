package p13_09_2022;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class UvodUSelenium {

	public static void main(String[] args) throws InterruptedException {
		// ova dva reda idu zbog novije verzije chroma
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		//podesavanje putanje
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize(); //maximizaraj prozor
		
		driver.get("https://www.google.com/"); //uvek krecemo od home stranice
		//driver.get("https://www.youtube.com/");
		
		WebElement searchInput = 
		driver.findElement(By.xpath("//textarea[@name='q']"));
		
		searchInput.sendKeys("IT Bootcamp"); //ukuca text
		//krace:
		//driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys("IT Bootcamp");
		
		Thread.sleep(5000); //1s = 1000 ms
		
		searchInput.sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		// searchInput.clear(); //brise tekst
		// searchInput.sendKeys("1000");
		

		WebElement firstResult = 
				driver.findElement(By.xpath("//h3[contains(@class, 'MBeuO')]"));
		firstResult.click();
		
	//	driver.close(); //zatvara tab
		driver.quit();	//zatvara chrome
	}

}
