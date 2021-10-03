package br.ce.mgomes.test;
import static br.ce.mgomes.core.DriverFactory.getDriver;
import static br.ce.mgomes.core.DriverFactory.killDriver;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.ce.mgomes.core.DSL;

public class TesteSincronismo {
	
	private DSL dsl;
	
	@Before
	public void inicializa() {
		getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL();
	}
	
	@After
	public void finaliza() {
		killDriver();
	}
	
	@Test 
	public void deveUltilizarEsperaFixa() throws InterruptedException {
		dsl.clicaBotao("buttonDelay");
		Thread.sleep(5000);
		dsl.escreve("novoCampo", "Deu Certo");
	}
	
	@Test 
	public void deveUltilizarEsperaImplicita() throws InterruptedException {
		getDriver().manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		dsl.clicaBotao("buttonDelay");
		dsl.escreve("novoCampo", "Deu Certo");
		getDriver().manage().timeouts().implicitlyWait(0,TimeUnit.SECONDS);
	}
	
	@Test 
	public void deveUltilizarEsperaExplicita() throws InterruptedException {
		dsl.clicaBotao("buttonDelay");
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("novoCampo")));
		dsl.escreve("novoCampo", "Deu Certo");
	}
	

}
