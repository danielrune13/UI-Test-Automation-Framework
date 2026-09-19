package org.uiframework.com.questions;

import io.cucumber.spring.ScenarioScope;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.uiframework.com.context.ScenarioContext;
import org.uiframework.com.domain.Product;
import org.uiframework.com.locators.Cart;
import org.uiframework.com.locators.CommonLocators;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Component
@ScenarioScope
public class CartQuestions extends PageObject {

    @Autowired
    ScenarioContext scenarioContext;

    public void cartIconsDisplaysQuantity(int number){
        assertEquals(number, Integer.parseInt($(CommonLocators.CART_ICON_NUMBER).getText()), "Unexpected cart number");
    }

    public void cartIconQuantityIsNotPresent(){
        assertFalse($(CommonLocators.CART_ICON_NUMBER).isVisible(), "Cart icon quantity is present");
    }

    public void confirmProductsInCart(List<Product> products){
        assertEquals(products.size(), getDriver().findElements(Cart.PRODUCT).size(), "Unexpected number of products found in cart");
        for(WebElement cartProduct: getDriver().findElements(Cart.PRODUCT)){
            String productName = cartProduct.findElement(Cart.PRODUCT_TITLE).getText().trim();
            float productPrice = Float.parseFloat(cartProduct.findElement(Cart.PRODUCT_PRICE).getText().trim().replace("$",""));
            assertTrue(products.stream().anyMatch(product -> product.getName().equalsIgnoreCase(productName) && product.getPrice() == productPrice), "Unexpected product found in cart, with name " + productName + " and price " + productPrice);
        }
    }

    public void productIsRemovedFromCart(){
        assertEquals(scenarioContext.getCart().getProducts().size() - 1, getDriver().findElements(Cart.PRODUCT).size(), "Product not removed from cart");
    }

    public void cartIsEmpty(){
        assertFalse($(Cart.PRODUCT).isVisible(), "Cart is not empty");
    }
}
