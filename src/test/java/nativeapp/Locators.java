package nativeapp;

import org.testng.annotations.Test;

//import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;

import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;

public class Locators {
	AndroidDriver<AndroidElement> driver;
  @Test
  public void f() throws InterruptedException {
	  
	  driver.findElementById("android:id/text1").click();
	  driver.navigate().back();
	  Thread.sleep(2000);
	  driver.findElementByAccessibilityId("Graphics").click();
	  driver.pressKeyCode(AndroidKeyCode.BACK);
	  Thread.sleep(2000);
	  driver.findElementByXPath("//android.widget.TextView[@text='Media']").click();
	  driver.pressKeyCode(AndroidKeyCode.BACK);
	  Thread.sleep(2000);
	  driver.findElementsByClassName("android.widget.TextView").get(7).click();
	  driver.pressKeyCode(AndroidKeyCode.BACK);
	  Thread.sleep(2000);
	  driver.findElementByAndroidUIAutomator("text(\"OS\")").click();
	  driver.pressKeyCode(AndroidKeyCode.BACK);
	  Thread.sleep(2000);
	  driver.findElementByAndroidUIAutomator("new UISelector().text(\"Preference\")").click();
	  driver.pressKeyCode(AndroidKeyCode.BACK);
	  System.out.println("No of scrollable items" + driver.findElementsByAndroidUIAutomator("new UiSelector().scrollable(false))").size());
	  
	  
  }
  @BeforeMethod
  public void beforeMethod() throws MalformedURLException {
	  File f= new File("AUT/ApiDemos.apk");
	  DesiredCapabilities caps = new DesiredCapabilities();
	  caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
	  caps.setCapability(MobileCapabilityType.APP, f);
	  driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),caps);
  }

  @AfterMethod
  public void afterMethod() throws InterruptedException {
	  Thread.sleep(2000);
	  driver.close();
  }

}
