package TestSuite;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.crypto.spec.PSource.PSpecified;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.steadystate.css.parser.selectors.PseudoElementSelectorImpl;
import org.apache.commons.io.FileUtils;

class nativeApp extends googletest {
	
	public static void takeScreenShot(RemoteWebDriver driver,String DeviceName, String fileName) throws IOException {

		TakesScreenshot scrShot = ((TakesScreenshot) driver); 
		File scrFile = scrShot.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(scrFile, new File("F:\\BCC\\Eclipse Scripts\\Demo2\\screenshots\\error.jpg"));
		
	}
	

	@Test
	void test() throws InterruptedException {
		
		driver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'net.tecnotopia.SimpleCalculator:id/button7')]")).click();
		driver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'net.tecnotopia.SimpleCalculator:id/buttonAdd')]")).click();
		driver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'net.tecnotopia.SimpleCalculator:id/button8')]")).click();
		driver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'net.tecnotopia.SimpleCalculator:id/buttonEquals')]")).click();
		
		String num1 = driver.findElement(By.xpath("//android.widget.EditText[contains(@resource-id,'net.tecnotopia.SimpleCalculator:id/display')]")).getText();
		
			Assert.assertEquals("15", num1);
			if(num1.equals("10"))
			{
				System.out.println(num1);
			}
			else {
				try {
					takeScreenShot((RemoteWebDriver)driver,"android","test");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		

	

}
