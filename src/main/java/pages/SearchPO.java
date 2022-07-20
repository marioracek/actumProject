package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPO {

    WebDriver driver;

    By heading = By.className("page-heading  product-listing");
    By submitSearch = By.name("submit_search");
    By searchInput = By.id("search_query_top");
    By alert = By.className("alert alert-warning");
    By resultsCounter = By.className("heading-counter");
    By searchPhrase = By.className("lighter");
    By sortBy = By.id("selectProductSort");
    By viewList = By.id("list");
    By viewGrid = By.id("grid");
    By compareButton = By.partialLinkText("Compare");
    By productContainer = By.className("product-container");
    By productImageContainer = By.className("product-image-container");
    By productName = By.className("product-name");

    public SearchPO(WebDriver driver) {
        this.driver = driver;
    }


}
