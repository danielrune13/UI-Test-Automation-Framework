package org.uiframework.com.actions;

import io.cucumber.spring.ScenarioScope;
import io.qameta.allure.Allure;
import lombok.extern.slf4j.Slf4j;
import org.uiframework.com.configuration.TestConfig;
import org.uiframework.com.domain.User;
import org.uiframework.com.domain.UserType;
import org.uiframework.com.locators.SideMenu;
import org.uiframework.com.utils.Wait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static org.uiframework.com.domain.UserType.STANDARD_USER;
import static org.uiframework.com.locators.LoginPage.*;

@Component
@Slf4j
@ScenarioScope
public class CommonActions extends BasePage {

    @Autowired
    TestConfig config;

    public void openApplication() {
        openAt(config.getUrl());
        Wait.forElementToDisplay($(LOGIN_PAGE_TITLE));
    }

    public void login(UserType userType) {
        User user = config.getUsers().getUserByType(userType);
        $(USERNAME_INPUT).type(user.getUsername());
        $(PASSWORD_INPUT).type(user.getPassword());
        $(LOGIN_BUTTON).click();
        Allure.attachment("Username", user.getUsername());
    }

    public void loginWithInvalidCredentials() {
        $(USERNAME_INPUT).type(config.getUsers().getUserByType(STANDARD_USER).getUsername());
        $(PASSWORD_INPUT).type("InvalidPassword123");
        $(LOGIN_BUTTON).click();
    }

    public void logout() {
        $(SideMenu.SIDE_MENU_BUTTON).click();
        $(SideMenu.getSideMenuOption("Logout")).click();
    }

    public void selectOptionFromSidebar(String option) {
        $(SideMenu.SIDE_MENU_BUTTON).click();
        $(SideMenu.getSideMenuOption(option)).click();
    }

    public void deleteDownloadedFiles() throws IOException {
        Path dir = Paths.get(System.getProperty("user.dir"));

        try (Stream<Path> files = Files.list(dir)) {
            files.filter(file -> file.getFileName().toString().contains("swag-labs-order"))
                    .filter(file -> file.getFileName().toString().endsWith(".pdf"))
                    .forEach(file -> {
                        try {
                            Files.delete(file);
                        } catch (IOException e) {
                            throw new UncheckedIOException(e);
                        }
                    });
        }
    }
}
