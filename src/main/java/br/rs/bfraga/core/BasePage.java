package br.rs.bfraga.core;

/*
 * Comportamento gen�rico que ser� herdado
 * entre todas as Pages
 */

public class BasePage {

	protected DSL dsl;
	
	public BasePage() {
		dsl = new DSL();
	}
	
}
