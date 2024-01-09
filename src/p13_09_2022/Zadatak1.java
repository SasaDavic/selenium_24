package p13_09_2022;

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
	Napisati program koji:
●	Maksimizuje prozor
●	Ucitava stranicu https://cms.demo.katalon.com/ 
●	U delu za pretragu unosi tekst Flying Ninja. Xpath za trazenje ovog elementa treba da 
	bude preko name atributa
●	Klikce na dugme za pretragu. Dugme sa lupom. Kada trazite element dohvatite element koji 
	je po tagu button a ne span. Xpath za trazenje ovog elementa treba da bude preko class 
	atributa.
●	Ceka 5 sekuni
●	Zatvara pretrazivac

		 */
		driver.get("https://cms.demo.katalon.com/");
		//driver.findElement(By.xpath("//input[@name='s']")).sendKeys("Flying Ninja");
		driver.findElement(By.name("s")).sendKeys("Flying Ninja");
		//driver.findElement(By.xpath("//button[@class='search-submit']")).click();
		driver.findElement(By.className("search-submit")).click();	
		
		Thread.sleep(5000);
		driver.quit();

	}

}
