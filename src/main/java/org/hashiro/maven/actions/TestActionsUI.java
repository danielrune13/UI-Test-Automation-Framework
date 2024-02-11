package org.hashiro.maven.actions;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hashiro.maven.configuration.JiraConfig;
import org.hashiro.maven.utils.Wait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.hashiro.maven.locators.TestLocators.*;

@Component
@AllArgsConstructor
@Slf4j
public class TestActionsUI extends BasePage {

    @Autowired
    JiraConfig jiraConfig;

    public void openApplication(){
        openAt(jiraConfig.getJiraUrl());
    }

    public void login(){
        $(USERNAME_INPUT).type(jiraConfig.getUser().getUsername());
        $(CONTINUE_LOGIN).click();
        $(PASSWORD_INPUT).type(jiraConfig.getUser().getPassword());
        $(CONTINUE_LOGIN).click();
        Wait.forElementToDisplay($(LANDING_PAGE_TITLE));
    }
}
