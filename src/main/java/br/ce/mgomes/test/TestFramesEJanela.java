package br.ce.mgomes.test;
import static br.ce.mgomes.core.DriverFactory.getDriver;
import static br.ce.mgomes.core.DriverFactory.killDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.ce.mgomes.core.DSL;

public class TestFramesEJanela {
	
	private DSL dsl;

	
	@Before
	public void inicializa() {
		getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL();
	}
	
	@After
	public void termina() {
		killDriver();
	}
	
	@Test
	public void deveInteragirComFrames() {
		dsl.entrarFrame("frame1");
		dsl.clicaBotao("frameButton");
		String msg = dsl.alertaObterTextoEAceita();
		Assert.assertEquals("Frame OK!", msg);
		
		dsl.sairFrame();
		dsl.escreve("elementosForm:nome", msg);
	}
	
	@Test
	public void deveInteragirComFrameEscondido() {
		WebElement frame = getDriver().findElement(By.id("frame2"));
		dsl.executarJS("window.scrollBy(0, arguments[0])", frame.getLocation().y);
		dsl.entrarFrame("frame2");
		dsl.clicaBotao("frameButton");
		String msg = dsl.alertaObterTextoEAceita();
		Assert.assertEquals("Frame OK!", msg);
	}
	
	@Test
	public void deveInteragirComJanelas() {		
		dsl.clicaBotao("buttonPopUpEasy");
		dsl.trocarJanela("Popup");
		dsl.escreve(By.tagName("textarea"), "Deu certo?");
		getDriver().close();
		dsl.trocarJanela("");
		dsl.escreve(By.tagName("textarea"), "e agora?");
	}
	
	@Test
	public void deveInteragirComJanelasSemTitulo() {
		dsl.clicaBotao("buttonPopUpHard");
		System.out.println(getDriver().getWindowHandle());
		System.out.println(getDriver().getWindowHandles());
		dsl.trocarJanela((String) getDriver().getWindowHandles().toArray()[1]);
		dsl.escreve(By.tagName("textarea"), "Deu certo?");
		dsl.trocarJanela((String) getDriver().getWindowHandles().toArray()[0]);
		dsl.escreve(By.tagName("textarea"), "e agora?");
	}

}
