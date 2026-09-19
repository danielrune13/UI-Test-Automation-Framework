package org.uiframework.com.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.uiframework.com.domain.Page;
import org.uiframework.com.domain.UserType;

import java.io.IOException;

import static org.uiframework.com.domain.Page.*;

@Slf4j
public class GeneralStepDefs extends ConfigStepDefinition {

    @After
    public void clean() throws IOException {
        commonActions.deleteDownloadedFiles();
        scenarioContext.cleanCart();
    }

    @Given("user has opened the application")
    public void userHasOpenedTheApplication(){
        commonActions.openApplication();
    }

    @Given("user is logged-in as {string}")
    public void userIsLoggedInAs(String userType){
        userLogsInAs(userType);
        userIsPresentedWithPage(PRODUCT_LIST.toString());
    }

    @When("user logs in as {string}")
    public void userLogsInAs(String userType){
        commonActions.login(UserType.fromString(userType));
    }

    @When("user logs in with invalid credentials")
    public void userLogsInWithInvalidCredentials(){
        commonActions.loginWithInvalidCredentials();
    }

    @Given("user is in {string} page")
    public void userIsInPage(String page){
        switch (Page.fromString(page)){
            case LOGIN:
                userLogsOut();
                break;
            case PRODUCT_LIST:
                break;
            case PRODUCT_DETAILS:
                productListActions.openRandomProduct("product title");
                break;
            case CART:
                productListActions.openCart();
                break;
            case CHECKOUT_YOUR_INFORMATION:
                userIsInPage(CART.toString());
                cartActions.checkout();
                break;
            case CHECKOUT_OVERVIEW:
                userIsInPage(CHECKOUT_YOUR_INFORMATION.toString());
                checkoutActions.submitInformation();
                break;
            case CHECKOUT_COMPLETE:
                userIsInPage(CHECKOUT_OVERVIEW.toString());
                checkoutActions.finishCheckout();
                break;
        }
        userIsPresentedWithPage(page);
    }

    @Then("user is presented with the message {string}")
    public void userIsPresentedWithTheMessage(String message){
        commonQuestions.errorMessageIsDisplayed(message);
    }

    @When("user logs out")
    public void userLogsOut(){
        commonActions.logout();
    }

    @Then("user is presented with {string} Page")
    public void userIsPresentedWithPage(String page){
        commonQuestions.userIsInPage(Page.fromString(page));
    }

    @Then("user is redirected to {string} page")
    public void userIsRedirectedToPage(String page){
        userIsPresentedWithPage(page);
    }

    @When("user selects {string} from the sidebar menu")
    public void userSelectsOptionFromTheSidebarMenu(String option){
        commonActions.selectOptionFromSidebar(option);
    }
}
