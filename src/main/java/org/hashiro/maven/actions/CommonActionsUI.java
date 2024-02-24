package org.hashiro.maven.actions;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hashiro.maven.configuration.TestConfig;
import org.hashiro.maven.domain.User;
import org.hashiro.maven.domain.UserType;
import org.hashiro.maven.utils.Wait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.hashiro.maven.locators.LoginPage.*;

@Component
@AllArgsConstructor
@Slf4j
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
