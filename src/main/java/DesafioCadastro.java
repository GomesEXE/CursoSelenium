import static br.ce.mgomes.core.DriverFactory.getDriver;
import static br.ce.mgomes.core.DriverFactory.killDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DesafioCadastro {
	
	private CampoTreinamentoPage page;
	
	@Before
	public void inicializa() {

		getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		page = new CampoTreinamentoPage();
	}
	
	@After
	public void termina() {
		killDriver();
	}
	
	@Test
	public void deveInteragirComCadastro() {
		page.setNome("Matheus");
		page.setSobrenome("Gomes");
		page.setSexoMasculino();	
		page.setComidaPizza();
		page.setEscolaridade("Doutorado");
		page.setEsporte("Natacao");
		page.setSugestao("uiuiui isso é um teste");
		page.cadastrar();
		
		Assert.assertEquals("Cadastrado!", page.obterResultadoCadastro());
		Assert.assertEquals("Matheus", page.obterNomeCadastro());
		Assert.assertEquals("Gomes", page.obterSobrenomeCadastro());
		Assert.assertEquals("Masculino", page.obterSexoCadastro());
		Assert.assertEquals("Pizza", page.obterComidaCadastro());
		Assert.assertEquals("doutorado", page.obterEscolaridadeCadastro());
		Assert.assertEquals("Natacao", page.obterEsporteCadastro());	
	}
	
}
