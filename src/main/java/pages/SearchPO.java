package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

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
    By productContainerGrid = By.cssSelector(".product_list.grid.row .product-container");
    By productContainerList = By.cssSelector(".product_list.row.list .product-container");
    By productImageContainer = By.cssSelector(".product-container .product-image-container");
    By firstProductName = By.cssSelector("#center_column > ul > li:first-of-type > .product-container .product-name");

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

    public String getSearchPhrase() {
        return driver.findElement(searchPhrase).getText();
    }

    public int getNumberOfReturnedElements() {
        return driver.findElements(productContainerGrid).size();
    }

    public String getCountOfResults() {
        return driver.findElement(resultsCounter).getText();
    }

    public void changeView(String view) {
        switch (view) {
            case "Grid":
                driver.findElement(viewGrid).click();
                break;
            case "List":
                driver.findElement(viewList).click();
                break;
            default:
                break;
        }
    }

    public void selectSort(String sort) {
        Select dropdown = new Select(driver.findElement(sortBy));
        dropdown.selectByValue(sort);
    }

    public String getFirstProductName() {
        return driver.findElement(firstProductName).getText();
    }

    public Boolean isListViewDisplayed() {
        return driver.findElement(productContainerList).isDisplayed();
    }

    public Boolean isGridViewDisplayed() {
        return driver.findElement(productContainerGrid).isDisplayed();
    }

    public int getNumberOfImages() {
        return driver.findElements(productImageContainer).size();
    }
}
