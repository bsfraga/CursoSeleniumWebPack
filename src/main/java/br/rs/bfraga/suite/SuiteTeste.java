package br.rs.bfraga.suite;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.rs.bfraga.core.DriverFactory;
import br.rs.bfraga.teste.DesafioTesteCadastro;
import br.rs.bfraga.teste.TesteDeRegraCadastro;

/*
 * Classe que gerencia a ordem
 * e quais testes devem ser
 * executados
 */

@RunWith(Suite.class)
@SuiteClasses({
	DesafioTesteCadastro.class,
	TesteDeRegraCadastro.class
})
public class SuiteTeste {

	@AfterClass
	public static void finalizarBrowser() {
		DriverFactory.killDriver();
	}
	
	
}
