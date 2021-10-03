package br.ce.mgomes.core;

import static br.ce.mgomes.core.DriverFactory.killDriver;

import org.junit.After;

public class BaseTest {
	
	@After
	public void termina() {
		if(Propriedades.FECHAR_BROWSER) {
			killDriver();
		}
	}

}
