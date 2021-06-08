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

public class SignupTest extends Base{
	
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
	
	@Test(enabled=false)
	public void EmptyForm() throws MalformedURLException, InterruptedException
	{
		AndroidDriver<AndroidElement> driver = Capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		TouchAction t = new TouchAction(driver);		
		
		//Click on SignUp:
		driver.findElement(By.xpath("(//android.widget.Button)")).click();
		WebElement Signup = driver.findElementByXPath("//*[@content-desc=' Sign up here']");
		t.tap(tapOptions().withElement(element(Signup))).perform();
		
		//Click on SignUp
		driver.findElement(By.xpath("//*[@content-desc='Sign up']")).click();
		
		Thread.sleep(2000);
		driver.quit();
		
	}
	
	@Test(enabled = false)
	public void FirstNameEmpty() throws InterruptedException, MalformedURLException
	{
		AndroidDriver<AndroidElement> driver = Capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		TouchAction t = new TouchAction(driver);		
		
		//Click on SignUp:
		driver.findElement(By.xpath("(//android.widget.Button)")).click();
		WebElement Signup = driver.findElementByXPath("//*[@content-desc=' Sign up here']");
		t.tap(tapOptions().withElement(element(Signup))).perform();
		
		//Click on Last Name
		WebElement LastName = driver.findElementByXPath("//*[@text='Last name']");
		t.tap(tapOptions().withElement(element(LastName))).perform();
				
		//type Last Name:
		Actions action = new Actions(driver);
		action.sendKeys(LastName, "Adel").perform();
		
		//Remove Keyboard:
		driver.hideKeyboard();
		
		//Click on Your Age:
		WebElement Age = driver.findElementByXPath("//*[@text='Your age']");
		t.tap(tapOptions().withElement(element(Age))).perform();
		
		//type Valid Age > 13:
		action = new Actions(driver);
		action.sendKeys(Age, "15").perform();
		
		//Remove Keyboard:
		driver.hideKeyboard();
		
		//Click on Email Address:
		WebElement EmailAddress = driver.findElementByXPath("//*[@text='Email address']");
		t.tap(tapOptions().withElement(element(EmailAddress))).perform();
				
		//type Email:
		action = new Actions(driver);
		action.sendKeys(EmailAddress, "joegaafar99@gmail.com").perform();
		
		//Remove Keyboard:
		driver.hideKeyboard();
		
		//Click on Password:
		WebElement Password = driver.findElementByXPath("//android.widget.EditText[@text='Password']");
		t.tap(tapOptions().withElement(element(Password))).perform();
						
		//type Password:
		action.sendKeys(Password,"yousefadel12").perform();
		
		//Remove Keyboard:
		driver.hideKeyboard();
		
		//Click on SignUp
		driver.findElement(By.xpath("//*[@content-desc='Sign up']")).click();
		
		Thread.sleep(2000);
		driver.quit();
	}
	
	
	@Test(enabled = false)
	public void LastNameEmpty() throws MalformedURLException, InterruptedException
	{
		AndroidDriver<AndroidElement> driver = Capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		TouchAction t = new TouchAction(driver);		
		
		//Click on SignUp:
		driver.findElement(By.xpath("(//android.widget.Button)")).click();
		WebElement Signup = driver.findElementByXPath("//*[@content-desc=' Sign up here']");
		t.tap(tapOptions().withElement(element(Signup))).perform();
		
		//Click on First Name
		WebElement FirstName = driver.findElementByXPath("//*[@text='First name']");
		t.tap(tapOptions().withElement(element(FirstName))).perform();
				
		//type First Name:
		Actions action = new Actions(driver);
		action.sendKeys(FirstName, "Joe").perform();
		
		//Remove Keyboard:
		driver.hideKeyboard();
		
		//Click on Your Age:
		WebElement Age = driver.findElementByXPath("//*[@text='Your age']");
		t.tap(tapOptions().withElement(element(Age))).perform();
		
		//type Valid Age > 13:
		action = new Actions(driver);
		action.sendKeys(Age, "15").perform();
		
		//Remove Keyboard:
		driver.hideKeyboard();
		
		//Click on Email Address:
		WebElement EmailAddress = driver.findElementByXPath("//*[@text='Email address']");
		t.tap(tapOptions().withElement(element(EmailAddress))).perform();
				
		//type Email:
		action = new Actions(driver);
		action.sendKeys(EmailAddress, "joegaafar99@gmail.com").perform();
		
		//Remove Keyboard:
		driver.hideKeyboard();
		
		//Click on Password:
		WebElement Password = driver.findElementByXPath("//android.widget.EditText[@text='Password']");
		t.tap(tapOptions().withElement(element(Password))).perform();
						
		//type Password:
		action.sendKeys(Password,"yousefadel12").perform();
		
		//Remove Keyboard:
		driver.hideKeyboard();
		
		//Click on SignUp
		driver.findElement(By.xpath("//*[@content-desc='Sign up']")).click();
		
		Thread.sleep(2000);
		driver.quit();
		
	}
	
	
	@Test(enabled=false)
	public void EmptyAge() throws InterruptedException, MalformedURLException
	{
		AndroidDriver<AndroidElement> driver = Capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		TouchAction t = new TouchAction(driver);		
		
		//Click on SignUp:
		driver.findElement(By.xpath("(//android.widget.Button)")).click();
		WebElement Signup = driver.findElementByXPath("//*[@content-desc=' Sign up here']");
		t.tap(tapOptions().withElement(element(Signup))).perform();
		
		//Click on First Name
		WebElement FirstName = driver.findElementByXPath("//*[@text='First name']");
		t.tap(tapOptions().withElement(element(FirstName))).perform();
				
		//type First Name:
		Actions action = new Actions(driver);
		action.sendKeys(FirstName, "Joe").perform();
		
		//Remove Keyboard:
		driver.hideKeyboard();
		
		//Click on Last Name
		WebElement LastName = driver.findElementByXPath("//*[@text='Last name']");
		t.tap(tapOptions().withElement(element(LastName))).perform();
						
		//type Last Name:
		action = new Actions(driver);
		action.sendKeys(LastName, "Adel").perform();
	
		//Remove Keyboard:
		driver.hideKeyboard();
		
		//Click on Email Address:
		WebElement EmailAddress = driver.findElementByXPath("//*[@text='Email address']");
		t.tap(tapOptions().withElement(element(EmailAddress))).perform();
				
		//type Email:
		action = new Actions(driver);
		action.sendKeys(EmailAddress, "joegaafar99@gmail.com").perform();
		
		//Remove Keyboard:
		driver.hideKeyboard();
		
		//Click on Password:
		WebElement Password = driver.findElementByXPath("//android.widget.EditText[@text='Password']");
		t.tap(tapOptions().withElement(element(Password))).perform();
						
		//type Password:
		action.sendKeys(Password,"yousefadel12").perform();
		
		//Remove Keyboard:
		driver.hideKeyboard();
		
		//Click on SignUp
		driver.findElement(By.xpath("//*[@content-desc='Sign up']")).click();
		
		Thread.sleep(2000);
		driver.quit();
	}
	
