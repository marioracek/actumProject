package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.SearchPO;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

public class SearchTests {

    WebDriver driver;
    SearchPO searchPO;


    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/marioracek/Documents/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    public void searchEmptyAndCheckPage() {
        searchPO = new SearchPO(driver);
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(By.name("submit_search")));
        searchPO.clickOnSearchButton();
        assertEquals(searchPO.getAlertMessage(), "Please enter a search keyword");
        assertTrue(searchPO.getHeadingText().contains("SEARCH"), "Heading has correct text");
        assertTrue(searchPO.getBreadcrumbsText().contains("Search"), "Breadcrumbs have correct text");
    }

    @Test(priority = 1)
    public void searchItemAndCheck() {
        searchPO = new SearchPO(driver);
        searchPO.enterSearchText("PRINTED CHIFFON DRESS");
        searchPO.clickOnSearchButton();
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(By.className("product-container")));
        assertTrue(searchPO.getHeadingText().contains("SEARCH"), "Heading has correct text");
        assertTrue(searchPO.getBreadcrumbsText().contains("Search"), "Breadcrumbs have correct text");
        assertEquals(searchPO.getFirstProductName(), "Printed Chiffon Dress", "First product name match");
        assertTrue(searchPO.getSearchPhrase().contains("PRINTED CHIFFON DRESS"), "Search phrase match actual phrase");
        assertTrue(searchPO.getCountOfResults().contains("2"), "Results counter shows correct value");
        assertEquals(searchPO.getNumberOfSearchedElements(), 2, "Number of products visible on page is correct");
        assertEquals(searchPO.getNumberOfImages(), 2, "Number of images visible on page is correct");
    }

    @Test(priority = 2)
    public void checkViewChange() {
        assertTrue(searchPO.isGridViewDisplayed(), "Grid view displayed");
        searchPO.changeView("List");
        assertTrue(searchPO.isListViewDisplayed(), "List view displayed");
    }

    @Test(priority = 2)
    public void checkSorting() {
        searchPO = new SearchPO(driver);
        searchPO.selectSort("name:desc");
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(By.className("product-container")));
        assertEquals(searchPO.getFirstProductName(), "Printed Summer Dress", "First product name match");
    }

    @AfterTest
    public void close() {
        driver.close();
    }
}
