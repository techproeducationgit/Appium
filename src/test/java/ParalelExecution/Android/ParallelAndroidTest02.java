package ParalelExecution.Android;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class ParallelAndroidTest02 extends ParalelAndroidBase{

    @Test
    public void test01() throws MalformedURLException, InterruptedException {
        AndroidDriver<MobileElement> driver = androidDriver("10001","10.0","RealDevice","1fd655780409","8201");

        Thread.sleep(3000);
        driver.findElementByXPath("//android.widget.TextView[@text='API Demos']").click();
        Thread.sleep(1000);
        driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();

        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Switches\"))");

        driver.findElementByXPath("//android.widget.TextView[@text='Switches']").click();

        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void test02() throws MalformedURLException, InterruptedException {
        AndroidDriver<MobileElement> driver = androidDriver("10000","10.0","Emulator","emulator-5554","8200");

        Thread.sleep(3000);
        driver.findElementByXPath("//android.widget.TextView[@text='API Demos']").click();
        Thread.sleep(1000);
        driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();

        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Switches\"))");

        driver.findElementByXPath("//android.widget.TextView[@text='Switches']").click();

        Thread.sleep(3000);
        driver.quit();

    }

}
