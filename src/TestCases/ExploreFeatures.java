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

public class ExploreFeatures extends Base {
	
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
	
	@Test(enabled=false)
	public void CommentingFromInside() throws InterruptedException, MalformedURLException
	{
		AndroidDriver<AndroidElement> driver = Login();
		TouchAction t = new TouchAction(driver);
		Actions action = new Actions(driver);
		Thread.sleep(18000);
		
		//Click on Image:
		driver.findElementByXPath("//android.widget.ImageView").click();
		Thread.sleep(2000);
		
		//Click on CommentIcon:
		driver.findElementsByClassName("android.widget.Button").get(2).click();
		
		//Click on EditBox:
		WebElement Edit = driver.findElementByXPath("//android.widget.EditText[@text='Write a comment...']");
		t.tap(tapOptions().withElement(element(Edit))).perform();
		
		//Type:
		action.sendKeys(Edit,"Hi this is my first automation test :)").perform();
		
		//Remove Keyboard:
		driver.hideKeyboard();
		
		//Click on Post:
		driver.findElementByXPath("//*[@content-desc='Post']").click();
		Thread.sleep(3000);
		
		//Click on Back:
		driver.findElementByXPath("//*[@content-desc='Back']").click();
		
		//Click on X button:
		driver.findElementsByXPath("//android.widget.Button").get(0).click();
		
		
		Thread.sleep(4000);
		driver.quit();
	}
	
	@Test(enabled=false)
	public void CommentingFromOutside() throws InterruptedException, MalformedURLException
	{
		AndroidDriver<AndroidElement> driver = Login();
		TouchAction t = new TouchAction(driver);
		Actions action = new Actions(driver);
		Thread.sleep(18000);
		
		//Click of CommentIcon on the Image:
		driver.findElementsByClassName("android.widget.Button").get(4).click();
		
		//Click on EditBox:
		WebElement Edit = driver.findElementByXPath("//android.widget.EditText[@text='Write a comment...']");
		t.tap(tapOptions().withElement(element(Edit))).perform();
				
		//Type:
		action.sendKeys(Edit,"Testing Comments from Outside").perform();
				
		//Remove Keyboard:
		driver.hideKeyboard();
				
		//Click on Post:
		driver.findElementByXPath("//*[@content-desc='Post']").click();
		Thread.sleep(3000);
				
		//Click on Back:
		driver.findElementByXPath("//*[@content-desc='Back']").click();
		
		//Checking for Recent Comment-----------------------------//

		//Click on Search Button:
		driver.findElementsByClassName("android.widget.Button").get(1).click();
		
		//ReClick on Explore Button:
		driver.findElementsByClassName("android.widget.Button").get(0).click();
		Thread.sleep(20000);
		
		Thread.sleep(4000);
		driver.quit();
	}
	
	
	@Test
	public void FavoringOnPicture() throws InterruptedException, MalformedURLException
	{
		AndroidDriver<AndroidElement> driver = Login();
		TouchAction t = new TouchAction(driver);
		Actions action = new Actions(driver);
		Thread.sleep(18000);
		
		//Click of Favoring on the Image:
		driver.findElementsByClassName("android.widget.Button").get(3).click();
		
		//Refreshing Stage------------------------//
		//Click on Search Button:
		driver.findElementsByClassName("android.widget.Button").get(1).click();
				
		//ReClick on Explore Button:
		driver.findElementsByClassName("android.widget.Button").get(0).click();
		Thread.sleep(18000);
				
		Thread.sleep(2000);
		driver.quit();
	}

}
