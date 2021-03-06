package br.ce.mgomes.test;
import static br.ce.mgomes.core.DriverFactory.getDriver;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ce.mgomes.core.BaseTest;
import br.ce.mgomes.page.CampoTreinamentoPage;

public class DesafioCadastro  extends BaseTest{
	
	private CampoTreinamentoPage page;
	
	@Before
	public void inicializa() {

		getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		page = new CampoTreinamentoPage();
	}
	
	
	@Test
	public void deveInteragirComCadastro() {
		page.setNome("Matheus");
		page.setSobrenome("Gomes");
		page.setSexoMasculino();	
		page.setComidaPizza();
		page.setEscolaridade("Doutorado");
		page.setEsporte("Natacao");
		page.setSugestao("uiuiui isso ? um teste");
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
