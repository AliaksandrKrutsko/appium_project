package tests;

import driver.TestBase;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.EmailLoginPage;
import pageObjects.PasswordLoginPage;
import pageObjects.PreLoginPage;
import pageObjects.SelectorPage;

public class UserAbleToLogin extends TestBase {

    PreLoginPage preLoginPage = new PreLoginPage();
    EmailLoginPage loginPage = new EmailLoginPage();
    PasswordLoginPage passwordPage = new PasswordLoginPage();
    SelectorPage selectorPage = new SelectorPage();

    public UserAbleToLogin() {
    }

    @Test
    @Parameters({"username", "password"})
    public void test(String username, String password) {

        preLoginPage
                .assert_imgLogoIsDisplayed()
                .tap_signInButton();
        loginPage
                .enterEmail(username)
                .tapEmailSignInButton();
        passwordPage
                .enter_password(password)
                .tap_passwordSignInButton();
        selectorPage.assertConversationSelectorSpinnerVisible();

    }

}
