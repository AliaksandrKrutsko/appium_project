package utilities;

import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;
import java.util.Properties;

@Slf4j
public class AppiumConfiguration {

    public enum AppiumCapabilities {

        APP_PATH("appPath"),
        DEVICE_NAME("deviceName"),
        PLATFORM_VERSION("platformVersion"),
        PLATFORM_NAME("platformName"),
        APP_PACKAGE("appPackage"),
        APP_ACTIVITY("appActivity"),
        URL("url"),
        AUTOMATION_NAME("automationName"),
        IMPLICIT_WAIT("implicitWait");

        private String myCapability;

        AppiumCapabilities(String capability) {
            myCapability = capability;
        }

        public String get() {
            return myCapability;
        }

    }

    private static Properties appiumConfig = new Properties();
    private static String fileName = "/appiumConfig.properties";

    private static InputStream is = TestConfiguration.class.getResourceAsStream(fileName);
    static {
        try{
            appiumConfig.load(is);
        } catch (Exception e){
            log.info("Error reading from property file");
        }
    }

    public static String getAppPath() {
        return appiumConfig.getProperty(AppiumCapabilities.APP_PATH.get());
    }

    public static String getDeviceName() {
        return appiumConfig.getProperty(AppiumCapabilities.DEVICE_NAME.get());
    }

    public static String getPlatformVersion() {
        return appiumConfig.getProperty(AppiumCapabilities.PLATFORM_VERSION.get());
    }

    public static String getPlatformName() {
        return appiumConfig.getProperty(AppiumCapabilities.PLATFORM_NAME.get());
    }

    public static String getAppPackage() {
        return appiumConfig.getProperty(AppiumCapabilities.APP_PACKAGE.get());
    }

    public static String getAppActivity() {
        return appiumConfig.getProperty(AppiumCapabilities.APP_ACTIVITY.get());
    }

    public static String getUrl() {
        return appiumConfig.getProperty(AppiumCapabilities.URL.get());
    }

    public static String getAutomationName() {
        return appiumConfig.getProperty(AppiumCapabilities.AUTOMATION_NAME.get());
    }

    public static long getImplicitWait() {
        return Long.parseLong(appiumConfig.getProperty(AppiumCapabilities.IMPLICIT_WAIT.get()));
    }

}
