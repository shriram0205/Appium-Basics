package webapp;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import org.testng.annotations.BeforeMethod;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class Facebook {
	AndroidDriver<AndroidElement> driver;
  @Test
  public void f() throws InterruptedException {
	  driver.get("https://m.facebook.com");
	  Thread.sleep(2000);
	  driver.findElementById("signup-button").click();
	  Thread.sleep(5000);
	  driver.findElementByName("firstname").sendKeys("Shriram");
	  driver.findElementByName("lastname").sendKeys("Suryanarayanan");
	  driver.findElementByXPath("//button[@type='submit']").click();
	  Thread.sleep(2000);
	  driver.findElementByName("reg_email__").sendKeys("123456789");
	  driver.findElementByXPath("//button[@type='submit']").click();
	  Thread.sleep(2000);
	  Select s = new Select(driver.findElementById("day"));
	  s.selectByValue("2");
	  Select s1 = new Select(driver.findElementById("month"));
	  s1.selectByVisibleText("May");
	  Select s2 = new Select(driver.findElementById("year"));
	  s2.selectByVisibleText("1991");
	  driver.findElementByXPath("//button[@type='submit']").click();
	  Thread.sleep(1000);
	  driver.findElementById("u_0_d").click();
	  driver.findElementByXPath("input[@value='2']").click();
	  driver.findElementByXPath("//button[@type='submit']").click();
	  
	  
  }
  @BeforeMethod
  public void beforeMethod() throws MalformedURLException {
	  DesiredCapabilities caps = new DesiredCapabilities();
	  caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
	  caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Browser");
	  driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),caps);
  }

  @AfterMethod
  public void afterMethod() throws InterruptedException {
	  driver.close();
  }

}
