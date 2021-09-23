package Appium;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumBSSauceApp {

    @Test
    public void test() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        // Set your access credentials
        caps.setCapability("browserstack.user", "mehmetayyildiz_HFVDMX");
        caps.setCapability("browserstack.key", "fwuU7xxcgZRSwegDPgvh");

        // Set URL of the application under test
        caps.setCapability("app", "bs://c66f1a18ba0da32263544bb6f1571aa1288b8ed2");

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

         driver.findElementByAccessibilityId("test-Username").sendKeys("standard_user");

         driver.findElementByAccessibilityId("test-Password").sendKeys("secret_sauce");

        driver.findElementByAccessibilityId("test-LOGIN").click();

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//XCUIElementTypeStaticText[@name='PRODUCTS']")));

        Assert.assertTrue(driver.findElementByXPath("//XCUIElementTypeStaticText[@name='PRODUCTS']").isDisplayed());



        // Invoke driver.quit() after the test is done to indicate that the test is completed.
        driver.quit();
    }
}
