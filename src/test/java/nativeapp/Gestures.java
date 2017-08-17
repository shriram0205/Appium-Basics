package nativeapp;

import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

//import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;

public class Gestures {
	AndroidDriver<AndroidElement> driver;
  @Test
  public void gesturesMethod() throws InterruptedException {
	  
	 /* TouchAction t = new TouchAction(driver);
	  driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
	  Thread.sleep(2000);
	  t.tap(driver.findElementByAccessibilityId("Expandable Lists")).perform();
	  WebElement customAdapter = driver.findElementByXPath("//android.widget.TextView[@text='1. Custom Adapter']");
	  customAdapter.click();
	  Thread.sleep(2000);
	  WebElement peopleNames = driver.findElementByXPath("//android.widget.TextView[@text='People Names']");
	  TouchAction action = new TouchAction(driver);
	  action.longPress(peopleNames);
	  Thread.sleep(2000);*/
	  driver.findElementByXPath("//android.widget.TextView[@text='Media']").click();
	  Thread.sleep(2000);
	  driver.findElementByAccessibilityId("AudioFx").click();
	  Thread.sleep(2000);
	  List<AndroidElement> seekbar = driver.findElementsByClassName("android.widget.SeekBar");
	// get location of seek bar from left
      for(AndroidElement element:seekbar){
	  int start=element.getLocation().getX();
      System.out.println("Startpoint - " + start);
      
      //get location of seekbar from top
      int y=element.getLocation().getY();
      System.out.println("Yaxis - "+ y);
      int end=start + element.getSize().getWidth();
      System.out.println("End point - "+ end);
      
      TouchAction action=new TouchAction(driver);
      //move slider to 50% of width
      int moveTo=(int)(end*0.5);
      action.longPress(start,y).moveTo(moveTo,y).release().perform();
      }
  }
  @BeforeMethod
  public void beforeMethod() throws MalformedURLException {
	  File f= new File("AUT/ApiDemos.apk");
	  DesiredCapabilities caps = new DesiredCapabilities();
	  caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
	  //caps.setCapability(MobileCapabilityType.APP, f);
	  caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Browser");
	  driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),caps);
  }

  @AfterMethod
  public void afterMethod() throws InterruptedException {
	  driver.close();
  }

}
