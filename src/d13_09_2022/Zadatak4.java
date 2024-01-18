package d13_09_2022;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Zadatak4 {

	public static void main(String[] args) throws InterruptedException {
	/*
	Napisati program koji matematicku formulu koju korisnik unese izvrsaav na stranici:
●	Ucitati stranicu https://www.calculatorsoup.com/calculators/math/basic.php
●	Korisnik unosi formulu, samo osnovne matematicke operacija, npr:
○	1243+329=
○	21912-4=
○	12913÷4=
●	U programu se formula unosi kao jedan string i potrebno je razbiti formulu na karaktere. 
Za to imate metodu 
https://www.geeksforgeeks.org/convert-a-string-to-a-list-of-characters-in-java/
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
		
		ArrayList<Character> karakteri = new ArrayList<Character>();
		ArrayList<Integer> broj = new ArrayList<Integer>();
		ArrayList<Integer> brojCifara = new ArrayList<Integer>();
		ArrayList<String> znak = new ArrayList<String>();
		for (char c : formula.toCharArray()) {
		    karakteri.add(c);
		}
		for (int i = 0; i < karakteri.size(); i++) {
			if (jeBroj(karakteri.get(i)) != karakteri.get(i)) {
				broj.add(jeBroj(karakteri.get(i)));
			} else if (jeZnak(karakteri.get(i)) != null){
				znak.add(jeZnak(karakteri.get(i)));
				brojCifara.add(i);
			}
		}
		String br1 = "";
		for (int i = 0; i < brojCifara.get(0); i++) {
			br1 += broj.get(i);
		}
		driver.findElement(By.id("cs_display")).sendKeys(br1);
		
		if(znak.get(0).equals("+")) {
			driver.findElement(By.name("cs_add")).click();
		} else if(znak.get(0).equals("-")) {
			driver.findElement(By.name("cs_subtract")).click();
		} else if(znak.get(0).equals("*")) {
			driver.findElement(By.name("cs_multiply")).click();
		} else if(znak.get(0).equals("/")) {
			driver.findElement(By.name("cs_divide")).click();
		}
		
		System.out.println(brojCifara.get(0));
		System.out.println(brojCifara.get(1));
		String br2 = "";
		for (int i = brojCifara.get(0); i < brojCifara.get(1) - 1; i++) {
			br2 += broj.get(i);
		}
		
		driver.findElement(By.id("cs_display")).sendKeys(br2);
		driver.findElement(By.name("cs_equal")).click();
		
		Thread.sleep(5000);
		//driver.quit();
	}

	public static int jeBroj(char k) {
		if(k == '1') {
			return 1;
		} else if(k == '2') {
			return 2;
		} else if(k == '3') {
			return 3;
		} else if(k == '4') {
			return 4;
		} else if(k == '5') {
			return 5;
		} else if(k == '6') {
			return 6;
		} else if(k == '7') {
			return 7;
		} else if(k == '8') {
			return 8;
		} else if(k == '9') {
			return 9;
		} else if(k == '0') {
			return 0;
		}
		return k;
	}
	public static String jeZnak(char k) {
		if(k == '+') {
			return "+";
		} else if(k == '-') {
			return "-";
		} else if(k == '*') {
			return "*";
		} else if(k == '/') {
			return "/";
		} else if(k == '=') {
			return "=";
		}
		return null;
	}

}
