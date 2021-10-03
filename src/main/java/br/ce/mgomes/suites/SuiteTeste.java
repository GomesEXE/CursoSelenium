package br.ce.mgomes.suites;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.ce.mgomes.core.DriverFactory;
import br.ce.mgomes.test.DesafioCadastro;
import br.ce.mgomes.test.TesteCampoTreinamento;
import br.ce.mgomes.test.TesteRegrasCadastro;

@RunWith(Suite.class)
@SuiteClasses({
	DesafioCadastro.class,
	TesteRegrasCadastro.class,
})

public class SuiteTeste {
	
	@AfterClass
	public static void finalizaTudo() {
		DriverFactory.killDriver();
	}

}
