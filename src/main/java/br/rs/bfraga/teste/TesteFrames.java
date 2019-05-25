package br.rs.bfraga.teste;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.rs.bfraga.core.DSL;

public class TesteFrames {

	private WebDriver driver;
	private DSL dsl;
	
	@Before
	public void inicializar() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bruno Fraga\\Documents\\Selenium WebDriver\\chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("C:\\Users\\Bruno Fraga\\Documents\\Selenium WebDriver\\Teste\\componentes.html");
		dsl = new DSL();
	}
	
	@After
	public void finalizar() {
		driver.quit();
	}
	
	@Test
	public void interagirComFrame() {

		dsl.entrarFrame("frame1");
		dsl.clicarBotão("frameButton");
		String msg = dsl.obterTextoAceitaAlerta();
		dsl.entrarSair();
		dsl.escrever("elementosForm:nome", msg);
		
	
	}
	
	@Test
	public void interagirComJanela() {
		/*
		 * Procura elementos por tagName
		 */
		
		dsl.clicarBotão("buttonPopUpEasy");
		dsl.trocarJanela("Popup");
		dsl.escrever(By.tagName("textarea"), "Teste");
		dsl.fecharJanela();
		dsl.trocarJanela("");
		dsl.escrever(By.tagName("textarea"), "Teste");

	}
	
	@Test
	public void interagirComJanelaSemTitulo() {
		/*
		 * getWindowHandle()
		 * getWindowHandles()
		 * Métodos que gerenciam as janelas que estão sendo
		 * abertas durante o teste
		 */
		
		driver.findElement(By.id("buttonPopUpHard")).click();
		driver.switchTo().window((String) driver.getWindowHandles().toArray()[1]);
		driver.findElement(By.tagName("textarea")).sendKeys("Teste");
		driver.switchTo().window((String) driver.getWindowHandles().toArray()[0]);
		driver.findElement(By.tagName("textarea")).sendKeys("Testando de novo");;
	}
	
}
