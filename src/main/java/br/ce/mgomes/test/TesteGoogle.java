package br.ce.mgomes.test;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteGoogle {
	
	private WebDriver driver;
	
	@Before
	public void inicializa() {
		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
	}
	
	@After
	public void termina() {
		driver.quit();
	}
	
	
	@Test
	public void teste() {
       //System.setProperty("webdriver.gecko.driver", "Users/great/Documents/DriverSelenium/geckodriver.exe");
      //WebDriver driver = new FirefoxDriver();
		driver.get("http://www.google.com");
		System.out.println(driver.getTitle());
		Assert.assertEquals("Google", driver.getTitle());
	} 

}
