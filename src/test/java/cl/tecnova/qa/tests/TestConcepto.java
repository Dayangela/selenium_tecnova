package cl.tecnova.qa.tests;

import java.io.File;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cl.tecnova.qa.helpers.Helper;
import cl.tecnova.qa.pages.LoginPage;
import cl.tecnova.qa.pages.CloseSessionPage;
import cl.tecnova.qa.pages.CrearTableroPage;
import cl.tecnova.qa.pages.InicioPage;
import cl.tecnova.qa.pages.ListWorkPage;


public class TestConcepto {
	private WebDriver driver;
	private ExtentReports extent;
	private ExtentTest test;
	private String SUBDIR = "AmbienteBase\\";
	private static Boolean TAKE_SS = true;
	private static int WAITING = 10;

	@BeforeSuite
	public void configExtentReports() {
		// ExtentReports config
		this.extent = new ExtentReports("ExtentReports/FinalCurso.html", true);
		this.extent.addSystemInfo("Host Name", "Tecnova Soluciones Informaticas SA");
		this.extent.addSystemInfo("Enviroment", "Automation Testing");
		this.extent.addSystemInfo("User Name", "Dayangela Ortega");
        //llamada a objeto de configuracion de Extent report
		File conf = new File("src/test/resources/extentReports/" + "extent-config.xml");
		this.extent.loadConfig(conf);
	}

	@BeforeMethod
	@Parameters({ "URL_PRINCIPAL" })
	public void configSelenium(String URL_PRINCIPAL) {
		// Selenium config
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("Empresa", "Tecnova");
		System.setProperty("webdriver.chrome.driver", "DRIVERS/chromedriver.exe");
		Helper.robotMoveMouse(2000, 2000);
		driver = new ChromeDriver();
		//Implicit Waits No usar si se estan usando explicit wait
		driver.manage().timeouts().implicitlyWait(WAITING, TimeUnit.SECONDS);
		//Maximisar Ventana
		driver.manage().window().maximize();
		//Navegar a url principal
		driver.navigate().to(URL_PRINCIPAL);
		
	}


	@Test //1 Login Correcto
	public void loginUsuario() {
		String subDir = SUBDIR + Thread.currentThread().getStackTrace()[1].getMethodName();
		test = extent.startTest("Prueba Login Usuario", "Prueba Login Usuario");
		test.log(LogStatus.INFO, "Prueba Login Usuario");
		InicioPage inicio = new InicioPage(driver, test, TAKE_SS, 20);
		LoginPage login = new LoginPage(driver, test, TAKE_SS, 20);
		CloseSessionPage close = new CloseSessionPage(driver, test, TAKE_SS, 2);
		inicio.iniciarSesion();
		login.loginMail("dayort212@gmail.com");
		login.loginPass("PruebaSelenium2020", subDir);
		login.assertIngreso("Tableros", subDir);
		close.finSession();	
	}
	
	
	@Test //2 Login Incorrecto
	public void loginPassIncorrecto() {
	String subDir = SUBDIR + Thread.currentThread().getStackTrace()[1].getMethodName();
	test = extent.startTest("Prueba Login Usuario Incorrecto", "Prueba Login Usuario Incorrecto");
	test.log(LogStatus.INFO, "Prueba Login Usuario Incorrecto");
	InicioPage inicio = new InicioPage(driver, test, TAKE_SS, 20);
	LoginPage login = new LoginPage(driver, test, TAKE_SS, 20);
	inicio.iniciarSesion();
	login.loginMail("dayort212@gmail.com");
	login.loginPassIncorrecto("PruebaSelenium2021", subDir);
	}
	
	
	@Test //3 Crear Tablero
	public void creacionTablero() {
	String subDir = SUBDIR + Thread.currentThread().getStackTrace()[1].getMethodName();
	test = extent.startTest("Prueba Crear Tablero", "Prueba Crear Tablero");
	test.log(LogStatus.INFO, "Prueba Crear Tablero");
	InicioPage inicio = new InicioPage(driver, test, TAKE_SS, 20);
	LoginPage login = new LoginPage(driver, test, TAKE_SS, 20);
	CrearTableroPage tablero = new CrearTableroPage(driver, test, TAKE_SS, 5);
	CloseSessionPage close = new CloseSessionPage(driver, test, TAKE_SS, 2);
	inicio.iniciarSesion();
	login.loginMail("dayort212@gmail.com");
	login.loginPassIncorrecto("PruebaSelenium2020", subDir);
	tablero.createTab(subDir, "Dayangela Ortega");
	close.finSession();
	}
	
	
	@Test //4 Crear Lista
	public void crearListaEnTablero() {
	String subDir = SUBDIR + Thread.currentThread().getStackTrace()[1].getMethodName();
	test = extent.startTest("Prueba Crear Lista", "Prueba Crear Lista");
	test.log(LogStatus.INFO, "Prueba crear lista descriptiva dentro del tablero");
	InicioPage inicio = new InicioPage(driver, test, TAKE_SS, 20);
	LoginPage login = new LoginPage(driver, test, TAKE_SS, 20);
	ListWorkPage list = new ListWorkPage(driver, test, TAKE_SS, 10);
	CloseSessionPage close = new CloseSessionPage(driver, test, TAKE_SS, 2);
	inicio.iniciarSesion();
	login.loginMail("dayort212@gmail.com");
	login.loginPassIncorrecto("PruebaSelenium2020", subDir);
	list.edicionTarjeta("Esta es la tarjeta de la lista final, creamos la descripcion", subDir);
	close.finSession();
	}
	
	
	@Test //5 Editar Tarjeta de la Lista
	public void editarTarjeta() {
	String subDir = SUBDIR + Thread.currentThread().getStackTrace()[1].getMethodName();
	test = extent.startTest("Prueba Editar Tarjeta", "Prueba Editar Tarjeta");
	test.log(LogStatus.INFO, "Prueba editar tarjeta de la lista creada");
	InicioPage inicio = new InicioPage(driver, test, TAKE_SS, 20);
	LoginPage login = new LoginPage(driver, test, TAKE_SS, 20);
	ListWorkPage list = new ListWorkPage(driver, test, TAKE_SS, 10);
	CloseSessionPage close = new CloseSessionPage(driver, test, TAKE_SS, 2);
	inicio.iniciarSesion();
	login.loginMail("dayort212@gmail.com");
	login.loginPassIncorrecto("PruebaSelenium2020", subDir);
	list.detallesDeTarjeta("Este contiene la prueba final, es importante que sea exitosa", subDir,"31/12/2020","12:00","C:\\Users\\tecnova\\Desktop\\Selenium_Java\\Prueba_Final_Dayangela\\Logo_Tarjeta.jpg");
	close.finSession();
	}
	
