package Appium;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium16BrowserStackIOS {
    @Test
    public void bsIOSTest() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        // Set your access credentials
        caps.setCapability("browserstack.user", "mehmetayyildiz_HFVDMX");
        caps.setCapability("browserstack.key", "fwuU7xxcgZRSwegDPgvh");

        // Set URL of the application under test
        caps.setCapability("app", "bs://14827edba453c8b9135a358e815ac0ea8d3d0f8d");

        // Specify device and os_version for testing
        caps.setCapability("device", "iPhone XS");
        caps.setCapability("os_version", "12");

        // Set other BrowserStack capabilities
       caps.setCapability("project", "First Java Project");
       caps.setCapability("build", "Java iOS");
       caps.setCapability("name", "first_test");


        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        IOSDriver<IOSElement> driver = new IOSDriver<IOSElement>(
                new URL("http://hub-cloud.browserstack.com/wd/hub"), caps);

        /* Write your Custom code here */
        String expectedText = "IOS testing";

        driver.findElementByAccessibilityId("Text Button").click();

        driver.findElementByAccessibilityId("Text Input").sendKeys(expectedText);

        driver.findElementByAccessibilityId("Return").click();

        String actualText = driver.findElementByAccessibilityId("Text Output").getText();

        Assert.assertEquals(actualText,expectedText);

        driver.findElementByXPath("(//XCUIElementTypeButton[@name='UI Elements'])[1]").click();

        Assert.assertEquals(driver.findElementByXPath("//XCUIElementTypeOther[@name='UI Elements']").getText(),"UI Elements");

        // Invoke driver.quit() after the test is done to indicate that the test is completed.
        driver.quit();

    }

    @Test
    public void iosBS() throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();
        // Set your access credentials
        caps.setCapability("browserstack.user", "mehmetayyildiz_HFVDMX");
        caps.setCapability("browserstack.key", "fwuU7xxcgZRSwegDPgvh");

        // Set URL of the application under test
        caps.setCapability("app", "bs://14827edba453c8b9135a358e815ac0ea8d3d0f8d");

        // Specify device and os_version for testing
        caps.setCapability("device", "iPhone XS");
        caps.setCapability("os_version", "12");

        // Set other BrowserStack capabilities
        caps.setCapability("project", "First Java Project");
        caps.setCapability("build", "Java iOS");
        caps.setCapability("name", "first_test");


        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        IOSDriver<IOSElement> driver = new IOSDriver<IOSElement>(
                new URL("http://hub-cloud.browserstack.com/wd/hub"), caps);

        Thread.sleep(2000);
        driver.findElementByAccessibilityId("Alert Button").click();
        Thread.sleep(2000);
        String actualAlertText = driver.findElementByXPath("//XCUIElementTypeStaticText[@name='Alert']").getText();
        Assert.assertEquals(actualAlertText,"Alert");
        Thread.sleep(2000);
        driver.findElementByAccessibilityId("OK").click();

        driver.quit();

    }
}
