package ParalelExecution.Android;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class ParallelAndroidTestCalculator extends ParalelAndroidBase{

    @Test
    public void test01() throws MalformedURLException, InterruptedException {
        AndroidDriver<MobileElement> driver = androidDriver("10000","10.0","Emulator","emulator-5554","8200");

        MobileElement num0 = driver.findElementById("com.google.android.calculator:id/digit_0");
        MobileElement num1 = driver.findElementById("com.google.android.calculator:id/digit_1");
        MobileElement num2 = driver.findElementById("com.google.android.calculator:id/digit_2");
        MobileElement num3 = driver.findElementById("com.google.android.calculator:id/digit_3");
        MobileElement num4 = driver.findElementById("com.google.android.calculator:id/digit_4");
        MobileElement num5 = driver.findElementById("com.google.android.calculator:id/digit_5");
        MobileElement num6 = driver.findElementById("com.google.android.calculator:id/digit_6");
        MobileElement num7 = driver.findElementById("com.google.android.calculator:id/digit_7");
        MobileElement num8 = driver.findElementById("com.google.android.calculator:id/digit_8");
        MobileElement num9 = driver.findElementById("com.google.android.calculator:id/digit_9");

        MobileElement plus = driver.findElementByAccessibilityId("plus");
        MobileElement equal = driver.findElementByAccessibilityId("equals");

        num2.click();
        num5.click();
        plus.click();
        num3.click();
        num8.click();
        Thread.sleep(3000);
        MobileElement preResult = driver.findElementById("com.google.android.calculator:id/result_preview");
        String expectedResult = preResult.getText();
        System.out.println("EX "+expectedResult );
        equal.click();
        Thread.sleep(3000);
        MobileElement finalResult = driver.findElementById("com.google.android.calculator:id/result_final");
        String actualResult = finalResult.getText();
        System.out.println("AC "+actualResult);
        Thread.sleep(3000);
        Assert.assertEquals(actualResult,expectedResult);

        Thread.sleep(3000);
        driver.quit();

    }

    @Test
    public void test02() throws MalformedURLException, InterruptedException {
        AndroidDriver<MobileElement> driver = androidDriver("10001","10.0","RealDevice","1fd655780409","8201");

        MobileElement num0 = driver.findElementById("com.google.android.calculator:id/digit_0");
        MobileElement num1 = driver.findElementById("com.google.android.calculator:id/digit_1");
        MobileElement num2 = driver.findElementById("com.google.android.calculator:id/digit_2");
        MobileElement num3 = driver.findElementById("com.google.android.calculator:id/digit_3");
        MobileElement num4 = driver.findElementById("com.google.android.calculator:id/digit_4");
        MobileElement num5 = driver.findElementById("com.google.android.calculator:id/digit_5");
        MobileElement num6 = driver.findElementById("com.google.android.calculator:id/digit_6");
        MobileElement num7 = driver.findElementById("com.google.android.calculator:id/digit_7");
        MobileElement num8 = driver.findElementById("com.google.android.calculator:id/digit_8");
        MobileElement num9 = driver.findElementById("com.google.android.calculator:id/digit_9");

        MobileElement plus = driver.findElementByAccessibilityId("plus");
        MobileElement equal = driver.findElementByAccessibilityId("equals");

        num4.click();
        num5.click();
        plus.click();
        num2.click();
        num5.click();
        Thread.sleep(3000);
        MobileElement preResult = driver.findElementById("com.google.android.calculator:id/result_preview");
        String expectedResult = preResult.getText();
        System.out.println("EX "+expectedResult );
        equal.click();
        Thread.sleep(3000);
        MobileElement finalResult = driver.findElementById("com.google.android.calculator:id/result_final");
        String actualResult = finalResult.getText();
        System.out.println("AC "+actualResult);
        Thread.sleep(3000);
        Assert.assertEquals(actualResult,expectedResult);

        Thread.sleep(3000);
        driver.quit();


    }
}
