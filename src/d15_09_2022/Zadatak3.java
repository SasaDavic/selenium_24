package d15_09_2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Zadatak3 {

	public static void main(String[] args) throws InterruptedException {
//		Napisati program koji 
//		Ucitava https://seeds.sproutsocial.com/components/loader-button/
//		Odskrola do Loader buttons are used to display a loading indicator inside of a button. paragrafa. Koristan link
//		Klikce ne dugme 
//		Ceka da dugme zavrsi sa loadingom 
//		Ispisati poruku na ekranu
//		Zatvoriti pretrazivac
//		HINT: Koristite data-qa-button-isloading  atribut elementa za cekanje odredjenog stanja tog elementa
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://seeds.sproutsocial.com/components");
		
		WebElement loaderButton = 
				driver.findElement(By.xpath("//*[contains(text(), 'Loader Button')]"));
		//WebElement loaderButton = driver.findElement(By.linkText("Loader Button"));
		new Actions (driver)
			.click(loaderButton)
			.perform();

		WebElement klik = driver.findElement(By.xpath("//main[@id='main']/div/div/div[2]/div[2]/div/button"));
		new Actions (driver)
			.click(klik)
			.perform();
		System.out.println("Dugme se ucitava!");
		driver.findElement(By.xpath("//*[@data-qa-button-isloading='false']"));
		System.out.println("Dugme se ucitalo!");
		Thread.sleep(5000);
		driver.quit();
		
	}

}
