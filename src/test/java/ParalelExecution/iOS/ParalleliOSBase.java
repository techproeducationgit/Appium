package ParalelExecution.iOS;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ParalleliOSBase {

    public static IOSDriver<IOSElement> iosDriver(String deviceName, String platformVersion,String wdaLocalPort,String udid,String port) throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"XCUITest");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"iOS");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,platformVersion);
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,deviceName);
        desiredCapabilities.setCapability("bundleId","com.example.apple-samplecode.UICatalog");
        //desiredCapabilities.setCapability("app","/Users/ayyildiz/Library/Developer/Xcode/DerivedData/UIKitCatalog-fxrdyeygsclnwverqkwwjyntnxtx/Build/Products/Debug-iphonesimulator/UIKitCatalog.app");
        desiredCapabilities.setCapability("wdaLocalPort",wdaLocalPort);//8100
        desiredCapabilities.setCapability("udid",udid);

        IOSDriver<IOSElement> driver = new IOSDriver<IOSElement>(new URL("http://127.0.0.1:"+port+"/wd/hub"),desiredCapabilities);//4327
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

       return driver;
    }

}
