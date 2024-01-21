package p16_09_2022;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Zadatak4 {

	public static void main(String[] args) {
		/*
		 * 4.Zadatak
Napisati program koji ucitava stranicu https://s.bootsnipp.com/iframe/klDWV i 
ceka da se ucita progress bar na 100% a zatim ispisuje tekst u konzoli “Stranica ucitana”

		 */
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		
		driver.manage().window().maximize();
		driver.get("https://s.bootsnipp.com/iframe/klDWV");

		driver.findElement(By.id("precent"))

	}

}
