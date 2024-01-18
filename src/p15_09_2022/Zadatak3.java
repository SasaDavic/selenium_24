package p15_09_2022;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Zadatak3 {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		/*
	Ucitava stranicu  https://www.ebay.com/
●	Zatim iz selekta za kategoriju povlaci sve opcije. Koristan link
●	Zatim bira random element iz niza opcija koristeci Random. Vodite racuna da random 
element bude u opsegu broja elemenata niza. Random podsetnik
●	Selektuje random kategoriju izabranu u koraku iznad
●	Zatvara pretrazivac

		 */
		driver.get("https://www.ebay.com/");
		Select select = new Select(driver.findElement(By.xpath("//select[@id='gh-cat']")));
	      // getting the list of options in the dropdown with getOptions()
	      List <WebElement> opt = select.getOptions();
	     
	      for(int i = 0; i < opt.size() ;i++){
	         String option = opt.get(i).getText();
	         System.out.println(option);
	         }
	      
	      Random ran = new Random();
	     // int x = ran.nextInt(36);
	      int randomOptions = ran.nextInt(select.getOptions().size());
	      
	      select.selectByIndex(randomOptions);
	      
		Thread.sleep(5000);
		driver.quit();

	}

}
