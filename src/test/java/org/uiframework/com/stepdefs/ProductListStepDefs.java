package org.uiframework.com.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.uiframework.com.domain.SortType;

@Slf4j
public class ProductListStepDefs extends ConfigStepDefinition {

    @Given("user has added some products to the cart")
    public void userHasAddedSomeProductsToTheCart(){
        productListActions.addRandomProductsToCart(3);
    }

    @When("user adds a product to the cart")
    public void userAddsAProductToTheCart(){
        productListActions.addRandomProductsToCart(1);
    }

    @When("user sorts the products by {string}")
    public void userSortsTheProductsBy(String sortType){
        productListActions.sortProducts(SortType.fromString(sortType));
    }

    @Then("products are sorted by {string}")
    public void productsAreCorrectlySorted(String sortType){
        productListQuestions.productsAreSorted(SortType.fromString(sortType));
    }

    @When("user selects a product using its {string}")
    public void userSelectsAProductUsingIts(String productElement){
        productListActions.openRandomProduct(productElement);
    }
}
