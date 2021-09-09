import static br.ce.mgomes.core.DriverFactory.getDriver;
import static br.ce.mgomes.core.DriverFactory.killDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.ce.mgomes.core.DSL;

public class TesteAjax {
	private DSL dsl;
	
	@Before
	public void inicializa() {
		getDriver().get("https://www.primefaces.org/showcase/ui/ajax/basic.xhtml?jfwid=51189");
		dsl = new DSL();
	}
	
	@After
	public void termina() {
		killDriver();
	}
	
	@Test
	public void testAjax() {
		dsl.escreve("j_idt303:name", "teste");
		dsl.clicaBotao("j_idt303:j_idt307");
		WebDriverWait wait =  new WebDriverWait(getDriver(), 30);
		wait.until(ExpectedConditions.textToBe(By.id("j_idt303:display"), "teste"));
	//	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("IdDaImagemQueVaiSumir")));
		Assert.assertEquals("teste", dsl.obterTexto("j_idt303:display"));
	}
	

}
