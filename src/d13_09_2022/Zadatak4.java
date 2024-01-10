package d13_09_2022;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Zadatak4 {

	public static void main(String[] args) {
	/*
	Napisati program koji matematicku formulu koju korisnik unese izvrsaav na stranici:
●	Ucitati stranicu https://www.calculatorsoup.com/calculators/math/basic.php
●	Korisnik unosi formulu, samo osnovne matematicke operacija, npr:
○	1243+329=
○	21912-4=
○	12913÷4=
●	U programu se formula unosi kao jedan string i potrebno je razbiti formulu na karaktere. 
Za to imate metodu https://www.geeksforgeeks.org/convert-a-string-to-a-list-of-characters-in-java/
●	Zatim u odnosu na karakter uradite odredjenu logiku

	 */
		Scanner s = new Scanner(System.in);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.get("https://www.calculatorsoup.com/calculators/math/basic.php");
		System.out.println("Upisite formulu koju zelite da izracunate: ");
		String formula = s.nextLine();
		
		//??

	}

	private static List<Character> convertStringToCharList(String formula) {
		// TODO Auto-generated method stub
		return null;
	}

}
