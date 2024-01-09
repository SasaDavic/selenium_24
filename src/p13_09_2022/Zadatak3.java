package p13_09_2022;

import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Zadatak3 {

	public static void main(String[] args) throws InterruptedException {
		/*
	Napisati program koji ima:
●	Niz stranica (niz stringova) koje treba da ucita. Niz je:
○	https://google.com/
○	https://youtube.com/
○	https://www.ebay.com/
○	https://www.kupujemprodajem.com/
●	Program petljom prolazi kroz niz stranica i svaku stranicu ucitava preko get ili 
navigate i od svake stranice na ekranu ispisuje naslov stranice. 
Kako od stranice procitati naslov imate na ovom linku
U prevodu u konzoli treba da se ispisu:
Google
YouTube
Electronics, Cars, Fashion, Collectibles & More | eBay
KupujemProdajem
●	Zatvara pretrazivac

		 */
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		ArrayList<String> nizStranica = new ArrayList<String>();
		nizStranica.add("https://google.com/");
		nizStranica.add("https://youtube.com/");
		nizStranica.add("https://www.ebay.com/");
		nizStranica.add("https://www.kupujemprodajem.com/");
		
		for(int i = 0; i < nizStranica.size(); i++) {
			driver.get(nizStranica.get(i));
			System.out.println("Page title is: " + driver.getTitle());
			Thread.sleep(2000);
		}
		driver.quit();
	}

}
