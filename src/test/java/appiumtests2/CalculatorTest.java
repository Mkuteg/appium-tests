package appiumtests2;

import java.net.URL;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class CalculatorTest {

    /*
     * static WebDriver driver; AndroidDriver driver;
     */
    static AppiumDriver<MobileElement> driver;

    public static void main(String[] args) {

        try {
            openCalculator();

        } catch (Exception exp) {
            System.out.println(exp.getCause());
            System.out.println(exp.getMessage());
            exp.printStackTrace();
        }

    }

    @Test
    public static void openCalculator() throws Exception {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName", "Pixel XL");
        cap.setCapability("udid", "HT6B70200690");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "9");
        cap.setCapability("appPackage", "com.google.android.calculator");
        cap.setCapability("appActivity", "com.android.calculator2.Calculator");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AppiumDriver<MobileElement>(url, cap);

        System.out.println("Application Started...");

        Thread.sleep(3000);

        MobileElement one = driver.findElement(By.id("com.google.android.calculator:id/digit_1"));

        one.click();
        Thread.sleep(3000);
        MobileElement seven = driver.findElement(By.id("com.google.android.calculator:id/digit_7"));
        MobileElement plus = driver.findElement(By.id("com.google.android.calculator:id/op_add"));
        MobileElement eq = driver.findElement(By.id("com.google.android.calculator:id/eq"));
        MobileElement result = driver.findElement(By.id("com.google.android.calculator:id/result"));

        plus.click();
        seven.click();
        eq.click();

        String res = result.getText();
        System.out.println("\n Result is : " + res);

        System.out.println("Test Completed");

    }

}
