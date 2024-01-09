package p13_09_2022;

import java.util.ArrayList;
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
		 * 4.Zadatak
Napisti proram koji :
●	Ucitava stranicu https://s.bootsnipp.com/iframe/oV91g
●	Hvatamo sve page-eve iz paginacije tabele
●	Zatim petljom prolazimo kroz paginaciju tako sto kliknemo na svaki broj
●	Izmedju iteracija napravite pauzu od 1s
●	Zatvorite pretrazivac

		 */
		
		driver.get("https://s.bootsnipp.com/iframe/oV91g");
		List<WebElement> nizElemenata = 
				driver.findElements(By.xpath("//*[contains(@class, 'page_link')]"));
		for (int i = 0; i < nizElemenata.size(); i++) {
			nizElemenata.get(i).click();
			Thread.sleep(1000);
			}
		driver.quit();
		
		}

	}


