package pageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SelectorPage extends AbstractPage {

    public SelectorPage() {

    }

    @AndroidFindBy(id = "conversation_selector_spinner")
    private MobileElement conversationSelectorSpinner;

    /**
     * Actions
     */

    /**
     * Verifications
     */

    /**
     * Method to verify if Conversation Selector Spinner is visible
     * @return
     */
    public SelectorPage assertConversationSelectorSpinnerVisible() {
        softAssert.assertTrue(conversationSelectorSpinner.isDisplayed());
        return this;
    }

}
