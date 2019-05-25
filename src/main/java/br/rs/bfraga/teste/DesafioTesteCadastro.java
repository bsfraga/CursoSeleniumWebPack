package br.rs.bfraga.teste;
import static br.rs.bfraga.core.DriverFactory.getDriver;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.rs.bfraga.core.BaseTeste;
import br.rs.bfraga.page.CampoTreinamentoPage;

public class DesafioTesteCadastro extends BaseTeste {

	private CampoTreinamentoPage page;
	
	@Before
	public void inicializar() {
		
		getDriver().get("C:\\Users\\Bruno Fraga\\Documents\\Selenium WebDriver\\Teste\\componentes.html");
		page = new CampoTreinamentoPage();
	}
	

	
	@Test
	public void realizarCadastroComSucesso(){
		
		page.setNome("Bruno");
		page.setSobrenome("Fraga");
		page.setSexoMasculino();
		page.setComidaPizza();
		page.setEscolaridade("Superior");
		page.setEsporte("Corrida");
		page.cadastrar();
		
		Assert.assertTrue(page.obterResultadoCadastrado().startsWith("Cadastrado!"));
		Assert.assertTrue(page.obterNomeCadastrado().endsWith("Bruno"));
		Assert.assertEquals(page.obterSobrenomeCadastrado(), "Sobrenome: Fraga");
		Assert.assertEquals(page.obterSexoCadastrado(), "Sexo: Masculino");
		Assert.assertEquals(page.obterComidaCadastrado(), "Comida: Pizza");
		Assert.assertEquals(page.obterEscolaridadeCadastrado(), "Escolaridade: superior");
		Assert.assertEquals(page.obterEsportesCadastrado(), "Esportes: Corrida");
		
	}
	
	
}
