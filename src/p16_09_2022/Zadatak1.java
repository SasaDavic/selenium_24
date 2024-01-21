package p16_09_2022;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Zadatak1 {

	public static void main(String[] args) throws InterruptedException {
	/*
●	Pre nego sto krenete u automatizaciju prvo sve korake uradite rucno
●	Implicitno cekanje za trazenje elemenata je maksimalno 10s
●	Implicitno cekanje za ucitavanje stranice je 5s
●	Ucitava stranicu https://docs.katalon.com/
●	Maksimizuje prozor
●	Od html elementa cita data-theme atribut. 
○	Korisni linkovi za citanje vrednosti atributa link1 i link2
●	Proverava da li je sadrzaj u tom atributu light i ispisuje odgovarajuce poruke
●	Klikce na dugme za zamenu tema
●	Ponovo cita data-theme atribut html elementa i validira da u atributu stoji vrednost dark
●	Izvrsava kombinaciju tastera CTRL + K. Koristan link  za keyboard actions…
kako izvrsavati precice preko Actions objekta
●	Zatim od inputa za pretragu cita atribut type i proverava da je vrednost tog atributa 
search
●	Zatvara pretrazivac

	 */
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		
		driver.get("https://docs.katalon.com/");
		
		driver.manage().window().maximize();
		WebElement html = driver.findElement(By.xpath("html"));
		//driver.findElement(By.tagName("html"));
		System.out.println("data-theme atribut je: " + html.getAttribute("data-theme"));

		if(html.getAttribute("data-theme").equals("light")) {
			System.out.println("Tema je light!");
		} else {
			System.out.println("Tema nije light!");
		}
		driver.findElement(By.xpath("//*[@class='navbar__inner']/div[2]/div[2]")).click();
		
		System.out.println("data-theme atribut je: " + html.getAttribute("data-theme"));

		if(html.getAttribute("data-theme").equals("dark")) {
			System.out.println("Tema je dark!");
		} else {
			System.out.println("Tema nije dark!");
		}
		new Actions (driver)
			.keyDown(Keys.CONTROL)
			.sendKeys("k")
			.keyUp(Keys.CONTROL)
			.perform();
		
		String tip = 
				driver.findElement(By.className("DocSearch-Input")).getAttribute("type");
		if(tip.equals("search")) {
			System.out.println("Atribut je tipa: " + tip);
		} else {
			System.out.println("Atribut nije tipa search!");
		}
		Thread.sleep(5000);
		driver.quit();
		
	}

}
