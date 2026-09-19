package org.uiframework.com.actions;

import io.cucumber.spring.ScenarioScope;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.uiframework.com.configuration.TestConfig;
import org.uiframework.com.configuration.TestConfig.CheckoutConfig;
import org.uiframework.com.context.ScenarioContext;
import org.uiframework.com.locators.CheckoutPage;
import org.uiframework.com.utils.Wait;

@Component
@Slf4j
@ScenarioScope
public class CheckoutActions extends BasePage {

    @Autowired
    TestConfig config;
    @Autowired
    ScenarioContext scenarioContext;

    public void submitInformation(){
        CheckoutConfig checkoutData = config.getDataInputCheckout();
        $(CheckoutPage.FIRST_NAME).type(checkoutData.getFirstName());
        $(CheckoutPage.LAST_NAME).type(checkoutData.getLastName());
        $(CheckoutPage.POSTAL_CODE).type(checkoutData.getPostalCode());
        $(CheckoutPage.CONTINUE).click();
    }

    public void submitInformationWithout(String fieldName){
        CheckoutConfig checkoutData = config.getDataInputCheckout();
        switch (fieldName.toLowerCase()){
            case "first name":
                $(CheckoutPage.LAST_NAME).type(checkoutData.getLastName());
                $(CheckoutPage.POSTAL_CODE).type(checkoutData.getPostalCode());
                break;
            case "last name":
                $(CheckoutPage.FIRST_NAME).type(checkoutData.getFirstName());
                $(CheckoutPage.POSTAL_CODE).type(checkoutData.getPostalCode());
                break;
            case "zip/postal code":
                $(CheckoutPage.FIRST_NAME).type(checkoutData.getFirstName());
                $(CheckoutPage.LAST_NAME).type(checkoutData.getLastName());
                break;
            default:
                throw new IllegalArgumentException("Invalid checkout field name: " + fieldName);
        }
        $(CheckoutPage.CONTINUE).click();
    }

    public void cancelCheckout(){
        $(CheckoutPage.CANCEL).click();
    }

    public void finishCheckout(){
        Wait.forElementToDisplay($(CheckoutPage.TAX));
        scenarioContext.getCart().setTax(Float.parseFloat($(CheckoutPage.TAX).getText().trim().replace("Tax: $", "")));
        $(CheckoutPage.FINISH).click();
    }

    public void backHome(){
        $(CheckoutPage.BACK_HOME).click();
    }

    public void generatePdfOrder(){
        $(CheckoutPage.GENERATE_PDF_ORDER).click();
    }
}
