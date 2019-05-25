package br.rs.bfraga.core;
import static br.rs.bfraga.core.DriverFactory.getDriver;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DSL {

	
	/********* TextField e TextArea ************/
	public void escrever(By by, String texto) {
		getDriver().findElement(by).clear();
		getDriver().findElement(by).sendKeys(texto);
	}
	
	public void escrever(String id_campo, String texto) {
		getDriver().findElement(By.id(id_campo)).sendKeys(texto);
	}
	
	public String obterValorCampo(String id_campo) {
		return getDriver().findElement(By.id(id_campo)).getAttribute("value");
	}
	/********* Radio e Check ************/
	public void clicarRadioButton(String id_campo) {
		getDriver().findElement(By.id(id_campo)).click();
	}
	
	public boolean verificaRadioMarcado(String id) {
		return getDriver().findElement(By.id(id)).isSelected();
	}
	
	public void clicarCheckBoxs(String id_campo) {
		getDriver().findElement(By.id(id_campo)).click();
	}
	
	public boolean verificaCheckMarcado(String id) {
		return getDriver().findElement(By.id(id)).isSelected();
	}
	/********* Combo ************/
	public void selecionarCombo(String id, String valor) {
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);
	}

	public void desmarcarCombo(String id, String valor) {
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		combo.deselectByVisibleText(valor);
	}
	
	public List<String> obterValoresCombo(String id) {
		WebElement element = getDriver().findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(element);
		List<WebElement> allSelectedOption = combo.getAllSelectedOptions();
		List<String> valores = new ArrayList<String>();
		
		for (WebElement opcao : allSelectedOption) {
			valores.add(opcao.getText());
		}

		return valores;
	}
	
	public String obterValorCombo(String id) {
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		return combo.getFirstSelectedOption().getText();
	}
	
	public boolean verificarOpcaoCombo(String id, String opcao) {
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		
		for (WebElement option : options) {
			if (option.getText().equals(opcao)) {
				return true;
			}
		}
		return false;
	}
	/********* Botao ************/
	public void clicarBotão(String id) {
		getDriver().findElement(By.id(id)).click();
	}
	
	public String obterValueElemento(String id) {
		return getDriver().findElement(By.id(id)).getAttribute("value");
	}
	
	public String obterTexto(By by) {
		return getDriver().findElement(by).getText();	
	}
	
	/********* Textos ************/
	public String obterTexto(String id) {
		return obterTexto(By.id(id));
	}
	public String obterTextoPeloElemento(By by) {
		return obterTexto(by);
	}
	/********* LINKS ************/
	public void clicarLink(String link) {
		getDriver().findElement(By.linkText(link)).click();
	}
	/********* Alerts ************/
	public String obterTextoAlerta() {
		Alert alerta = getDriver().switchTo().alert();
		return alerta.getText();
	}
	
	public String obterTextoAceitaAlerta() {
		Alert alerta = getDriver().switchTo().alert();
		String valor = alerta.getText();
		alerta.accept();
		return valor;
	}
	
	public String obterTextoNegaAlerta() {
		Alert alerta = getDriver().switchTo().alert();
		String valor = alerta.getText();
		alerta.dismiss();
		return valor;
	} 
	
	public void escreverAlerta(String valor) {
		Alert alerta = getDriver().switchTo().alert();
		alerta.sendKeys(valor);
		alerta.accept();
	}
	/********* Frames e Janelas ************/
	public void  entrarFrame(String id) {
		getDriver().switchTo().frame(id);
	}
	
	public void  entrarSair() {
		getDriver().switchTo().defaultContent();
	}
	
	public void  trocarJanela(String id) {
		getDriver().switchTo().window(id);
	}
	
	public void fecharJanela() {
		getDriver().close();
	}

	
}
