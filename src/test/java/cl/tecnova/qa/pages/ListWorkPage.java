package cl.tecnova.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentTest;

import cl.tecnova.qa.helpers.Helper;
import cl.tecnova.qa.helpers.PageWeb;

public class ListWorkPage extends PageWeb {

	// Atributos
	
	private By seleccionarLista;
	private By anadeLista;
	private By tituloLista;
	private By incluirLista;
	private By plusTarjeta;
	private By introduzcaDescripcion;
	private By anadaTarjeta;
	private By clickDescripcion;
	private By detallarMas;
	private By etiquetas;
	private By dataColor;
	private By cierraEtiqueta;
	private By vencimiento;
	private By fechaVencimiento;
	private By guardarVenci;
	private By adjunto;
	private By linkAdjunto;
	private By clickComentario;
	private By guardarTodo;
	private By cerrarTarjeta;
	private By datosTarjeta;
	private By opcionMover;
	private By listaMover;
	private By botonMover;
	private By mostrarMenu;
	private By mostrarMas;
	private By menuCerrarTablero;
	private By confirmoCerrar;
	private By eliminarTabPermanente;
	private By confirmEliminar;
	private By volverInicio;

	// Constructor
	public ListWorkPage(WebDriver driver, ExtentTest test, Boolean TAKE_SS, int seconds)
	{
		super(driver, test, TAKE_SS, seconds);
		
	this.seleccionarLista = By.xpath("//*[@id=\"content\"]//div[contains(@title,\"Dayangela Ortega\")]");
	this.anadeLista = By.xpath("//*[@id=\"board\"]//span[contains(text(), \"Añada una lista\")]");
	this.tituloLista = By.name("name");
	this.incluirLista = By.xpath("//*[@id=\"board\"]/div/form/div/input");
	this.plusTarjeta = By.xpath("//*[@id=\"board\"]//span[text()=\"Añada una tarjeta\"]");
	this.introduzcaDescripcion = By.xpath("//*[@id=\"board\"]//textarea[contains(@placeholder, \"Introduzca un\")]");
	this.anadaTarjeta = By.xpath("//*[@id=\"board\"]//input[contains(@value, \"Añadir tarjeta\")]");
	this.clickDescripcion = By.xpath("//*[@id=\"board\"]//span[contains(@class,\"list-card-title js-card-name\")]");
	this.detallarMas = By.xpath("//*[@id=\"chrome-container\"]//textarea[@class=\"field field-autosave js-description-draft description card-description\"]");
	this.etiquetas = By.xpath("//*[@id=\"chrome-container\"]//a[@title=\"Etiquetas\"]");
	this.dataColor = By.xpath("//*[@id=\"chrome-container\"]//span[contains(@data-color,\"green\")]");
	this.cierraEtiqueta = By.xpath("//*[@id=\"chrome-container\"]//a[contains(@class, \"icon-sm icon-close\")]");
	this.vencimiento = By.xpath("//*[@id=\"chrome-container\"]//a[@title=\"Vencimiento\"]");
	this.fechaVencimiento = By.xpath("//*[@id=\"chrome-container\"]//input[contains(@placeholder, \"Introducir la fecha\")]");
	this.guardarVenci = By.xpath("//*[@id=\"chrome-container\"]//input[contains(@class, \"primary wide confirm\")]");
	this.adjunto = By.xpath("//*[@id=\"chrome-container\"]//a[contains(@title, \"Adjunto\")]");
	this.linkAdjunto = By.xpath("//*[@id=\"chrome-container\"]//input[contains(@name,\"file\")]");
	this.clickComentario = By.xpath("//*[@id=\"chrome-container\"]//a[contains(span,\"Comentario\")]");
	this.guardarTodo = By.xpath("//*[@id=\"chrome-container\"]//input[contains(@class,\"add-comment\")]");
	this.cerrarTarjeta = By.xpath("//*[@id=\"chrome-container\"]//a[contains(@class,\"js-close-window\")]");
	this.datosTarjeta = By.xpath("//*[@id=\"board\"]/div[1]/div/div[2]/a/div[1]");
	this.opcionMover = By.xpath("//*[@id=\"chrome-container\"]//a[contains(@title, \"Mover\")]");
	this.listaMover = By.xpath("//*[@id=\"chrome-container\"]//select[contains(@class,\"js-select-list\")]");
	this.botonMover = By.xpath("//*[@id=\"chrome-container\"]//input[contains(@value, \"Mover\")]");
	this.mostrarMenu = By.xpath("//*[@id=\"content\"]//span[contains(text(), \"Mostrar menú\")]");
	//this.mostrarMas =By.xpath("//*[@id=\"content\"]//a//span[contains(@class, \"icon-sm icon-overflow-menu-horizontal board-menu-navigation-item-link-icon\")]");
	this.mostrarMas =By.xpath("//*[@id=\"content\"]//a[contains(@class,\"board-menu-navigation-item-link js-open-more\")]");
	this.menuCerrarTablero = By.xpath("//*[@id=\"content\"]//a[contains(text(), \"Cerrar tablero\")]");
	this.confirmoCerrar = By.xpath("//*[@id=\"chrome-container\"]//input[contains(@value, \"Cerrar\")]");
	this.eliminarTabPermanente = By.xpath("//*[@class=\"delete-container\"]/a");
	this.confirmEliminar = By.xpath("//*[@id=\"chrome-container\"]//input[contains(@value, \"Eliminar\")]");
	this.volverInicio = By.xpath("//*[@id=\"header\"]//span[contains(@aria-label, \"HouseIcon\")]");
		
	}
	// Metodos

