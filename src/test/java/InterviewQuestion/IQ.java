package InterviewQuestion;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;
import java.net.URL;

public class IQ {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        /*
        desired capabilities bolumunde hangi telefonu ve hangi platformu kullanacagimizi tanimliyoruz.
         */
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "AndroidEmulator");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        // desiredCapabilities.setCapability(MobileCapabilityType.APP,"app path .apk uzantili");
        //burda telefonu yan cevirerek daha fazla numarayi ekran sigdirmamnizi soyluyor test case
        //bu sekilde tanimliyoruz
        desiredCapabilities.setCapability("deviceOrientation", "landscape");
        //driver olusturup appium server (server url) vasitasiyle telefon ile baglanti sagliyoruz
        AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);
        Thread.sleep(3000);
        //1st step
        //calculator app .apk file ile path i desire capabilities tanimliyarak telefon
        // baglandiginda direk hesap makinasi acilir bu yol ile de yapila bilir
        // yukarda ornegi var ben telefona baglanip app tiklayarak yaptim.
        //telefona baglandiktan sonra ekranda calculator app tiklioruz
        driver.findElementByXPath("//android.widget.TextView[@content-desc='Calculator']").click();
//2nd step
        //ihtiyac olan elementleri locate ettik
        WebElement num1 = driver.findElementById("com.google.android.calculator:id/digit_1");
        WebElement num2 = driver.findElementById("com.google.android.calculator:id/digit_2");
        WebElement num3 = driver.findElementById("com.google.android.calculator:id/digit_3");
        WebElement num5 = driver.findElementById("com.google.android.calculator:id/digit_5");
        WebElement num8 = driver.findElementById("com.google.android.calculator:id/digit_8");
        WebElement num9 = driver.findElementById("com.google.android.calculator:id/digit_9");
        WebElement plus = driver.findElementByAccessibilityId("plus");
        WebElement equal = driver.findElementByAccessibilityId("equals");
        WebElement rightParanthesis = driver.findElementByAccessibilityId("right parenthesis");
        WebElement leftParanthesis = driver.findElementByAccessibilityId("left parenthesis");
        WebElement squareRoot = driver.findElementByAccessibilityId("square root");
        WebElement multiply = driver.findElementById("com.google.android.calculator:id/op_mul");
        WebElement minus = driver.findElementById("com.google.android.calculator:id/op_sub");
//artik mathematik islemini yapiyoruz
        num2.click();
        num3.click();
        plus.click();
        num9.click();
        num5.click();
        equal.click();
//sonucu strin olarak result variable icine aldik.
        String result = driver.findElementById("com.google.android.calculator:id/result_final").getText();
//3rd step
        //sonucu kare kokununalacagiz karakok tikladik
        squareRoot.click();
        //string sonucu hesap makinasinde karakok icine
        // yeniden yazmak icin for loop icinde switch kullandim
        //bu benim yalasimim farkli yollar olabilir
        for (int i = 0; i<result.length(); i++){
            switch (result.charAt(i)){
                case '1':
                    num1.click();
                    break;
                case '8':
                    num8.click();
                    break;
            }
        }
        //esittir tiklayarak son sonucu result icine uopdate ettik ve yazdirdik
        equal.click();
        result =driver.findElementById("com.google.android.calculator:id/result_final").getText();
        System.out.println("karekokten sonra ki son sonuc "+result);
//4th step
        //ekranda sobuc var ve isleme devam ediyoruz (sonuc*(-1))
        multiply.click();
        minus.click();
        num1.click();
        equal.click();
        result = driver.findElementById("com.google.android.calculator:id/result_final").getText();
        System.out.println("-1 ile carptiktan sonraki sonuc "+result);
        //5th step
 /*
 burda benim emulator ekrani kucuk oldugu icin expected result biraz azalttacagim
  siz 6+ bir inch kullanirsaniz rakam sigabilir
  */
        //-10.862782780491200215723891499337473741120122
        // ekrana sigan rakami aldim
        String expedtedResult = "-10.86278278049120021572389149933747374";
        //burda soft assert kullancagim ki test sonuna kadar calissin cunku bug var :)
        SoftAssert softAssert = new SoftAssert();
        //-1 ile cartiktan sonraki sonuc ile beklenen sonucu kiyaliyoruz
        //burda bug var  tirknak icinde belirttim altta
        //  10.86278"2"78049120021572389149933747374 beklenen sonuc
        //10.86278"0"78049120021572389149933747374  gerceklesen sonuc
        softAssert.assertEquals(result,expedtedResult);
        //6th step
        String roundedExpectedResult = "10.8628";
        //sonucumuz string formatinda wrapper class a convert yapmak icn
        // sadece numaric value yapmaliyiz o yuzden bastaki - isaretini kaldiriyoruz
        //substring methodu ile
        result = result.substring(1);
        //sonuc tamamen nuramlardan suan ve stringi double cast yaptik ve yazdirdik
        Double doubleResult = Double.valueOf(result);
        System.out.println(doubleResult);
        // sonucu rounded (yuvarlama) yapmak icin Math calss tan round() kullaniyoruz
        //. dan sonra 4 hane olmasi icin 10000.0 ile carpip bolerek yapmis oldu ve yazdirdik
        double roundedResult = Math.round(doubleResult*10000.0)/10000.0;
        System.out.println(roundedResult);
        //burda asseet ederek test case sonucandi.
        softAssert.assertEquals(roundedResult,roundedExpectedResult);
        //5th step deki failden dolayi burda execution duracak
        softAssert.assertAll();
    }

}
