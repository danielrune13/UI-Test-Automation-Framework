package org.uiframework.com.stepdefs;

import io.cucumber.spring.CucumberContextConfiguration;
import net.thucydides.core.steps.ScenarioSteps;
import org.springframework.beans.factory.annotation.Autowired;
import org.uiframework.com.actions.*;
import org.uiframework.com.configuration.SpringConfig;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.uiframework.com.context.ScenarioContext;
import org.uiframework.com.questions.*;

@SpringBootTest
@CucumberContextConfiguration
@ContextConfiguration(classes = SpringConfig.class)
public class ConfigStepDefinition extends ScenarioSteps {

    @Autowired
    ScenarioContext scenarioContext;
    @Autowired
    CommonActions commonActions;
    @Autowired
    CommonQuestions commonQuestions;
    @Autowired
    ProductListActions productListActions;
    @Autowired
    ProductListQuestions productListQuestions;
    @Autowired
    ProductDetailsActions productDetailsActions;
    @Autowired
    ProductDetailsQuestions productDetailsQuestions;
    @Autowired
    CartActions cartActions;
    @Autowired
    CartQuestions cartQuestions;
    @Autowired
    CheckoutActions checkoutActions;
    @Autowired
    CheckoutQuestions checkoutQuestions;
}
