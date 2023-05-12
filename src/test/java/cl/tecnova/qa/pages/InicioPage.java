package cl.tecnova.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.relevantcodes.extentreports.ExtentTest;
import cl.tecnova.qa.helpers.PageWeb;

public class InicioPage extends PageWeb {

	// Atributos
	
	private By clickIniciarSesion;
	
	
	// Constructor
	public InicioPage(WebDriver driver, ExtentTest test, Boolean TAKE_SS, int seconds) {
		super(driver, test, TAKE_SS, seconds);
		
	this.clickIniciarSesion = By.xpath("/html/body/header/nav/div[2]/a[1]");

	}
	// Metodos

	public void iniciarSesion()
	{
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(clickIniciarSesion))).click();
		
	}


}
