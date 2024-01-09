package p13_09_2022;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Zadatak6 {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		/*
6.Zadatak (Za vezbanje)
Napisti program koji:
●	Ucitava stranicu https://s.bootsnipp.com/iframe/z80en
●	Hvata sve elemente iz tabele i stampa tekst svakog elementa. 
Kako da od nekog elementa procitamo tekst imate na sledecem linku 
●	Ceka 5s
●	Zatvara pretrazivac
Stampa treba da bude kao u primeru:
John	Doe	john@example.com
Mary	Moe	mary@example.com
July	Dooley	july@example.com

HINT: bice vam lakse da radite ulancano trazenje. findElement().findELement()...

		 */
		driver.get("https://s.bootsnipp.com/iframe/z80en");
		List<WebElement> table = 
				driver.findElements(By.xpath("//*[@id='lorem']//tbody/tr/td"));
		
		for (int i = 0; i < 3; i++) {
			for (int j = 3*i; j < 3*i + 3; j++) {
				System.out.print(table.get(j).getText() + "\t");
			}
			System.out.println();
		}
		driver.quit();
	}

}
