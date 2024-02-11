package org.hashiro.maven.stepdefs;

import io.cucumber.java.en.Given;
import lombok.extern.slf4j.Slf4j;
import org.hashiro.maven.actions.TestActionsUI;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class TestStepDef extends ConfigStepDefinition {

    @Autowired
    TestActionsUI testActionsUI;

    @Given("user opens the application")
    public void userOpensTheApplication(){
        testActionsUI.openApplication();
    }

    @Given("user is logged in to the application")
    public void userIsLoggedInToTheApplication(){
        testActionsUI.login();
    }
}
