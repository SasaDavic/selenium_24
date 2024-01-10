package d13_09_2022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Zadatak1 {

	public static void main(String[] args) throws InterruptedException {
		/*
	Maksimizirati prozor
●	Ucitati stranicu https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
●	Prijavite se na sistem 
○	Username: Admin
○	Password: admin123
●	Cekanje od 5s
●	U input za pretragu iz navigacije unesite tekst Me
●	Kliknite na prvi rezultat pretrage (to ce biti Time)
●	Cekanje od 1s
●	Kliknite u headeru na svog avatara (to ce biti na ime: Paul Collings)
●	Klinkite na logout
●	Cekanje od 5s
●	Zatvorite pretrazivac

		 */
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.className("oxd-button")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("Me");
		driver.findElement(By.xpath("//ul[@class='oxd-main-menu']/li")).click();
		Thread.sleep(1000);
		driver.findElement(By.className("oxd-userdropdown")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[contains(text(), 'Logout')]")).click();
		//driver.findElement(By.linkText("Logout")).click();
		
		Thread.sleep(5000);
		driver.quit();
	}

}