	@Test(enabled=false)
	public void AgeLimitation() throws InterruptedException, MalformedURLException
	{
		AndroidDriver<AndroidElement> driver = Capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		TouchAction t = new TouchAction(driver);		
		
		//Click on SignUp:
		driver.findElement(By.xpath("(//android.widget.Button)")).click();
		WebElement Signup = driver.findElementByXPath("//*[@content-desc=' Sign up here']");
		t.tap(tapOptions().withElement(element(Signup))).perform();
		
		//Click on First Name
		WebElement FirstName = driver.findElementByXPath("//*[@text='First name']");
		t.tap(tapOptions().withElement(element(FirstName))).perform();
				
		//type First Name:
		Actions action = new Actions(driver);
		action.sendKeys(FirstName, "Joe").perform();
		
		//Remove Keyboard:
		driver.hideKeyboard();
		
		//Click on Last Name
		WebElement LastName = driver.findElementByXPath("//*[@text='Last name']");
		t.tap(tapOptions().withElement(element(LastName))).perform();
						
		//type Last Name:
		action = new Actions(driver);
		action.sendKeys(LastName, "Adel").perform();
	
		//Remove Keyboard:
		driver.hideKeyboard();
		
		//Click on Email Address:
		WebElement EmailAddress = driver.findElementByXPath("//*[@text='Email address']");
		t.tap(tapOptions().withElement(element(EmailAddress))).perform();
				
		//type Email:
		action = new Actions(driver);
		action.sendKeys(EmailAddress, "joegaafar99@gmail.com").perform();
		
		//Remove Keyboard:
		driver.hideKeyboard();
				
		//Click on Your Age:
		WebElement Age = driver.findElementByXPath("//*[@text='Your age']");
		t.tap(tapOptions().withElement(element(Age))).perform();
						
		//type Invalid Age < 13:
		action = new Actions(driver);
		action.sendKeys(Age, "12").perform();
				
		//Remove Keyboard:
		driver.hideKeyboard();
		
		//Click on Password:
		WebElement Password = driver.findElementByXPath("//android.widget.EditText[@text='Password']");
		t.tap(tapOptions().withElement(element(Password))).perform();
						
		//type Password:
		action.sendKeys(Password,"yousefadel12").perform();
		
		//Remove Keyboard:
		driver.hideKeyboard();
		
		//Click on SignUp
		driver.findElement(By.xpath("//*[@content-desc='Sign up']")).click();
		
		Thread.sleep(2000);
		driver.quit();
	}
	
