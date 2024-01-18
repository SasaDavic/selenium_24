package p15_09_2022;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Zadatak4 {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		/*
●	Ucitava stranicu https://demoqa.com/login
●	Loginuje se sa usename itbootcamp i lozinkom ITBootcamp2021!
●	Zatim ceka 5sekundi da se korisnik uloguje
●	Proverava da li se korisnik ulogovao, tako sto se proverava postojanje dugmeta Logout. 
Ispisati odgovarajucu poruku u konzoli za rezultat loginovanja.
●	Klikce na dugme za logout
●	Gasi stranicu

		 */
		
		driver.get("https://demoqa.com/login");
		driver.findElement(By.id("userName")).sendKeys("itbootcamp");
		driver.findElement(By.id("password")).sendKeys("ITBootcamp2021!");
		driver.findElement(By.id("login")).click();
		Thread.sleep(10000);
		List<WebElement> logout = 
				driver.findElements(By.id("submit"));
		if(logout.size() == 0) {
			System.out.println("Korisnik se nije ulogovao!");
		} else {
			System.out.println("Korisnik se ulogovao!");
		}
		Thread.sleep(5000);
		driver.quit();
		
		
		
	}

}
