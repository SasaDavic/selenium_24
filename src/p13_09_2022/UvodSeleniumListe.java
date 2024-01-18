package p13_09_2022;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class UvodSeleniumListe {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); 
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.get("https://cms.demo.katalon.com/");
		
		List<WebElement> links = 
				driver.findElements(By.xpath("//*[@id='primary-menu']//a"));
		
		for (int i = 0; i < links.size(); i++) {
			System.out.println(links.get(i).getText());
		}
		Thread.sleep(5000);
		//driver.quit();
	}

}
