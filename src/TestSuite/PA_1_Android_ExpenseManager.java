package TestSuite;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

class PA_1_Android_ExpenseManager {
	
	public AndroidDriver driver;

	@BeforeEach
	void setUp() throws Exception {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "4ff90a67");
		capabilities.setCapability(MobileCapabilityType.APP, "D:\\BCC\\Mobile Testing\\Apks\\expensemanager.apk");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@AfterEach
	void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	void test() throws IOException, InterruptedException {
		
		String expense = null,object = null;
		for(int i=0;i<3;i++) {
			
		driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'at.markushi.expensemanager:id/menu_new_expense_only')]")).click();
		if(i==0) {
			driver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'at.markushi.expensemanager:id/digit_2')]")).click();
			 expense = driver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'at.markushi.expensemanager:id/digit_2')]")).getText();
		}
		else if(i==1) {
			driver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'at.markushi.expensemanager:id/digit_3')]")).click();
			 expense = driver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'at.markushi.expensemanager:id/digit_3')]")).getText();
		}
		else {
			driver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'at.markushi.expensemanager:id/digit_4')]")).click();
			 expense = driver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'at.markushi.expensemanager:id/digit_4')]")).getText();
		}
		
		
		
		driver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'android:id/button1')]")).click();
		if(i==0) {
			driver.findElement(By.xpath("//android.widget.CheckedTextView[contains(@text,'Other')]")).click();
			object = driver.findElement(By.xpath("//android.widget.CheckedTextView[contains(@text,'Other')]")).getText();
		}
		else if(i==1) {
			driver.findElement(By.xpath("//android.widget.CheckedTextView[contains(@text,'Health')]")).click();
			object = driver.findElement(By.xpath("//android.widget.CheckedTextView[contains(@text,'Health')]")).getText();
		}
		else {
			driver.findElement(By.xpath("//android.widget.CheckedTextView[contains(@text,'Leisure')]")).click();
			object = driver.findElement(By.xpath("//android.widget.CheckedTextView[contains(@text,'Leisure')]")).getText();
		}
		
		
		driver.findElement(By.xpath("//android.widget.FrameLayout[contains(@resource-id,'at.markushi.expensemanager:id/actionbar_done')]")).click();
		System.out.println(expense+" "+object);
		
		}
		
		
		Thread.sleep(2000);
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("F:\\BCC\\Eclipse Scripts\\Demo2\\screenshots\\Expense.jpg"));
		
		
	}

}
