import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestePrime {
	
	private WebDriver driver;
	private DSL dsl;
	
	@Before
	public void inicializa() {
		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		dsl = new DSL(driver);
	}
	
	@After
	public void finaliza() {
//		driver.quit();
	}
	
	@Test
	public void deveInteragirComRadioPrime() {
		driver.get("https://www.primefaces.org/showcase/ui/input/oneRadio.xhtml?jfwid=9c29c");
		dsl.clicaRadio(By.xpath("//input[@id='j_idt303:console:0']/../..//span"));
		Assert.assertTrue(dsl.isRadioMarcado("j_idt303:console:0"));
		dsl.clicaRadio(By.xpath("//label[.='Option2']/..//span"));
		Assert.assertTrue(dsl.isRadioMarcado("j_idt303:console:1"));
	}
	
	@Test
	public void deveInteragirComSelctPrime() {
		driver.get("https://www.primefaces.org/showcase/ui/input/oneMenu.xhtml?jfwid=00851");
		dsl.selecionaComboPrime("j_idt302:option", "Option1");
		Assert.assertEquals("Option1", dsl.obterTexto("j_idt302:option_label"));
	}
}
