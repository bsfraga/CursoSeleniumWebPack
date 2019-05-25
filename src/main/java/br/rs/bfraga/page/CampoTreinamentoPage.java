package br.rs.bfraga.page;
import br.rs.bfraga.core.BasePage;

public class CampoTreinamentoPage extends BasePage{
	
	public void setNome(String nome) {
		dsl.escrever("elementosForm:nome", nome);
	}
	
	public void setSobrenome(String sobrenome) {
		dsl.escrever("elementosForm:sobrenome", sobrenome);
	}
	
	public void setSexoMasculino() {
		dsl.clicarRadioButton("elementosForm:sexo:0");
	}
	
	public void setSexoFeminino() {
		dsl.clicarRadioButton("elementosForm:sexo:1");
	}
	
	public void setComidaCarne() {
		dsl.clicarCheckBoxs("elementosForm:comidaFavorita:0");
	}
	
	public void setComidaFrango() {
		dsl.clicarCheckBoxs("elementosForm:comidaFavorita:1");
	}
	
	public void setComidaPizza() {
		dsl.clicarCheckBoxs("elementosForm:comidaFavorita:2");
	}
	
	public void setComidaVegetariano() {
		dsl.clicarCheckBoxs("elementosForm:comidaFavorita:3");
	}
	
	public void setEscolaridade(String escolaridade) {
		dsl.selecionarCombo("elementosForm:escolaridade", escolaridade);
	}
	public void setEsporte(String... esportes) {
		
		for (String esporte: esportes) {
			dsl.selecionarCombo("elementosForm:esportes", esporte);
		}
		
	}
	//------------- Botão Cadastrar -----------//
	
	public void cadastrar() {
		dsl.clicarBotão("elementosForm:cadastrar");
	}
	
	//-------------	ASSERTS ----------------/
	public String obterResultadoCadastrado() {
		return dsl.obterTexto("resultado");
	}
	
	public String obterNomeCadastrado() {
		return dsl.obterTexto("descNome");
	}
	
	public String obterSobrenomeCadastrado () {
		return dsl.obterTexto("descSobrenome");
	}
	
	public String obterSexoCadastrado () {
		return dsl.obterTexto("descSexo");
	}
	
	public String obterComidaCadastrado () {
		return dsl.obterTexto("descComida");
	}
	
	public String obterEscolaridadeCadastrado () {
		return dsl.obterTexto("descEscolaridade");
	}
	
	public String obterEsportesCadastrado () {
		return dsl.obterTexto("descEsportes");
	}

	
}
