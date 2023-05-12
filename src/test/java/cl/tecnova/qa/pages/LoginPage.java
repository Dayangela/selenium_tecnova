package cl.tecnova.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;

import cl.tecnova.qa.helpers.Helper;
import cl.tecnova.qa.helpers.PageWeb;

public class LoginPage extends PageWeb {

	// Atributos
	
	private By ingresarMail;
	private By sesionAtlassian;
	private By password;
	private By clickIniciar;
	private By validarIngreso;
	

	// Constructor
	public LoginPage(WebDriver driver, ExtentTest test, Boolean TAKE_SS, int seconds)
	{
		super(driver, test, TAKE_SS, seconds);
		
	this.ingresarMail = By.id("user");
	this.sesionAtlassian = By.id("login");
	this.password = By.xpath("//*[@id=\"password\"]");
	this.clickIniciar = By.xpath("//*[@id=\"login-submit\"]/span/span");
	this.validarIngreso = By.xpath("//a[@href=\"/dayangelaortega/boards\"]/span[text()=\"Tableros\"]");
	
	}
	// Metodos

	public void loginMail(String correoIngreso)
	{
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(ingresarMail))).sendKeys(correoIngreso);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {   
			e.printStackTrace();             
		}
		driver.findElement(sesionAtlassian).click();
		
	}

	public void loginPass(String passwords, String subDir)
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {   
			e.printStackTrace();             
		}
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(password))).sendKeys(passwords);
		Helper.addEvidence(TAKE_SS, driver, test, "Ingreso datos", subDir, "loginMail_01");
		driver.findElement(clickIniciar).click();
		
	}
	
	public void loginPassIncorrecto(String passwords, String subDir)
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {   
			e.printStackTrace();             
		}
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(password))).sendKeys(passwords);
		driver.findElement(clickIniciar).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {   
			e.printStackTrace();             
		}
		Helper.addEvidence(TAKE_SS, driver, test, "Ingreso datos", subDir, "loginPassIncorrecto_01");
		
	}
	
	public void assertIngreso(String titulo, String subDir) 
	{
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {   
			e.printStackTrace();
		}
		Assert.assertEquals(driver.findElement(validarIngreso).getText(), titulo);
		Helper.addEvidence(TAKE_SS, driver, test, "Valido Ingreso", subDir, "validoIngreso_01");
	}
	
}