	public void creaUnaLista(String tituloParaLista, String subDir)
	{
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(seleccionarLista))).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {   
			e.printStackTrace();             
		}
		driver.findElement(anadeLista).click();
		driver.findElement(tituloLista).sendKeys(tituloParaLista);
		driver.findElement(incluirLista).click();
		Helper.addEvidence(TAKE_SS, driver, test, "Lista Creada", subDir, "creaUnaLista_01");	
	}

	public void edicionTarjeta(String descripcion, String subDir)
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {   
			e.printStackTrace();             
		}
		driver.findElement(seleccionarLista).click();
		driver.findElement(plusTarjeta).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {   
			e.printStackTrace();             
		}
		driver.findElement(introduzcaDescripcion).sendKeys(descripcion);
		driver.findElement(anadaTarjeta).click();
		Helper.addEvidence(TAKE_SS, driver, test, "Ingreso descripcion de la tarjeta", subDir, "edicionTarjeta_01");
		
	}
	
	public void detallesDeTarjeta(String detallesDescrip, String subDir, String introducirFechaVenci, String introducirHoraVenci, String adjuntoLink)
	{
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(seleccionarLista))).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {   
			e.printStackTrace();             
		}
		driver.findElement(clickDescripcion).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {   
			e.printStackTrace();             
		}
		
		driver.findElement(detallarMas).click();;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {   
			e.printStackTrace();             
		}
		driver.findElement(detallarMas).sendKeys(detallesDescrip);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {   
			e.printStackTrace();             
		}
		driver.findElement(etiquetas).click();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {   
			e.printStackTrace();             
		}
		driver.findElement(dataColor).click();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {   
			e.printStackTrace();             
		}
		driver.findElement(cierraEtiqueta).click();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {   
			e.printStackTrace();             
		}
		driver.findElement(vencimiento).click();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {   
			e.printStackTrace();             
		}
		driver.findElement(fechaVencimiento).clear();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {   
			e.printStackTrace();             
		}
		driver.findElement(fechaVencimiento).sendKeys(introducirFechaVenci);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {   
			e.printStackTrace();             
		}
		driver.findElement(guardarVenci).click();
		driver.findElement(adjunto).click();
		driver.findElement(linkAdjunto).sendKeys(adjuntoLink);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {   
			e.printStackTrace();             
		}
		driver.findElement(clickComentario).click();
		driver.findElement(guardarTodo).click();
		Helper.addEvidence(TAKE_SS, driver, test, "Detalles de la tarjeta", subDir, "detallesDeTarjeta_01");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {   
			e.printStackTrace();             
		}
		driver.findElement(cerrarTarjeta).click();	
	}
	
	public void crearMasListas(String nombreOtrasListas, String subDir)
	{
		driver.findElement(tituloLista).sendKeys(nombreOtrasListas);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {   
			e.printStackTrace();             
		}
		driver.findElement(incluirLista).click();
		Helper.addEvidence(TAKE_SS, driver, test, "Lista Creada", subDir, "crearMasListas_01");
		
	}
	
	public void cambiarTarjetaDeLista(String subDir)
	{
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(seleccionarLista))).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {   
			e.printStackTrace();             
		}
		driver.findElement(datosTarjeta).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {   
			e.printStackTrace();             
		}
		driver.findElement(opcionMover).click();
		Select lista = new Select(driver.findElement(listaMover));
		lista.selectByVisibleText("En proceso");
		driver.findElement(botonMover).click();
		driver.findElement(cerrarTarjeta).click();	
		Helper.addEvidence(TAKE_SS, driver, test, "Cambiar de tarjeta una lista", subDir, "cambiarTarjetaDeLista_01");
	}
	
	
	public void eliminaUnTablero(String subDir)
	{
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {   
			e.printStackTrace();             
		}
		driver.findElement(seleccionarLista).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {   
			e.printStackTrace();             
		}
		try {
			driver.findElement(mostrarMenu).click();
		} catch (Exception e) {
			System.out.println("Menú ya esta abierto");
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {   
			e.printStackTrace();             
		}
		driver.findElement(mostrarMas).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {   
			e.printStackTrace();             
		}
		
		driver.findElement(menuCerrarTablero).click();
		driver.findElement(confirmoCerrar).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {   
			e.printStackTrace();             
		}
		driver.findElement(eliminarTabPermanente).click();
		driver.findElement(confirmEliminar).click();
		driver.findElement(volverInicio).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {   
			e.printStackTrace();             
		}
		Helper.addEvidence(TAKE_SS, driver, test, "Eliminar el tablero", subDir, "eliminaUnTablero_01");
	}
	

}
