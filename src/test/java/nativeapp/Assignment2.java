package nativeapp;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;

public class Assignment2 {
	AndroidDriver<AndroidElement> driver;
  @Test
  public void cloning() throws InterruptedException {
	  driver.findElementByAccessibilityId("Animation").click();
	  Thread.sleep(2000);
	  driver.findElementByAccessibilityId("Cloning").click();
	  Thread.sleep(2000);
	  System.out.println(driver.findElementsByXPath("//android.view.View[@bounds='[0,156][1600,900]']").size());
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
	  driver.close();
  }

}
