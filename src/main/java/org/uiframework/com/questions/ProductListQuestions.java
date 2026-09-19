package org.uiframework.com.questions;

import io.cucumber.spring.ScenarioScope;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import org.uiframework.com.domain.SortType;
import org.uiframework.com.locators.ProductList;
import org.uiframework.com.utils.ListUtils;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Component
@ScenarioScope
public class ProductListQuestions extends PageObject {

    public void productsAreSorted(SortType sortType){
        switch (sortType){
            case NAME_ASC, NAME_DESC -> productsAreSortedByName(sortType.getDirection());
            case PRICE_ASC, PRICE_DESC -> productsAreSortedByPrice(sortType.getDirection());
        }
    }

    private void productsAreSortedByName(String sortDirection){
        List<String> productNames = getDriver().findElements(ProductList.PRODUCT_TITLE).stream()
                .map(WebElement::getText)
                .map(String::trim)
                .toList();

        assertTrue(ListUtils.stringListIsSorted(productNames, sortDirection), "Product Names are not sorted in " + sortDirection + " direction: " + productNames);
    }

    private void productsAreSortedByPrice(String sortDirection){
        List<Float> productPrices = getDriver().findElements(ProductList.PRODUCT_PRICE).stream()
                .map(WebElement::getText)
                .map(String::trim)
                .map(text -> text.replace("$", ""))
                .map(Float::parseFloat)
                .toList();

        assertTrue(ListUtils.floatListIsSorted(productPrices, sortDirection), "Product Prices are not sorted in " + sortDirection + " direction: " + productPrices);
    }
}
