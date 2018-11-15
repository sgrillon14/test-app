package waterfall.test.selenium.test;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.noraui.utils.Utilities.OperatingSystem;
import com.github.noraui.utils.Utilities.SystemArchitecture;

public class LoginIT {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginIT.class);
	private WebDriver webDriver;

	@Before
	public void init() {
		final OperatingSystem currentOperatingSystem = OperatingSystem.getCurrentOperatingSystem();
		String pathWebdriver = String.format("src/test/resources/drivers/%s/googlechrome/%s/chromedriver%s",
				currentOperatingSystem.getOperatingSystemDir(),
				SystemArchitecture.getCurrentSystemArchitecture().getSystemArchitectureName(),
				currentOperatingSystem.getSuffixBinary());
		if (!new File(pathWebdriver).setExecutable(true)) {
			logger.error("ERROR when change setExecutable on " + pathWebdriver);
		}
		System.setProperty("webdriver.chrome.driver", pathWebdriver);
		logger.info("init OK");
	}

	@After
	public void quit() {
		
	}

	@Test
	public void read() {
		this.webDriver = new ChromeDriver();
		//webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		webDriver.get("http://localhost:8080/app/login");
		logger.info(webDriver.getPageSource());
		assertEquals("<html xmlns=\"http://www.w3.org/1999/xhtml\"><head></head><body>Hello stackoverflow.com questions 53268198</body></html>",webDriver.getPageSource());
		this.webDriver.quit();
	}
	
}
