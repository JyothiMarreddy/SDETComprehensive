package comprehensive;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NoCodeAutifySignUpTest {

	    WebDriver driver;

	    @Test(groups = "signup")
	    public void validateErrorMessagesAfterEmptySignup() {
	    	
	    	WebDriverManager.chromedriver().setup();
	    	
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	        
	        driver.get("https://nocode.autify.com/");
	        
			WebElement freeTrailButton = driver.findElement(By.xpath("//a[text()=\"Start Free Trial\"]"));
			
			Actions act = new Actions(driver);
			act.scrollToElement(freeTrailButton);
			
			freeTrailButton.click();

	        String parentWindow = driver.getWindowHandle();
	        
	        Set<String> windows = driver.getWindowHandles();
	        
	        for (String window : windows) {
	            if (!window.equals(parentWindow)) {
	                driver.switchTo().window(window);
	                break;
	            }
	        }

	        driver.findElement(By.xpath("//button[contains(text(),'Sign up')]")).click();

	        Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),\"First name can't be blank\")]")).isDisplayed());
	        Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),\"Last name can't be blank\")]")).isDisplayed());
	        Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),\"Company name can't be blank\")]")).isDisplayed());
	        Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),\"Company size can't be blank\")]")).isDisplayed());
	        Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),\"Email can't be blank\")]")).isDisplayed());
	        Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),\"Password cannot be blank\")]")).isDisplayed());
	        Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),\"Phone Number can't be blank\")]")).isDisplayed());
	    
	    }

	    @AfterMethod
	    public void tearDown() {
	    	
	        if (driver != null) 
	        	driver.quit();
	    }

}
