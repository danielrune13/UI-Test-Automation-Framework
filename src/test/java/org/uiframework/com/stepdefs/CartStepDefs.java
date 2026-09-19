package org.uiframework.com.stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import static org.uiframework.com.domain.Page.CART;

@Slf4j
public class CartStepDefs extends ConfigStepDefinition {

    @Autowired
    GeneralStepDefs generalStepDefs;

    @Then("product is added to the cart")
    public void productIsAddedToTheCart(){
        generalStepDefs.userIsInPage(CART.toString());
        cartQuestions.confirmProductsInCart(scenarioContext.getCart().getProducts());
    }

    @When("user removes a product from the cart")
    public void userRemovesAProductFromTheCart(){
        cartActions.removeRandomProduct();
    }

    @When("user removes all products from the cart")
    public void userRemovesAllProductsFromTheCart(){
        cartActions.removeAllProducts();
    }

    @Then("product is removed from the cart")
    public void productIsRemovedFromTheCart(){
        cartQuestions.productIsRemovedFromCart();
    }

    @Then("the cart is empty")
    public void theCartIsEmpty(){
        cartQuestions.cartIsEmpty();
    }

    @Then("cart icon displays a quantity of {int}")
    public void cartIconDisplaysAQuantityOf(int number){
        cartQuestions.cartIconsDisplaysQuantity(number);
    }

    @Then("cart icon does not display a quantity")
    public void cartIconDoesNotDisplayAQuantity(){
        cartQuestions.cartIconQuantityIsNotPresent();
    }

    @Then("cart icon quantity is decreased by 1")
    public void cartQuantityIsDecreasedBy1(){
        cartQuestions.cartIconsDisplaysQuantity(scenarioContext.getCart().getProducts().size() - 1);
    }

    @When("user selects to continue shopping")
    public void userSelectsToContinueShopping(){
        cartActions.continueShopping();
    }
}
