package org.uiframework.com.actions;

import io.cucumber.spring.ScenarioScope;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.uiframework.com.context.ScenarioContext;
import org.uiframework.com.domain.Product;
import org.uiframework.com.domain.SortType;
import org.uiframework.com.locators.CommonLocators;
import org.uiframework.com.locators.ProductList;
import org.uiframework.com.utils.Randomizer;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
@ScenarioScope
public class ProductListActions extends BasePage {

    @Autowired
    ScenarioContext scenarioContext;

    public void sortProducts(SortType sortType){
        $(ProductList.SORT_DROPDOWN).selectByVisibleText(sortType.toString());
    }

    public void addRandomProductsToCart(int numberOfProducts){
        List<Product> products = new ArrayList<>();
        for(int i=1; i<=numberOfProducts; i++){
            int productsAvailable = getDriver().findElements(ProductList.ADDABLE_PRODUCT).size();
            int randomIndex = Randomizer.generateInteger(0, productsAvailable - 1);
            WebElement productElement = getDriver().findElements(ProductList.ADDABLE_PRODUCT).get(randomIndex);
            String productName = productElement.findElement(ProductList.PRODUCT_TITLE).getText().trim();
            float productPrice = Float.parseFloat(productElement.findElement(ProductList.PRODUCT_PRICE).getText().trim().replace("$", ""));
            Product product = new Product(productName, productPrice);
            productElement.findElement(ProductList.ADD_TO_CART_BUTTON).click();
            products.add(product);
        }
        scenarioContext.getCart().setProducts(products);
    }

    public void openCart(){
        $(CommonLocators.CART_ICON).click();
    }

    public void openRandomProduct(String productElement){
        By interactionElement = switch (productElement.toLowerCase()){
            case "product title" -> ProductList.PRODUCT_TITLE;
            case "product image" -> ProductList.PRODUCT_IMAGE;
            default -> throw new IllegalArgumentException("Invalid product element: " + productElement);
        };
        int productsAvailable = getDriver().findElements(interactionElement).size();
        int randomIndex = Randomizer.generateInteger(0, productsAvailable - 1);
        getDriver().findElements(interactionElement).get(randomIndex).click();
    }
}
