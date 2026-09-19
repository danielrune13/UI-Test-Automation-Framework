package org.uiframework.com.stepdefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import static org.uiframework.com.domain.Page.CHECKOUT_YOUR_INFORMATION;

@Slf4j
public class CheckoutStepDefs extends ConfigStepDefinition {

    @Autowired
    GeneralStepDefs generalStepDefs;

    @Given("user starts the checkout")
    public void userStartsTheCheckout(){
        cartActions.checkout();
    }

    @Given("user has started the checkout process")
    public void userHasStartedTheCheckoutProcess(){
        generalStepDefs.userIsInPage(CHECKOUT_YOUR_INFORMATION.toString());
    }

    @Then("the following information is requested by the system")
    public void theFollowingInformationIsRequestedByTheSystem(DataTable dataTable){
        checkoutQuestions.personalInformationIsRequested(dataTable.transpose().asList());
    }

    @When("user cancels the checkout")
    public void userCancelsTheCheckout(){
        checkoutActions.cancelCheckout();
    }

    @When("user submits checkout information")
    public void userSubmitsCheckoutInformation(){
        checkoutActions.submitInformation();
    }

    @When("user submits checkout information without providing {string}")
    public void userSubmitsCheckoutInformationWithoutProviding(String fieldName){
        checkoutActions.submitInformationWithout(fieldName);
    }

    @Then("the following checkout information is provided")
    public void theFollowingCheckoutInformationIsProvided(DataTable dataTable){
        checkoutQuestions.checkoutInformationIsProvided(dataTable.transpose().asList());
    }

    @When("user finishes the checkout")
    public void userFinishedTheCheckout(){
        checkoutActions.finishCheckout();
    }

    @Then("the message {string} is provided")
    public void theMessageIsProvided(String message){
        checkoutQuestions.messageIsDisplayed(message);
    }

    @Then("the following options are available")
    public void theFollowingOptionsAreAvailable(DataTable dataTable){
        checkoutQuestions.optionsAreDisplayed(dataTable.transpose().asList());
    }

    @When("user selects to return back to home")
    public void userSelectsToReturnBackToHome(){
        checkoutActions.backHome();
    }

    @When("user selects to generate the PDF Order")
    public void userSelectsToGenerateThePdfOrder(){
        checkoutActions.generatePdfOrder();
    }

    @Then("a PDF document is downloaded")
    public void aPdfDocumentIsDownloaded() {
        checkoutQuestions.pdfOrderIsDownloaded();
    }

    @Then("the document contains the following information")
    public void theDocumentContainsTheFollowingInformation(DataTable dataTable){
        checkoutQuestions.pdfOrderContains(dataTable.transpose().asList());
    }
}
