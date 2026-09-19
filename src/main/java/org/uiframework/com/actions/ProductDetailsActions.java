package org.uiframework.com.actions;

import io.cucumber.spring.ScenarioScope;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.uiframework.com.context.ScenarioContext;
import org.uiframework.com.domain.Product;
import org.uiframework.com.locators.ProductDetailsPage;
import org.uiframework.com.utils.Wait;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
@ScenarioScope
public class ProductDetailsActions extends BasePage {

    @Autowired
    ScenarioContext scenarioContext;

    public void addProductToCart(){
        $(ProductDetailsPage.ADD_TO_CART_BUTTON).click();
        Wait.forElementToDisappear($(ProductDetailsPage.ADD_TO_CART_BUTTON));
        String productName = $(ProductDetailsPage.PRODUCT_TITLE).getText().trim();
        float productPrice = Float.parseFloat($(ProductDetailsPage.PRODUCT_PRICE).getText().trim().replace("$", ""));

        List<Product> products = new ArrayList<>();
        products.add(new Product(productName, productPrice));
        scenarioContext.getCart().setProducts(products);
    }
}
