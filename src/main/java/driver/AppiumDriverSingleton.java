package driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumDriverSingleton {

    private static AppiumDriver<MobileElement> driver;
    private static File app = new File(AppiumCapabilities.PATH_NAME.get());

    public static AppiumDriver getDriver()  {
        if (driver == null) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
            capabilities.setCapability("deviceName", AppiumCapabilities.DEVICE_NAME.get());
            capabilities.setCapability("platformVersion", AppiumCapabilities.PLATFORM_VERSION.get());
            capabilities.setCapability("platformName", AppiumCapabilities.PLATFORM_NAME.get());
            capabilities.setCapability("automationName", AppiumCapabilities.AUTOMATION_NAME.get());
            capabilities.setCapability("app", app.getAbsolutePath());
            capabilities.setCapability("appPackage", AppiumCapabilities.APP_PACKAGE.get());
            capabilities.setCapability("appWaitActivity", AppiumCapabilities.APP_ACTIVITY.get());
            try {
                driver = new AndroidDriver<>(new URL(AppiumCapabilities.URL.get()), capabilities);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            driver.manage().timeouts().implicitlyWait(Long.parseLong(AppiumCapabilities.IMPLICIT_WAIT.get()), TimeUnit.SECONDS);
        }
        return driver;
    }

}
