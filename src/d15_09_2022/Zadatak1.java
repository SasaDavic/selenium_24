package d15_09_2022;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Zadatak1 {

	public static void main(String[] args) throws InterruptedException {
	/*
	 Napisati program koji:
●	Ucitava stranicu https://s.bootsnipp.com/iframe/Dq2X
●	Klikce na svaki iks da ugasi obavestenje i proverava da li se nakon klika element 
obrisao sa stranice i ispisuje odgovarajuce poruke (OVO JE POTREBNO RESITI PETLJOM)
●	POMOC: Brisite elemente odozdo.
●	(ZA VEZBANJE)Probajte da resite da se elemementi brisu i odozgo

	 */
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		
		driver.get("https://s.bootsnipp.com/iframe/Dq2X");
		
		List<WebElement> lista = driver.findElements(By.className("close"));
		
		
		
		for (int i = lista.size() - 1; i > -1; i--) {
			boolean deleted = false;
			lista.get(i).click();
			try {
				driver.findElement(By.xpath("//*[@class='col-md-12']/div[" + i + 1 + "]"));
			}
			catch (NoSuchElementException error) {
				deleted = true;
			} 
			if(deleted == true) {
				System.out.println("Red je obrisan!");
			} else {
				System.out.println("Greska! Red nije obrisan!");
			}
		}
		Thread.sleep(5000);
		driver.quit();
		
		

	}

}
