package org.uiframework.com.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.uiframework.com.actions.CommonActionsUI;
import org.uiframework.com.domain.UserType;
import org.uiframework.com.questions.CommonQuestionsUI;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class GeneralStepDefs extends ConfigStepDefinition {

    @Autowired
    CommonActionsUI testActionsUI;
    @Autowired
    CommonQuestionsUI testQuestionsUI;

    @Given("user opens the application")
    public void userOpensTheApplication(){
        testActionsUI.openApplication();
    }

    @When("user logs in as {string}")
    public void userIsLoggedInToTheApplication(String userType){
        testActionsUI.login(UserType.fromString(userType));
    }

    @Then("user is presented with the Product List Page")
    public void userIsPresentedWithTheProductListPage(){
        testQuestionsUI.userIsInProductListPage();
    }
}
