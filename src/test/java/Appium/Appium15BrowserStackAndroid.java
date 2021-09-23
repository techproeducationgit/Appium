package Appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Appium15BrowserStackAndroid {
    @Test
    public void browserStackAndroid() throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();
        // Set your access credentials
        caps.setCapability("browserstack.user", "mehmetayyildiz_HFVDMX");
        caps.setCapability("browserstack.key", "fwuU7xxcgZRSwegDPgvh");

        // Set URL of the application under test
        caps.setCapability("app", "bs://b8368b9628b4416aa7f8b631b8235753bea00b07");

        // Specify device and os_version for testing
        caps.setCapability("device", "Samsung Galaxy S10");
        caps.setCapability("os_version", "9.0");

        // Set other BrowserStack capabilities
        caps.setCapability("project", "First Java Project");
        caps.setCapability("build", "Java Android");
        caps.setCapability("name", "first_test");


        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
                new URL("http://hub.browserstack.com/wd/hub"), caps);


        /* Write your Custom code here */

        driver.findElementById("com.touchboarder.android.api.demos:id/buttonDefaultPositive").click();

        driver.findElementByXPath("//android.widget.TextView[@text='API Demos']").click();

        driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();

        driver.findElementByXPath("//*[@text='3. Preference dependencies']").click();
//check box a gore kosul
//        String isChecked = driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"android:id/checkbox\").checkable(true)").getAttribute("checked");
//
//        if (isChecked.equals("false")) {
//            driver.findElementById("android:id/checkbox").click();
//            Thread.sleep(2000);
//        }

        //Wifi settings e gore
        List<AndroidElement> list = driver.findElementsByAndroidUIAutomator("UiSelector().className(\"android.widget.TextView\").text(\"WiFi settings\").enabled(false)");
        if (list.size() > 0) {
            String isEnabled = driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.TextView\").text(\"WiFi settings\").enabled(false)").getAttribute("enabled");
            if (isEnabled.equals("false")) {
                driver.findElementById("android:id/checkbox").click();
            }
        }
        Thread.sleep(2000);
        driver.findElementByXPath("//android.widget.TextView[@text='WiFi settings']").click();
        Thread.sleep(2000);
        driver.findElementById("android:id/edit").sendKeys("test");
        Thread.sleep(2000);
        driver.findElementById("android:id/button1").click();



        // Invoke driver.quit() after the test is done to indicate that the test is completed.
        driver.quit();
    }
}
