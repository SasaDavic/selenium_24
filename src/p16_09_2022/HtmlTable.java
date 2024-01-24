package p16_09_2022;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class HtmlTable {
	
	private WebElement table;
	

	public HtmlTable(WebElement table) {
		super();
		this.table = table;
	}
	public WebElement getCellText(int row, int cell) {
		return table.findElement(By.xpath("//tbody/tr[" + row + "]/td[" + cell + "]"));
	}
	public List<WebElement> getColumnsByName(String cellName) {
		List<WebElement> colums = null;
		for (int i = 1; i < 5; i++) {
			WebElement header = table.findElement(By.xpath("//thead/tr/th[" + i + "]"));
			String headerText = header.getText();
			if(cellName.equals(headerText)) {
				colums = table.findElements(By.xpath("//tbody/tr/td[" + i + "]")); //tr nije definisano, pa uzima sve
			}
		}
		return colums;		
	}
	public void sortDescending(String cellName) {
		int cellNumb = 0;
		
		for (int i = 1; i < 5; i++) {
			WebElement header = table.findElement(By.xpath("//thead/tr/th[" + i + "]"));
			String headerText = header.getText();
			if(cellName.equals(headerText)) {
				cellNumb = i;
			}
		}
		table.findElement(By.xpath("//thead/tr/th[" + cellNumb + "]")).click();
		table.findElement(By.xpath("//thead/tr/th[" + cellNumb + "]")).click();
		if(!table
	.findElement(By.xpath("//table/thead/tr/th[contains(@class, 'headerSortUp')]")).isDisplayed()) {
			table.findElement(By.xpath("//thead/tr/th[" + cellNumb + "]")).click();
		}
		
	}
	public void sortAscending(String cellName) {
		int cellNumb = 0;
		
		for (int i = 1; i < 5; i++) {
			WebElement header = table.findElement(By.xpath("//thead/tr/th[" + i + "]"));
			String headerText = header.getText();
			if(cellName.equals(headerText)) {
				cellNumb = i;
			}
		}
		table.findElement(By.xpath("//thead/tr/th[" + cellNumb + "]")).click();
		if(!table
	.findElement(By.xpath("//table/thead/tr/th[contains(@class, 'headerSortDown')]")).isDisplayed()) {
			table.findElement(By.xpath("//thead/tr/th[" + cellNumb + "]")).click();
		}
		
	}
	public static void main(String[] args) throws InterruptedException {
	/*Kreirati klasu HtmlTable
●	koja od atributa ima table web element sa stranice
●	konstruktor koji prima web element sa kojim se radi
●	metodu getCellText, koja prima dva parametra row i cell od kog hocemo da procitamo tekst. 
Npr ako se za tabelu(2012 goald medal olympic drivers)  sa linka prozovmeo metodu sa row=1 i 
cell =3 metoda vraca vrednost  China
●	metodu getColumnsByName, metoda kao parametar prima naslov kolone a vraca niz elemenata, 
gde je svaki element celija iz trazene kolone. Npr ako se pozove metoda za “Country”, metoda 
vraca UnitedStates, China, China, ….Russia, …China samo ne stringove nego elemente koji 
cuvaju te vrednosti!
●	metodu sortDescending, koja kao parametar prima naziv kolone. Metoda treba da uradi 
potrebne akcije da se tabela sortira u opadajucem redosledu po trazenoj koloni. 
POMOC: Sortiranje je izvrseno ukoliko header trazene kolone ima klasu headerSortUp
●	metodu sortDescending, koja kao parametar prima naziv kolone. Metoda radi slicno kao za 
descending
U glavnom programu:
●	Ucitati stranicu 
https://www.bu.edu/tech/services/cccs/websites/www/wordpress/how-to/sortable-searchable-tables/
●	Kreirati HtmlTable objekat koji se veze za 2012 Gold Medal Olympic Divers 
tabelu sa stranice
●	Probajte metodu getCellText

	 */
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		
		driver.get("https://www.bu.edu/tech/services/cccs/websites/www/wordpress/how-to/sortable-searchable-tables/");
	
		HtmlTable tableO = new HtmlTable(driver.findElement(By.className("sortable")));
		System.out.println("Tekst je: " + tableO.getCellText(2, 2).getText());
		
		List<WebElement> kolona = tableO.getColumnsByName("Country");
		System.out.println("Kolona sadrzi: ");
		for (int i = 0; i < kolona.size(); i++) {
			System.out.println(kolona.get(i).getText() + ", ");
		}
		new Actions (driver)
			.scrollToElement(driver.findElement(By.id("searchable")))
			.perform();
		
		tableO.sortAscending("Age");
		Thread.sleep(5000);
		tableO.sortDescending("Athlete");
		Thread.sleep(5000);
		//driver.quit();
	}

}
