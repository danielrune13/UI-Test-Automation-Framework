package org.uiframework.com.runner;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("/features/")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "net.serenitybdd.cucumber.core.plugin.SerenityReporterParallel,io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm,pretty,json:target/cucumber-reports/report.json,html:target/html-reports/report.html")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "org.uiframework.com")
public class SuiteRunner {}
