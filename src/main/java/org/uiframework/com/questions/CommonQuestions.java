package org.uiframework.com.questions;

import io.cucumber.spring.ScenarioScope;
import net.serenitybdd.core.pages.PageObject;
import org.springframework.stereotype.Component;
import org.uiframework.com.domain.Page;
import org.uiframework.com.locators.*;
import org.uiframework.com.utils.Wait;

import static org.junit.jupiter.api.Assertions.*;

@Component
@ScenarioScope
public class CommonQuestions extends PageObject {

    public void userIsInPage(Page page){
        switch (page){
            case LOGIN -> Wait.forElementToDisplay($(LoginPage.LOGIN_PAGE_TITLE));
            case PRODUCT_DETAILS -> Wait.forElementToDisplay($(ProductDetailsPage.BACK_TO_PRODUCTS));
            default -> Wait.forElementToDisplay($(CommonLocators.getPageTitle(page)));
        }
    }

    public void errorMessageIsDisplayed(String message){
        assertTrue($(CommonLocators.getErrorMessage(message)).isVisible(), "Error message '" + message + "' not found");
    }
}
