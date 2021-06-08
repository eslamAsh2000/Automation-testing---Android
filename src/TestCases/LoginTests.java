package TestCases;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;



public class LoginTests extends Base
{
	// TODO Auto-generated method stub
	
	@Test(enabled=false)
	public void LoginUsingEmptyMail() throws MalformedURLException, InterruptedException
	{
		AndroidDriver<AndroidElement> driver = Capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		
		//Click on GetStarted:
		driver.findElement(By.xpath("(//android.widget.Button)")).click();
		
		//Click Next:
		driver.findElementByXPath("//*[@content-desc='Next']").click();
		
		//Find Required Text:
		WebElement R = driver.findElementByXPath("//*[@content-desc='Required']");
		
		if(R.isDisplayed())
		{
			Assert.assertTrue(true, "Required Error is Displayed");
		}
		else
		{
			Assert.assertTrue(false, "Required Error isn't Displayed");
		}
		
		Thread.sleep(2000);
		driver.quit();
	
	}
	
	@Test(enabled=false)
	public void LoginUsingValidAccount() throws MalformedURLException, InterruptedException 
	{
		AndroidDriver<AndroidElement> driver = Capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		TouchAction t = new TouchAction(driver);		
		
		//Locate Email TextBox:
		driver.findElement(By.xpath("(//android.widget.Button)")).click();
		WebElement EmailAddress = driver.findElementByXPath("//*[@text='Email address']");
		t.tap(tapOptions().withElement(element(EmailAddress))).perform();
				
		//type Email:
		Actions action = new Actions(driver);
		action.sendKeys(EmailAddress, "yousfjaafer@gmail.com").perform();
				
		//Click next
		driver.findElementByXPath("//*[@content-desc='Next']").click();
				
		//Locate Password TextBox:
		WebElement Password = driver.findElementByXPath("//android.widget.EditText[@text='Password']");
		t.tap(tapOptions().withElement(element(Password))).perform();
				
		//type Password:
		action.sendKeys(Password,"yousefadel12").perform();
		
		//Show Password:
		driver.findElementsByClassName("android.widget.Button").get(1).click();
		
		//Remove Keyboard:
		driver.hideKeyboard();
				
		//Click SignIn Button:
		driver.findElementByXPath("//*[@content-desc='Sign in']").click();
		
		
		Thread.sleep(5000);
		driver.quit();
	}
	
	@Test
	public void LoginUsingInvalidAccount() throws MalformedURLException, InterruptedException
	{
		AndroidDriver<AndroidElement> driver = Capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		TouchAction t = new TouchAction(driver);		
		//Locate Email TextBox:
		driver.findElement(By.xpath("(//android.widget.Button)")).click();
		WebElement EmailAddress = driver.findElementByXPath("//*[@text='Email address']");
		t.tap(tapOptions().withElement(element(EmailAddress))).perform();
				
		//type Email:
		Actions action = new Actions(driver);
		action.sendKeys(EmailAddress, "2@31.com").perform();
		
		//Click next
		driver.findElementsByClassName("android.widget.Button").get(1).click();
		
		//Locate Password TextBox:
		WebElement Password = driver.findElementByXPath("//android.widget.EditText[@text='Password']");
		t.tap(tapOptions().withElement(element(Password))).perform();
						
		//type Password:
		action.sendKeys(Password,"aaabb").perform();
				
		//Remove Keyboard:
		driver.hideKeyboard();
		
		//Click SignIn Button:
		driver.findElementByXPath("//*[@content-desc='Sign in']").click();
		driver.findElementByXPath("//*[@content-desc='Sign in']").click();
		
		//Check for Invalid Password:
		WebElement P = driver.findElementByXPath("//*[@content-desc='Invalid password']");
		
		if(P.isDisplayed())
		{
			Assert.assertTrue(true, "Caught Error");
		}
		
		else
		{
			Assert.assertTrue(false, "Assertion Failed!");
		}
		
		
		Thread.sleep(2000);
		driver.quit();
		
	}
	
	@Test
	public void LoginUsingUnknownDomain() throws MalformedURLException, InterruptedException
	{
		AndroidDriver<AndroidElement> driver = Capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		TouchAction t = new TouchAction(driver);		
		
		//Locate Email TextBox:
		driver.findElement(By.xpath("(//android.widget.Button)")).click();
		WebElement EmailAddress = driver.findElementByXPath("//*[@text='Email address']");
		t.tap(tapOptions().withElement(element(EmailAddress))).perform();
					
		//type Email:
		Actions action = new Actions(driver);
		action.sendKeys(EmailAddress, "joe.com").perform();
		
		//Remove Keyboard:
		driver.hideKeyboard();
		
		//Click next
		driver.findElementsByClassName("android.widget.Button").get(1).click();
		
		//Locate TryAgain Button:
		WebElement T = driver.findElementByXPath("//*[@content-desc='Try again']");
		
		if(T.isDisplayed())
		{
			//Click on Tryagain:
			driver.findElementByXPath("//*[@content-desc='Try again']").click();
			
			//Click next
			driver.findElementsByClassName("android.widget.Button").get(1).click();
			
			//Click on Continue To Yahoo:
			driver.findElementByXPath("//*[@content-desc='Continue to Yahoo']").click();
			
			Assert.assertTrue(true, "Caught Error");
			
		
		}
		
		else
		{
			Assert.assertTrue(false, "Assertion Failed!");
		}
		
		Thread.sleep(2000);
		driver.quit();
		
	}
	
