import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class TesteGoogle {

	@Test
	public void teste() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bruno Fraga\\Documents\\Selenium WebDriver\\chrome\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.google.com");
		
		Assert.assertEquals("Google", driver.getTitle());
		
		System.out.println();
		
		
		driver.quit();
		
	}
	
}
