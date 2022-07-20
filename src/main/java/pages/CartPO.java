package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPO {

    WebDriver driver;

    By heading = By.id("cart_title");
    By breadcrumbs = By.className("navigation_page");
    By firstStep = By.className("step_current  first");
    By secondStep = By.className("step_todo second");
    By thirdStep = By.className("step_todo third");
    By fourthStep = By.className("step_todo four");
    By fifthStep = By.className("step_todo last");

    By totalProducts = By.className("cart_total_price");
    By totalShipping = By.className("cart_total_delivery");
    By totalPriceWithoutTax = By.className("cart_total_price");
    By totalTax = By.className("cart_total_tax");

    By totalProductsValue = By.id("total_product");
    By totalShippingValue = By.id("total_shipping");
    By totalPriceWithoutTaxValue = By.id("total_price_without_tax");
    By totalTaxValue = By.id("total_tax");

    public CartPO(WebDriver driver) {
        this.driver = driver;
    }
}
