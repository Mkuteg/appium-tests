package appiumtests2;

import java.net.URL;
import java.util.Set;
import java.util.Timer;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.errorprone.annotations.Var;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import sun.jvm.hotspot.runtime.Threads;

public class Stoloto {

    /*
     * static WebDriver driver; AndroidDriver driver;
     */
    static AppiumDriver<MobileElement> driver;

    public static void main(String[] args) {

        try {
            Stoloto stoloto = new Stoloto();
            stoloto.openStoloto();

        } catch (Exception exp) {
            System.out.println(exp.getCause());
            System.out.println(exp.getMessage());
            exp.printStackTrace();
        }

    }

    @Test
    public void openStoloto() throws Exception {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName", "Pixel XL");
        cap.setCapability("udid", "HT6B70200690");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "9");
        cap.setCapability("appPackage", "ru.stoloto.mobile");
        cap.setCapability("appActivity", "ru.stoloto.mobile.ca.presentation.ui.activity.MainActivity");
        //char[] login = {'m', 'e', 'f', 'r', 'o', 'l', 'i', 'o', '@', 'y', 'a', 'n', 'd', 'e', 'x', '.', 'r', 'u'};


        URL url = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AppiumDriver<MobileElement>(url, cap);
        System.out.println("Application Started...");
        MobileElement onBoardContinue = driver.findElement(By.id("ru.stoloto.mobile:id/confirm"));

        onBoardContinue.click();

        onBoardContinue.click();

        MobileElement onBoardLogin = driver.findElement(By.id("ru.stoloto.mobile:id/login"));

        onBoardLogin.click();
        MobileElement passwordHide = driver.findElement(By.id("ru.stoloto.mobile:id/text_input_password_toggle"));

        MobileElement loginField = driver.findElement(By.id("ru.stoloto.mobile:id/user"));
        String login = "mefrolio@yandex.ru";
        loginField.setValue(login);
        MobileElement passwordField = driver.findElement(By.id("ru.stoloto.mobile:id/passwordInputEdit"));

        String password = "qwerty";
        passwordField.setValue(password);

        driver.hideKeyboard();

        MobileElement log_in = driver.findElement(By.id("ru.stoloto.mobile:id/buttonSubmit"));
        log_in.click();
        System.out.println("Test Completed");

    }

}
