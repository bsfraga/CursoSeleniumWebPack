import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteFrames {

	private WebDriver driver;
	
	@Before
	public void inicializar() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bruno Fraga\\Documents\\Selenium WebDriver\\chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("C:\\Users\\Bruno Fraga\\Documents\\Selenium WebDriver\\Teste\\componentes.html");
	}
	
	@After
	public void finalizar() {
		driver.quit();
	}
	
	@Test
	public void interagirComFrame() {

		driver.switchTo().frame("frame1");								//Muda o foco para o componente iFrame
		driver.findElement(By.id("frameButton")).click();

		Alert alert = driver.switchTo().alert();
		String msg = alert.getText();
		alert.accept();

		driver.switchTo().defaultContent();								//Muda o foco para a pagina principal
		driver.findElement(By.id("elementosForm:nome")).sendKeys(msg);
		
	}
	
	@Test
	public void interagirComJanela() {
		/*
		 * Procura elementos por tagName
		 */
		
		driver.findElement(By.id("buttonPopUpEasy")).click();
		driver.switchTo().window("Popup");								//Muda o foco para a nova janela
		driver.findElement(By.tagName("textarea")).sendKeys("Teste");
		
		driver.close();
		driver.switchTo().window("");
		
		driver.findElement(By.tagName("textarea")).sendKeys("Testando de novo");;
	}
	
	@Test
	public void interagirComJanelaSemTitulo() {
		/*
		 * getWindowHandle()
		 * getWindowHandles()
		 * Métodos que gerenciam as janelas que estão sendo
		 * abertas durante o teste
		 */
		
		driver.findElement(By.id("buttonPopUpHard")).click();
		driver.switchTo().window((String) driver.getWindowHandles().toArray()[1]);
		driver.findElement(By.tagName("textarea")).sendKeys("Teste");
		driver.switchTo().window((String) driver.getWindowHandles().toArray()[0]);
		driver.findElement(By.tagName("textarea")).sendKeys("Testando de novo");;
	}
	
}
