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
    SearchPO searchPage;


    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/marioracek/Documents/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    public void searchEmptyAndCheckPage() {
        searchPage = new SearchPO(driver);
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(By.name("submit_search")));
        searchPage.clickOnSearchButton();
        assertEquals(searchPage.getAlertMessage(), "Please enter a search keyword");
        assertTrue(searchPage.getHeadingText().contains("SEARCH"), "Heading has correct text");
        assertTrue(searchPage.getBreadcrumbsText().contains("Search"), "Breadcrumbs have correct text");
    }

    @Test(priority = 1)
    public void searchItemAndCheck() {
        searchPage = new SearchPO(driver);
        searchPage.enterSearchText("PRINTED CHIFFON DRESS");
        searchPage.clickOnSearchButton();
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(By.className("product-container")));
        assertTrue(searchPage.getHeadingText().contains("SEARCH"), "Heading has correct text");
        assertTrue(searchPage.getBreadcrumbsText().contains("Search"), "Breadcrumbs have correct text");
        assertEquals(searchPage.getFirstProductName(), "Printed Chiffon Dress", "First product name match");
        assertTrue(searchPage.getSearchPhrase().contains("PRINTED CHIFFON DRESS"), "Search phrase match actual phrase");
        assertTrue(searchPage.getCountOfResults().contains("2"), "Results counter shows correct value");
        assertEquals(searchPage.getNumberOfSearchedElements(), 2, "Number of products visible on page is correct");
        assertEquals(searchPage.getNumberOfImages(), 2, "Number of images visible on page is correct");
    }

    @Test(priority = 2)
    public void checkViewChange() {
        assertTrue(searchPage.isGridViewDisplayed(), "Grid view displayed");
        searchPage.changeView("List");
        assertTrue(searchPage.isListViewDisplayed(), "List view displayed");
    }

    @Test(priority = 2)
    public void checkSorting() {
        searchPage = new SearchPO(driver);
        searchPage.selectSort("name:desc");
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(By.className("product-container")));
        assertEquals(searchPage.getFirstProductName(), "Printed Summer Dress", "First product name match");
    }

    @AfterTest
    public void close() {
        driver.close();
    }
}
