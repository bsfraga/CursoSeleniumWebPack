package br.rs.bfraga.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

	private static WebDriver driver;
	
	private DriverFactory() {}
	
	public static WebDriver getDriver() {
		if(driver == null) {
			/*
			 * 
			 */
//			switch(Propriedades.browser) {
//				case FIREFOX: driver = new FirefoxDriver(); break;
//				case CHROME: driver = new ChromeDriver(); break;
//			}
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bruno Fraga\\Documents\\Selenium WebDriver\\chrome\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		return driver;
	}
	
	public static void killDriver() {
		if(driver != null) {
			driver.quit();
			driver = null;
		}
		
	}
}
