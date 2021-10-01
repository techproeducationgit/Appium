package ParalelExecution.iOS;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.HashMap;

public class ParalleliOSTest extends ParalleliOSBase {

    @Test////14C8B848-B927-44D4-8000-A995DB82E886
    public void test01() throws MalformedURLException {
        IOSDriver<IOSElement> driver = iosDriver("iPhone 12","14.5","8100","14C8B848-B927-44D4-8000-A995DB82E886","10000");

        HashMap<String, Object> scrollObject = new HashMap<>();
        scrollObject.put("direction","down");
        scrollObject.put("value", "Web View");
        driver.executeScript("mobile:scroll", scrollObject);

        driver.findElementByXPath("//XCUIElementTypeStaticText[@name='Web View']").click();

        driver.quit();
    }

    @Test//A146FAA0-8C74-478C-8CC7-F1D32B92E08E
    public void test02() throws MalformedURLException {
        IOSDriver<IOSElement> driver = iosDriver("iPhone 8","14.5","8000","A146FAA0-8C74-478C-8CC7-F1D32B92E08E","10001");
        HashMap<String, Object> scrollObject = new HashMap<>();
        scrollObject.put("direction","down");
        scrollObject.put("value", "Web View");
        driver.executeScript("mobile:scroll", scrollObject);

        driver.findElementByXPath("//XCUIElementTypeStaticText[@name='Web View']").click();
        driver.quit();
    }
}
