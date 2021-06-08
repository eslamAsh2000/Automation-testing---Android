package TestCases;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class Base {

	public static AndroidDriver<AndroidElement> Capabilities() throws MalformedURLException {
		// TODO Auto-generated method stub
		//Appium Code
		
		File f = new File("src");
		File fs = new File(f,"app-release.apk");
		
		DesiredCapabilities Cap = new DesiredCapabilities();
		Cap.setCapability(MobileCapabilityType.DEVICE_NAME, "YousefEmulator");
		Cap.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.ANDROID);
		Cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");//new step
		Cap.setCapability(MobileCapabilityType.APP,fs.getAbsolutePath());
		Cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "24");
		AndroidDriver<AndroidElement> driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),Cap );
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
	}

}