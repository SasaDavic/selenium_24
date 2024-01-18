package p15_09_2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Zadatak6 {

	public static void main(String[] args) {
	/*
	 * Napisati program koji ucitava stranicu Zadatak6.html
Skinite Zadatak6.html sa drajva. Otvorite u pretrazivacu duplim klikom na fajl i Downloads-a i ikopirajte url. To je url za get u programu
●	I na stranici dodaje 5 poruka “IT Bootcamp”
●	Potrebno  je u svakoj iteraciji kliknuti na dugme Show in
●	Sacekati da se novi element pojavi pre nego sto se doda sledeci

	 */
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		
		driver.get("file:///C:/Users/KTG/Desktop/QA%20sve/Selenijum/p15.09.2022/15.09.2022/Zadatak6a.html");
		
		
		for (int i = 0; i < 5; i++) {
			driver.findElement(By.id("showInBtn")).click();
			boolean vidljiv =
				driver.findElement(By.id("id-" + i)).isDisplayed();
			if(vidljiv == true) {
				System.out.println("Element je prikazan!");
				}
		}
		driver.quit();
		
	}

}
