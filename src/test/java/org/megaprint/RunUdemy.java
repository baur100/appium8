package org.megaprint;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by Baurz on 4/26/2017.
 */
public class RunUdemy {

    DesiredCapabilities cap=new DesiredCapabilities();
    AndroidDriver<AndroidElement> driver;
    @BeforeClass
    public void init() throws MalformedURLException {
        cap.setCapability(MobileCapabilityType.BROWSER_NAME,"Chrome");
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,"105");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Android Device");
        driver=new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"),cap);
    }
    @Test
    public void test1(){
        if(cap.getCapability(MobileCapabilityType.DEVICE_NAME)=="Demo"){
            String context = driver.getContext(); // = "CHROMIUM"
            driver.context("NATIVE_APP");
            driver.findElement(By.id("com.android.chrome:id/terms_accept")).click();
            driver.findElement(By.id("com.android.chrome:id/negative_button")).click();
            driver.context(context);
        }
        driver.get("https://www.udemy.com");
        System.out.println("Site opened");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@class='udi udi-minus close']")).click();
        System.out.println("Upper banner closed");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElementByXPath("//*[@class='form-control ng-pristine ng-untouched ng-valid ng-empty']").sendKeys("SoapUI");
        driver.findElementByXPath("//*[@class='btn btn-primary']").click();
        System.out.println("Search sent");
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.findElementByXPath("//search-course-card/*/div[2]/div[1]/a").click();
        System.out.println("Complited");
    }
}
