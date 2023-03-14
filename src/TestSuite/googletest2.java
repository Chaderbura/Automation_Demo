package TestSuite;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import javax.crypto.spec.PSource.PSpecified;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.steadystate.css.parser.selectors.PseudoElementSelectorImpl;

class googletest2 extends googletest {
	

	@Test
	void test() throws InterruptedException {
		
		for(int i=0;i<1;i++) {
			driver = i==0?(new FirefoxDriver()):(new ChromeDriver());
			
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			 
			driver.get("https://www.google.com/");
			
			driver.findElement(By.name("q")).sendKeys("ISQI");
			driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
			
			Thread.sleep(2000);
			
			//driver.findElement(By.linkText("iSQI")).click();
			driver.findElement(By.xpath("//h3[@class='LC20lb']")).click();
			
			Thread.sleep(2000);
			
			String title = driver.getTitle();
			
			Assert.assertEquals("iSQI.org",title);
			
			System.out.println(title);
			driver.close();
		}
		

	}

}
