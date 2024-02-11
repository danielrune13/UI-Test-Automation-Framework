package org.hashiro.maven.stepdefs;

import net.thucydides.core.steps.ScenarioSteps;
import org.hashiro.maven.configuration.SpringConfig;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = SpringConfig.class)
public class ConfigStepDefinition extends ScenarioSteps {
}
