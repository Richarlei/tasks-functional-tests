package br.ce.wcaquino.tasks.functional;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TasksTest {

	public WebDriver acessarAplicacao() throws MalformedURLException {
		//WebDriver driver = new ChromeDriver();
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		WebDriver driver = new RemoteWebDriver(new URL("http://10.4.0.57:4444/wd/hub"),cap);
		driver.navigate().to("http://10.4.0.57:8001/tasks/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
	}
	
	@Test
	public void deveSalvarTarefaComSucesso() throws MalformedURLException {
		WebDriver driver = acessarAplicacao();
		
		try {
		
		//clicar em Add Todo
		driver.findElement(By.id("addTodo")).click();
		
		//Escrever Descri��o
		driver.findElement(By.id("task")).sendKeys("Teste via Selenium");
		
		// Escrever a Data
		driver.findElement(By.id("dueDate")).sendKeys("10/10/2030");
		
		//Clicar e Salva
		driver.findElement(By.id("saveButton")).click();
		
		//Validar menssagem de sucesso
		String message = driver.findElement(By.id("message")).getText();
		Assert.assertEquals("Success!", message);
	} finally {
		
		//fechar o browser
		driver.quit();
	}
		
	}
	
	
	@Test
	public void deveSalvarTarefaSemDescricao() throws MalformedURLException {
		WebDriver driver = acessarAplicacao();
		
		try {
		
		//clicar em Add Todo
		driver.findElement(By.id("addTodo")).click();
		
		
		// Escrever a Data
		driver.findElement(By.id("dueDate")).sendKeys("10/10/2030");
		
		//Clicar e Salva
		driver.findElement(By.id("saveButton")).click();
		
		//Validar menssagem de sucesso
		String message = driver.findElement(By.id("message")).getText();
		Assert.assertEquals("Fill the task description", message);
	} finally {
		
		//fechar o browser
		driver.quit();
	}
		
	}
	
	
	
	@Test
	public void deveSalvarTarefaSemData() throws MalformedURLException {
		WebDriver driver = acessarAplicacao();
		
		try {
		
		//clicar em Add Todo
		driver.findElement(By.id("addTodo")).click();
		
		//Escrever Descri��o
		driver.findElement(By.id("task")).sendKeys("Teste via Selenium");
		
		//Clicar e Salva
		driver.findElement(By.id("saveButton")).click();
		
		//Validar menssagem de sucesso
		String message = driver.findElement(By.id("message")).getText();
		Assert.assertEquals("Fill the due date", message);
	} finally {
		
		//fechar o browser
		driver.quit();
	}
		
	}
	
	
	@Test
	public void deveSalvarTarefaComDataPassada() throws MalformedURLException {
		WebDriver driver = acessarAplicacao();
		
		try {
		
		//clicar em Add Todo
		driver.findElement(By.id("addTodo")).click();
		
		//Escrever Descri��o
		driver.findElement(By.id("task")).sendKeys("Teste via Selenium");
		
		// Escrever a Data
		driver.findElement(By.id("dueDate")).sendKeys("10/10/2010");
		
		//Clicar e Salva
		driver.findElement(By.id("saveButton")).click();
		
		//Validar menssagem de sucesso
		String message = driver.findElement(By.id("message")).getText();
		Assert.assertEquals("Due date must not be in past", message);
	} finally {
		
		//fechar o browser
		driver.quit();
	}
		
	}
	
}
