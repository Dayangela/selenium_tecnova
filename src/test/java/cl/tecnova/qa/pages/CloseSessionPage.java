package cl.tecnova.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import cl.tecnova.qa.helpers.PageWeb;

public class CloseSessionPage extends PageWeb {

	// Atributos
	
	private By clickCuenta;
	private By closeSession;

	// Constructor
	public CloseSessionPage(WebDriver driver, ExtentTest test, Boolean TAKE_SS, int seconds)
	{
		super(driver, test, TAKE_SS, seconds);
		
	this.clickCuenta = By.xpath("//*[@id=\"surface\"]//button[contains(@title,\"Dayangela Ortega (dayangelaortega)\")]");
	this.closeSession = By.xpath("//*[@data-test-id=\"header-member-menu-logout\"]//span[contains(text(),\"Cerrar sesión\")]");

	}
	// Metodos

	public void finSession()
	{
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {   
			e.printStackTrace();             
		}
		driver.findElement(clickCuenta).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {   
			e.printStackTrace();             
		}
		driver.findElement(closeSession).click();
		
	}
	
}