	@Test(enabled=false)
	public void EmptyEmailAddress() throws InterruptedException, MalformedURLException
	{
		AndroidDriver<AndroidElement> driver = Capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		TouchAction t = new TouchAction(driver);		
		
		//Click on SignUp:
		driver.findElement(By.xpath("(//android.widget.Button)")).click();
		WebElement Signup = driver.findElementByXPath("//*[@content-desc=' Sign up here']");
		t.tap(tapOptions().withElement(element(Signup))).perform();
		
		//Click on First Name
		WebElement FirstName = driver.findElementByXPath("//*[@text='First name']");
		t.tap(tapOptions().withElement(element(FirstName))).perform();
				
		//type First Name:
		Actions action = new Actions(driver);
		action.sendKeys(FirstName, "Joe").perform();
		
		//Remove Keyboard:
		driver.hideKeyboard();
		
		//Click on Last Name
		WebElement LastName = driver.findElementByXPath("//*[@text='Last name']");
		t.tap(tapOptions().withElement(element(LastName))).perform();
						
		//type Last Name:
		action = new Actions(driver);
		action.sendKeys(LastName, "Adel").perform();
	
		//Remove Keyboard:
		driver.hideKeyboard();
		
		//Click on Your Age:
		WebElement Age = driver.findElementByXPath("//*[@text='Your age']");
		t.tap(tapOptions().withElement(element(Age))).perform();
						
		//type Valid Age >= 13:
		action = new Actions(driver);
		action.sendKeys(Age, "13").perform();
				
		//Remove Keyboard:
		driver.hideKeyboard();
		
		//Click on Password:
		WebElement Password = driver.findElementByXPath("//android.widget.EditText[@text='Password']");
		t.tap(tapOptions().withElement(element(Password))).perform();
						
		//type Password:
		action.sendKeys(Password,"yousefadel12").perform();
		
		//Remove Keyboard:
		driver.hideKeyboard();
		
		//Click on SignUp
		driver.findElement(By.xpath("//*[@content-desc='Sign up']")).click();
		
		Thread.sleep(2000);
		driver.quit();
	}
	
	@Test(enabled=false)
	public void InvalidEmailAddress() throws InterruptedException, MalformedURLException
	{
		AndroidDriver<AndroidElement> driver = Capabilities();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		TouchAction t = new TouchAction(driver);		
		
		//Click on SignUp:
		driver.findElement(By.xpath("(//android.widget.Button)")).click();
		WebElement Signup = driver.findElementByXPath("//*[@content-desc=' Sign up here']");
		t.tap(tapOptions().withElement(element(Signup))).perform();
		
		//Click on First Name
		WebElement FirstName = driver.findElementByXPath("//*[@text='First name']");
		t.tap(tapOptions().withElement(element(FirstName))).perform();
				
		//type First Name:
		Actions action = new Actions(driver);
		action.sendKeys(FirstName, "Joe").perform();
		
		//Remove Keyboard:
		driver.hideKeyboard();
		
		//Click on Last Name
		WebElement LastName = driver.findElementByXPath("//*[@text='Last name']");
		t.tap(tapOptions().withElement(element(LastName))).perform();
						
		//type Last Name:
		action = new Actions(driver);
		action.sendKeys(LastName, "Adel").perform();
	
		//Remove Keyboard:
		driver.hideKeyboard();
		
		//Click on Email Address:
		WebElement EmailAddress = driver.findElementByXPath("//*[@text='Email address']");
		t.tap(tapOptions().withElement(element(EmailAddress))).perform();
				
		//type Email:
		action = new Actions(driver);
		action.sendKeys(EmailAddress, "joegaafar99.com").perform();
		
		//Remove Keyboard:
		driver.hideKeyboard();
				
		//Click on Your Age:
		WebElement Age = driver.findElementByXPath("//*[@text='Your age']");
		t.tap(tapOptions().withElement(element(Age))).perform();
						
		//type valid Age >= 13:
		action = new Actions(driver);
		action.sendKeys(Age, "13").perform();
				
		//Remove Keyboard:
		driver.hideKeyboard();
		
		//Click on Password:
		WebElement Password = driver.findElementByXPath("//android.widget.EditText[@text='Password']");
		t.tap(tapOptions().withElement(element(Password))).perform();
						
		//type Password:
		action.sendKeys(Password,"yousefadel12").perform();
		
		//Remove Keyboard:
		driver.hideKeyboard();
		
		//Click on SignUp
		driver.findElement(By.xpath("//*[@content-desc='Sign up']")).click();
		
		Thread.sleep(2000);
		driver.quit();
	}
	
