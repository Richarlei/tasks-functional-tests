package br.ce.wcaquino.tasks.functional;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TasksTest {

	public WebDriver acessarAplicacao() {
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://localhost:8001/tasks/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
	}
	
	@Test
	public void deveSalvarTarefaComSucesso() {
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
	public void deveSalvarTarefaSemDescricao() {
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
	public void deveSalvarTarefaSemData() {
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
	public void deveSalvarTarefaComDataPassada() {
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
