package cl.tecnova.qa.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;

import cl.tecnova.qa.helpers.Helper;
import cl.tecnova.qa.helpers.PageWeb;

public class CrearTableroPage extends PageWeb {

	// Atributos
	
	private By iniTablero;
	private By tituloTablero;
	private By finCrearTablero;
	
	
	// Constructor
	public CrearTableroPage(WebDriver driver, ExtentTest test, Boolean TAKE_SS, int seconds)
	{
		super(driver, test, TAKE_SS, seconds);
		
	this.iniTablero = By.xpath("//main[@id=\"popover-boundary\"]//span[text()=\"Crear un tablero nuevo\"]");
	this.tituloTablero = By.xpath("//*[@id=\"chrome-container\"]//input[contains(@placeholder, \"de tablero\")]");
	this.finCrearTablero = By.xpath("//*[@id=\"chrome-container\"]//button[contains(text(),\"Crear tablero\")]");
	
	}
	
	// Metodos

	public void createTab(String subDir, String nombre)
	{
		driver.findElement(iniTablero).click();
		driver.findElement(tituloTablero).sendKeys(nombre);
		Helper.addEvidence(TAKE_SS, driver, test, "Crear Tablero", subDir, "createTab_01");
		driver.findElement(finCrearTablero).click();
		
	}
	
}
