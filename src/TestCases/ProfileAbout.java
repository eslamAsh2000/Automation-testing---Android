package TestCases;
import static io.appium.java_client.touch.TapOptions.tapOptions;

import static io.appium.java_client.touch.offset.ElementOption.element;

import java.net.MalformedURLException;
import java.nio.charset.Charset;
import java.util.Random;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class ProfileAbout extends Base
{
	
	public AndroidDriver<AndroidElement> Login() throws InterruptedException, MalformedURLException
	{
		//Login Stage
		AndroidDriver<AndroidElement> driver = Capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
		TouchAction t = new TouchAction(driver);		
				
		//Locate Email TextBox:
		driver.findElement(By.xpath("(//android.widget.Button)")).click();
		WebElement EmailAddress = driver.findElementByXPath("//*[@text='Email address']");
		t.tap(tapOptions().withElement(element(EmailAddress))).perform();
						
		//type Email:
		Actions action = new Actions(driver);
		action.sendKeys(EmailAddress, "tarek.niazy2@gmail.com").perform();
		
		//Remove Keyboard:
		driver.hideKeyboard();
		
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
	
	public static String RandomString()
	{
		//Generating Random String:
				// create a string of all characters
			    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

			    // create random string builder
			    StringBuilder sb = new StringBuilder();

			    // create an object of Random class
			    Random random = new Random();

			    // specify length of random string
			    int length = 7;

			    for(int i = 0; i < length; i++) {

			      // generate random index number
			      int index = random.nextInt(alphabet.length());

			      // get character specified by index
			      // from the string
			      char randomChar = alphabet.charAt(index);

			      // append the character to string builder
			      sb.append(randomChar);
			    }

			    String randomString = sb.toString();
			    
			    return randomString;
	}
	
	@Test
	public void EditingDescription() throws MalformedURLException, InterruptedException
	{
		AndroidDriver<AndroidElement> driver = Login();
		Thread.sleep(12000);
		TouchAction t = new TouchAction(driver);
		Actions action = new Actions(driver);
		//Click on Profile Button:
		driver.findElementsByClassName("android.widget.Button").get(2).click();
		Thread.sleep(2000);
		
		//Click on Description Box:
		driver.findElementByXPath("//*[contains(@content-desc,'Description')]").click();
		//*[contains(@attribute name,’ part of attribute value’)]”.
		
		//Click on EditBox (At top Right):
		driver.findElementByXPath("//*[@content-desc='Edit']").click();
		Thread.sleep(500);
		
		//Click on Typing Box:
		driver.findElementByXPath("//android.widget.EditText").click();
		
		//Clear Typing Box:
		WebElement Description = driver.findElementByXPath("//android.widget.EditText");
		
		int Length = Description.getText().length();
		
		System.out.println(Length);
		
		for(int i = 0 ; i < Length ; i++)
			
		{
			
			  action.sendKeys(Description,Keys.BACK_SPACE).perform();
		}
		
		//Type:
		String Random = RandomString();
		action.sendKeys(Description,Random).perform();
		
		//Click on Done:
		driver.findElementByXPath("//android.widget.Button[@content-desc='Done']").click();
		Thread.sleep(300);
		
		Thread.sleep(1000);
		driver.quit();
	}
	
	
	@Test
	public void EditingOccupation() throws MalformedURLException, InterruptedException
	{
		AndroidDriver<AndroidElement> driver = Login();
		Thread.sleep(12000);
		TouchAction t = new TouchAction(driver);
		Actions action = new Actions(driver);
		
		
		//Click on Profile Button:
		driver.findElementsByClassName("android.widget.Button").get(2).click();
		
		//Click on Occupation:
		driver.findElementByXPath("//*[contains(@content-desc,'Occupation')]").click();
		
		//Click on TextBox:
		driver.findElementByXPath("//android.widget.EditText").click();
		WebElement T = driver.findElementByXPath("//android.widget.EditText");
		
		//Clear TextBox:
		
		for(int i = 0 ; i < T.getText().length() ; i++)
		{
			action.sendKeys(T, Keys.BACK_SPACE).perform();
		}
		
		//Type:
		String Random = RandomString(); 
		action.sendKeys(T, Random).perform();
		
		//Click on Done:
		driver.findElementByXPath("//android.widget.Button[@content-desc='Done']").click();
		Thread.sleep(300);
		
		System.out.println(Random);
		
		Thread.sleep(1000);
		driver.quit();
		
	}
	
	@Test
	public void EditingCurrentCity() throws MalformedURLException, InterruptedException
	{
		AndroidDriver<AndroidElement> driver = Login();
		Thread.sleep(12000);
		TouchAction t = new TouchAction(driver);
		Actions action = new Actions(driver);
				
		//Click on Profile Button:
		driver.findElementsByClassName("android.widget.Button").get(2).click();
		
		//Click on CurrentCity:
		driver.findElementByXPath("//*[contains(@content-desc,'CurrentCity')]").click();
		
		//Click on TextBox:
		driver.findElementByXPath("//android.widget.EditText").click();
		WebElement T = driver.findElementByXPath("//android.widget.EditText");
		
		//Clear Textbox:
		for(int i = 0 ; i < T.getText().length() ; i++)
		{
			action.sendKeys(T, Keys.BACK_SPACE).perform();
		}
		
		//Type:
		String Random = RandomString(); 
		action.sendKeys(T,Random).perform();
				
		//Click on Done:
		driver.findElementByXPath("//android.widget.Button[@content-desc='Done']").click();
		Thread.sleep(300);
		
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test
	public void EditingHometown() throws MalformedURLException, InterruptedException
	{
		AndroidDriver<AndroidElement> driver = Login();
		Thread.sleep(12000);
		TouchAction t = new TouchAction(driver);
		Actions action = new Actions(driver);
				
		//Click on Profile Button:
		driver.findElementsByClassName("android.widget.Button").get(2).click();
		
		
		//Swipe down, LongPress on 0Photos and Swipe up\
		WebElement X = driver.findElementByXPath("//*[contains(@content-desc,'Photos')]");
		WebElement Y = driver.findElementByXPath("//*[contains(@content-desc,'CurrentCity')]");
		t.longPress(longPressOptions().withElement(element(Y)).withDuration(ofSeconds(2))).moveTo(element(X)).release().perform();
		
		//Click on Hometown:
		driver.findElementByXPath("//*[contains(@content-desc,'Hometown')]").click();
		
		//Click on TextBox:
		driver.findElementByXPath("//android.widget.EditText").click();
		WebElement T = driver.findElementByXPath("//android.widget.EditText");
		
		//Clear Textbox:
		for(int i = 0 ; i < T.getText().length() ; i++)
		{
			action.sendKeys(T, Keys.BACK_SPACE).perform();
		}
				
		//Type:
		String Random = RandomString();
		action.sendKeys(T,Random).perform();
				
		//Click on Done:
		driver.findElementByXPath("//android.widget.Button[@content-desc='Done']").click();
		Thread.sleep(300);
		
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test
	public void EditAll() throws MalformedURLException, InterruptedException
	{
		AndroidDriver<AndroidElement> driver = Login();
		Thread.sleep(12000);
		TouchAction t = new TouchAction(driver);
		Actions action = new Actions(driver);
		
		//Click on Profile Button:
		
		driver.findElementsByClassName("android.widget.Button").get(2).click();
		
		//Click on Description Box:
		driver.findElementByXPath("//*[contains(@content-desc,'Description')]").click();
		//*[contains(@attribute name,’ part of attribute value’)]”.
				
		//Click on EditBox (At top Right):
		driver.findElementByXPath("//*[@content-desc='Edit']").click();
		Thread.sleep(500);
				
		//Click on Typing Box:
		driver.findElementByXPath("//android.widget.EditText").click();
				
		//Clear Typing Box:
		WebElement Description = driver.findElementByXPath("//android.widget.EditText");
		
		int Length = Description.getText().length();
				
		System.out.println(Length);
				
		for(int i = 0 ; i < Length ; i++)
					
		{
					
			 action.sendKeys(Description,Keys.BACK_SPACE).perform();
		}
				
		//Type:
		String Random = RandomString();
		action.sendKeys(Description,Random).perform();
				
		//Click on Done:
		driver.findElementByXPath("//android.widget.Button[@content-desc='Done']").click();
		Thread.sleep(300);
		
		//Click on Occupation:
		driver.findElementByXPath("//*[contains(@content-desc,'Occupation')]").click();
				
		//Click on TextBox:
		driver.findElementByXPath("//android.widget.EditText").click();
		WebElement T = driver.findElementByXPath("//android.widget.EditText");
				
		//Clear TextBox:
				
		for(int i = 0 ; i < T.getText().length() ; i++)
		{
			action.sendKeys(T, Keys.BACK_SPACE).perform();
		}
				
		//Type:
		String Random1 = RandomString(); 
		action.sendKeys(T, Random1).perform();
				
		//Click on Done:
		driver.findElementByXPath("//android.widget.Button[@content-desc='Done']").click();
		Thread.sleep(300);
		
		//Click on CurrentCity:
		driver.findElementByXPath("//*[contains(@content-desc,'CurrentCity')]").click();
				
		//Click on TextBox:
		driver.findElementByXPath("//android.widget.EditText").click();
		WebElement T1 = driver.findElementByXPath("//android.widget.EditText");
				
		//Clear Textbox:
		for(int i = 0 ; i < T1.getText().length() ; i++)
		{
			action.sendKeys(T1, Keys.BACK_SPACE).perform();
		}
				
		//Type:
		String Random2 = RandomString(); 
		action.sendKeys(T1,Random2).perform();
						
		//Click on Done:
		driver.findElementByXPath("//android.widget.Button[@content-desc='Done']").click();
		Thread.sleep(300);
		
		//Swipe down, LongPress on 0Photos and Swipe up\
		WebElement X = driver.findElementByXPath("//*[contains(@content-desc,'Photos')]");
		WebElement Y = driver.findElementByXPath("//*[contains(@content-desc,'CurrentCity')]");
		t.longPress(longPressOptions().withElement(element(Y)).withDuration(ofSeconds(2))).moveTo(element(X)).release().perform();
				
		//Click on Hometown:
		driver.findElementByXPath("//*[contains(@content-desc,'Hometown')]").click();
				
		//Click on TextBox:
		driver.findElementByXPath("//android.widget.EditText").click();
		WebElement T2 = driver.findElementByXPath("//android.widget.EditText");
				
		//Clear Textbox:
		for(int i = 0 ; i < T.getText().length() ; i++)
		{
			action.sendKeys(T, Keys.BACK_SPACE).perform();
		}
						
		//Type:
		String Random3 = RandomString();
		action.sendKeys(T,Random3).perform();
						
		//Click on Done:
		driver.findElementByXPath("//android.widget.Button[@content-desc='Done']").click();
		Thread.sleep(300);
				
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test
	public void EditingUserEmail() throws MalformedURLException, InterruptedException
	{
		AndroidDriver<AndroidElement> driver = Login();
		Thread.sleep(12000);
		TouchAction t = new TouchAction(driver);
		Actions action = new Actions(driver);
				
		//Click on Profile Button:
		driver.findElementsByClassName("android.widget.Button").get(2).click();
		
		//Swipe down, LongPress on Photos and Swipe up\
		WebElement X = driver.findElementByXPath("//*[contains(@content-desc,'Photos')]");
		WebElement Y = driver.findElementByXPath("//*[contains(@content-desc,'CurrentCity')]");
		t.longPress(longPressOptions().withElement(element(Y)).withDuration(ofSeconds(2))).moveTo(element(X)).release().perform();
		
		//Click on Email:
		driver.findElementByXPath("//*[contains(@content-desc,'Email')]").click();
		Thread.sleep(300);
		
		//Click on Back:
		driver.findElementByXPath("//android.widget.Button[@content-desc='Back']").click();
		Thread.sleep(300);
		
		Thread.sleep(1000);
		driver.quit();
				
	}
}
