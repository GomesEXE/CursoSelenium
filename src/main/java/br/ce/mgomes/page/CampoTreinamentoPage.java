package br.ce.mgomes.page;
import org.openqa.selenium.By;

import br.ce.mgomes.core.BasePage;

public class CampoTreinamentoPage extends BasePage {

	public void setNome(String nome) {
		dsl.escreve("elementosForm:nome", nome);
	}
	
	public void setSobrenome(String sobrenome) {
		dsl.escreve("elementosForm:sobrenome", sobrenome);
	}
	
	public void setSexoMasculino() {
		dsl.clicaRadio("elementosForm:sexo:0");	
	}
	
	public void setSexoFeminino() {
		dsl.clicaRadio("elementosForm:sexo:1");	
	}
	
	public void setComidaCarne() {
		dsl.clicaRadio("elementosForm:comidaFavorita:0");
	}
	
	public void setComidaPizza() {
		dsl.clicaRadio("elementosForm:comidaFavorita:2");
	}
	
	public void setComidaVegeteriana() {
		dsl.clicaRadio("elementosForm:comidaFavorita:3");
	}
	
	public void setEscolaridade(String valor) {
		dsl.selecionarCombo("elementosForm:escolaridade", valor);
	}
	
	public void setEsporte(String... valores) {
		for(String valor: valores)
			dsl.selecionarCombo("elementosForm:esportes", valor); 
	}
	
	public void setSugestao(String textoSugestao) {
		dsl.escreve("elementosForm:sugestoes", textoSugestao);
	}
	
	public void cadastrar() {
		dsl.clicaBotao("elementosForm:cadastrar");
	}
	
	public String obterResultadoCadastro() {
		return dsl.obterTexto(By.xpath("//*[@id='resultado']/span"));
	}
	
	public String obterNomeCadastro() {
		return dsl.obterTexto(By.xpath("//*[@id='descNome']/span"));
		
	}
	
	public String obterSobrenomeCadastro() {
		return dsl.obterTexto(By.xpath("//*[@id='descSobrenome']/span"));
	}
	
	public String obterSexoCadastro() {
		return dsl.obterTexto(By.xpath("//*[@id='descSexo']/span"));
	}
	
	public String obterComidaCadastro() {
		return dsl.obterTexto(By.xpath("//*[@id='descComida']/span"));
	}
	
	public String obterEscolaridadeCadastro() {
		return dsl.obterTexto(By.xpath("//*[@id='descEscolaridade']/span"));
	}
	
	public String obterEsporteCadastro() {
		return dsl.obterTexto(By.xpath("//*[@id='descEsportes']/span"));
	}

}
