package pageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PreLoginPage extends AbstractPage {

    public PreLoginPage() {
        super();
    }

    @AndroidFindBy(id = "imgSignInLogo")
    private MobileElement imgLogo;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Sign in')]")
    private MobileElement signInButton;

    /**
     * Actions
     */

    /**
     * Method to tap Sign In button to be redirected to login page
     * @return
     */
    public PreLoginPage tap_signInButton() {
        signInButton.click();
        log.info("tapped Sign In button on Prelogin page screen");
        return this;
    }

    /**
     * Verifications
     */

    /**
     * Method to verify that Circuit logo is visible
     * @return
     */
    public PreLoginPage assert_imgLogoIsDisplayed() {
        softAssert.assertTrue(imgLogo.isDisplayed());
        return this;
    }

}
