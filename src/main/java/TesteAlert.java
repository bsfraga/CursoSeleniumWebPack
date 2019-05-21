import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class TesteAlert {

	@Test
	public void interagirComAlertSimples() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bruno Fraga\\Documents\\Selenium WebDriver\\chrome\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("C:\\Users\\Bruno Fraga\\Documents\\Selenium WebDriver\\Teste\\componentes.html");
	
		driver.findElement(By.id("alert")).click();
		
		Alert alert = driver.switchTo().alert();
		
		String texto = alert.getText();
		
		Assert.assertEquals("Alert Simples", texto);
		alert.accept();
		
		driver.findElement(By.id("elementosForm:nome")).sendKeys(texto);
		
		driver.quit();
	
	}
	
	@Test
	public void interagirComAlertConfirm() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bruno Fraga\\Documents\\Selenium WebDriver\\chrome\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("C:\\Users\\Bruno Fraga\\Documents\\Selenium WebDriver\\Teste\\componentes.html");
	
		driver.findElement(By.id("confirm")).click();
		
		Alert alert = driver.switchTo().alert();
		String texto = alert.getText();
		Assert.assertEquals("Confirm Simples", texto);
		alert.dismiss();
		texto = alert.getText();
		Assert.assertEquals("Negado", texto);
		alert.accept();
		
		
		driver.findElement(By.id("confirm")).click();
		
		alert = driver.switchTo().alert();
		texto = alert.getText();
		Assert.assertEquals("Confirm Simples", texto);
		alert.accept();
		texto = alert.getText();
		Assert.assertEquals("Confirmado", texto);
		alert.accept();
		
		
		driver.quit();
		
	}
	
	@Test
	public void interagirComAlertPrompt() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bruno Fraga\\Documents\\Selenium WebDriver\\chrome\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("C:\\Users\\Bruno Fraga\\Documents\\Selenium WebDriver\\Teste\\componentes.html");
	
		driver.findElement(By.id("prompt")).click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Digite um numero", alert.getText());
		alert.sendKeys("09");
		alert.accept();
		Assert.assertEquals("Era 09?", alert.getText());
		alert.accept();
		Assert.assertEquals(":D", alert.getText());
		alert.accept();
		
		
		driver.quit();
	}
	
}
