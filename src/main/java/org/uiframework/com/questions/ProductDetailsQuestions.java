package org.uiframework.com.questions;

import io.cucumber.spring.ScenarioScope;
import net.serenitybdd.core.pages.PageObject;
import org.springframework.stereotype.Component;
import org.uiframework.com.locators.ProductDetailsPage;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Component
@ScenarioScope
public class ProductDetailsQuestions extends PageObject {

    public void productInformationIsProvided(List<String> productInformation){
        for(String productInfo: productInformation){
            switch (productInfo.toLowerCase()){
                case "name" -> assertTrue($(ProductDetailsPage.PRODUCT_TITLE).isVisible() && !$(ProductDetailsPage.PRODUCT_TITLE).getText().isEmpty(), "Product title not found");
                case "image" -> assertTrue($(ProductDetailsPage.PRODUCT_DESCRIPTION).isVisible(), "Product description not found");
                case "description" -> assertTrue($(ProductDetailsPage.PRODUCT_IMAGE).isVisible(), "Product image not found");
                case "price" -> assertTrue($(ProductDetailsPage.PRODUCT_PRICE).isVisible() && !$(ProductDetailsPage.PRODUCT_PRICE).getText().isEmpty(), "Product price not found");
                case "add to cart" -> assertTrue($(ProductDetailsPage.ADD_TO_CART_BUTTON).isVisible(), "'Add to Cart' button not found");
                default -> throw new IllegalArgumentException("Invalid product information to check: " + productInfo);
            }
        }
    }
}
