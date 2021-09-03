import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TesteAjax {
	private WebDriver driver;
	private DSL dsl;
	
	@Before
	public void inicializa() {
		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("https://www.primefaces.org/showcase/ui/ajax/basic.xhtml?jfwid=51189");
		dsl = new DSL(driver);
	}
	
	@After
	public void termina() {
//		driver.quit();
	}
	
	@Test
	public void testAjax() {
		dsl.escreve("j_idt303:name", "teste");
		dsl.clicaBotao("j_idt303:j_idt307");
		WebDriverWait wait =  new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.textToBe(By.id("j_idt303:display"), "teste"));
	//	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("IdDaImagemQueVaiSumir")));
		Assert.assertEquals("teste", dsl.obterTexto("j_idt303:display"));
	}
	

}
