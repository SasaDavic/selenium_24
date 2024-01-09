package p09_09_2022;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class HelloWorldSelenium {

	public static void main(String[] args) {
		// ova dva reda idu zbog novije verzije chroma
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		//podesavanje putanje
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.google.com/");
		
	}

}
