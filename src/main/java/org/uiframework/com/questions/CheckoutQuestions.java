package org.uiframework.com.questions;

import io.cucumber.spring.ScenarioScope;
import net.serenitybdd.core.pages.PageObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.uiframework.com.configuration.TestConfig;
import org.uiframework.com.configuration.TestConfig.CheckoutConfig;
import org.uiframework.com.context.ScenarioContext;
import org.uiframework.com.domain.Product;
import org.uiframework.com.locators.CheckoutPage;
import org.uiframework.com.utils.*;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Component
@ScenarioScope
public class CheckoutQuestions extends PageObject {

    @Autowired
    ScenarioContext scenarioContext;
    @Autowired
    TestConfig config;

    File receipt;

    public void personalInformationIsRequested(List<String> information){
        for(String info: information){
            switch (info.toLowerCase()){
                case "first name" -> assertTrue($(CheckoutPage.FIRST_NAME).isVisible());
                case "last name" -> assertTrue($(CheckoutPage.LAST_NAME).isVisible());
                case "zip/postal code" -> assertTrue($(CheckoutPage.POSTAL_CODE).isVisible());
                default -> throw new IllegalArgumentException("Invalid personal information: " + info);
            }
        }
    }

    public void checkoutInformationIsProvided(List<String> information){
        for(String info: information){
            switch (info.toLowerCase()){
                case "products" -> {
                    assertTrue($(CheckoutPage.PRODUCTS).isVisible(), "Products not found");
                    assertEquals(scenarioContext.getCart().getProducts().size(), getDriver().findElements(CheckoutPage.PRODUCTS).size(), "Unexpected number of products");
                }
                case "payment information" -> assertFalse($(CheckoutPage.PAYMENT_INFORMATION).getText().isEmpty(), "Payment Information not found");
                case "shipping information" -> assertFalse($(CheckoutPage.SHIPPING_INFORMATION).getText().isEmpty(), "Postal code not found");
                case "total price" -> {
                    assertFalse($(CheckoutPage.SUB_TOTAL).getText().isEmpty(), "Sub Total not found");
                    assertEquals(scenarioContext.getCart().getSubTotal(), Float.parseFloat($(CheckoutPage.SUB_TOTAL).getText().replace("Item total: $", "")), 0.01f, "Unexpected sub total");
                    assertFalse($(CheckoutPage.TAX).getText().isEmpty(), "TAX not found");
                    scenarioContext.getCart().setTax(Float.parseFloat($(CheckoutPage.TAX).getText().trim().replace("Tax: $", "")));
                    assertFalse($(CheckoutPage.TOTAL_PRICE).getText().isEmpty(), "Total Price not found");
                    assertEquals(scenarioContext.getCart().getTotal(), Float.parseFloat($(CheckoutPage.TOTAL_PRICE).getText().replace("Total: $", "")), 0.01f, "Unexpected total price");
                }
                default -> throw new IllegalArgumentException("Invalid checkout information: " + info);
            }
        }
    }

    public void messageIsDisplayed(String message){
        assertTrue($(CheckoutPage.CHECKOUT_COMPLETE_HEADER).getText().contains(message) || $(CheckoutPage.CHECKOUT_COMPLETE_MESSAGE).getText().contains(message), "Message '" + message + "' not provided");
    }

    public void optionsAreDisplayed(List<String> options){
        for(String option: options){
            switch (option.toLowerCase()){
                case "back home" -> assertTrue($(CheckoutPage.BACK_HOME).isVisible(), "'Back Home' button not provided");
                case "generate pdf order" -> assertTrue($(CheckoutPage.GENERATE_PDF_ORDER).isVisible(), "'Generate PDF Order' button not provided");
                default -> throw new IllegalArgumentException("Invalid option: " + option);
            }
        }
    }

    public void pdfOrderIsDownloaded() {
        Wait.browserWaitFor(5000);  // Wait for document to be downloaded
        receipt = FileUtils.getFileFromLocation(System.getProperty("user.dir"), "swag-labs-order");
        assertTrue(receipt.getName().contains("swag-labs-order") && receipt.getName().endsWith(".pdf"));
    }

    public void pdfOrderContains(List<String> information){
        String pdfContent = String.join("\n", FileUtils.getPdfContent(receipt));
        for(String info: information){
            switch (info.toLowerCase()){
                case "order date":
                    String currentDate = DateUtils.getCurrentDateString("MMMM d, yyyy");
                    assertTrue(pdfContent.contains(currentDate), "Order date not found in PDF order");
                    break;
                case "shipping address":
                    CheckoutConfig checkoutData = config.getDataInputCheckout();
                    assertTrue(pdfContent.contains(checkoutData.getFirstName()), "First name not found in PDF order");
                    assertTrue(pdfContent.contains(checkoutData.getLastName()), "Last name not found in PDF order");
                    assertTrue(pdfContent.contains(checkoutData.getPostalCode()), "Postal code not found in PDF order");
                    break;
                case "items":
                    for(Product product: scenarioContext.getCart().getProducts()){
                        assertTrue(pdfContent.contains(product.getName()), "Product name not found in PDF Order: " + product.getName());
                        assertTrue(pdfContent.contains(String.valueOf(product.getPrice())), "Product price not found in PDF Order: " + product.getPrice());
                    }
                    break;
                case "price":
                    assertTrue(pdfContent.contains(String.valueOf(scenarioContext.getCart().getSubTotal())), "Sub Total not found in PDF Order: " + scenarioContext.getCart().getSubTotal());
                    assertTrue(pdfContent.contains(String.valueOf(scenarioContext.getCart().getTax())), "Tax not found in PDF Order: " + scenarioContext.getCart().getTax());
                    assertTrue(pdfContent.contains(String.valueOf(scenarioContext.getCart().getTotal())), "Total not found in PDF Order: " + scenarioContext.getCart().getTotal());
                    break;
                default:
                    throw new IllegalArgumentException("Invalid PDF order information to check: " + info);
            }
        }
    }
}
