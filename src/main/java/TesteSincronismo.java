import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TesteSincronismo {
	
	private WebDriver driver;
	private DSL dsl;
	
	@Before
	public void inicializa() {
		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL(driver);
	}
	
	@After
	public void finaliza() {
		driver.quit();
	}
	
	@Test 
	public void deveUltilizarEsperaFixa() throws InterruptedException {
		dsl.clicaBotao("buttonDelay");
		Thread.sleep(5000);
		dsl.escreve("novoCampo", "Deu Certo");
	}
	
	@Test 
	public void deveUltilizarEsperaImplicita() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		dsl.clicaBotao("buttonDelay");
		dsl.escreve("novoCampo", "Deu Certo");
		driver.manage().timeouts().implicitlyWait(0,TimeUnit.SECONDS);
	}
	
	@Test 
	public void deveUltilizarEsperaExplicita() throws InterruptedException {
		dsl.clicaBotao("buttonDelay");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("novoCampo")));
		dsl.escreve("novoCampo", "Deu Certo");
	}
	

}
