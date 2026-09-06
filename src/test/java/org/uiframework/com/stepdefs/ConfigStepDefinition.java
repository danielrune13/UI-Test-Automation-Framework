package org.uiframework.com.stepdefs;

import io.cucumber.spring.CucumberContextConfiguration;
import net.thucydides.core.steps.ScenarioSteps;
import org.uiframework.com.configuration.SpringConfig;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@CucumberContextConfiguration
@ContextConfiguration(classes = SpringConfig.class)
public class ConfigStepDefinition extends ScenarioSteps {
}
