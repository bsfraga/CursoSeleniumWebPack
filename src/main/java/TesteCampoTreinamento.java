import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCampoTreinamento {

	@Test
	public void testeCampoTreinamento() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bruno Fraga\\Documents\\Selenium WebDriver\\chrome\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		/*driver.get("file:///"+System.getProperty("user.dir")+""
				+ "src/main/resources/componentes.html");*/
		driver.get("C:\\Users\\Bruno Fraga\\Documents\\Selenium WebDriver\\Teste\\componentes.html");
		driver.findElement(By.id("elementosForm:nome")).sendKeys("teste");;
		Assert.assertEquals("teste",
				driver.findElement(By.id("elementosForm:nome"))
				.getAttribute("value"));
		
		driver.quit();
	}
	
	@Test
	public void interagirComTextArea() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bruno Fraga\\Documents\\Selenium WebDriver\\chrome\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("C:\\Users\\Bruno Fraga\\Documents\\Selenium WebDriver\\Teste\\componentes.html");
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("teste\nteste quebra de linha\nteste quebra de linha");;
		Assert.assertEquals("teste\nteste quebra de linha\nteste quebra de linha",
				driver.findElement(By.id("elementosForm:sugestoes"))
				.getAttribute("value"));
		
		driver.quit();
	}
	
	@Test
	public void interagirComRadioButton() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bruno Fraga\\Documents\\Selenium WebDriver\\chrome\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("C:\\Users\\Bruno Fraga\\Documents\\Selenium WebDriver\\Teste\\componentes.html");
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
		
		driver.quit();
	}
	
	@Test
	public void interagirComCheckBox() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bruno Fraga\\Documents\\Selenium WebDriver\\chrome\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("C:\\Users\\Bruno Fraga\\Documents\\Selenium WebDriver\\Teste\\componentes.html");
		driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();;
		Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());
		
		driver.quit();
	}
	
	@Test
	public void interagirComComboBox() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bruno Fraga\\Documents\\Selenium WebDriver\\chrome\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("C:\\Users\\Bruno Fraga\\Documents\\Selenium WebDriver\\Teste\\componentes.html");
		driver.findElement(By.id("elementosForm:escolaridade")).click();
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		
		//combo.selectByIndex(2);
		//combo.selectByValue("superior");
		combo.selectByVisibleText("2o grau completo");
		
		Assert.assertEquals("2o grau completo", combo.getFirstSelectedOption().getText());
		
		
		driver.quit();

	}
	
	@Test
	public void verificarValoresCombo() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bruno Fraga\\Documents\\Selenium WebDriver\\chrome\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("C:\\Users\\Bruno Fraga\\Documents\\Selenium WebDriver\\Teste\\componentes.html");
		driver.findElement(By.id("elementosForm:escolaridade")).click();
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		
		List<WebElement> options = combo.getOptions();
		Assert.assertEquals(8, options.size());
		
		boolean encontrou = false;
		for(WebElement option : options) {
			if(option.getText().equals("Mestrado")) {
				encontrou = true;
				break;
			}
		}

		Assert.assertTrue(encontrou);
		
		driver.close();
	}
	
	@Test
	public void verificarValoresComboMultiplo() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bruno Fraga\\Documents\\Selenium WebDriver\\chrome\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("C:\\Users\\Bruno Fraga\\Documents\\Selenium WebDriver\\Teste\\componentes.html");
		
		WebElement element = driver.findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(element);
		
		combo.selectByVisibleText("Natacao");
		combo.selectByVisibleText("Corrida");
		combo.selectByVisibleText("O que eh esporte?");
		
		
		
		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(3, allSelectedOptions.size());
		
		combo.deselectByVisibleText("Corrida");
		allSelectedOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(2, allSelectedOptions.size());
		
		driver.quit();
		
	}
	
	@Test
	public void interagirComBotoes() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bruno Fraga\\Documents\\Selenium WebDriver\\chrome\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("C:\\Users\\Bruno Fraga\\Documents\\Selenium WebDriver\\Teste\\componentes.html");
		
		WebElement botao = driver.findElement(By.id("buttonSimple"));
		
		botao.click();
		
		Assert.assertEquals("Obrigado!", botao.getAttribute("value"));
		
		driver.quit();
	}
	
	@Test
	public void testaLinks() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bruno Fraga\\Documents\\Selenium WebDriver\\chrome\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("C:\\Users\\Bruno Fraga\\Documents\\Selenium WebDriver\\Teste\\componentes.html");
		
		driver.findElement(By.linkText("Voltar")).click();;
		
		Assert.assertEquals("Voltou!", driver.findElement(By.id("resultado")).getText());
		
		driver.quit();
	}
	
	@Test
	public void buscarTextoNaPagina() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bruno Fraga\\Documents\\Selenium WebDriver\\chrome\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("C:\\Users\\Bruno Fraga\\Documents\\Selenium WebDriver\\Teste\\componentes.html");
		
		
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Campo de Treinamento"));
		
		driver.quit();
		
	}
	
}