	@Test
	public void LoginUsingInvalidPassword() throws MalformedURLException, InterruptedException
	{
		AndroidDriver<AndroidElement> driver = Capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		TouchAction t = new TouchAction(driver);		
		
		//Locate Email TextBox:
		driver.findElement(By.xpath("(//android.widget.Button)")).click();
		WebElement EmailAddress = driver.findElementByXPath("//android.widget.EditText[@text='Email address']");
		t.tap(tapOptions().withElement(element(EmailAddress))).perform();
				
		//type Email:
		Actions action = new Actions(driver);
		action.sendKeys(EmailAddress, "yousfjaafer@gmail.com").perform();
		
		//Remove Keyboard:
		driver.hideKeyboard();
		
		//Click next
		driver.findElementsByClassName("android.widget.Button").get(1).click();
		
		//Locate Password TextBox:
		WebElement Password = driver.findElementByXPath("//android.widget.EditText[@text='Password']");
		t.tap(tapOptions().withElement(element(Password))).perform();
						
		//type Password:
		action.sendKeys(Password,"aaabb").perform();
		
		//Show Password:
		driver.findElementsByClassName("android.widget.Button").get(1).click();
		
		//Remove Keyboard:
		driver.hideKeyboard();
		
		for(int i = 0 ; i < 2 ; i++)
		{
			//Click SignIn Button:
			driver.findElementByXPath("//*[@content-desc='Sign in']").click();
		}
		
		//Check for Invalid Password:
		WebElement P = driver.findElementByXPath("//*[@content-desc='Invalid password']");
				
		if(P.isDisplayed())
		{
			Assert.assertTrue(true, "Caught Error");
		}
				
		else
		{
			Assert.assertTrue(false, "Assertion Failed!");
		}
		
		Thread.sleep(2000);
		driver.quit();
	}
	
	@Test(enabled=false)
	public void BlankPassword() throws MalformedURLException, InterruptedException
	{
		AndroidDriver<AndroidElement> driver = Capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		TouchAction t = new TouchAction(driver);		
		
		//Locate Email TextBox:
		driver.findElement(By.xpath("(//android.widget.Button)")).click();
		WebElement EmailAddress = driver.findElementByXPath("//android.widget.EditText[@text='Email address']");
		t.tap(tapOptions().withElement(element(EmailAddress))).perform();
				
		//type Email:
		Actions action = new Actions(driver);
		action.sendKeys(EmailAddress, "yousfjaafer@gmail.com").perform();
		
		//Remove Keyboard:
		driver.hideKeyboard();
		
		//Click next
		driver.findElementsByClassName("android.widget.Button").get(1).click();
		
		for(int i = 0 ; i < 2 ; i++)
		{
			//Click SignIn Button:
			driver.findElementByXPath("//*[@content-desc='Sign in']").click();
		}
		//Remove Keyboard:
		driver.hideKeyboard();
		
		//Find Required Text:
		WebElement R = driver.findElementByXPath("//*[@content-desc='Required']");
				
		if(R.isDisplayed())
		{
			Assert.assertTrue(true, "Required Error is Displayed");
		}
		
		else
		{
			Assert.assertTrue(false, "Required Error isn't Displayed");
		}
		
	}
	
	@Test(enabled=false)
	public void ForgetPasswordAndSendEmail() throws MalformedURLException, InterruptedException
	{
		AndroidDriver<AndroidElement> driver = Capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		TouchAction t = new TouchAction(driver);		
		
		//Locate Email TextBox:
		driver.findElement(By.xpath("(//android.widget.Button)")).click();
		WebElement EmailAddress = driver.findElementByXPath("//android.widget.EditText[@text='Email address']");
		t.tap(tapOptions().withElement(element(EmailAddress))).perform();
				
		//type Email:
		Actions action = new Actions(driver);
		action.sendKeys(EmailAddress, "yousfjaafer@gmail.com").perform();
				
		//Click next
		driver.findElementsByClassName("android.widget.Button").get(1).click();
		
		//Remove Keyboard:
		driver.hideKeyboard();
		
		//Click on ForgetPasswordLink:
		driver.findElementByXPath("//*[@content-desc='Forgot password?']").click();
		
		//Click on Send Email:
		driver.findElementByXPath("//*[@content-desc='Send email']").click();
		
		//Check Send Email Enableness:
		WebElement SE = driver.findElementByXPath("//*[@content-desc='Send email']");
		
		if(SE.isEnabled())
		{
			Assert.assertTrue(true, "Sent an Email");
		}
		
		else
		{
			Assert.assertTrue(false, "Nothing has been Sent");
		}
		
		Thread.sleep(2000);
		driver.quit();
	}
	
}
