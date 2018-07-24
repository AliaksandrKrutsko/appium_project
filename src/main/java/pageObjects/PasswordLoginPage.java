package pageObjects;


import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PasswordLoginPage extends AbstractPage {

    public PasswordLoginPage() {

    }

    @AndroidFindBy(xpath = "//TextInputLayout[contains(@text,'Password')]/android.widget.FrameLayout/android.widget.EditText")
    private MobileElement passwordInputField;
    @AndroidFindBy(id = "btnSignIn")
    private MobileElement passwordSignInButton;

    /**
     * Actions
     */

    public PasswordLoginPage enter_password(String password) {
        passwordInputField.sendKeys(password);
        log.info("Sent password " + password + " to the Password Input Field");
        return this;
    }

    public PasswordLoginPage tap_passwordSignInButton() {
        passwordSignInButton.click();
        log.info("Tapped Sign In button on Password page screen");
        acceptCertificateAlertIfPresent();
        return this;
    }

    /**
     * Verifications
     */

}
