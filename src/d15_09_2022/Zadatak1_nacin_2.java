package d15_09_2022;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Zadatak1_nacin_2 {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		
		driver.get("https://s.bootsnipp.com/iframe/Dq2X");
		
		List<WebElement> dugmeX = 
				driver.findElements(By.className("close"));
		
		for (int i = 0; i < dugmeX.size(); i++) {
			driver.findElement(By.className("close")).click();
			List<WebElement> dugme = 
					driver.findElements(By.className("close"));
			if(dugme.size() == dugmeX.size() - i - 1) {
				System.out.println("Red je obrisan!");
			} else {
				System.out.println("Red nije obrisan!");
			}
			Thread.sleep(1000);
			
		}
		Thread.sleep(5000);
		driver.quit();

	}

}