	@Test(enabled=false)
	public void EmptyPassword() throws InterruptedException, MalformedURLException
	{
		AndroidDriver<AndroidElement> driver = Capabilities();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		TouchAction t = new TouchAction(driver);		
		
		//Click on SignUp:
		driver.findElement(By.xpath("(//android.widget.Button)")).click();
		WebElement Signup = driver.findElementByXPath("//*[@content-desc=' Sign up here']");
		t.tap(tapOptions().withElement(element(Signup))).perform();
		
		//Click on First Name
		WebElement FirstName = driver.findElementByXPath("//*[@text='First name']");
		t.tap(tapOptions().withElement(element(FirstName))).perform();
				
		//type First Name:
		Actions action = new Actions(driver);
		action.sendKeys(FirstName, "Joe").perform();
		
		//Remove Keyboard:
		driver.hideKeyboard();
		
		//Click on Last Name
		WebElement LastName = driver.findElementByXPath("//*[@text='Last name']");
		t.tap(tapOptions().withElement(element(LastName))).perform();
						
		//type Last Name:
		action = new Actions(driver);
		action.sendKeys(LastName, "Adel").perform();
	
		//Remove Keyboard:
		driver.hideKeyboard();
		
		//Click on Email Address:
		WebElement EmailAddress = driver.findElementByXPath("//*[@text='Email address']");
		t.tap(tapOptions().withElement(element(EmailAddress))).perform();
				
		//type Email:
		action = new Actions(driver);
		action.sendKeys(EmailAddress, "joegaafar99@gmail.com").perform();
		
		//Remove Keyboard:
		driver.hideKeyboard();
				
		//Click on Your Age:
		WebElement Age = driver.findElementByXPath("//*[@text='Your age']");
		t.tap(tapOptions().withElement(element(Age))).perform();
						
		//type valid Age >= 13:
		action = new Actions(driver);
		action.sendKeys(Age, "13").perform();
				
		//Remove Keyboard:
		driver.hideKeyboard();
		
		//Click on SignUp
		driver.findElement(By.xpath("//*[@content-desc='Sign up']")).click();
		
		Thread.sleep(2000);
		driver.quit();
	}
	
