import static br.ce.mgomes.core.DriverFactory.getDriver;
import static br.ce.mgomes.core.DriverFactory.killDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import br.ce.mgomes.core.DSL;

public class TestePrime {
	
	private DSL dsl;
	
	@Before
	public void inicializa() {
		dsl = new DSL();
	}
	
	@After
	public void finaliza() {
		killDriver();
	}
	
	@Test
	public void deveInteragirComRadioPrime() {
		getDriver().get("https://www.primefaces.org/showcase/ui/input/oneRadio.xhtml?jfwid=9c29c");
		dsl.clicaRadio(By.xpath("//input[@id='j_idt303:console:0']/../..//span"));
		Assert.assertTrue(dsl.isRadioMarcado("j_idt303:console:0"));
		dsl.clicaRadio(By.xpath("//label[.='Option2']/..//span"));
		Assert.assertTrue(dsl.isRadioMarcado("j_idt303:console:1"));
	}
	
	@Test
	public void deveInteragirComSelctPrime() {
		getDriver().get("https://www.primefaces.org/showcase/ui/input/oneMenu.xhtml?jfwid=00851");
		dsl.selecionaComboPrime("j_idt302:option", "Option1");
		Assert.assertEquals("Option1", dsl.obterTexto("j_idt302:option_label"));
	}
}
