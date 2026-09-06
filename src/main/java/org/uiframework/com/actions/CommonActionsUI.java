package org.uiframework.com.actions;

import io.cucumber.spring.ScenarioScope;
import lombok.extern.slf4j.Slf4j;
import org.uiframework.com.configuration.TestConfig;
import org.uiframework.com.domain.User;
import org.uiframework.com.domain.UserType;
import org.uiframework.com.utils.Wait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.uiframework.com.locators.LoginPage.*;

@Component
@Slf4j
@ScenarioScope
public class CommonActionsUI extends BasePage {

    @Autowired
    TestConfig config;

    public void openApplication(){
        openAt(config.getUrl());
        Wait.forElementToDisplay($(MAIN_TITLE));
    }

    public void login(UserType userType){
        User user = config.getUsers().getUserByType(userType);
        $(USERNAME_INPUT).type(user.getUsername());
        $(PASSWORD_INPUT).type(user.getPassword());
        $(LOGIN_BUTTON).click();
        Wait.forElementToDisappear($(LOGIN_BUTTON));
    }
}
