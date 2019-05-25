package br.rs.bfraga.teste;
import static br.rs.bfraga.core.DriverFactory.getDriver;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import br.rs.bfraga.core.BaseTeste;
import br.rs.bfraga.core.DSL;
import br.rs.bfraga.page.CampoTreinamentoPage;

@RunWith(Parameterized.class)
public class TesteDeRegraCadastro extends BaseTeste{

	private DSL dsl;
	private CampoTreinamentoPage page;
	
	/*
	 * Declaração de Ordem dos parâmetros
	 */
	@Parameter
	public String nome;
	@Parameter(value=1)
	public String sobrenome;
	@Parameter(value=2)
	public Object sexo;
	@Parameter(value=3)
	public List<String> comidas;
	@Parameter(value=4)
	public String[] esportes;
	@Parameter(value=5)
	public String msg;
	
	@Before
	public void inicializar() {
		
		getDriver().get("C:\\Users\\Bruno Fraga\\Documents\\Selenium WebDriver\\Teste\\componentes.html");
		dsl = new DSL();
		page = new CampoTreinamentoPage();
	}
	

	
	/*
	 * Método que informa os parâmetros para
	 * método genérico de inserção
	 */
	
	@Parameters
	public static Collection<Object[]> getCollection(){
		return Arrays.asList(new Object[][]{
			{"", "", "", Arrays.asList(), new String[]{}, "Nome eh obrigatorio"},
			{"nomeTeste", "", "", Arrays.asList(), new String[]{}, "Sobrenome eh obrigatorio"},
			{"nomeTeste", "sobrenomeTeste", "", Arrays.asList(), new String[]{}, "Sexo eh obrigatorio"},
			{"nomeTeste", "sobrenomeTeste", "Masculino", Arrays.asList("Carne", "Vegetariano"), new String[]{}, "Tem certeza que voce eh vegetariano?"},
			{"nomeTeste", "sobrenomeTeste", "Masculino", Arrays.asList("Carne"), new String[]{"Corrida", "O que eh esporte?"}, "Voce faz esporte ou nao?"}	
		});
		
			
	}
	
	@Test
	public void validarRegrasDeNegocio () {
		
		page.setNome(nome);
		page.setSobrenome(sobrenome);
		
		if(sexo.equals("Masculino")) page.setSexoMasculino();
		if(sexo.equals("Feminino"))  page.setSexoFeminino();
		if(comidas.contains("Carne")) page.setComidaCarne();
		if(comidas.contains("Frango")) page.setComidaFrango();
		if(comidas.contains("Vegetariano")) page.setComidaVegetariano();
		page.setEsporte(esportes);
		page.cadastrar();
		
		Assert.assertEquals(msg, dsl.obterTextoAceitaAlerta());
		
	}
	
}
