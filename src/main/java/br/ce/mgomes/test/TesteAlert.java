package br.ce.mgomes.test;
import static br.ce.mgomes.core.DriverFactory.getDriver;
import static br.ce.mgomes.core.DriverFactory.killDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;

import br.ce.mgomes.core.DSL;

public class TesteAlert {
	
	private DSL dsl;
	
	@Before
	public void inicializa() {
		getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL();
	}
	
	@After
	public void termina() {
		killDriver();;
	}
	
	@Test
	public void deveInteragirComAlertSimples() {
		dsl.clicaBotao("alert");
		Alert alert = getDriver().switchTo().alert();
		String texto = alert.getText();
		Assert.assertEquals("Alert Simples", texto);
		alert.accept(); 
		
		dsl.escreve("elementosForm:nome", texto);
	}
	
	@Test
	public void deveInteragirComAlertConfirm() {
		dsl.clicaBotao("confirm");
		Assert.assertEquals("Confirm Simples", dsl.alertaObterTextoEAceita());
		Assert.assertEquals("Confirmado", dsl.alertaObterTextoEAceita());

		
		dsl.clicaBotao("confirm");
		Assert.assertEquals("Confirm Simples", dsl.alertaObterTextoENega());
		Assert.assertEquals("Negado", dsl.alertaObterTextoENega());
	}
	
	@Test
	public void deveInteragirComAlertPrompt() {
		dsl.clicaBotao("prompt");
		Assert.assertEquals("Digite um numero", dsl.alertaObterTexto());
		dsl.alertaEscrever("12");
		Assert.assertEquals("Era 12?", dsl.alertaObterTextoEAceita());
		Assert.assertEquals(":D", dsl.alertaObterTextoEAceita());
	}

}
