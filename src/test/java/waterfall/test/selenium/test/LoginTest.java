package waterfall.test.selenium.test;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import waterfall.test.selenium.page.HeaderPage;
import waterfall.test.selenium.page.LoginPage;
import waterfall.test.selenium.page.LotteryPlaygroundPage;

public class LoginTest {
	
	public WebDriver webDriver;
	public LoginPage loginPage;
	public LotteryPlaygroundPage lotteryPlaygroundPage;
	public HeaderPage headerPage;
	
	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		this.webDriver = new ChromeDriver();
		loginPage = new LoginPage(webDriver);
		lotteryPlaygroundPage = new LotteryPlaygroundPage(webDriver);
		headerPage = new HeaderPage(webDriver);
 
 	}
	
	@After
	public void fini() {
		headerPage.clickLogoutButton();
		this.webDriver.quit();

	}
	
	@Test
	public void loginTest() {
		System.out.println(webDriver.getPageSource());
		webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//webDriver.get("http://127.0.0.1:8080/login");
		webDriver.get("http://localhost:8080/login");
		webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println(webDriver.getPageSource());

		loginPage.inputUsername("root");
		loginPage.inputPassword("root");
		loginPage.clickLoginButton();
		
		assertEquals("root", headerPage.getUsername());
	}
	
}
