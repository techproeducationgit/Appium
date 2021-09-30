package EcommerceApp;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class ECommerce03SepeteEkle {

     @Test
     public void test() throws MalformedURLException, InterruptedException {
         DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

         desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
         desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
         desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Emulator");
         desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
         desiredCapabilities.setCapability("app","/Users/ayyildiz/IdeaProjects/AppiumTurkish/Apps/General-Store.apk");
         desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET,true);

         AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapabilities);
//butun data eksiksiz doldurunca basarili girs yapacagiz
         Thread.sleep(3000);
         driver.findElementById("com.androidsample.generalstore:id/spinnerCountry").click();

         driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"France\"))");

         driver.findElementByXPath("//android.widget.TextView[@text='France']").click();

         driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Anne");
         //eger klavyeyi kapatmak istiyorsaniz
        // driver.hideKeyboard(); //klavyeyi kapatir

         driver.getKeyboard();

         driver.findElementById("com.androidsample.generalstore:id/radioFemale").click();

         driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
         Thread.sleep(3000);
//product title basrasili girsi sonrasi onayliyalim
         Assert.assertTrue(driver.findElementById("com.androidsample.generalstore:id/toolbar_title").isDisplayed());

<<<<<<< HEAD
        //3-Validate if the items selected in the page 2 are matching with the items displayed in check out page

         driver.findElementByXPath("(//android.widget.TextView[@text='ADD TO CART'])[1]").click();

         driver.findElementByXPath("(//android.widget.TextView[@text='ADD TO CART'])[1]").click();


=======
       // sepete ekelem
//         driver.findElementByXPath("(//android.widget.TextView[@text='ADD TO CART'])[1]").click();
//
//         driver.findElementByXPath("(//android.widget.TextView[@text='ADD TO CART'])[1]").click();

         //eger syntax bu sekilde yaziyorsaniz (ozellikle POM da ) bu sekilde calisir
         //ama yukardaki gibi (49 ve 51 satirlar) o zman element indexine dikkat etmeliyiz
         MobileElement ilkurun = driver.findElementByXPath("(//android.widget.TextView[@text='ADD TO CART'])[1]");
         MobileElement ikinciUrun = driver.findElementByXPath("(//android.widget.TextView[@text='ADD TO CART'])[2]");
         ilkurun.click();
         ikinciUrun.click();
         //sepete git
         driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();

        String ilkUrunAdi = driver.findElementByXPath("//android.widget.TextView[@text='Air Jordan 4 Retro']").getText();

         String ikinciUrunAdi = driver.findElementByXPath("//android.widget.TextView[@text='Air Jordan 1 Mid SE']").getText();

         Assert.assertEquals(ilkUrunAdi,"Air Jordan 4 Retro");
         Assert.assertEquals(ikinciUrunAdi,"Air Jordan 1 Mid SE");
>>>>>>> cfeaaeb95a0a5b59e7fda009b8721c9618c540c7


     }
}
