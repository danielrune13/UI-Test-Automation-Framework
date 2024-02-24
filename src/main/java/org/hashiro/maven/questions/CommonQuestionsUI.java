package org.hashiro.maven.questions;

import net.serenitybdd.core.pages.PageObject;
import org.springframework.stereotype.Component;

import static org.hashiro.maven.locators.ProductList.PRODUCT_LIST_TITLE;
import static org.junit.Assert.assertTrue;

@Component
public class CommonQuestionsUI extends PageObject {

    public void userIsInProductListPage(){
        assertTrue("Product List title is not visible", $(PRODUCT_LIST_TITLE).isVisible());
        //TODO: More assertions?
    }
}
