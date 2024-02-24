package org.hashiro.maven.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.hashiro.maven.actions.CommonActionsUI;
import org.hashiro.maven.domain.UserType;
import org.hashiro.maven.questions.CommonQuestionsUI;
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
