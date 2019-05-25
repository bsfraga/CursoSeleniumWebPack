package br.rs.bfraga.core;

/*
 * Comportamento genérico que será herdado
 * entre todas as Pages
 */

public class BasePage {

	protected DSL dsl;
	
	public BasePage() {
		dsl = new DSL();
	}
	
}
