package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPO {

    WebDriver driver;

    By heading = By.cssSelector(".page-heading.product-listing");
    By submitSearch = By.name("submit_search");
    By searchInput = By.id("search_query_top");
    By alert = By.cssSelector(".alert.alert-warning");
    By breadcrumbs = By.cssSelector(".breadcrumb.clearfix .navigation_page");
    By resultsCounter = By.className("heading-counter");
    By searchPhrase = By.className("lighter");
    By sortBy = By.id("selectProductSort");
    By viewList = By.id("list");
    By viewGrid = By.id("grid");
    By compareButton = By.partialLinkText("Compare");
    By productContainer = By.className("product-container");
    By productImageContainer = By.className("product-image-container");
    By productName = By.cssSelector(".product-container .product-name");

    public SearchPO(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnSearchButton() {
        driver.findElement(submitSearch).click();
    }

    public String getAlertMessage() {
        return driver.findElement(alert).getText();
    }

    public void enterSearchText(String message) {
        driver.findElement(searchInput).sendKeys(message);
    }

    public String getHeadingText() {
        return driver.findElement(heading).getText();
    }

    public String getBreadcrumbsText() {
        return driver.findElement(breadcrumbs).getText();
    }
}
