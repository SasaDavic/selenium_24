package p15_09_2022;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Zadatak3a {

	public static void main(String[] args) {
	/*
	 * ●	Ucitati stranicu https://cms.demo.katalon.com/
●	Maksimizovati prozor
●	Proveriri da li je je crno MENU dugme vidljivo (Ispisati poruke u konzoli)
●	Prostavite duzinu prozora na 700px i visinu na 700px
●	Proverite da li je crno MENU dugme vidljivo (Ispisati poruke u konzoli)

	 */
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);

		driver.get("https://cms.demo.katalon.com/");
		driver.manage().window().maximize();
		boolean vidljiv = 
			driver.findElement(By.className("menu-toggle")).isDisplayed();
		if(vidljiv == true) {
			System.out.println("Element je vidljiv!");
		} else {
			System.out.println("Element nije vidljiv");
		}
	    Dimension newDimension = new Dimension(700, 700);
		driver.manage().window().setSize(newDimension);
		
		boolean buttonMenu1 = driver.findElement(By.xpath("//*[@id='site-navigation']/button")).isDisplayed();
        System.out.println("MENU dugme vidljivo:" + buttonMenu1);
        
        driver.quit();
		
	}

}
