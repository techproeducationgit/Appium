package ParalelExecution.Android;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ParalelAndroidBase {
     public static AndroidDriver<MobileElement> androidDriver(String port,String platformVersion,String deviceName,String udid, String systemPort) throws MalformedURLException {
         DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
         desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
         desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
         desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,platformVersion);
         desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,deviceName);
         desiredCapabilities.setCapability(MobileCapabilityType.UDID,udid);
         desiredCapabilities.setCapability(MobileCapabilityType.APP,"/Users/ayyildiz/IdeaProjects/appiumEnglish/Apps/Calculator.apk");
         desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET,true);
         desiredCapabilities.setCapability("systemPort",systemPort);

         AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:"+port+"/wd/hub"),desiredCapabilities);
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         return driver;

     }
}
