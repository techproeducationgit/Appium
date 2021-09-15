package Appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium05 {
    @Test
    public void test() throws InterruptedException, MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Emulator");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Users/ayyildiz/IdeaProjects/AppiumTurkish/Apps/Calculator.apk");
        //noReset
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
//http://localhost:4723/wd/hub
        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);

        Thread.sleep(4000);

          /*
          install app
          do any mathematical operation
          and verify pre result and final result
           */
        AndroidElement num0 = driver.findElementById("com.google.android.calculator:id/digit_0");
        AndroidElement num1 = driver.findElementById("com.google.android.calculator:id/digit_1");
        AndroidElement num2 = driver.findElementById("com.google.android.calculator:id/digit_2");
        AndroidElement num3 = driver.findElementById("com.google.android.calculator:id/digit_3");
        AndroidElement num4 = driver.findElementById("com.google.android.calculator:id/digit_4");
        AndroidElement num5 = driver.findElementById("com.google.android.calculator:id/digit_5");
        AndroidElement num6 = driver.findElementById("com.google.android.calculator:id/digit_6");
        AndroidElement num7 = driver.findElementById("com.google.android.calculator:id/digit_7");
        AndroidElement num8 = driver.findElementById("com.google.android.calculator:id/digit_8");
        AndroidElement num9 = driver.findElementById("com.google.android.calculator:id/digit_9");

        AndroidElement carpma = driver.findElementByAccessibilityId("multiply");
        AndroidElement esit = driver.findElementByAccessibilityId("equals");

        num1.click();
        num5.click();
        carpma.click();
        num3.click();
        Thread.sleep(2000);
        String expectedResult = driver.findElementById("com.google.android.calculator:id/result_preview").getText();
        Assert.assertEquals(expectedResult,"45");


        Thread.sleep(4000);

        esit.click();

        String actualResult = driver.findElementById("com.google.android.calculator:id/result_final").getText();
        Thread.sleep(4000);
        Assert.assertEquals(actualResult,expectedResult);
        System.out.println("Ex " +expectedResult);
        System.out.println("Ac " + actualResult);


    }
}
