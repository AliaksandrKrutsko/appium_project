package utilities;

import driver.AppiumDriverSingleton;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VerificationManager {

    private long timeOutSeconds;

    WebDriverWait wait = new WebDriverWait(AppiumDriverSingleton.getDriver(), timeOutSeconds);

    private void waitForElementVisibility(MobileElement element, long timeOut) {
        this.timeOutSeconds = timeOut;
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public boolean isElementVisible(MobileElement element, long timeOutSeconds) {
        try {
            waitForElementVisibility(element, timeOutSeconds);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
