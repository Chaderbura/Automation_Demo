package TestSuite;

import static org.junit.jupiter.api.Assertions.*;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.crypto.spec.PSource.PSpecified;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.steadystate.css.parser.selectors.PseudoElementSelectorImpl;

class googletest {
	
	WebDriver driver = null;
	String Text = null;
	@BeforeEach
	void setUp() throws Exception {
//		 System.setProperty("webdriver.chrome.driver", "D:\\BCC\\Mobile Testing\\Jar Library files\\chromedriver_win32\\chromedriver.exe");
//		 System.setProperty("webdriver.gecko.driver", "D:\\BCC\\Mobile Testing\\Jar Library files\\geckodriver-v0.19.0-win64\\geckodriver.exe");
		 //driver = new FirefoxDriver();
		 //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("AutomationName", "UIAutomator2");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName", "emulator-5556");
		//capabilities.setCapability("browserName", "Chrome");
		capabilities.setCapability("app", "D:\\BCC\\Mobile Testing\\Apks\\calculator.apk");
		
		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		 //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		// try {
			//Assert.assertEquals("PHPTRAVELS | Travel Technology Partner", driver.getTitle());
			//System.out.println("Passed");
		//} catch (Exception e) {
			//System.out.println("Failed");
		//}
		 
	                
		 //driver.close(); //for browsers only
		driver.quit(); //for mobile applications
	}

	@Test
	void test() throws InterruptedException {
		driver.get("https://www.phptravels.net/login");
		
		
		
//		driver.findElement(By.linkText("MY ACCOUNT")).click();
//		driver.findElement(By.linkText("Login")).click();
		//driver.findElement(By.xpath("//*[@id=\"li_myaccount\"]/ul/li[1]/a")).click();
		
		
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("user@phptravels.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("demouser");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//Thread.sleep(2000);
		Text = driver.findElement(By.xpath("//h3[@class='RTL']")).getText();
		
		if(Text.equals("Hi, Johny Smith")) {
			System.out.println("Passed");
		}
		else {
			System.out.println("Failed");
		}
		
	}

}
