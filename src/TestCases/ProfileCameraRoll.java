package TestCases;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileCameraRoll extends Base 
{
	public AndroidDriver<AndroidElement> Login() throws InterruptedException, MalformedURLException
	{
		//Login Stage
		AndroidDriver<AndroidElement> driver = Capabilities();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				
		TouchAction t = new TouchAction(driver);		
				
		//Locate Email TextBox:
		driver.findElement(By.xpath("(//android.widget.Button)")).click();
		WebElement EmailAddress = driver.findElementByXPath("//*[@text='Email address']");
		t.tap(tapOptions().withElement(element(EmailAddress))).perform();
						
		//type Email:
		Actions action = new Actions(driver);
		action.sendKeys(EmailAddress, "tarek.niazy2@gmail.com").perform();
						
		//Click next
		driver.findElementByXPath("//*[@content-desc='Next']").click();
						
		//Locate Password TextBox:
		WebElement Password = driver.findElementByXPath("//android.widget.EditText[@text='Password']");
		t.tap(tapOptions().withElement(element(Password))).perform();
						
		//type Password:
		action.sendKeys(Password,"Tarek1741999").perform();
				
		//Remove Keyboard:
		driver.hideKeyboard();
						
		//Click SignIn Button:
		driver.findElementByXPath("//*[@content-desc='Sign in']").click();
		Thread.sleep(3000);
		
		return driver;
		
	}
	
	@Test
	public void OpeningCameraRoll() throws InterruptedException, MalformedURLException
	{
		AndroidDriver<AndroidElement> driver = Login();
		Thread.sleep(12000);
		TouchAction t = new TouchAction(driver);
		Actions action = new Actions(driver);
		
		//Click on Profile Button:
		driver.findElementsByClassName("android.widget.Button").get(2).click();
		Thread.sleep(2000);
		
		//Click on CameraRoll Button:
		WebElement CameraRoll = driver.findElementByXPath("//*[contains(@content-desc,'Camera')]");
		t.tap(tapOptions().withElement(element(CameraRoll))).perform();
		Thread.sleep(1000);
		
		//Swipe down:
		WebElement X = driver.findElementsByXPath("//android.widget.ImageView").get(0);
		WebElement Y = driver.findElementsByXPath("//android.widget.ImageView").get(2);
	t.longPress(longPressOptions().withElement(element(Y)).withDuration(ofSeconds(2))).moveTo(element(X)).release().perform();
		
		//Click on Photos:
		
		for(int i = 0 ; i < 3 ; i++) 
	 {
	
		WebElement Pic = driver.findElementsByClassName("android.widget.ImageView").get(i);
		
		if(Pic.isDisplayed() == false)
		{
			Assert.assertTrue(false, "Assert Failed");
			
		}
		
			else
		{
			Assert.assertTrue(true, "Assert Succedded");
		}
		
	 }
		Thread.sleep(1000);
		driver.quit();

   }
}
