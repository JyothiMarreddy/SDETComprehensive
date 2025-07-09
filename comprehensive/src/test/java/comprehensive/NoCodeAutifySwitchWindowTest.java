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

public class NoCodeAutifySwitchWindowTest {

	WebDriver driver;
	WebElement freeTrailButton;

	@Test(groups = "windows")
	public void verifyWindowSwitchAndTitle() throws InterruptedException{
		System.out.println("in test");
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get("https://nocode.autify.com/");
		
		try {
		driver.findElement(By.xpath("//div[@class=\"cky-notice\"]//button[text()=\"Accept All\"]")).click();
	    
		freeTrailButton = driver.findElement(By.xpath("//a[text()=\"Start Free Trial\"]"));
		
		Actions act = new Actions(driver);
		act.scrollToElement(freeTrailButton);
		
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		if (freeTrailButton.isDisplayed())
			freeTrailButton.click();

			Thread.sleep(3000);
		
		String parentWindow = driver.getWindowHandle();

		Set<String> windows = driver.getWindowHandles();
		for (String window : windows) {
			if (!window.equals(parentWindow)) {
				driver.switchTo().window(window);
				break;
			}
		}

		String actualTitle = driver.getPageSource();
		String expectedTitle = "Trial Application - Autify";
		Assert.assertTrue(actualTitle.contains(expectedTitle), "Title mismatch");

		driver.close();
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
			System.out.println("in after");
		}
	}

}
