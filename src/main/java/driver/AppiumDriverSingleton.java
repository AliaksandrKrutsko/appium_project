package driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import utilities.AppiumConfiguration;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumDriverSingleton {

    private static AppiumDriver<MobileElement> driver;
    private static File app = new File(AppiumConfiguration.getAppPath());

    public static AppiumDriver getDriver()  {
        if (driver == null) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
            capabilities.setCapability("deviceName", AppiumConfiguration.getDeviceName());
            capabilities.setCapability("platformVersion", AppiumConfiguration.getPlatformName());
            capabilities.setCapability("platformName", AppiumConfiguration.getPlatformName());
            capabilities.setCapability("automationName", AppiumConfiguration.getAutomationName());
            capabilities.setCapability("app", app.getAbsolutePath());
            capabilities.setCapability("appPackage", AppiumConfiguration.getAppPackage());
            capabilities.setCapability("appWaitActivity", AppiumConfiguration.getAppActivity());
            try {
                driver = new AndroidDriver<>(new URL(AppiumConfiguration.getUrl()), capabilities);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            driver.manage().timeouts().implicitlyWait(AppiumConfiguration.getImplicitWait(), TimeUnit.SECONDS);
        }
        return driver;
    }

}