	@Test //6 Mover tarjeta a otra lista
	public void moverTarjeta() {
	String subDir = SUBDIR + Thread.currentThread().getStackTrace()[1].getMethodName();
	test = extent.startTest("Prueba Mover Tarjeta", "Prueba Mover Tarjeta");
	test.log(LogStatus.INFO, "Prueba mover tarjeta a otra lista");
	InicioPage inicio = new InicioPage(driver, test, TAKE_SS, 20);
	LoginPage login = new LoginPage(driver, test, TAKE_SS, 20);
	ListWorkPage list = new ListWorkPage(driver, test, TAKE_SS, 10);
	CloseSessionPage close = new CloseSessionPage(driver, test, TAKE_SS, 2);
	inicio.iniciarSesion();
	login.loginMail("dayort212@gmail.com");
	login.loginPassIncorrecto("PruebaSelenium2020", subDir);
	list.cambiarTarjetaDeLista(subDir);
	close.finSession();
	}
	
	@Test //7 Eliminar el Tablero
	public void eliminarTablero() {
	String subDir = SUBDIR + Thread.currentThread().getStackTrace()[1].getMethodName();
	test = extent.startTest("Prueba Eliminar Tablero", "Prueba Eliminar Tablero");
	test.log(LogStatus.INFO, "Prueba eliminar tablero");
	InicioPage inicio = new InicioPage(driver, test, TAKE_SS, 20);
	LoginPage login = new LoginPage(driver, test, TAKE_SS, 20);
	ListWorkPage list = new ListWorkPage(driver, test, TAKE_SS, 10);
	CloseSessionPage close = new CloseSessionPage(driver, test, TAKE_SS, 2);
	inicio.iniciarSesion();
	login.loginMail("dayort212@gmail.com");
	login.loginPassIncorrecto("PruebaSelenium2020", subDir);
	list.eliminaUnTablero(subDir);
	close.finSession();
	}
	
	
	@AfterMethod
	public void afterMethod(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.FAIL, "Test failed.- <br>" + result.getThrowable());
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.SKIP, "Test skipped.- <br>" + result.getThrowable());
		} else {
			test.log(LogStatus.PASS, "Test passed.-");
		}
		driver.close();
		extent.endTest(test);
	}

	@AfterSuite
	public void closeExtentReports() {
		// Escribimos los datos al reporte.
		extent.flush();
	}
}
