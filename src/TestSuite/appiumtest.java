package TestSuite;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import javax.crypto.spec.PSource.PSpecified;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

class appiumtest {
	
	public AndroidDriver driver = null;
	String Text = null;
	@BeforeEach
	void setUp() throws Exception {
//		 System.setProperty("webdriver.chrome.driver", "D:\\BCC\\Mobile Testing\\Jar Library files\\chromedriver_win32\\chromedriver.exe");
//		 System.setProperty("webdriver.gecko.driver", "D:\\BCC\\Mobile Testing\\Jar Library files\\geckodriver-v0.19.0-win64\\geckodriver.exe");
		 //driver = new FirefoxDriver();
		 //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "4ff90a67");
		capabilities.setCapability("browserName", "Chrome");
		//capabilities.setCapability(MobileCapabilityType.APP, "D:\\BCC\\Mobile Testing\\Apks\\calculator.apk");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
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
		//driver.quit(); //for mobile applications
	}

	@Test
	void test() throws InterruptedException {
		driver.get("http://www.phptravels.net");
		Thread.sleep(2000);
		//TapTouch();
		taptouch_javascript();
		
		//driver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'net.tecnotopia.SimpleCalculator:id/button7')]")).click();
//		driver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'net.tecnotopia.SimpleCalculator:id/buttonAdd')]")).click();
//		driver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'net.tecnotopia.SimpleCalculator:id/button8')]")).click();
//		driver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'net.tecnotopia.SimpleCalculator:id/buttonEquals')]")).click();
//		
//		String num1 = driver.findElement(By.xpath("//android.widget.EditText[contains(@resource-id,'net.tecnotopia.SimpleCalculator:id/display')]")).getText();
//		
//			Assert.assertEquals("15", num1);
//			if(num1.equals("10"))
//			{
//				System.out.println(num1);
//			}
//			else {
//				try {
//					takeScreenShot((RemoteWebDriver)driver,"android","test");
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				
//			}
		}
	public static void takeScreenShot(RemoteWebDriver driver,String DeviceName, String fileName) throws IOException {

		TakesScreenshot scrShot = ((TakesScreenshot) driver); 
		File scrFile = scrShot.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(scrFile, new File("F:\\BCC\\Eclipse Scripts\\Demo2\\screenshots\\error.jpg"));
		
	}
	
	public void TapTouch()
	{
		
		TouchAction touch = new TouchAction((MobileDriver)driver);
		
		
//		WebElement start = driver.findElement(By.xpath("//*[@id=\"body-section\"]/section/div[2]/div/div/div[2]/ul/li[1]/a"));
//		WebElement end = driver.findElement(By.xpath("//*[@id=\"hotels\"]/form/div[5]/button"));
//		
//		touch.press(end).moveTo(start).release().perform();
		touch.press(800, 700).waitAction(500).moveTo(200, 700).release().perform();
		//WebElement e = driver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'net.tecnotopia.SimpleCalculator:id/button7')]"));
		//touch.press(e).release().perform();
	}
	
	public void taptouch_javascript()
	{
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
//		HashMap <String, String> scrollObject = new HashMap<String,String>();
//		scrollObject.put("direction","down");
		js.executeScript("window.scrollBy(0,250)", "");	
		
	}
	
	

}
