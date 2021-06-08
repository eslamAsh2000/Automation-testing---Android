package TestCases;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.net.MalformedURLException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;
import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchByPhotos extends Base 
{
	public AndroidDriver<AndroidElement> Login() throws InterruptedException, MalformedURLException
	{
		//Login Stage
		AndroidDriver<AndroidElement> driver = Capabilities();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				
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
	public void SearchAPhoto() throws InterruptedException, MalformedURLException
	{
		AndroidDriver<AndroidElement> driver = Login();
		Thread.sleep(18000);
		TouchAction t = new TouchAction(driver);
		Actions action = new Actions(driver);
		
		//Click on Search Button:
		driver.findElementsByClassName("android.widget.Button").get(1).click();
		
		//Click on EditTextBox:
		driver.findElementByXPath("//android.widget.EditText").click();
		
		//Type hoho:
		WebElement SearchBar = driver.findElementByXPath("//android.widget.EditText");
		
		action.sendKeys(SearchBar,"hoho").perform();
		
		//Click on Run and validate its appearence:
		driver.findElementsByXPath("//android.widget.Button").get(3).click();
		
		WebElement Pic = driver.findElementByXPath("//android.widget.ImageView");
		
		if(Pic.isDisplayed())
		{
			Assert.assertTrue(true,"Displayed Searched Image");
		}
		
		else
		{
			Assert.assertTrue(false,"Displayed Searched Image");
		}
		
		Thread.sleep(1000);
		driver.quit();		
	}
	
	@Test
	public void ReSearchingAPhoto() throws InterruptedException, MalformedURLException
	{
		AndroidDriver<AndroidElement> driver = Login();
		Thread.sleep(16000);
		TouchAction t = new TouchAction(driver);
		Actions action = new Actions(driver);
		
		//Click on Search Button:
		driver.findElementsByClassName("android.widget.Button").get(1).click();
		
		//Click on EditTextBox:
		driver.findElementByXPath("//android.widget.EditText").click();
		
		//Type hoho:
		WebElement SearchBar = driver.findElementByXPath("//android.widget.EditText");
		
		action.sendKeys(SearchBar,"hoho").perform();
		
		//Click on Run:
		driver.findElementsByXPath("//android.widget.Button").get(3).click();
		
		MobileElement Pic = driver.findElementByXPath("//android.widget.ImageView");
		
		//Click on X button 
		driver.findElementsByXPath("//android.widget.Button").get(4).click();
		
		//Click on EditTextBox:
		driver.findElementByXPath("//android.widget.EditText").click();
		
		//Researching by Unknown Image:
		action.sendKeys(SearchBar,"Simpsons").perform();
		
		//Click on Run and validate its appearence:
		driver.findElementsByXPath("//android.widget.Button").get(3).click();
		
		Thread.sleep(3000);
		//Validate Appearence:
		
		if(driver.findElements(By.xpath("//android.widget.ImageView")).isEmpty())
		{
			Assert.assertTrue(true,"Displayed Searched Image");
		}
		
		else
		{
			Assert.assertTrue(false,"Displayed Searched Image");
		}
		

		
		Thread.sleep(1000);
		driver.quit();

	}
}