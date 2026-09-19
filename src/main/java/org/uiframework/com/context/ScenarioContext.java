package org.uiframework.com.context;

import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.uiframework.com.configuration.SpringConfig;
import org.uiframework.com.domain.Cart;

@Component
@ContextConfiguration(classes = SpringConfig.class)
public class ScenarioContext {
    private ThreadLocal<Cart> cart;

    public ScenarioContext(){
        this.cart = ThreadLocal.withInitial(Cart::new);
    }

    public Cart getCart(){
        return cart.get();
    }

    public void setCart(Cart cart){
        this.cart.set(cart);
    }

    public void cleanCart(){
        this.cart.remove();
    }
}
