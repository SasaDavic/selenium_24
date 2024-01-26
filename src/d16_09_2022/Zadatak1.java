package d16_09_2022;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Zadatak1 {

	public static void main(String[] args) throws InterruptedException {
	/*
	Napisati program koji ima:
●	Podesava:
○	implicitno cekanje za trazenje elemenata od 10s
○	implicitno cekanje za ucitavanje stranice od 10s
○	eksplicitno cekanje podeseno na 10s
●	Podaci:
○	Potrebno je u projektu ukljuciti 4 slike.
○	Imenovanje slika neka bude po pravilu pozicija_ime_prezime_polaznika.ekstenzija
■	Npr: front_milan_jovanovic.jpg, left_milan_jovanovic.jpg …
●	Koraci:
○	Ucitava stranicu https://boomf.com/apps/proxy/boomf-bomb/i-bloody-love-you
○	Maksimizuje prozor
○	Selektuje Image - Front klikom na tu karticu u dnu ekrana
○	Klik na add photo iz levog navigacionog menia
○	Upload slike. Upload preko File objekta koristeci getAbsolutePath
○	Sacekati da broj prikazanih slika u donjem uglu navigacije bude za 1 veca
○	Kliknuti na poslednje dodatu sliku kako bi bila izabrana za postavljanje
○	Ceka da dijalog bude vidljiv
○	Klik na Use One Side Only dugme
○	Ceka da se pojavi dijalog sa slikom
○	Klik na Done
○	Ponoviti proces za Left, Right i Back
○	Zatim iz desnog gornjeg ugla izabrati random jedan od ponudjenih konfeta
○	Kliknuti na Add To Cart dugme
○	Verifikovati postojanje greske Oops! It looks like you`ve not added an text to this field, please add one before continuing.
■	Xpath: //*[@action='error']
○	Zatvorite pretrazivac

	 */
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.get("https://boomf.com/apps/proxy/boomf-bomb/i-bloody-love-you");
		driver.manage().window().maximize();
		
		ArrayList<File> pics = new ArrayList<File>();
		File frontPic = new File("img/front_sasa_davic.png");
		File backPic = new File("img/back_sasa_davic.jpg");
		File leftPic = new File("img/left_sasa_davic.jpg");
		File rightPic = new File("img/right_sasa_davic.jpg");
		
		pics.add(frontPic);
		pics.add(backPic);
		pics.add(leftPic);
		pics.add(rightPic);
		
		for (int i = 0; i < 4; i++) {
			driver.findElement(By.id("cube-" + i + "-image")).click();
			driver.findElement(By.className("edit-image")).click();
			if(i == 0) {
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.id("image-option-replace")));
				driver.findElement(By.id("image-option-replace")).click();
			}
			if(i > 0) {
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.className("edit-image")));
				//driver.findElement(By.className("edit-image")).click();
				
			}
			
			WebElement upload = 
					driver.findElement(By.xpath("//input[@type='file']"));
			upload.sendKeys(pics.get(i).getAbsolutePath());
			
			wait.until(ExpectedConditions.numberOfElementsToBe
					(By.xpath("//div[contains(@class, 'sc-imWYAI')]//img"), i + 1));
			
			driver.findElement(By.id("image-option-0")).click();
			wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//div[contains(@class, 'reactEasyCrop_CropArea')]")));
			driver.findElement(By.id("image-crop-done-button")).click();
		}
		
		driver.findElement(By.id("next-button")).click();
		driver.findElement(By.id("textareaID")).sendKeys("Hello!!");
		driver.findElement(By.id("next-button")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("next-button")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("next-button")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("next-button")).click();
		Thread.sleep(2000);
		driver.quit();
	
		
		
	}

}
