package pageObjects;

import driver.AppiumDriverSingleton;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import utilities.VerificationManager;

import java.util.concurrent.TimeUnit;

@Slf4j
public abstract class AbstractPage {

    VerificationManager verificationManager = new VerificationManager();
    SoftAssert softAssert = new SoftAssert();

    public AbstractPage() {
        PageFactory.initElements(new AppiumFieldDecorator(AppiumDriverSingleton.getDriver(), 3, TimeUnit.SECONDS), this);
    }

    @AndroidFindBy(id = "alertTitle")
    private MobileElement certificateAlert;
    @AndroidFindBy(id = "android:id/button1")
    private MobileElement continueAlertButton;

    protected void acceptCertificateAlertIfPresent() {
        if (verificationManager.isElementVisible(certificateAlert, 5)) {
            continueAlertButton.click();
            log.info("Tapped \"Continue\" button on Certificate Alert");
        }
        else log.info("Certificate Alert was not visible");
    }
}
