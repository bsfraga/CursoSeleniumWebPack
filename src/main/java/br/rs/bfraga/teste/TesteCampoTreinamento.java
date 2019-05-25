package br.rs.bfraga.teste;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.rs.bfraga.core.DSL;
/*
 * 
 * TESTE NAO FUNCIONANDO
 * 
 * criar instancia de DSL
 * modificar testes com padrões de métodos DSL
 * 
 * 
 */
public class TesteCampoTreinamento {

	private WebDriver driver;
	private DSL dsl;
	
	@Before
	public void inicializar() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bruno Fraga\\Documents\\Selenium WebDriver\\chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("C:\\Users\\Bruno Fraga\\Documents\\Selenium WebDriver\\Teste\\componentes.html");

	}

	@After
	public void finalizar() {
		driver.quit();
	}
	
	@Test
	public void testeCampoTreinamento() {
		
		dsl.escrever("elementosForm:nome", "teste");
		
		Assert.assertEquals("teste", dsl.obterValorCampo("elementosForm:nome"));

	}
	
	@Test
	public void interagirComTextArea() {
		
		dsl.escrever("elementosForm:sugestoes", "teste\nteste\nTeste");
		Assert.assertEquals("teste\nteste\nTeste", dsl.obterValorCampo("elementosForm:sugestoes"));
	}
	
	@Test
	public void interagirComRadioButton() {
		
		dsl.clicarRadioButton("elementosForm:sexo:0");
		Assert.assertTrue(dsl.verificaRadioMarcado("elementosForm:sexo:0"));

	}
	
	@Test
	public void interagirComCheckBox() {
		
		dsl.clicarCheckBoxs("elementosForm:comidaFavorita:2");
		Assert.assertTrue(dsl.verificaCheckMarcado("elementosForm:comidaFavorita:2"));
	}
	
	@Test
	public void interagirComComboBox() {
		
		dsl.selecionarCombo("elementosForm:escolaridade", "Superior");
		Assert.assertEquals("superior", dsl.obterValorCombo("elementosForm:escolaridade"));

	}
	
	@Test
	public void verificarValoresCombo() {
		
		Assert.assertEquals(8, dsl.obterValoresCombo("elementosForm:escolaridade"));
		Assert.assertTrue(dsl.verificarOpcaoCombo("elementosForm:escolaridade", "superior"));

	}
	
	@Test
	public void verificarValoresComboMultiplo() {
		dsl.obterValoresCombo("elementosForm:esportes");
		dsl.selecionarCombo("elementosForm:esportes", "Corrida");
		dsl.selecionarCombo("elementosForm:esportes", "Natacao");
		dsl.selecionarCombo("elementosForm:esportes", "O que eh esporte?");
		
		dsl.verificarOpcaoCombo("elementosForm:esportes", "Corrida");
		dsl.verificarOpcaoCombo("elementosForm:esportes", "Natacao");
		dsl.verificarOpcaoCombo("elementosForm:esportes", "O que eh esporte?");
		
		Assert.assertTrue(dsl.verificarOpcaoCombo("elementosForm:esportes", "Corrida"));
		Assert.assertTrue(dsl.verificarOpcaoCombo("elementosForm:esportes", "Natacao"));
		Assert.assertTrue(dsl.verificarOpcaoCombo("elementosForm:esportes", "O que eh esporte?"));
		
		dsl.desmarcarCombo("elementosForm:esportes", "Natacao?");
		dsl.desmarcarCombo("elementosForm:esportes", "O que eh esporte?");
		
	}
	
	@Test
	public void interagirComBotoes() {
		
		dsl.clicarBotão("buttonSimple");
		Assert.assertEquals("Obrigado!", dsl.obterValueElemento("buttonSimple"));

	}
	
	@Test
	public void testaLinks() {
		
		dsl.clicarLink("Voltar");
		Assert.assertEquals("Voltou!", dsl.obterTexto("resultado"));
	}
	
	@Test
	public void buscarTextoNaPagina() {

		dsl.obterTextoPeloElemento(By.tagName(("body")));
		Assert.assertTrue(dsl.obterTextoPeloElemento(By.tagName(("body"))).contains("Campo de Treinamento"));
		
	}
	
}
