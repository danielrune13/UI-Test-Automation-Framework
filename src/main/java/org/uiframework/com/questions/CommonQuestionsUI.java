package org.uiframework.com.questions;

import io.cucumber.spring.ScenarioScope;
import net.serenitybdd.core.pages.PageObject;
import org.springframework.stereotype.Component;

import static org.uiframework.com.locators.ProductList.PRODUCT_LIST_TITLE;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Component
@ScenarioScope
public class CommonQuestionsUI extends PageObject {

    public void userIsInProductListPage(){
        assertTrue($(PRODUCT_LIST_TITLE).isVisible(), "Product List title is not visible");
        //TODO: More assertions?
    }
}
