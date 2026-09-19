package org.uiframework.com.actions;

import io.cucumber.spring.ScenarioScope;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.uiframework.com.locators.Cart;
import org.uiframework.com.utils.Randomizer;
import org.uiframework.com.utils.Wait;

@Component
@Slf4j
@ScenarioScope
public class CartActions extends BasePage {

    public void removeRandomProduct(){
        int numberOfProducts = getDriver().findElements(Cart.REMOVE_PRODUCT).size();
        int randomIndex = Randomizer.generateInteger(0, numberOfProducts - 1);
        getDriver().findElements(Cart.REMOVE_PRODUCT).get(randomIndex).click();
    }

    public void removeAllProducts(){
        while($(Cart.REMOVE_PRODUCT).isVisible()){
            $(Cart.REMOVE_PRODUCT).click();
        }
    }

    public void continueShopping(){
        $(Cart.CONTINUE_SHOPPING).click();
        Wait.forElementToDisappear($(Cart.CONTINUE_SHOPPING));
    }

    public void checkout(){
        $(Cart.CHECKOUT).click();
        Wait.forElementToDisappear($(Cart.CHECKOUT));
    }
}