	@Test(enabled=false)
	public void InvalidPassword() throws InterruptedException, MalformedURLException
	{
		AndroidDriver<AndroidElement> driver = Capabilities();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		TouchAction t = new TouchAction(driver);		
		
		//Click on SignUp:
		driver.findElement(By.xpath("(//android.widget.Button)")).click();
		WebElement Signup = driver.findElementByXPath("//*[@content-desc=' Sign up here']");
		t.tap(tapOptions().withElement(element(Signup))).perform();
		
		//Click on First Name
		WebElement FirstName = driver.findElementByXPath("//*[@text='First name']");
		t.tap(tapOptions().withElement(element(FirstName))).perform();
				
		//type First Name:
		Actions action = new Actions(driver);
		action.sendKeys(FirstName, "Joe").perform();
		
		//Remove Keyboard:
		driver.hideKeyboard();
		
		//Click on Last Name
		WebElement LastName = driver.findElementByXPath("//*[@text='Last name']");
		t.tap(tapOptions().withElement(element(LastName))).perform();
						
		//type Last Name:
		action = new Actions(driver);
		action.sendKeys(LastName, "Adel").perform();
	
		//Remove Keyboard:
		driver.hideKeyboard();
		
		//Click on Email Address:
		WebElement EmailAddress = driver.findElementByXPath("//*[@text='Email address']");
		t.tap(tapOptions().withElement(element(EmailAddress))).perform();
				
		//type Email:
		action = new Actions(driver);
		action.sendKeys(EmailAddress, "joegaafar99@gmail.com").perform();
		
		//Remove Keyboard:
		driver.hideKeyboard();
				
		//Click on Your Age:
		WebElement Age = driver.findElementByXPath("//*[@text='Your age']");
		t.tap(tapOptions().withElement(element(Age))).perform();
						
		//type valid Age >= 13:
		action = new Actions(driver);
		action.sendKeys(Age, "13").perform();
				
		//Remove Keyboard:
		driver.hideKeyboard();
		
		//Click on Password:
		WebElement Password = driver.findElementByXPath("//android.widget.EditText[@text='Password']");
		t.tap(tapOptions().withElement(element(Password))).perform();
						
		//type Password:
		action.sendKeys(Password,"yousef12").perform();
		
		//Remove Keyboard:
		driver.hideKeyboard();

		//Show Password:
		driver.findElementsByClassName("android.widget.Button").get(1).click();
		
		//Remove Keyboard:
		driver.hideKeyboard();
		
		//Click on SignUp
		driver.findElement(By.xpath("//*[@content-desc='Sign up']")).click();
			
		Thread.sleep(2000);
		driver.quit();
	}
	
	@Test
	public void ValidSignin() throws InterruptedException, MalformedURLException
	{
		AndroidDriver<AndroidElement> driver = Capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		TouchAction t = new TouchAction(driver);		
		
		//Click on SignUp:
		driver.findElement(By.xpath("(//android.widget.Button)")).click();
		WebElement Signup = driver.findElementByXPath("//*[@content-desc=' Sign up here']");
		t.tap(tapOptions().withElement(element(Signup))).perform();
		
		//Click on First Name
		WebElement FirstName = driver.findElementByXPath("//*[@text='First name']");
		t.tap(tapOptions().withElement(element(FirstName))).perform();
				
		//type First Name:
		Actions action = new Actions(driver);
		action.sendKeys(FirstName, "Joe").perform();
		
		//Remove Keyboard:
		driver.hideKeyboard();
		
		//Click on Last Name
		WebElement LastName = driver.findElementByXPath("//*[@text='Last name']");
		t.tap(tapOptions().withElement(element(LastName))).perform();
						
		//type Last Name:
		action = new Actions(driver);
		action.sendKeys(LastName, "Adel").perform();
	
		//Remove Keyboard:
		driver.hideKeyboard();
		
		//Click on Email Address:
		WebElement EmailAddress = driver.findElementByXPath("//*[@text='Email address']");
		t.tap(tapOptions().withElement(element(EmailAddress))).perform();
				
		//type Email:
		action = new Actions(driver);
		action.sendKeys(EmailAddress, "joegaafar99@gmail.com").perform();
		
		//Remove Keyboard:
		driver.hideKeyboard();
				
		//Click on Your Age:
		WebElement Age = driver.findElementByXPath("//*[@text='Your age']");
		t.tap(tapOptions().withElement(element(Age))).perform();
						
		//type valid Age >= 13:
		action = new Actions(driver);
		action.sendKeys(Age, "21").perform();
				
		//Remove Keyboard:
		driver.hideKeyboard();
		
		//Click on Password:
		WebElement Password = driver.findElementByXPath("//android.widget.EditText[@text='Password']");
		t.tap(tapOptions().withElement(element(Password))).perform();
						
		//type Password:
		action.sendKeys(Password,"yousefadel12").perform();
		
		//Remove Keyboard:
		driver.hideKeyboard();

		//Show Password:
		driver.findElementsByClassName("android.widget.Button").get(1).click();
		
		//Remove Keyboard:
		driver.hideKeyboard();
		
		String BeforeSignUp = driver.currentActivity();
		System.out.println(BeforeSignUp);
		
		//Click on SignUp
		driver.findElement(By.xpath("//*[@content-desc='Sign up']")).click();
		String AfterSignUp = driver.currentActivity();
		System.out.println(AfterSignUp);
		 
		Thread.sleep(3000);
		driver.quit();
	}
}
