package br.rs.bfraga.core;

public class Propriedades {

	/*
	 * Define se o browser ser� fechado ap�s a execu��o de um teste
	 */
	public static boolean FECHAR_BROWSER = false;
	
	/*
	 * Define qual browser dever� executar os testes
	 */
	public static Browsers browser = Browsers.CHROME;
	
	/*
	 * enumera browsers que podem rodar o teste (browsers contidos na maquina)
	 */
	public enum Browsers{
		CHROME,
		FIREFOX
	}
	
}
