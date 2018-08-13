package tests;

import driver.TestBase;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.EmailLoginPage;
import pageObjects.PasswordLoginPage;
import pageObjects.PreLoginPage;
import pageObjects.SelectorPage;
import utilities.TestListener;

@Listeners({TestListener.class})
public class UserAbleToLogin extends TestBase {

    PreLoginPage preLoginPage = new PreLoginPage();
    EmailLoginPage loginPage = new EmailLoginPage();
    PasswordLoginPage passwordPage = new PasswordLoginPage();
    SelectorPage selectorPage = new SelectorPage();

    public UserAbleToLogin() {
    }

    @Test
    @Description("User is able to login to Circuit")
    public void test_user1AbleToLogin() {

        preLoginPage
                .assert_imgLogoIsDisplayed()
                .tap_signInButton();
        loginPage
                .enterEmail(user1 + serverAdress)
                .tapEmailSignInButton();
        passwordPage
                .enter_password(password)
                .tap_passwordSignInButton();
        selectorPage.assertConversationSelectorSpinnerVisible();

    }

//    @Test
//    public void test_user2AbleToLogin() {
//
//        preLoginPage
//                .assert_imgLogoIsDisplayed()
//                .tap_signInButton();
//        loginPage
//                .enterEmail(user2 + serverAdress)
//                .tapEmailSignInButton();
//        passwordPage
//                .enter_password(password)
//                .tap_passwordSignInButton();
//        selectorPage.assertConversationSelectorSpinnerVisible();
//
//    }

}
