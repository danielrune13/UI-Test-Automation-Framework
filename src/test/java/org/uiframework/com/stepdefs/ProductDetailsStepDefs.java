package org.uiframework.com.stepdefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProductDetailsStepDefs extends ConfigStepDefinition {

    @When("user adds the product to the cart")
    public void userAddsTheProductToTheCart(){
        productDetailsActions.addProductToCart();
    }

    @Then("the following product information is provided")
    public void theFollowingProductInformationIsProvided(DataTable dataTable){
        productDetailsQuestions.productInformationIsProvided(dataTable.transpose().asList());
    }
}
