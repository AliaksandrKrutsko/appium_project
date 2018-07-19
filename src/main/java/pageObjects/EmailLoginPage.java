package pageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmailLoginPage extends AbstractPage {

    public EmailLoginPage() {
        super();
    }

    @AndroidFindBy(id = "edtMaterialEditTextContent")
    private MobileElement emailInputField;
    @AndroidFindBy(id = "btnSignIn")
    private MobileElement emailSignInButton;


    /**
     * Actions
      */

    public EmailLoginPage enterEmail(String username) {
        emailInputField.sendKeys(username);
        log.info("sent username " + username + " to Email Input Field");
        return this;
    }

    public EmailLoginPage tapEmailSignInButton() {
        emailSignInButton.click();
        log.info("tapped Next button on Email page screen");
        acceptCertificateAlertIfPresent();
        return this;
    }


    /**
     * VerificationManager
     */

}
