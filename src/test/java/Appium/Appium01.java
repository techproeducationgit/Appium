package Appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium01 {
    @Test
    public void test() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//setCapability() metodunu farkli sekillerde yazabilirsiniz
//        desiredCapabilities.setCapability("automationName","UiAutomator2");
//        desiredCapabilities.setCapability(CapabilityType.PLATFORM_NAME,"Android");
//https://appium.io/docs/en/writing-running-appium/caps/index.html
        //gerekli bilgiler detayli olarak linkte var

        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Emulator");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
//http://localhost:4723/wd/hub
        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapabilities);

//        if(driver.isDeviceLocked()) {
//            driver.unlockDevice();
//        }
        /*
        eger telefon kullanmak istiyorsaniz developer options aktif hale getirlemeli ve USB Debugging acik olmali
        USB vasitasiyle gercek telefonlardada test yapabilirsiniz
         */

    }
}
